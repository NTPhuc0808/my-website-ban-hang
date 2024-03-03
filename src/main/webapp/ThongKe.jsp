<%-- 
    Document   : ThongKe
    Created on : Oct 30, 2023, 3:18:52 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" />
        <title>JSP Page</title>
    </head>

    <body>

        <div class="row">
            <div class="text-center col-lg-2 col-md-2 col-sm-3 col-12 h-100"
                 style="background-color: rgb(163, 173, 173);">


                <p><a class="nav-link text-dark mt-3" href="/AdminController">Thống kê</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dsuser">Danh sách tài khoản</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dssanpham">Danh sách sản phẩm</a></p>
                <p><a class="nav-link text-dark" href="/AdminController/dsDonHang">Danh sách đơn hàng</a></p>

            </div>
            <div class="col-lg-10 col-sm-9 col-md-10 col-12 p-0">

                <div class="d-flex flex-row-reverse" style="background-color: rgb(134, 188, 170);">
                    <a class="btn btn-danger mx-5 h-100 mt-1" href="/LogoutController">Logout</a>
                    <p class="mx-5 h-100 pt-2">Xin chao boss</p>
                </div>


                <div class="row d-flex justify-content-around">
                    <div class="col-6 col-md-3 col-lg-3 bg-light m-2 border rounded d-flex justify-content-between">
                        <p class="pt-2">User</p>
                        <p class="pt-2">${totalUser}</p>
                    </div>
                    <div class="col-6 col-md-3 col-lg-3 bg-light m-2 border rounded d-flex justify-content-between">
                        <p class="pt-2">Product</p>
                        <p class="pt-2">${totalPro}</p>
                    </div>
                    <div class="col-6 col-md-3 col-lg-3 bg-light m-2 border rounded d-flex justify-content-between">
                        <p class="pt-2">Order</p>
                        <p class="pt-2">${totalOrder}</p>
                    </div>
                    <div class="col-6 col-md-3 col-lg-3 bg-light m-2 border rounded d-flex justify-content-between">
                        <p class="pt-2">Daily total</p>
                        <p class="pt-2">20</p>
                    </div>
                    <div class="col-6 col-md-3 col-lg-3 bg-light m-2 border rounded d-flex justify-content-between">
                        <p class="pt-2">Weekly total</p>
                        <p class="pt-2">20</p>
                    </div>
                    <div class="col-6 col-md-3 col-lg-3 bg-light m-2 border rounded d-flex justify-content-between">
                        <p class="pt-2">Monthly total</p>
                        <p class="pt-2">20</p>
                    </div>

                </div>
                <div class="row">
                    <p class="h5">Thong ke theo ngay</p>
                    <form method="get" action="AdminController">
                        <label>Ngay</label>
                        <input type="=date" name="date">
                    </form>
                    <table id="example" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Position</th>
                                <th>Office</th>
                                <th>Age</th>
                                <th>Start date</th>
                                <th>Salary</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Tiger Nixon</td>
                                <td>System Architect</td>
                                <td>Edinburgh</td>
                                <td>61</td>
                                <td>2011-04-25</td>
                                <td>$320,800</td>
                            </tr>
                        </tbody><!-- comment -->
                    </table>
                </div> 

            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script>
            new DataTable('#example');
        </script>
        <script src="JS/validate.js"></script>

    </body>

</html>