/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.FALSE;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class app extends HttpServlet {

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
            String usn=request.getParameter("ausn");
            String name=request.getParameter("aname");
            String course=request.getParameter("ac");
            String passtype=request.getParameter("at");
            String routeid=request.getParameter("arid");
            Mydb db=new Mydb();
            Connection con=db.getCon();
            Statement stmt =con.createStatement();
            String query,query1;
            query="select USN from student where USN='"+usn+"';";
            query1="select USN from application where USN='"+usn+"';";
            ResultSet result,result1;
            result=stmt.executeQuery(query);
            boolean records=result.next();
            String tusn=result.getString(1);
            
            if((records!=FALSE)){
                stmt.executeUpdate("insert into application values('"+usn+"','"+name+"','"+course+"','"+passtype+"','"+routeid+"');");
                out.print("<center style='color:green'><h1>APPLICATION "+"<u style='color:red'>"+usn+"</u>"+" SUCCESSFULLY SUBMITTED");
                }
            
            else{
                out.print("<center style'color:grey'>INVALID USN OR APPLICATION ALREADY SUBMITTED");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
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
