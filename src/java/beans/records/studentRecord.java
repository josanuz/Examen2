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
        if(record == null) record = new HashMap<String, student>();
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
        if(studentRecord.record == null)
            return " ";
        SortedSet<String> keys = new TreeSet<String>(record.keySet());
        for (String key : keys) { 
            sb.append(getRow(key));
   // do something
}
       return sb.toString(); 
    }
    private String getRow(String id){
        if(!exist(id)) return "<td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td> <td>NULL</td>";
        StringBuilder sb = new StringBuilder();
        student s = record.get(id);
        String frm = "frm"+s.getId();
        String sid = s.getId();
        sb.append("<tr>\n");
        sb.append("<td>").append(sid).append("</td>\n");
        sb.append("<td>").append(s.getSurName()).append("</td>");
        sb.append("<td>").append(s.getName()).append("</td>");
        sb.append("<td class=selecCell>").append( makeSelector(1, (int)s.getFirstTest(), sid) ).append("</td>\n");
        sb.append("<td class=selecCell>").append( makeSelector(2, (int)s.getSecondTest(), sid) ).append("</td>\n");
        sb.append("<td class=selecCell>").append( makeSelector(3, (int)s.getThirdTest(), sid) ).append("</td>\n");
        sb.append("<td>").append(s.getPromedio()).append("</td>\n");
        sb.append("<td>").append(makeButton(s.getId())).append("</td>\n");
        sb.append("<td>").append(makeDelButton(s.getId())).append("</td>\n");
        sb.append("</tr>");
        
        return sb.toString();
    }
    private String makeSelector(int tstnum,int def,String sid){
        StringBuilder sb = new StringBuilder();
        sb.append("<select id=").append(tstnum).append(sid).append(" value=").append(def).append(" class=styledSelect >");
        for(int i = 100; i >= 0 ; i-=5){
            if(i == def)sb.append("<option selected=selected > ").append(i).append(" </option>");
            else sb.append("<option> ").append(i).append(" </option>");
        }
        sb.append("</select>");
        return sb.toString();
    }
    private String makeButton(String id){
        return "<input class=btnupdt type=button value=Actualizar onclick=UpdateStudent("+id+"); />";  
    }
    private String makeDelButton(String id){
        return "<input class=btnupdt type=button value=Borrar onclick=DeleteStudent("+id+"); />";        
    }
    
    private static HashMap<String, student> record;
    //private static studentRecord instance = null;
}
