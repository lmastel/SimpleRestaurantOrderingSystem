/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.controller;

import SROS.model.MenuService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LPM
 */
public class MenuController extends HttpServlet {
    private static final String RESULT_PAGE = "order.jsp";

    /*
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {
//            out.close();
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //processRequest(request, response);
        
        String webMaster =
                this.getServletContext().getInitParameter("webMaster");
        
        String custServiceEmail =                
        this.getServletConfig().getInitParameter("custServEmail");
        System.out.println("init-param custServiceEmail = " + custServiceEmail);
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("custServEmail", custServiceEmail);        
        System.out.println("session custServEmail = " + session.getAttribute("custServEmail"));
        
        String dbUrl = this.getServletConfig().getInitParameter("dbUrl");
        System.out.println("init-param dbUrl = " + dbUrl);
        
        String dbUsername = this.getServletConfig().getInitParameter("dbUsername");
        System.out.println("init-param dbUsername = " + dbUsername);
        
        String dbPassword = this.getServletConfig().getInitParameter("dbPassword");
        System.out.println("init-param dbPassword = " + dbPassword);
        
        
        
        MenuService ms = new MenuService();
        ArrayList<ArrayList> menuitems = ms.getAllMenuItems();
        
        request.setAttribute("menuitems", menuitems);  
        
        request.setAttribute("webMaster", webMaster);   
        
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "MenuController";
    }// </editor-fold>
}
