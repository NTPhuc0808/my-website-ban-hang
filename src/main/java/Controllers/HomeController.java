/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.CartDAO;
import DAOs.CategoriesDAO;
import DAOs.OrderDAO;
import DAOs.ProductDAO;
import Models.Account;
import Models.Cart;
import Models.Categories;
import Models.Orders;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class HomeController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        String acc_id = null;
        Cookie[] cookie = null;
        cookie = request.getCookies();

        boolean flag = false;//dat bien kiem tra
        if (cookie != null) {
            for (int i = 0; i < cookie.length; i++) {
                if (cookie[i].getName().equals("user")) {
                    acc_id = cookie[i].getValue();
                    flag = true;
                    break;

                }
            }
        }
        if (flag == true) {

            AccountDAO dao = new AccountDAO();
            Account acc = dao.GetAccountByAccId(Integer.parseInt(acc_id));
            HttpSession session = request.getSession();//tao session
            session.setAttribute("account", acc);
            String fullname = acc.getFullname();

            session.setAttribute("fullname", fullname);
            session.setAttribute("username", acc.getUsername());
            if (acc.getIsAdmin() == 1) {
                response.sendRedirect("/AdminController");
            }

            if (acc.getIsAdmin() == 0) {

                CartDAO cdao = new CartDAO();
                LinkedList<Cart> cart_list = cdao.GetListCartByAccID(acc.getAcc_id());
                session.setAttribute("cart_list", cart_list);
                OrderDAO odao = new OrderDAO();
                LinkedList<Orders> order = odao.GetListOrderByAccId(acc.getAcc_id());
                session.setAttribute("orders", order);
                CategoriesDAO catdao = new CategoriesDAO();
                ProductDAO pdao = new ProductDAO();

                LinkedList<Categories> cat = catdao.GetListCat();
                Map<Categories, LinkedList<Product>> map = new HashMap<>();
                LinkedList<Product> pro = new LinkedList<>();

                for (Categories c : cat) {

                    pro = pdao.Get3ProductByCatId(c.getCat_id());
                    map.put(c, pro);
                    pro = new LinkedList<>();
                }

                request.setAttribute("cat", map);

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } else {

            CategoriesDAO catdao = new CategoriesDAO();
            ProductDAO pdao = new ProductDAO();

            LinkedList<Categories> cat = catdao.GetListCat();
            Map<Categories, LinkedList<Product>> map = new HashMap<>();
            LinkedList<Product> pro = new LinkedList<>();

            for (Categories c : cat) {

                pro = pdao.Get3ProductByCatId(c.getCat_id());
                map.put(c, pro);
                pro = new LinkedList<>();
            }

            request.setAttribute("cat", map);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        
        
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
//        processRequest(request, response);

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
