/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.CategoriesDAO;
import DAOs.ProductDAO;
import Models.Categories;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 *
 * @author xuan
 */
public class ProductController extends HttpServlet {

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
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
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
        ProductDAO dao = new ProductDAO();

        String path = request.getRequestURI();

        if (path.endsWith("/ProductController") || path.startsWith("/ProductController/index")) {
            request.setAttribute("path", "ProductController");
            int index = 0;
            String[] split = path.split("/");
            try {
                if (split.length == 2) {
                    index = 1;
                } else {
                    index = Integer.parseInt(split[split.length - 1]);
                }

                int totalPro = dao.GetTotalpro();
                int endPage = totalPro / 6;
                if ((totalPro % 6) != 0) {
                    endPage++;
                }

                LinkedList<Product> list = dao.PagingAllPro(index);
                request.setAttribute("list", list);
                request.setAttribute("endP", endPage);

                request.getRequestDispatcher("/product.jsp").forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("/ProductController");
            }

        } else {
            if (path.endsWith("/ProductController/HopQuaTetGo") || path.startsWith("/ProductController/HopQuaTetGo/index")) {
                request.setAttribute("path", "ProductController/HopQuaTetGo");
                int index = 0;
                String[] split = null;
                try {
                    split = path.split("/");
                    if (split.length == 3) {
                        index = 1;
                    } else {
                        index = Integer.parseInt(split[split.length - 1]);
                    }
                    int totalPro = dao.GetTotalProOfCat(1);
                    int endPage = totalPro / 6;
                    if ((totalPro % 6) != 0) {
                        endPage++;
                    }

                    LinkedList<Product> list1 = dao.PagingProOfCat(index, 1);
                    request.setAttribute("list", list1);
                    request.setAttribute("endP", endPage);

                    request.getRequestDispatcher("/product.jsp").forward(request, response);
                } catch (Exception e) {
                    response.sendRedirect("/ProductController/HopQuaTetGo");
                }

            } else {
                if (path.endsWith("/ProductController/HopQuaTetGo/PriceLess1tr") || path.startsWith("/ProductController/HopQuaTetGo/PriceLess1tr/index")) {
                    request.setAttribute("path", "ProductController/HopQuaTetGo/PriceLess1tr");
                    int index = 0;
                    String[] split = path.split("/");
                    try {
                        if (split.length == 4) {
                            index = 1;
                        } else {
                            index = Integer.parseInt(split[split.length - 1]);
                        }
                        int totalPro = dao.GetTotalProOfCatByPriceIsLess(1, 1000.0);
                        int endPage = totalPro / 6;
                        if ((totalPro % 6) != 0) {
                            endPage++;
                        }

                        LinkedList<Product> list2 = dao.PagingProOfCatByPriceIsLess(index, 1, 1000.0);
                        request.setAttribute("list", list2);
                        request.setAttribute("endP", endPage);

                        request.getRequestDispatcher("/product.jsp").forward(request, response);
                    } catch (Exception e) {
                        response.sendRedirect("/ProductController/HopQuaTetGo/PriceLess1tr");
                    }

                } else {
                    if (path.endsWith("/ProductController/HopQuaTetGo/PriceThan1tr") || path.startsWith("/ProductController/HopQuaTetGo/PriceThan1tr/index")) {
                        request.setAttribute("path", "ProductController/HopQuaTetGo/PriceThan1tr");
                        int index = 0;
                        String[] split = path.split("/");
                        try {
                            if (split.length == 4) {
                                index = 1;
                            } else {
                                index = Integer.parseInt(split[split.length - 1]);
                            }
                            int totalPro = dao.GetTotalProOfCatByPriceIsGreater(1, 1000.0);
                            int endPage = totalPro / 6;
                            if ((totalPro % 6) != 0) {
                                endPage++;
                            }

                            LinkedList<Product> list2 = dao.PagingProOfCatByPriceIsGreater(index, 1, 1000.0);
                            request.setAttribute("list", list2);
                            request.setAttribute("endP", endPage);

                            request.getRequestDispatcher("/product.jsp").forward(request, response);
                        } catch (Exception e) {
                            response.sendRedirect("/ProductController/HopQuaTetGo/PriceThan1tr");
                        }

                    } else {
                        if (path.endsWith("/ProductController/GioQuaTet") || path.startsWith("/ProductController/GioQuaTet/index")) {
                            request.setAttribute("path", "ProductController/GioQuaTet");
                            int index = 0;
                            String[] split = path.split("/");
                            try {
                                if (split.length == 3) {
                                    index = 1;
                                } else {
                                    index = Integer.parseInt(split[split.length - 1]);
                                }

                                int totalPro = dao.GetTotalProOfCat(2);
                                int endPage = totalPro / 6;
                                if ((totalPro % 6) != 0) {
                                    endPage++;
                                }

                                LinkedList<Product> list2 = dao.PagingProOfCat(index, 2);
                                request.setAttribute("list", list2);
                                request.setAttribute("endP", endPage);

                                request.getRequestDispatcher("/product.jsp").forward(request, response);
                            } catch (Exception e) {
                                response.sendRedirect("/ProductController/GioQuaTet");
                            }

                        } else {
                            if (path.endsWith("/ProductController/GioQuaTet/PriceLess1tr") || path.startsWith("/ProductController/GioQuaTet/PriceLess1tr/index")) {
                                request.setAttribute("path", "ProductController/GioQuaTet/PriceLess1tr");
                                int index = 0;
                                String[] split = path.split("/");
                                try {
                                    if (split.length == 4) {
                                        index = 1;
                                    } else {
                                        index = Integer.parseInt(split[split.length - 1]);
                                    }
                                    int totalPro = dao.GetTotalProOfCatByPriceIsLess(2, 1000.0);
                                    int endPage = totalPro / 6;
                                    if ((totalPro % 6) != 0) {
                                        endPage++;
                                    }

                                    LinkedList<Product> list2 = dao.PagingProOfCatByPriceIsLess(index, 2, 1000.0);
                                    request.setAttribute("list", list2);
                                    request.setAttribute("endP", endPage);

                                    request.getRequestDispatcher("/product.jsp").forward(request, response);
                                } catch (Exception e) {
                                    response.sendRedirect("/ProductController/GioQuaTet/PriceLess1tr");
                                }

                            } else {
                                if (path.endsWith("/ProductController/GioQuaTet/PriceThan1tr") || path.startsWith("/ProductController/GioQuaTet/PriceThan1tr/index")) {
                                    request.setAttribute("path", "ProductController/GioQuaTet/PriceThan1tr");
                                    int index = 0;
                                    String[] split = path.split("/");
                                    try {
                                        if (split.length == 4) {
                                            index = 1;
                                        } else {
                                            index = Integer.parseInt(split[split.length - 1]);
                                        }
                                        int totalPro = dao.GetTotalProOfCatByPriceIsGreater(2, 1000.0);
                                        int endPage = totalPro / 6;
                                        if ((totalPro % 6) != 0) {
                                            endPage++;
                                        }

                                        LinkedList<Product> list2 = dao.PagingProOfCatByPriceIsGreater(index, 2, 1000.0);
                                        request.setAttribute("list", list2);
                                        request.setAttribute("endP", endPage);

                                        request.getRequestDispatcher("/product.jsp").forward(request, response);
                                    } catch (Exception e) {
                                        response.sendRedirect("/ProductController/GioQuaTet/PriceThan1tr");
                                    }

                                } else {
                                    if (path.endsWith("/ProductController/TuiQuaTet") || path.startsWith("/ProductController/TuiQuaTet/index")) {
                                        request.setAttribute("path", "ProductController/TuiQuaTet");
                                        int index = 0;
                                        String[] split = path.split("/");
                                        try {
                                            if (split.length == 3) {
                                                index = 1;
                                            } else {
                                                index = Integer.parseInt(split[split.length - 1]);
                                            }

                                            int totalPro = dao.GetTotalProOfCat(3);
                                            int endPage = totalPro / 6;
                                            if ((totalPro % 6) != 0) {
                                                endPage++;
                                            }

                                            LinkedList<Product> list2 = dao.PagingProOfCat(index, 3);
                                            request.setAttribute("list", list2);
                                            request.setAttribute("endP", endPage);

                                            request.getRequestDispatcher("/product.jsp").forward(request, response);
                                        } catch (Exception e) {
                                            response.sendRedirect("/ProductController/TuiQuaTet");
                                        }

                                    } else {
                                        if (path.endsWith("/ProductController/TuiQuaTet/PriceLess500") || path.startsWith("/ProductController/TuiQuaTet/PriceLess500/index")) {
                                            request.setAttribute("path", "ProductController/TuiQuaTet/PriceLess500");
                                            int index = 0;
                                            String[] split = path.split("/");
                                            try {
                                                if (split.length == 4) {
                                                    index = 1;
                                                } else {
                                                    index = Integer.parseInt(split[split.length - 1]);
                                                }
                                                int totalPro = dao.GetTotalProOfCatByPriceIsLess(3, 500.0);
                                                int endPage = totalPro / 6;
                                                if ((totalPro % 6) != 0) {
                                                    endPage++;
                                                }

                                                LinkedList<Product> list2 = dao.PagingProOfCatByPriceIsLess(index, 3, 500.0);
                                                request.setAttribute("list", list2);
                                                request.setAttribute("endP", endPage);

                                                request.getRequestDispatcher("/product.jsp").forward(request, response);
                                            } catch (Exception e) {
                                                response.sendRedirect("/ProductController/TuiQuaTet/PriceLess500");
                                            }

                                        } else {
                                            if (path.endsWith("/ProductController/TuiQuaTet/PriceThan500") || path.startsWith("/ProductController/TuiQuaTet/PriceThan500/index")) {
                                                request.setAttribute("path", "ProductController/TuiQuaTet/PriceThan500");
                                                int index = 0;
                                                String[] split = path.split("/");
                                                try {
                                                    if (split.length == 4) {
                                                        index = 1;
                                                    } else {
                                                        index = Integer.parseInt(split[split.length - 1]);
                                                    }
                                                    int totalPro = dao.GetTotalProOfCatByPriceIsGreater(3, 500.0);
                                                    int endPage = totalPro / 6;
                                                    if ((totalPro % 6) != 0) {
                                                        endPage++;
                                                    }

                                                    LinkedList<Product> list2 = dao.PagingProOfCatByPriceIsGreater(index, 3, 500.0);
                                                    request.setAttribute("list", list2);
                                                    request.setAttribute("endP", endPage);

                                                    request.getRequestDispatcher("/product.jsp").forward(request, response);
                                                } catch (Exception e) {
                                                    response.sendRedirect("/ProductController/TuiQuaTet/PriceThan500");
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

        if (path.endsWith("/ProductController/less1tr") || path.startsWith("/ProductController/less1tr/index")) {
            request.setAttribute("path", "ProductController/less1tr");
            int index = 0;
            String[] split = path.split("/");
            try {
                if (split.length == 3) {
                    index = 1;
                } else {
                    index = Integer.parseInt(split[split.length - 1]);
                }

                int totalPro = dao.GetTotalProByPriceIsLess(1000.0);
                int endPage = totalPro / 6;
                if ((totalPro % 6) != 0) {
                    endPage++;
                }

                LinkedList<Product> list = dao.PagingProByPriceIsLess(index, 1000.0);
                request.setAttribute("list", list);
                request.setAttribute("endP", endPage);

                request.getRequestDispatcher("/product.jsp").forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("/ProductController/less1tr");
            }

        } else {
            if (path.endsWith("/ProductController/1trTo1,5tr") || path.startsWith("/ProductController/1trTo1,5tr/index")) {
                request.setAttribute("path", "ProductController/1trTo1,5tr");
                int index = 0;
                String[] split = path.split("/");
                try {
                    if (split.length == 3) {
                        index = 1;
                    } else {
                        index = Integer.parseInt(split[split.length - 1]);
                    }

                    int totalPro = dao.GetTotalByPriceBetween(1000.0, 1500.0);
                    int endPage = totalPro / 6;
                    if ((totalPro % 6) != 0) {
                        endPage++;
                    }

                    LinkedList<Product> list = dao.PagingProByPriceBetween(index, 1000.0, 1500.0);
                    request.setAttribute("list", list);
                    request.setAttribute("endP", endPage);

                    request.getRequestDispatcher("/product.jsp").forward(request, response);
                } catch (Exception e) {
                    response.sendRedirect("/ProductController/1trTo1,5tr");
                }

            } else {
                if (path.endsWith("/ProductController/1,5trTo2tr") || path.startsWith("/ProductController/1,5trTo2tr/index")) {
                    request.setAttribute("path", "ProductController/1,5trTo2tr");
                    int index = 0;
                    String[] split = path.split("/");
                    try {
                        if (split.length == 3) {
                            index = 1;
                        } else {
                            index = Integer.parseInt(split[split.length - 1]);
                        }

                        int totalPro = dao.GetTotalByPriceBetween(1500.0, 2000.0);
                        int endPage = totalPro / 6;
                        if ((totalPro % 6) != 0) {
                            endPage++;
                        }

                        LinkedList<Product> list = dao.PagingProByPriceBetween(index, 1500.0, 2000.0);
                        request.setAttribute("list", list);
                        request.setAttribute("endP", endPage);

                        request.getRequestDispatcher("/product.jsp").forward(request, response);
                    } catch (Exception e) {
                        response.sendRedirect("/ProductController/1,5trTo2tr");
                    }

                } else {
                    if (path.endsWith("/ProductController/2trTo2,5tr") || path.startsWith("/ProductController/2trTo2,5tr/index")) {
                        request.setAttribute("path", "ProductController/2trTo2,5tr");
                        int index = 0;
                        String[] split = path.split("/");
                        try {
                            if (split.length == 3) {
                                index = 1;
                            } else {
                                index = Integer.parseInt(split[split.length - 1]);
                            }

                            int totalPro = dao.GetTotalByPriceBetween(2000.0, 2500.0);
                            int endPage = totalPro / 6;
                            if ((totalPro % 6) != 0) {
                                endPage++;
                            }

                            LinkedList<Product> list = dao.PagingProByPriceBetween(index, 2000.0, 2500.0);
                            request.setAttribute("list", list);
                            request.setAttribute("endP", endPage);

                            request.getRequestDispatcher("/product.jsp").forward(request, response);
                        } catch (Exception e) {
                            response.sendRedirect("/ProductController/2trTo2,5tr");
                        }

                    } else {
                        if (path.endsWith("/ProductController/2,5trTo3tr") || path.startsWith("/ProductController/2,5trTo3tr/index")) {
                            request.setAttribute("path", "ProductController/2,5trTo3tr");
                            int index = 0;
                            String[] split = path.split("/");
                            try {
                                if (split.length == 3) {
                                    index = 1;
                                } else {
                                    index = Integer.parseInt(split[split.length - 1]);
                                }

                                int totalPro = dao.GetTotalByPriceBetween(2500.0, 3000.0);
                                int endPage = totalPro / 6;
                                if ((totalPro % 6) != 0) {
                                    endPage++;
                                }

                                LinkedList<Product> list = dao.PagingProByPriceBetween(index, 2500.0, 3000.0);
                                request.setAttribute("list", list);
                                request.setAttribute("endP", endPage);

                                request.getRequestDispatcher("/product.jsp").forward(request, response);
                            } catch (Exception e) {
                                response.sendRedirect("/ProductController/2,5trTo3tr");
                            }

                        } else {
                            if (path.endsWith("/ProductController/3trTo5tr") || path.startsWith("/ProductController/3trTo5tr/index")) {
                                request.setAttribute("path", "ProductController/3trTo5tr");
                                int index = 0;
                                String[] split = path.split("/");
                                try {
                                    if (split.length == 3) {
                                        index = 1;
                                    } else {
                                        index = Integer.parseInt(split[split.length - 1]);
                                    }

                                    int totalPro = dao.GetTotalByPriceBetween(3000.0, 5000.0);
                                    int endPage = totalPro / 6;
                                    if ((totalPro % 6) != 0) {
                                        endPage++;
                                    }

                                    LinkedList<Product> list = dao.PagingProByPriceBetween(index, 3000.0, 5000.0);
                                    request.setAttribute("list", list);
                                    request.setAttribute("endP", endPage);

                                    request.getRequestDispatcher("/product.jsp").forward(request, response);
                                } catch (Exception e) {
                                    response.sendRedirect("/ProductController/3trTo5tr");
                                }

                            } else {
                                if (path.endsWith("/ProductController/5trTo10tr") || path.startsWith("/ProductController/5trTo10tr/index")) {
                                    request.setAttribute("path", "ProductController/5trTo10tr");
                                    int index = 0;
                                    String[] split = path.split("/");
                                    try {
                                        if (split.length == 3) {
                                            index = 1;
                                        } else {
                                            index = Integer.parseInt(split[split.length - 1]);
                                        }

                                        int totalPro = dao.GetTotalByPriceBetween(5000.0, 10000.0);
                                        int endPage = totalPro / 6;
                                        if ((totalPro % 6) != 0) {
                                            endPage++;
                                        }

                                        LinkedList<Product> list = dao.PagingProByPriceBetween(index, 5000.0, 10000.0);
                                        request.setAttribute("list", list);
                                        request.setAttribute("endP", endPage);

                                        request.getRequestDispatcher("/product.jsp").forward(request, response);
                                    } catch (Exception e) {
                                        response.sendRedirect("/ProductController/5trTo10tr");
                                    }

                                }
                            }
                        }
                    }
                }
            }

        }

        if (path.startsWith("/ProductController/Detail")) {
            CategoriesDAO cdao = new CategoriesDAO();
            String[] split = path.split("/");
            try {
                int id = Integer.parseInt(split[split.length - 1]);
                Product product = dao.GetProById(id);
                Categories cat = cdao.GetCatById(product.getCat_id());
                HttpSession session = request.getSession();
                session.setAttribute("product", product);
                session.setAttribute("categories", cat);
                request.getRequestDispatcher("/detailOfPro.jsp").forward(request, response);
            } catch (Exception e) {
              response.sendRedirect("/HomeController");
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
