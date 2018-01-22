/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NITHIN
 */
public class colupdate extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           String susn=request.getParameter("usn");
           String snam=request.getParameter("sname");
           String yo=request.getParameter("yos");
           String ac=request.getParameter("course");
           String cfee=request.getParameter("fee");
           String cname=request.getParameter("collname");
           String apps=request.getParameter("appstatus");
           String ps=request.getParameter("paystatus");
                     
           Mydb db=new Mydb();
           Connection con=db.getCon();
           Statement stmt =con.createStatement();
           String query;
           out.print("ok");
           query="insert into student values('"+susn+"','"+snam+"','"+yo+"','"+ac+"','"+cfee+"','"+cname+"','"+apps+"','"+ps+"');";
           out.print("ok");
           stmt.executeUpdate(query);
           out.print("ok");
           out.print("<center style='color:green'><h1>STUDENT DETAILS OF USN:"+"<u style='color:red'>"+susn+"</u>"+" SUCCESSFULLY ADDED");
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(colupdate.class.getName()).log(Level.SEVERE, null, ex);
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
