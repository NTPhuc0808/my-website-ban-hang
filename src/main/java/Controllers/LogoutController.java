/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author xuan
 */
public class LogoutController extends HttpServlet {

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
            out.println("<title>Servlet LogoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogoutController at " + request.getContextPath() + "</h1>");
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
        if (path.endsWith("/LogoutController")) {

            Cookie[] cookie = null;
            cookie = request.getCookies();//lay tat ca cookie luu vao mang
            HttpSession session = request.getSession();

            Cookie cook = null;

            for (int i = 0; i < cookie.length; i++) {//duyet mang cookie
                cook = cookie[i];
                if (cookie[i].getName().equals("user")) {//neu tim duoc cookie co tên "user"
//                    cook.setValue(null);
                    cook.setMaxAge(0);//dat thoi gian = 0, tuc la cookie nay da hêt han su dung
                    response.addCookie(cook);//add cookie het han o tren, tuc la da xoa cookie
                    break;
                }
            }

            session.invalidate();//xoa session

            response.sendRedirect("HomeController");//chuyen den trang login

        }
    }

//    HttpSession session = request.getSession();
//    if (cookie== null) {//kiem tra neu mang rong
//                response.sendRedirect("LoginController");//chuyen den trang login va bat nguoi dung login lai
//    }
//
//    
//        else {//neu mang khong rong
//                boolean flag = false;//dat bien kiem tra
//        for (int i = 0; i < cookie.length; i++) {//vong for duyet qua tat ca cookie có trong mang
//            if (cookie[i].getName().equals("user")) {//neu tim duoc cookie co tên "user", tên dat o trang loginServlet
//                //lay gia tri cua cookie co ten "user" luu vao bien username
//                flag = true;//da tim thây cookie, thay doi gia tri bien flag=true;
//                break;//dung vong lap for
//
//            }
//        }
//        if (!flag) {// !flag tuc la flag=false, nghia la nguoi dung chua dang nhap
//            response.sendRedirect("LoginController");//chuyen den trang login va bat nguoi dung login lai
//        } else {//neu dang nhap roi
//            response.sendRedirect("HomeController");
//        }
//    }
//
//}
//}
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

        if (request.getParameter("btnSignOut") != null) {//kiem tra xem nguoi dung da bam vao nut signout chua, !=null la co

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
