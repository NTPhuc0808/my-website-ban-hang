/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.CartDAO;
import DAOs.ProductDAO;
import Models.Account;
import Models.Cart;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 *
 * @author Dell
 */
public class CartController extends HttpServlet {

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
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
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
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String acc_id = null;
        Cookie[] cookie = null;
        cookie = request.getCookies();
        if (cookie == null) {
            response.sendRedirect("/LoginController");
        } else {//neu mang khong rong
            boolean flag = false;//dat bien kiem tra
            for (int i = 0; i < cookie.length; i++) {
                if (cookie[i].getName().equals("user")) {
                    acc_id = cookie[i].getValue();
                    flag = true;
                    break;

                }
            }
            if (!flag) {// !flag tuc la flag=false, nghia la nguoi dung chua dang nhap
                response.sendRedirect("/LoginController");//chuyen den trang login va bat nguoi dung login lai
            } else {
                ProductDAO pdao = new ProductDAO();
                CartDAO cdao = new CartDAO();
                HttpSession session = request.getSession();

                Account acc = (Account) session.getAttribute("account");//account of user
                String path = request.getRequestURI();
                if (path.startsWith("/CartController/AddToCartAtHome")) {
                    String[] split = path.split("/");
                    try {
                        int pro_id = Integer.parseInt(split[split.length - 1]);//pro_id
                        Product pro = pdao.GetProById(pro_id);
                        if (pro.getPro_quantity() > 0) {
                            LinkedList<Cart> cart = new LinkedList<>();
                            LinkedList<Cart> cart_list = (LinkedList<Cart>) session.getAttribute("cart_list");
                            if (cart_list.size() == 0) {
                                Cart c = new Cart(1, acc.getAcc_id(), pro.getPro_id(), pro.getPro_name(), 1, pro.getPro_price());
                                Cart add = cdao.AddCart(c);
                                cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                session.setAttribute("cart_list", cart);
                            } else {
                                boolean checkIdExist = false;
                                for (Cart c : cart_list) {
                                    if (pro_id == c.getPro_id()) {
                                        checkIdExist = true;
                                        if (c.getPro_quantity() < pro.getPro_quantity()) {
                                            c.setPro_quantity(c.getPro_quantity() + 1);
                                            Cart update = cdao.UpdateQuan(c);
                                            cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                            session.setAttribute("cart_list", cart);
                                            break;
                                        }

                                    }
                                }

                                if (checkIdExist == false) {
                                    Cart c = new Cart(1, acc.getAcc_id(), pro.getPro_id(), pro.getPro_name(), 1, pro.getPro_price());
                                    Cart add = cdao.AddCart(c);//neu pro_id khong exist, them moi vao data
                                    cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                    session.setAttribute("cart_list", cart);
                                }
                            }
                        }

                        response.sendRedirect("/HomeController");
//                        request.getRequestDispatcher("/cart.jsp").forward(request, response);
                    } catch (Exception e) {
                    }

                } else {
                    if (path.endsWith("/CartController")) {
                        request.getRequestDispatcher("/cart.jsp").forward(request, response);
                    } else {
                        if (path.startsWith("/CartController/IncQuan")) {
                            LinkedList<Cart> cart = (LinkedList<Cart>) session.getAttribute("cart_list");
                            String[] split = path.split("/");
                            try {
                                int pro_id = Integer.parseInt(split[split.length - 1]);
                                Product p = pdao.GetProById(pro_id);
                                for (Cart c : cart) {
                                    if (pro_id == c.getPro_id() && c.getPro_quantity() < p.getPro_quantity()) {
                                        int quantity = c.getPro_quantity();
                                        quantity++;
                                        if (quantity <= p.getPro_quantity()) {
                                            c.setPro_quantity(quantity);
                                            Cart update = cdao.UpdateQuan(c);
                                            cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                            session.setAttribute("cart_list", cart);
                                            break;
                                        }
                                    }
                                }

                                response.sendRedirect("/CartController");

                            } catch (Exception e) {
                                response.sendRedirect("/CartController");
                            }
                        } else {
                            if (path.startsWith("/CartController/DecQuan")) {
                                LinkedList<Cart> cart = (LinkedList<Cart>) session.getAttribute("cart_list");
                                String[] split = path.split("/");
                                try {
                                    int pro_id = Integer.parseInt(split[split.length - 1]);
                                    for (Cart c : cart) {
                                        if (pro_id == c.getPro_id() && c.getPro_quantity() > 1) {
                                            int quantity = c.getPro_quantity();
                                            quantity--;
                                            if (quantity >= 1) {
                                                c.setPro_quantity(quantity);
                                                Cart update = cdao.UpdateQuan(c);
                                                cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                                session.setAttribute("cart_list", cart);
                                                break;
                                            }
                                        }
                                    }

                                    response.sendRedirect("/CartController");

                                } catch (Exception e) {
                                    response.sendRedirect("/CartController");
                                }
                            } else {
                                if (path.startsWith("/CartController/Delete")) {

                                    String[] split = path.split("/");
                                    try {
                                        int cart_id = Integer.parseInt(split[split.length - 1]);
                                        int delete = cdao.DeleteCart(cart_id);
                                        LinkedList<Cart> cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                        session.setAttribute("cart_list", cart);
                                        response.sendRedirect("/CartController");
                                    } catch (Exception e) {
                                        response.sendRedirect("/CartController");
                                    }
                                } else {
                                    if (path.startsWith("/CartController/AddToCartAtPro")) {
                                        String[] split = path.split("/");
                                        try {
                                            int pro_id = Integer.parseInt(split[split.length - 1]);//pro_id
                                            Product pro = pdao.GetProById(pro_id);
                                            if (pro.getPro_quantity() > 0) {
                                                LinkedList<Cart> cart = new LinkedList<>();
                                                LinkedList<Cart> cart_list = (LinkedList<Cart>) session.getAttribute("cart_list");
                                                if (cart_list == null || cart_list.size() == 0) {
                                                    Cart c = new Cart(1, acc.getAcc_id(), pro.getPro_id(), pro.getPro_name(), 1, pro.getPro_price());
                                                    Cart add = cdao.AddCart(c);
                                                    cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                                    session.setAttribute("cart_list", cart);
                                                } else {
                                                    boolean checkIdExist = false;
                                                    for (Cart c : cart_list) {
                                                        if (pro_id == c.getPro_id()) {
                                                            checkIdExist = true;
                                                            if (c.getPro_quantity() < pro.getPro_quantity()) {
                                                                c.setPro_quantity(c.getPro_quantity() + 1);
                                                                Cart update = cdao.UpdateQuan(c);
                                                                cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                                                session.setAttribute("cart_list", cart);
                                                                break;
                                                            }

                                                        }
                                                    }

                                                    if (checkIdExist == false) {
                                                        Cart c = new Cart(1, acc.getAcc_id(), pro.getPro_id(), pro.getPro_name(), 1, pro.getPro_price());
                                                        Cart add = cdao.AddCart(c);//neu pro_id khong exist, them moi vao data
                                                        cart = cdao.GetListCartByAccID(acc.getAcc_id());
                                                        session.setAttribute("cart_list", cart);
                                                    }
                                                }
                                            }

                                            response.sendRedirect("/ProductController");
//                        request.getRequestDispatcher("/cart.jsp").forward(request, response);
                                        } catch (Exception e) {
                                            response.sendRedirect("/ProductController");
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }

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
