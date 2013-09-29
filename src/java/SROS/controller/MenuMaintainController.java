/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.controller;

import SROS.model.MaintenanceBuilder;
import SROS.model.MenuService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LPM
 */
public class MenuMaintainController extends HttpServlet {

    private static final String RESULT_PAGE = "/menumaintain.jsp";

    /**
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
//            out.println("<title>Servlet MenuMaintainController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MenuMaintainController at " + request.getContextPath() + "</h1>");
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
        MenuService ms = new MenuService();
        ArrayList<ArrayList> menuitems = ms.getAllMenuItems();

        request.setAttribute("menuitems", menuitems);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
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

        String radiocd = request.getParameter("radiocd");
//        System.out.println("radiocd = " + radiocd);

        String dbpkey = request.getParameter("dbpkey");
        System.out.println("dbpkey = " + dbpkey);

        String[] xrefRows = request.getParameterValues("xrefRows");
        if (xrefRows == null) {
            System.out.println("xrefRows NULL");
        }
        System.out.println("xrefRows[12]= " + xrefRows[12]);

        String[] descs = request.getParameterValues("descs");
        String[] ums = request.getParameterValues("ums");
        String[] prices = request.getParameterValues("prices");

        MaintenanceBuilder mb = new MaintenanceBuilder(xrefRows, radiocd, dbpkey,
                descs, ums, prices);
        
//        String jspName = "/MenuMaintainController.jsp";
//        RequestDispatcher rd = request.getRequestDispatcher(jspName);
//        rd.forward(request, response);
        
//        String url = "/MenuMaintainController.jsp";
//        RequestDispatcher dispatcher =
//                getServletContext().getRequestDispatcher(url);
//        dispatcher.forward(request, response);
        


         //response.sendRedirect("index.html");
         
         MenuService ms = new MenuService();
        ArrayList<ArrayList> menuitems = ms.getAllMenuItems();

        request.setAttribute("menuitems", menuitems);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);


//        RequestDispatcher view =
//                request.getRequestDispatcher(RESULT_PAGE);
//        view.forward(request, response);

//        String url = "/menumaintain.jsp";
//        RequestDispatcher dispatcher =
//                getServletContext().getRequestDispatcher(url);
//        dispatcher.forward(request, response);




    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "MenuMaintainController";
    }// </editor-fold>
}
