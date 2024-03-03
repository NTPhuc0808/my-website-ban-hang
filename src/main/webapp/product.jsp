<%-- 
    Document   : product
    Created on : Oct 16, 2023, 11:54:05 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>San pham</title>
        <style>
            .page-link:active {
                background: inherit !important;            }
        </style>
    </head>
    <body>
        <%@include file="head.jsp" %>

        <div class="container mt-5 ps-5 px-5">
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-6 col-md-12 border-1 border p-0">
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
                    <div class="row ">
                        <c:forEach items="${list}" var="p">
                            <div class="col-lg-4 pt-0 pt-3 text-center">
                                <div class="card  w-100 h-100">
                                    <a href="/ProductController/Detail/${p.pro_id}">
                                        <img src="/${p.pro_picture}" class="card-img-top h-100" alt="product img">
                                    </a>
                                    <div class="card-body">
                                        <h5 class="card-title">${p.pro_name}</h5>
                                        <p class="card-text">${p.pro_price}</p>
                                        <c:if test="${p.pro_quantity>0}">
                                            <a href="/CartController/AddToCartAtPro/${p.pro_id}" class="btn btn-primary ms-3">add to cart</a>
                                            <a href="/OrderController/BuyNow/${p.pro_id}" class="btn btn-primary mx-3">buy now</a>
                                        </c:if>
                                        <c:if test="${p.pro_quantity==0}">
                                            <p class="btn btn-primary">Hết hàng</p>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>


                    </div>
                    <div class="mt-3">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-center">
                                <c:if test="${path == 'ProductController'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/HopQuaTetGo'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/HopQuaTetGo/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/HopQuaTetGo/PriceLess1tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/HopQuaTetGo/PriceLess1tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/HopQuaTetGo/PriceThan1tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/HopQuaTetGo/PriceThan1tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/GioQuaTet'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/GioQuaTet/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/GioQuaTet/PriceLess1tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/GioQuaTet/PriceLess1tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/GioQuaTet/PriceThan1tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/GioQuaTet/PriceThan1tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/TuiQuaTet'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/TuiQuaTet/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/TuiQuaTet/PriceLess500'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/TuiQuaTet/PriceLess1tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/TuiQuaTet/PriceThan500'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/TuiQuaTet/PriceThan500/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/less1tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/less1tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/1trTo1,5tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/1trTo1,5tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/1,5trTo2tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/1,5trTo2tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/2trTo2,5tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/2trTo2,5tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/2,5trTo3tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/2,5trTo3tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/3trTo5tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/3trTo5tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${path == 'ProductController/5trTo10tr'}">
                                    <c:forEach begin="1" end="${endP}" var="i">
                                        <li class="page-item">
                                            <a class="page-link" href="/ProductController/5trTo10tr/index/${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                            </ul>
                        </nav>
                    </div>


                </div>

            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
