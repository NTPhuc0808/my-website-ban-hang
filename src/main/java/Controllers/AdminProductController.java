/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.ProductDAO;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Xuan
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet(name = "AdminProductController", urlPatterns = {"/AdminProductController"})
public class AdminProductController extends HttpServlet {

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
            out.println("<title>Servlet AdminProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminProductController at " + request.getContextPath() + "</h1>");
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
        if (path.endsWith("/AdminProductController/create")) {
            request.getRequestDispatcher("/createPro.jsp").forward(request, response);
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
        ProductDAO dao = new ProductDAO();
        String fileName = null;

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
                response.sendRedirect("/AdminProductController/create");
            } else {
                response.sendRedirect("/AdminProductController");
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
