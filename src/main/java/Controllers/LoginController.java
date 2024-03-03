/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.CartDAO;
import DAOs.OrderDAO;
import Models.Account;
import Models.Cart;
import Models.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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

        String path = request.getRequestURI();
        if (path.endsWith("/LoginController")) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if (path.endsWith("/LoginController/Create")) {
                request.getRequestDispatcher("/createAcc.jsp").forward(request, response);
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
        AccountDAO dao = new AccountDAO();
        if (request.getParameter("btnSubmit") != null) {//kiem tra xem co bam nut co name = btnSubmit chua
            // btnSubmit la nut login
            String us = request.getParameter("txtUS");//lay gia tri cua bien co ten "txtUS",
            //la username cua form login
            String pw = request.getParameter("txtPwd");//lay gia tri cua bien co ten "txtPud",
            //la password cua form login
            Account acc = dao.GetAccount(us, pw);//luu account lay duoc

            if (acc != null && acc.getIsAdmin() == 0) {//neu rs co data, tuc la dang nhap dung

                HttpSession session = request.getSession();//tao session
                session.setAttribute("account", acc);
                String fullname = acc.getFullname();

                session.setAttribute("fullname", fullname);
                session.setAttribute("username", us);
                CartDAO cdao = new CartDAO();
                LinkedList<Cart> cart_list = cdao.GetListCartByAccID(acc.getAcc_id());
                session.setAttribute("cart_list", cart_list);
                OrderDAO odao = new OrderDAO();
                LinkedList<Orders> order = odao.GetListOrderByAccId(acc.getAcc_id());
                session.setAttribute("orders", order);

                //dung vao bien ten "username
//                    session.setAttribute("password", pw);
                Cookie user = new Cookie("user", acc.getAcc_id() + "");//tao va luu username vao bien tên "user"

                response.addCookie(user);//add cookie
                user.setMaxAge(3 * 24 * 60 * 60);//dat thoi gian ton tai cua cookie la 3 ngay

                response.sendRedirect("HomeController");// dang nhap thanh cong => chuyen sang trang list
            } else if (acc != null && acc.getIsAdmin() == 1) {
                HttpSession session = request.getSession();//tao session
                session.setAttribute("account", acc);
                String fullname = acc.getFullname();

                session.setAttribute("fullname", fullname);
                session.setAttribute("username", us);

                //dung vao bien ten "username
//                    session.setAttribute("password", pw);
                Cookie user = new Cookie("user", acc.getAcc_id() + "");//tao va luu username vao bien tên "user"

                response.addCookie(user);//add cookie
                user.setMaxAge(3 * 24 * 60 * 60);//dat thoi gian ton tai cua cookie la 3 ngay
                response.sendRedirect("AdminController");
            } else {//dang nhap dung sai, trong database khong co du lieu nay
                response.sendRedirect("LoginController");//dang nhap that bai => dung yen tai trang login
            }

        }
        if (request.getParameter("btnCreateAcc") != null) {

            String fullname = request.getParameter("txtFullname");
            String gender = request.getParameter("rdoGender");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            String us = request.getParameter("txtUS");
            String pw = request.getParameter("txtPwd");
            Account acc = new Account(0, fullname, gender, birthday, us, pw, 0);
            Account newAcc = null;
            newAcc = dao.AddNewAcc(acc);

            if (newAcc == null) {//khi them that bai

                response.sendRedirect("/LoginController/Create");
            } else {
                HttpSession session = request.getSession();//tao session
                session.setAttribute("account", newAcc);
                session.setAttribute("fullname", newAcc.getFullname());
                session.setAttribute("username", newAcc.getUsername());
                CartDAO cdao = new CartDAO();
                LinkedList<Cart> cart_list = cdao.GetListCartByAccID(acc.getAcc_id());
                session.setAttribute("cart_list", cart_list);
                OrderDAO odao = new OrderDAO();
                LinkedList<Orders> order = odao.GetListOrderByAccId(acc.getAcc_id());
                session.setAttribute("orders", order);

                Cookie user = new Cookie("user", acc.getAcc_id() + "");//tao va luu username vao bien tên "user"

                response.addCookie(user);//add cookie
                user.setMaxAge(3 * 24 * 60 * 60);
                response.sendRedirect("/HomeController");
            }

        }

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
