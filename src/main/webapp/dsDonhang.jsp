<%-- 
    Document   : dsDonhang
    Created on : Nov 1, 2023, 10:01:49 PM
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
            <div class="text-center col-2" style="background-color: rgb(163, 173, 173); width: 250px; height: 800px;">


                <p><a class="nav-link text-dark mt-3" href="/AdminController">Thống kê</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dsuser">Danh sách tài khoản</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dssanpham">Danh sách sản phẩm</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dsDonHang">Danh sách đơn hàng</a></p>

            </div>
            <div class="col-10">
                <table id="example" class="display border border-2">
                    <thead>
                        <tr>
                            <th>Mã đơn hàng</th>
                            <th>Địa chỉ</th>
                            <th>Số điện thoại</th>
                            <th>Tổng tiền</th>
                            <th>Ngày đặt hàng</th>
                            <th>Trạng thái đơn hàng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${dsOrders}" var="o">
                            <tr>
                                <td>
                                    ${o.o_id}
                                </td>

                                <td>
                                    ${o.o_address}
                                </td>
                                <td>
                                    ${o.o_phone}
                                </td>
                                <td>
                                    ${o.total_price}
                                </td>
                                <td>
                                    ${o.o_date}
                                </td>
                                <td>
                                    ${o.order_status}
                                </td>
                                <td>
                                    <a class="btn btn-primary" href="/AdminController/dsDonHang/edit/${o.o_id}">Edit</a>
                                    <a class="btn btn-primary" href="/AdminController/dsDonHang/detail/${o.o_id}">Detail</a>
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