 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.records;

import bean.entities.student;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author johan
 */

public class studentRecord implements Serializable{
    /*public studentRecord Instance(){
        if(instance == null) instance = new studentRecord();
        return instance;
    }*/
    
    //protected
    public studentRecord(){
        /*if(record == null)*/ record = new HashMap<String, student>();
    }
    
    public boolean deleteStudent(String s){
        if(!record.containsKey(s)) return false;
        record.remove(s);
        return true;
    }
    public boolean addStudent(student s){
        if(record.containsKey(s.getId())) return false;
        record.put(s.getId(), s);
        return true;
    }
    public int updateStudent(String id, String t1, String t2, String t3){
        if(!exist(id)) return 1;
        try{
            float f1 = Float.parseFloat(t1);
            float f2 = Float.parseFloat(t2);
            float f3 = Float.parseFloat(t3);
            student s = record.get(id);
            s.setFirstTest(f1);
            s.setSecondTest(f2);
            s.setThirdTest(f3);
        }
        catch(NumberFormatException e){
            return 2;
        }
        return 0;
    }
    public boolean addStudent(String name, String surName, String id){
        student s = new student(name,surName,id,0,0,0);
        return addStudent(s);
    }
    public boolean exist(String id){
        return record.containsKey(id);
    }
    public String getRecord(){
        StringBuilder sb = new StringBuilder();
        float fl[] = new float[3], total;
        if(record == null)
            return " ";
        SortedSet<String> keys = new TreeSet<String>(record.keySet());
        int sz = keys.size();
        for (String key : keys) { 
            sb.append(getRow(key, fl));
        }
         String tot;
        if(sz == 0)
            tot = "<td></td> <td></td> <td>Total: </td> <td>0</td> <td>0</td> <td>0</td> <td>0</td> <td></td> ";
        else{
            total = ((fl[0] + fl[1] +fl[2])/3)/sz;
            tot = "<td></td> <td></td> <td>Total: </td> <td>"+String.format("%1$,.2f",fl[0]/sz)+"</td> <td>"+String.format("%1$,.2f",fl[1]/sz)+"</td> <td>"+String.format("%1$,.2f",fl[2]/sz)+"</td> <td>"+String.format("%1$,.2f",total)+"</td> <td></td>";
        }
        sb.append(tot);
        return sb.toString(); 
    }
    private String getRow(String id, float[] v){
        if(!exist(id)) return "<td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td>";

        StringBuilder sb = new StringBuilder();
        student s = record.get(id);
        v[0] += s.getFirstTest();
        v[1] += s.getSecondTest();
        v[2] += s.getThirdTest();

        String sid = s.getId();
        sb.append("<tr class=adatarow>\n");
        sb.append("<td> <input name=cCarnet type=text class=rdonly value=").append(sid).append(" readonly/> </td>\n");
        sb.append("<td>").append(s.getSurName()).append("</td>");
        sb.append("<td>").append(s.getName()).append("</td>");
        sb.append("<td class=selecCell onchange=enaBtn()>").append( makeSelector(1, (int)s.getFirstTest(), sid) ).append("</td>\n");
        sb.append("<td class=selecCell onchange=enaBtn()>").append( makeSelector(2, (int)s.getSecondTest(), sid) ).append("</td>\n");
        sb.append("<td class=selecCell onchange=enaBtn()>").append( makeSelector(3, (int)s.getThirdTest(), sid) ).append("</td>\n");
        sb.append("<td>").append(String.format("%1$,.2f",s.getPromedio()) ).append("</td>\n");
        sb.append("<td>").append(makeDelButton(s.getId())).append("</td>\n");
        sb.append("</tr>");
        
        return sb.toString();
    }
    private String makeSelector(int tstnum,int def,String sid){
        StringBuilder sb = new StringBuilder();
        sb.append("<select id=").append(tstnum).append(sid).append(" value=").append(def).append(" class=styledSelect name=pt").append(tstnum).append(">");
        for(int i = 100; i >= 0 ; i-=5){
            if(i == def)sb.append("<option selected=selected > ").append(i).append(" </option>");
            else sb.append("<option> ").append(i).append(" </option>");
        }
        sb.append("</select>");
        return sb.toString();
    }

    private String makeDelButton(String id){
        return "<input class=btnupdt type=button value=Borrar onclick=DeleteStudent(\'"+id+"\'); />";        
    }
    
    private /*static*/ HashMap<String, student> record;
    //private static studentRecord instance = null;
}
