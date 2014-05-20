/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services.scores.record;

import beans.records.studentRecord;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author johan
 */
public class UpdateStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     // response.setContentType("text/html;charset=UTF-8");
     studentRecord record = (studentRecord) request.getSession().getAttribute("record");
      //studentRecord record = new studentRecord();
      HttpSession session = request.getSession();
      String[] carnets;
      String[] pt1;
      String[] pt2;
      String[] pt3;
      carnets = request.getParameterValues("cCarnet");
      pt1 = request.getParameterValues("pt1");
      pt2 = request.getParameterValues("pt2");
      pt3 = request.getParameterValues("pt3");
      int status;
      for(int i = 0; i < carnets.length; i++){
        if( (status = record.updateStudent(carnets[i], pt1[i], pt2[i], pt3[i])) == 1)
          session.setAttribute("Error", "No Existe el ID: " + carnets[i]);
        else if (status == 2)
          session.setAttribute("Error", "No se pudieron Convertir los caracteres");
      }
       request.getRequestDispatcher("/register.jsp"). 
       forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
