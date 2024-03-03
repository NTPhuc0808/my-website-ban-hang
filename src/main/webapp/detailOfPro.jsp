<%-- 
    Document   : detailOfPro
    Created on : Oct 23, 2023, 5:05:47 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>San pham</title>
    </head>
    <body>
        <%@include file="head.jsp" %>

        <div class="container mt-5 ps-5 px-5">
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-6 col-12 border-1 border p-0">
                    <p class="h4 text-center p-2" style="background-color: rgb(213, 221, 221);">Danh mục quà tết</p>
                    <ul class="list-inline ps-3 px-3">
                        <li class="border-bottom p-2">
                            <a class="h6 text-dark text-decoration-none" href="/ProductController/HopQuaTetGo">Hộp quà tết gỗ
                                2024</a>
                        </li>
                        <li class="border-bottom p-2">
                            <a class="text-dark text-decoration-none" href="/ProductController/HopQuaTetGo/PriceLess1tr">-Hộp quà tết gỗ giá
                                &lt;
                                1tr</a>
                        </li>
                        <li class="border-bottom p-2">
                            <a class="text-dark text-decoration-none" href="/ProductController/HopQuaTetGo/PriceThan1tr">-Hộp quà tết gỗ giá
                                &gt;
                                1tr</a>
                        </li>
                        <li class="border-bottom p-2">
                            <a class="h6 text-dark text-decoration-none" href="/ProductController/GioQuaTet">Giỏ quà tết
                                2024</a>
                        </li>
                        <li class="border-bottom p-2">
                            <a class="text-dark text-decoration-none" href="/ProductController/GioQuaTet/PriceLess1tr">-Giỏ quà tết giá
                                &lt;
                                1tr</a></li>
                        <li class="border-bottom p-2">
                            <a class="text-dark text-decoration-none" href="/ProductController/GioQuaTet/PriceThan1tr">-Giỏ quà tết giá
                                &gt;
                                1tr</a></li>
                        <li class="border-bottom p-2">
                            <a class="h6 text-dark text-decoration-none" href="/ProductController/TuiQuaTet">Túi quà tết
                                2024</a>
                        </li>
                        <li class="border-bottom p-2">
                            <a class="text-dark text-decoration-none" href="/ProductController/TuiQuaTet/PriceLess500">-Túi quà tết gỗ giá
                                &lt;
                                500</a></li>
                        <li class="border-bottom p-2">
                            <a class="text-dark text-decoration-none" href="/ProductController/TuiQuaTet/PriceThan500">-Túi quà tết gỗ giá
                                &gt;
                                500</a></li>
                    </ul>
                </div>
                <div class="col-lg-9 col-md-6 col-sm-6 col-12 ps-2">
                    <p class="h5 border-bottom border-danger pb-2">Danh mục sản phẩm</p>
                    <div class="row ps-3">
                        <div class="row ps-3">
                            <div class="col-lg-6 col-md-12 col-sm-6 col-12 border border-dark ">
                                <img class="w-100 h-100" src="/${product.pro_picture}" alt="product image">
                            </div>
                            <div class="col-lg-5 col-md-12 col-sm-6 col-12 mt-3">
                                <h5
                                    class="text-center w-100 text-uppercase fw-bold text-danger border-bottom shadow shadow-bottom p-3">
                                    ${product.pro_name}
                                </h5>
                                <p class="p-3 w-100 fs-5 pb-0">Giá: ${product.pro_price}</p>
                                <p class="ps-3 w-100 fs-5 pt-0">số lượng hàng: ${product.pro_quantity}</p>

                            </div>

                        </div>
                        <div class="mt-4">
                            <h5 class="text-center w-100 text-uppercase fw-bold p-3">
                                Chi tiết sản phẩm
                            </h5>
                            <p class="p-3 w-100 fs-5 pb-0">${product.pro_name} bao gồm các sản phẩm sau:</p>
                            <p class="ps-3 w-100 pt-0">${product.pro_description}</p>


                            <p class="ps-3 w-100 pt-0">${categories.cat_description}</p>
                        </div>
                    </div>

                </div>
            </div>
        </div>          
        <%@include file="footer.jsp" %>
    </body>
</html>
