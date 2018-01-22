/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.SystemColor.text;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NITHIN
 */
public class susn extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          ResultSet Results;
          String name,yos,course,fee,collname,appstat;
            String musn=request.getParameter("usn");
           
           Mydb db=new Mydb();
          
            try (Connection con = db.getCon()) {
                
                Statement stmt=con.createStatement();
                
                
                Results=stmt.executeQuery("CALL `viewapplicationstatus`('"+musn+"')");
                
                boolean records=Results.next();
                if(!records){
                    out.print("not found");
                }
                name=Results.getString(2);
                yos=Results.getString(3);
                course=Results.getString(4);
                fee=Results.getString(5);
                collname=Results.getString(6);
                appstat=Results.getString(7);
                out.print("<body style='background-color:#f0f0f2'>");
                out.print("<center style='color:blue'");
                
                out.print("<pre><h2>");
                out.print("NAME   :  "+name);
                out.print("</pre></h2>");
                
                out.print("<pre><h2>");
                out.print("YEAR OF STUDY:"+yos);
                out.print("</pre></h2>");
                
                out.print("<pre><h2>");
                out.print("COURSE   :   "+course);
                out.print("</pre></h2>");
                
                out.print("<pre><h2>");
                out.print("FEE    :    "+fee);
                out.print("</pre></h2>");
                
                out.print("<pre><h2>");
                out.print("COLLAGE NAME : "+collname);
                out.print("</pre></h2>");
                
                out.print("<pre><h2>");
                out.print("APPLICATION STATUS:"+appstat);
                out.print("</pre></h2>");
               
                out.print("</center>");
                out.print("</body>");
                con.close();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(susn.class.getName()).log(Level.SEVERE, null, ex);
        }
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
