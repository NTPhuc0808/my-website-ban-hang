/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.CartDAO;
import DAOs.OrderDAO;
import DAOs.Order_deailDAO;
import DAOs.ProductDAO;
import DAOs.ProductHistoryDAO;
import Models.Account;
import Models.Cart;
import Models.Order_detail;
import Models.Orders;
import Models.Product;
import Models.ProductHistory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author xuan
 */
public class OrderController extends HttpServlet {

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
            out.println("<title>Servlet OrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderController at " + request.getContextPath() + "</h1>");
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
        OrderDAO odao = new OrderDAO();
        Order_deailDAO oddao = new Order_deailDAO();
        ProductHistoryDAO phdao = new ProductHistoryDAO();
        HttpSession session = request.getSession();
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
                String path = request.getRequestURI();
                if (path.endsWith("/OrderController")) {
                    request.getRequestDispatcher("/order.jsp").forward(request, response);
                } else {
                    if (path.endsWith("/OrderController/Ordered")) {
                        LinkedList<Orders> order = odao.GetListOrderByAccId(Integer.valueOf(acc_id));
                        session.setAttribute("orders", order);
                        request.getRequestDispatcher("/Ordered.jsp").forward(request, response);
                    } else {
                        if (path.startsWith("/OrderController/BuyNow")) {
                            ProductDAO pdao = new ProductDAO();
                            String[] split = path.split("/");
                            try {
                                int pro_id = Integer.valueOf(split[split.length - 1]);
                                Product pro = pdao.GetProById(pro_id);
                                session.setAttribute("proBuy", pro);
                                request.getRequestDispatcher("/buyNow.jsp").forward(request, response);
                            } catch (Exception e) {
                            }
                        } else {
                            if (path.startsWith("/OrderController/Ordered/cancel")) {
                                String[] split = path.trim().split("/");
                                try {
                                    ProductDAO pdao = new ProductDAO();
                                    LocalDate date = LocalDate.now();
                                    Date o_date = Date.valueOf(date);
                                    int o_id = Integer.parseInt(split[split.length - 1]);
                                    Orders o = odao.GetOrderById(o_id);
                                    if (!o.getOrder_status().equals("Cancelled")) {
                                        int rs = odao.editOrderById(o.getO_id(), "Cancelled");
                                        LinkedList<Order_detail> list = oddao.GetListDetailByOId(o_id);
                                        for (Order_detail od : list) {
                                            Product update = pdao.GetProById(od.getPro_id());
                                            ProductHistory ph = new ProductHistory(od.getPro_id(), od.getPro_name(),
                                                    update.getPro_quantity() + od.getPro_quantity(), 0, 0, 0, od.getPro_quantity(), o_date);
                                            int result = phdao.AddProHistory(ph);
                                            int updateQuan = pdao.UpdateQuantity(ph.getQuanInStock(), update.getPro_id());
                                        }
                                    }

                                    response.sendRedirect("/OrderController/Ordered");
                                } catch (Exception e) {
                                    response.sendRedirect("/OrderController/Ordered");
                                }
                            } else {
                                if (path.startsWith("/OrderController/Ordered/detail")) {
                                    String[] split = path.trim().split("/");
                                    try {
                                        int o_id = Integer.parseInt(split[split.length - 1]);
                                        LinkedList<Order_detail> list = oddao.GetListDetailByOId(o_id);
                                        session.setAttribute("lisDetail", list);
                                        request.getRequestDispatcher("/orderDetail.jsp").forward(request, response);
                                    } catch (Exception e) {
                                        response.sendRedirect("/OrderController/Ordered");
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
        ProductHistoryDAO phdao = new ProductHistoryDAO();
        CartDAO cdao = new CartDAO();
        ProductDAO pdao = new ProductDAO();
        OrderDAO odao = new OrderDAO();
        Order_deailDAO od_dao = new Order_deailDAO();
        HttpSession session = request.getSession();
        //buy in cart
        if (request.getParameter("btnBuy") != null) {
            LinkedList<Cart> cart_buy = new LinkedList<>();
            LinkedList<Cart> cart_out = new LinkedList<>();//list pro out of stock
            String[] list_cart_id = request.getParameterValues("checkbox");
            for (String s : list_cart_id) {
                Cart c = cdao.GetCartById(Integer.parseInt(s));
                Product p = pdao.GetProById(c.getPro_id());
                int quanPro = p.getPro_quantity();
                int catPro = c.getPro_quantity();
                if (p.getPro_quantity() >= c.getPro_quantity()) {
                    cart_buy.add(c);
                } else {
                    cart_out.add(c);
                }

            }
            Double tong_tien = 0.0;
            if (cart_buy.size() > 1) {
                for (Cart c : cart_buy) {
                    Double total = c.getTotal_price();
                    tong_tien = tong_tien + total;
                }
            } else {
                for (Cart c : cart_buy) {
                    Double total = c.getTotal_price();
                    tong_tien = total;
                }
            }

            session.setAttribute("cart_out", cart_out);

            session.setAttribute("tong_tien", tong_tien);
            session.setAttribute("cart_buy", cart_buy);
            response.sendRedirect("/OrderController");
        }

        if (request.getParameter("btnCheckOut") != null) {
            LinkedList<Cart> buy = (LinkedList<Cart>) session.getAttribute("cart_buy");
            Account acc = (Account) session.getAttribute("account");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            Double tong_tien = (Double) session.getAttribute("tong_tien");
            LocalDate date = LocalDate.now();
            Date o_date = Date.valueOf(date);
            Orders o = new Orders(1, acc.getAcc_id(), address, phone, tong_tien, o_date);
            int order_id = odao.AddOrder(o);//add order va return order id
            for (Cart c : buy) {
                Order_detail od = new Order_detail(order_id, c.getPro_id(), c.getPro_name(),
                        c.getPrice(), c.getPro_quantity());
                od_dao.AddOrderDetail(od);
                Product update = pdao.GetProById(od.getPro_id());

                pdao.UpdateQuantity(update.getPro_quantity() - od.getPro_quantity(),
                        update.getPro_id());

                ProductHistory ph = new ProductHistory(od.getPro_id(), od.getPro_name(),
                        update.getPro_quantity() - od.getPro_quantity(), od.getPro_quantity(), 0, 0, 0, o_date);
                int rs = phdao.AddProHistory(ph);
            }
            LinkedList<Orders> order = odao.GetListOrderByAccId(acc.getAcc_id());
            session.setAttribute("orders", order);
            response.sendRedirect("/OrderController/Ordered");
        }

        if (request.getParameter("btnBuyNow") != null) {
            Product pro = (Product) session.getAttribute("proBuy");
            Account acc = (Account) session.getAttribute("account");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            LocalDate date = LocalDate.now();
            Date o_date = Date.valueOf(date);
            Orders o = new Orders(1, acc.getAcc_id(), address, phone, pro.getPro_price(), o_date);
            int order_id = odao.AddOrder(o);//add order va return order id
            Order_detail od = new Order_detail(order_id, pro.getPro_id(), pro.getPro_name(),
                    pro.getPro_price(), 1);
            od_dao.AddOrderDetail(od);
            Product update = pdao.GetProById(od.getPro_id());
            pdao.UpdateQuantity(update.getPro_quantity() - od.getPro_quantity(),
                    update.getPro_id());

            ProductHistory ph = new ProductHistory(od.getPro_id(), od.getPro_name(),
                    update.getPro_quantity() - od.getPro_quantity(), od.getPro_quantity(), 0, 0, 0, o_date);
            int rs = phdao.AddProHistory(ph);

            LinkedList<Orders> order = odao.GetListOrderByAccId(acc.getAcc_id());
            session.setAttribute("orders", order);
            response.sendRedirect("/OrderController/Ordered");
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
