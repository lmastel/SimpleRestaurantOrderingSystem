/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.controller;

import SROS.model.MaintenanceBuilder;
import SROS.model.MenuService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        String webMaster =
                this.getServletContext().getInitParameter("webMaster");
        
        request.setAttribute("webMaster", webMaster); 

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
        System.out.println("radiocd = " + radiocd);

        String dbpkey = request.getParameter("dbpkey");
        System.out.println("dbpkey = " + dbpkey);

        String[] xrefRows = request.getParameterValues("xrefRows");
//        if (xrefRows == null) {
//            System.out.println("xrefRows NULL");
//        }
//        System.out.println("xrefRows[0]= " + xrefRows[0]);
//        System.out.println("xrefRows[1]= " + xrefRows[1]);
        System.out.println("xrefRows[11]= " + xrefRows[11]);

        String[] descs = request.getParameterValues("descs");
//        System.out.println("descs[0]= " + descs[0]);
//        System.out.println("descs[1]= " + descs[1]);
        System.out.println("descs[0].length() = " + descs[0].length());
        System.out.println("descs[1].length() = " + descs[1].length());



        int viewRow = 0;
        for (int i = 0; i < xrefRows.length; i++) {
            if (xrefRows[i].equals(dbpkey)) {
                viewRow = i;
                break;
            }
        }


        String message = null;
        System.out.println("viewRow = " + viewRow);
        if (isBlank(descs[viewRow])) {
            int x = viewRow + 1;
            message = "Item " + x + " Item Descrption must be filled in";

            setValidationMessage(message, request, response);

        }


        String[] ums = request.getParameterValues("ums");

        if (isBlank(ums[viewRow])) {
            int x = viewRow + 1;
            message = "Item " + x + " Unit of Measure must be filled in";

            setValidationMessage(message, request, response);

        }


        String[] prices = request.getParameterValues("prices");

        if (isBlank(prices[viewRow])) {
            int x = viewRow + 1;
            message = "Item " + x + " Unit Price must be filled in";

            setValidationMessage(message, request, response);

        }


        if (!prices[viewRow].matches("\\d{1,3}\\.\\d{1,2}")) {
            int x = viewRow + 1;
            message = "Item " + x + " Unit Price must be valid";

            setValidationMessage(message, request, response);

        }
        try {
            MaintenanceBuilder mb = new MaintenanceBuilder(xrefRows, radiocd, dbpkey,
                    descs, ums, prices);

    //        String jspName = "/MenuMaintainController.jsp";
    //        RequestDispatcher rd = request.getRequestDispatcher(jspName);
    //        rd.forward(request, response);

    //        String url = "/MenuMaintainController.jsp";
    //        RequestDispatcher dispatcher =
    //                getServletContext().getRequestDispatcher(url);
    //        dispatcher.forward(request, response);
        } catch (SQLException ex) {
            message = "Contact webmaster database error " + ex.getMessage();
            setValidationMessage(message, request, response);
        }



        //response.sendRedirect("index.html");

        MenuService ms = new MenuService();
        ArrayList<ArrayList> menuitems = ms.getAllMenuItems();

        request.setAttribute("menuitems", menuitems);

        request.setAttribute("message", message);
        
        String webMaster =
                this.getServletContext().getInitParameter("webMaster");
        
        request.setAttribute("webMaster", webMaster); 

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

    public static boolean isBlank(String s) {
        return (s == null) || (s.trim().length() == 0);
    }

    public void setValidationMessage(String message, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        MenuService ms = new MenuService();
        ArrayList<ArrayList> menuitems = ms.getAllMenuItems();

        request.setAttribute("menuitems", menuitems);

        request.setAttribute("message", message);

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
        return "MenuMaintainController";
    }// </editor-fold>
}
