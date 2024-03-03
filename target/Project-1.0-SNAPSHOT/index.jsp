<%-- 
    Document   : header
    Created on : Oct 13, 2023, 6:36:19 PM
    Author     : Dell
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
    </head>
    <body>
        <%@include file="head.jsp" %>
        <div class="container mt-3">
            <!-- image  -->
            <div class="row" style="height: 390px">
                <div class="col-9 ps-0">
                    <img class="w-100  h-75" src="images/slide_1..jpg" alt="slide_1">
                </div>
                <div class="col-3 px-0">
                    <img class="w-100  h-75" src="images/slide_2.jpg" alt="slide_2">
                </div>
            </div>
            <div class="row">
                <div class="col-4 ps-0 px-0">
                    <img class="w-100 h-100" src="images/slide_4.jpg" alt="">
                </div>
                <div class="col-4">
                    <img class="w-100 h-100" src="images/silde_5.jpg" alt="">
                </div>
                <div class="col-4 px-0">
                    <img class="w-100 h-100" src="images/silde_6.jpg" alt="">
                </div>
            </div>
        </div>
        <!-- start first categories hop qua go -->
        <div>
            <c:forEach items="${cat.entrySet()}" var="c">
                <div class="container mt-5 ">
                    <div class="d-flex justify-content-between">
                        <p class="h3">${c.key.cat_name}</p>
                        <c:if test="${c.key.cat_id ==1}">
                            <a href="/ProductController/HopQuaTetGo" class="align-content-end h6 pt-3 text-dark text-decoration-none">Xem thêm</a>
                        </c:if>
                        <c:if test="${c.key.cat_id ==2}">
                            <a href="/ProductController/GioQuaTet" class="align-content-end h6 pt-3 text-dark text-decoration-none">Xem thêm</a>
                        </c:if>
                        <c:if test="${c.key.cat_id ==3}">
                            <a href="/ProductController/TuiQuaTet" class="align-content-end h6 pt-3 text-dark text-decoration-none">Xem thêm</a>
                        </c:if>
                    </div>
                    <div class="row mt-1 border-2 border-danger border-top ">
                        <div class="col-lg-3 col-md-4 col-sm-6 col-12 p-0 pt-3 px-3">
                            <img class="w-100 h-100" src="${c.key.cat_picture}" alt="hop go">
                        </div>
                        <c:forEach items="${c.value}" var="p">
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12 pt-0 pt-3 text-center">
                                <div class="card h-100">
                                    <a href="/ProductController/Detail/${p.pro_id}"><img src="/${p.pro_picture}" class="card-img-top h-100" alt="product img"></a>
                                    <div class="card-body">
                                        <h5 class="card-title">${p.pro_name}</h5>
                                        <p class="card-text">${p.pro_price}</p>
                                        <c:if test="${p.pro_quantity>0}">
                                            <a href="CartController/AddToCartAtHome/${p.pro_id}" class="btn btn-primary ms-3">add to cart</a>
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
                </div>

            </c:forEach>



        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
