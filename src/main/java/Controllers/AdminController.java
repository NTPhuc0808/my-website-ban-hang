/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.OrderDAO;
import DAOs.Order_deailDAO;
import DAOs.ProductDAO;
import DAOs.ProductHistoryDAO;
import Models.Account;
import Models.Order_detail;
import Models.Orders;

import Models.Product;
import Models.ProductHistory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author Dell
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class AdminController extends HttpServlet {

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
            out.println("<title>Servlet AdminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminController at " + request.getContextPath() + "</h1>");
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
        ProductDAO pdao = new ProductDAO();
        OrderDAO odao = new OrderDAO();
        Order_deailDAO oddao = new Order_deailDAO();
        AccountDAO accdao = new AccountDAO();
        HttpSession session = request.getSession();
        if (path.endsWith("/AdminController")) {
            int user = accdao.CountAccount();
            int pro = pdao.GetTotalpro();
            int order = odao.CountOrder();
            session.setAttribute("totalUser", user);
            session.setAttribute("totalPro", pro);
            session.setAttribute("totalOrder", order);
            
          
            
            request.getRequestDispatcher("/ThongKe.jsp").forward(request, response);
        } else {
            if (path.endsWith("/AdminController/dssanpham")) {
                LinkedList<Product> dsPro = new LinkedList<>();
                dsPro = pdao.GetAllPro();
                session.setAttribute("dsPro", dsPro);
                request.getRequestDispatcher("/dsSanpham.jsp").forward(request, response);

            } else {
                if (path.endsWith("/AdminController/dsuser")) {
                    LinkedList<Account> listUS = new LinkedList<>();
                    listUS = accdao.GetAllUser();
                    session.setAttribute("listUS", listUS);
                    request.getRequestDispatcher("/dsUser.jsp").forward(request, response);
                } else {
                    if (path.endsWith("/AdminController/dssanpham/createPro")) {
                        request.getRequestDispatcher("/createPro.jsp").forward(request, response);
                    } else {
                        if (path.startsWith("/AdminController/dssanpham/editPro")) {
                            String[] split = path.trim().split("/");
                            try {
                                int id = Integer.parseInt(split[split.length - 1]);
                                Product pro = pdao.GetProById(id);
                                if (pro == null) {
                                    response.sendRedirect("/AdminController/dssanpham");
                                } else {
                                    session.setAttribute("product", pro);
                                    request.getRequestDispatcher("/editPro.jsp").forward(request, response);
                                }
                            } catch (Exception e) {
                                response.sendRedirect("/AdminController/dssanpham");
                            }

                        } else {
                            if (path.startsWith("/AdminController/dssanpham/deletePro")) {
                                String[] split = path.trim().split("/");
                                try {
                                    int id = Integer.parseInt(split[split.length - 1]);
                                    Product pro = pdao.GetProById(id);
                                    int rs = pdao.Delete(id);
                                    response.sendRedirect("/AdminController/dssanpham");
                                } catch (Exception e) {
                                    response.sendRedirect("/AdminController/dssanpham");
                                }

                            } else {
                                if (path.endsWith("/AdminController/dsuser/createAcc")) {
                                    request.getRequestDispatcher("/adCreateAccUser.jsp").forward(request, response);
                                } else {
                                    if (path.startsWith("/AdminController/dsuser/deleteAcc")) {
                                        String[] split = path.trim().split("/");
                                        try {
                                            int id = Integer.valueOf(split[split.length - 1]);
                                            int rs = accdao.DeleteAccById(id);
                                            response.sendRedirect("/AdminController/dsuser");
                                        } catch (Exception e) {
                                            response.sendRedirect("/AdminController/dsuser");
                                        }
                                    } else {
                                        if (path.endsWith("/AdminController/dsDonHang")) {
                                            LinkedList<Orders> list = odao.GetListOrder();
                                            session.setAttribute("dsOrders", list);
                                            request.getRequestDispatcher("/dsDonhang.jsp").forward(request, response);
                                        } else {
                                            if (path.startsWith("/AdminController/dsDonHang/edit")) {
                                                String[] split = path.trim().split("/");
                                                try {
                                                    int id = Integer.parseInt(split[split.length - 1]);
                                                    Orders o = odao.GetOrderById(id);
                                                    session.setAttribute("orders", o);
                                                    request.getRequestDispatcher("/adEditOrder.jsp").forward(request, response);
                                                } catch (Exception e) {
                                                    response.sendRedirect("/AdminController/dsDonHang");
                                                }
                                            } else {
                                                if (path.startsWith("/AdminController/dsDonHang/detail")) {
                                                    String[] split = path.trim().split("/");
                                                    try {
                                                        int id = Integer.parseInt(split[split.length - 1]);
                                                        LinkedList<Order_detail> list = oddao.GetListDetailByOId(id);
                                                        session.setAttribute("detail", list);
                                                        request.getRequestDispatcher("/adOrderDetail.jsp").forward(request, response);
                                                    } catch (Exception e) {
                                                        response.sendRedirect("/AdminController/dsDonHang");
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
        HttpSession session = request.getSession();
        ProductDAO dao = new ProductDAO();

        ProductHistoryDAO phdao = new ProductHistoryDAO();
        String fileName = null;
        OrderDAO odao = new OrderDAO();
        try {
            Part part = request.getPart("proPic");
            String realPart = request.getServletContext().getRealPath("/images");

            fileName = Paths.get(part.getSubmittedFileName())
                    .getFileName().toString();
            if (!Files.exists(Paths.get(realPart))) {
                Files.createDirectory(Paths.get(realPart));
            }
            part.write(realPart + "/" + fileName);
        } catch (Exception e) {
        }

        if (request.getParameter("btnAdd") != null) {
            String name = request.getParameter("txtName");
            Double price = Double.valueOf(request.getParameter("price"));
            int quantity = Integer.valueOf(request.getParameter("quan"));
            String description = request.getParameter("txtDes");
            int cat_id = Integer.valueOf(request.getParameter("cat_id"));
            Product pro = new Product(1, cat_id, name, price, "images/" + fileName, quantity, description);
            Product add = dao.AddNew(pro);

            if (add == null) {//khi them that bai
                response.sendRedirect("/AdminController/createPro");
            } else {
                response.sendRedirect("/AdminController/dssanpham");
            }

        }
        if (request.getParameter("btnEdit") != null) {//edit product
            String editFile = null;
            int id = Integer.parseInt(request.getParameter("txtId"));
            Product editPro = dao.GetProById(id);
            String pictureOld = editPro.getPro_picture();// images/abc.jpg
            try {
                Part part = request.getPart("proPic");
                String realPart = request.getServletContext().getRealPath("/images");

                editFile = Paths.get(part.getSubmittedFileName())
                        .getFileName().toString();
                if (editFile == null || editFile.equals("")) {
                    String[] plit = pictureOld.split("/");
                    editFile += plit[plit.length - 1];
                }
                if (!Files.exists(Paths.get(realPart))) {
                    Files.createDirectory(Paths.get(realPart));
                }
                part.write(realPart + "/" + editFile);
            } catch (Exception e) {
            }
            String name = request.getParameter("txtName");
            Double price = Double.valueOf(request.getParameter("price"));
            int quantity = Integer.valueOf(request.getParameter("quan"));
            String description = request.getParameter("txtDes");
            int cat_id = Integer.valueOf(request.getParameter("cat_id"));
            Product pro = new Product(1, cat_id, name, price, "images/" + editFile, quantity, description);
            Product update = dao.Update(pro, id);

            if (update == null) {//khi them that bai
                Product old = dao.GetProById(id);
                session.setAttribute("pro", old);
                response.sendRedirect("/AdminController/Edit" + id);
            } else {
                LocalDate date = LocalDate.now();
                Date o_date = Date.valueOf(date);
                if (editPro.getPro_quantity() > update.getPro_quantity()) {
                    ProductHistory ph = new ProductHistory(editPro.getPro_id(), editPro.getPro_name(),
                            update.getPro_quantity(), 0, 0, editPro.getPro_quantity() - update.getPro_quantity(), 0, o_date);
                    int result = phdao.AddProHistory(ph);
                } else if (editPro.getPro_quantity() < update.getPro_quantity()) {
                    ProductHistory ph = new ProductHistory(editPro.getPro_id(), editPro.getPro_name(),
                            update.getPro_quantity(), 0, update.getPro_quantity() - editPro.getPro_quantity(), 0, 0, o_date);
                    int result = phdao.AddProHistory(ph);
                }

                response.sendRedirect("/AdminController/dssanpham");
            }

        }

        if (request.getParameter("btnCreateAcc") != null) {
            AccountDAO adao = new AccountDAO();
            String fullname = request.getParameter("txtFullname");
            String gender = request.getParameter("rdoGender");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            String us = request.getParameter("txtUS");
            String pw = request.getParameter("txtPwd");
            Account acc = new Account(0, fullname, gender, birthday, us, pw, 0);
            Account newAcc = null;
            newAcc = adao.AddNewAcc(acc);

            if (newAcc == null) {//khi them that bai
                response.sendRedirect("/AdminController/dsuser/createAcc");
            } else {
                response.sendRedirect("/AdminController/dsuser");
            }
        }

        if (request.getParameter("btnEditOrder") != null) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            Orders beforeEdit = odao.GetOrderById(id);
            String status = request.getParameter("o_status");
            int rs = odao.editOrderById(id, status);
            if (rs == 0) {
                Orders o = odao.GetOrderById(id);
                session.setAttribute("orders", o);
                response.sendRedirect("/AdminController/dsDonHang/edit/" + id);
            } else {
                ProductDAO pdao = new ProductDAO();
                LocalDate date = LocalDate.now();
                Date o_date = Date.valueOf(date);
                Order_deailDAO oddao = new Order_deailDAO();
                LinkedList<Order_detail> list = oddao.GetListDetailByOId(id);
                if (!beforeEdit.getOrder_status().equals("Cancelled")) {
                    if (status.equals("Cancelled")) {
                        for (Order_detail od : list) {
                            Product update = pdao.GetProById(od.getPro_id());
                            ProductHistory ph = new ProductHistory(od.getPro_id(), od.getPro_name(),
                                    update.getPro_quantity() + od.getPro_quantity(), 0, 0, 0, od.getPro_quantity(), o_date);
                            int result = phdao.AddProHistory(ph);
                            int updateQuan = pdao.UpdateQuantity(ph.getQuanInStock(), update.getPro_id());
                        }
                    }
                }
                if (beforeEdit.getOrder_status().equals("Cancelled")) {
                    if (!status.equals("Cancelled")) {
                        for (Order_detail od : list) {
                            Product update = pdao.GetProById(od.getPro_id());
                            ProductHistory ph = new ProductHistory(od.getPro_id(), od.getPro_name(),
                                    update.getPro_quantity() - od.getPro_quantity(), od.getPro_quantity(), 0, 0, 0, o_date);
                            int result = phdao.AddProHistory(ph);
                            int updateQuan = pdao.UpdateQuantity(ph.getQuanInStock(), update.getPro_id());
                        }
                    }
                }
                response.sendRedirect("/AdminController/dsDonHang");
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
