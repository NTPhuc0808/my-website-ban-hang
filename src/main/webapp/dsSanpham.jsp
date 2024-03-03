<%-- 
    Document   : dsSanpham
    Created on : Oct 30, 2023, 3:21:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/> 
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div >
            <div class="d-flex flex-row-reverse" style="background-color: rgb(134, 188, 170);">
                <a class="btn btn-danger mx-5 h-100 mt-1" href="/LogoutController">Logout</a>
                <p class="mx-5 h-100 pt-2">Xin chao boss</p>
            </div>

        </div>
        <div class="row"> 
            <div class="text-center col-2" style="background-color: rgb(163, 173, 173); width: 250px; height: 1650px;">


                <p><a class="nav-link text-dark mt-3" href="/AdminController">Thống kê</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dsuser">Danh sách tài khoản</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dssanpham">Danh sách sản phẩm</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dsDonHang">Danh sách đơn hàng</a></p>

            </div>
            <div class="col-10">
                <div class=" mt-3 mb-3">
                    <a class="btn btn-primary" href="/AdminController/dssanpham/createPro">Create new product</a>
                </div>
                <table id="example" class=" border border-2">
                    <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Ten</th>
                            <th>picture</th>
                            <th>Don gia</th>
                            <th>SO luong</th>
                            <th>mo ta</th>
                            <th>trang thai</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${dsPro}" var="p">
                            <tr>
                                <td>
                                    ${p.pro_id}
                                </td>

                                <td>
                                    ${p.pro_name}
                                </td>

                                <td class="h-25" style="width: 250px;">
                                    <img src="/${p.pro_picture}" class="w-50 h-50" alt="product picture"/>

                                </td>
                                <td>
                                    ${p.pro_price}
                                </td>
                                <td>
                                    ${p.pro_quantity}
                                </td>
                                <td>
                                    ${p.pro_description}
                                </td>
                                <td>
                                    <c:if test="${p.pro_quantity==0}">
                                        <p>Het hang</p>
                                    </c:if>
                                    <c:if test="${p.pro_quantity!=0}">
                                        <p>Con hang</p>
                                    </c:if>
                                </td>
                                <td>
                                    <a class="btn btn-success" href="/AdminController/dssanpham/editPro/${p.pro_id}">Edit</a>
                                    <a onclick="return confirm('Do you want to delete this product?')" class="btn btn-danger" href="/AdminController/dssanpham/deletePro/${p.pro_id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.7.0.js"></script> <%-- 3 dong script la thu vien cua table lay o trang datatable.nets --%>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script>
                                        new DataTable('#example');
        </script>
        <script src="JS/validate.js"></script>
    </body>
</html>
