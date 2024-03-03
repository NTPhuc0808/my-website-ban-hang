<%-- 
    Document   : headerTest
    Created on : Nov 3, 2023, 8:16:29 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="CSS/style.css">
        <title>header</title>
    </head>

    <body>
        <div class="container-fluid d-flex border-bottom shadow" style="background-color: rgb(227, 241, 164);">
            <div class="container ">
                <div class="row p-3">
                    <div class="col-md-1 col-sm-12 col-12">
                        <img src="/images/logo.png" class="w-100">
                    </div>
                    <div class="col-md-6 col-sm-12 col-6">

                        <nav class="navbar navbar-expand-sm text-uppercase fs-6 text-lg-center ">

                            <ul class="navbar-nav d-flex">
                                <li class="nav-item">
                                    <a class="nav-link text-dark" href="/HomeController">Trang Chủ</a>
                                </li>

                                <li class="nav-item dropdown">
                                    <a class="nav-link text-dark" href="/ProductController">Sản Phẩm</a>
                                </li>



                                <li class="nav-item ">
                                    <a class="nav-link text-dark" href="/LienHeController">Liên hệ</a>
                                </li>

                                <c:if test="${account!=null}">
                                    <li class="nav-item">
                                        <a class="nav-link text-dark" href="/CartController">Giỏ hàng <span class="text-uppercase bg-danger text-white rounded-circle p-1
                                                                                                            ">${cart_list.size()}</span> </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link text-dark" href="/OrderController/Ordered">Đơn hàng <span class="text-uppercase bg-danger text-white rounded-circle p-1
                                                                                                                     ">${orders.size()}</span></a>
                                    </li> 

                                </c:if>
                            </ul>

                        </nav>

                    </div>
                    <div class=" col-md-2 col-sm-12 col-6">
                        <nav class="navbar navbar-expand-sm fs-6 text-lg-center ">
                            <ul class="navbar-nav border border-2 border-danger w-100">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle text-dark" href="#" data-bs-toggle="dropdown">Tìm
                                        theo giá
                                    </a>
                                    <ul class="dropdown-menu">
                                        <!-- <li><a class="dropdown-item" href="#">Hop qua tet go 2024</a></li> -->
                                        <li>
                                            <a class="dropdown-item" href="/ProductController/less1tr">Dưới 1 triệu</a>
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="/ProductController/1trTo1,5tr"> 1 triệu - 1,5
                                                triệu</a>
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="/ProductController/1,5trTo2tr"> 1,5 triệu - 2
                                                triệu</a>
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="/ProductController/2trTo2,5tr">2 triệu - 2,5
                                                triệu</a>
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="/ProductController/2,5trTo3tr"> 2,5 triệu - 3
                                                triệu</a>
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="/ProductController/3trTo5tr"> 3 triệu - 5
                                                triệu</a>
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="/ProductController/5trTo10tr"> 5 triệu - 10
                                                triệu</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-3 col-sm-12 col-6 border-2  border-start border-danger d-flex ">

                        <c:if test="${account==null}">
                            <a href="/LoginController" class="btn btn-info m-2">Login</a>

                        </c:if>
                        <c:if test="${account!=null}">
                            <a href="/LogoutController" class="btn btn-info m-2">Logout</a>

                        </c:if>
                        <c:if test="${fullname!=null}">
                            <div class="w-100 d-flex">

                                <span class="text-lg-center p-2 pt-3">Xin chào ${fullname}</span>
                            </div>
                        </c:if>



                    </div>

                </div>
            </div>
        </div>
    </body>

</html>
