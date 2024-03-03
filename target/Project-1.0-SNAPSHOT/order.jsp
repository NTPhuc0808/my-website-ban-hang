<%-- 
    Document   : order.jsp
    Created on : Oct 28, 2023, 2:29:56 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/> 
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"/>
    </head>
    <body>
        <%@include file="head.jsp" %>
        <div class="container mt-4">

            <c:if test="${cart_out.size()!=0}">
                <table  class="table table-light mb-4">
                    <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${cart_out}" var="c">
                            <tr>
                                <td>
                                    ${c.pro_id}
                                </td>

                                <td>
                                    ${c.pro_name}
                                </td>
                                <td>
                                    ${c.price}
                                </td>
                                <td>
                                    ${c.pro_quantity}
                                </td>
                                <td>
                                    ${c.total_price}
                                </td>
                                <td>
                                    Sản phẩm này không đủ số lượng
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <table id="example" class="display border border-2">
                <thead>
                    <tr>
                        <th>Mã sản phẩm</th>
                        <th>Sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${cart_buy}" var="c">
                        <tr>
                            <td>
                                ${c.pro_id}
                            </td>

                            <td>
                                ${c.pro_name}
                            </td>
                            <td>
                                ${c.price}
                            </td>
                            <td>
                                ${c.pro_quantity}
                            </td>
                            <td>
                                ${c.total_price}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <form class="container" action="OrderController" method="post" onsubmit="return validateOrder();">
            <div class="form-group pb-4 validate">
                <label>Fulname:</label>
                <input type="text" class="form-control" readonly value="${account.fullname}">
            </div>
            <div class="validate form-group pb-4 validate">
                <label>address:</label>
                <input type="text" class="form-control"placeholder="Enter your adsress" name="address" id="add">
                <br/>
                <span class="error"></span>
            </div>
            <div class="validate form-group pb-4 validate">
                <label>Your phone number:</label>
                <input type="text" class="form-control"placeholder="phone number" name="phone" id="phone">
                <br/>
                <span class="error"></span>
            </div>

            <p class="fs-5">so tien: ${tong_tien}</p>
            <input type="submit" class="btn btn-primary" name="btnCheckOut" value="Check out">
        </form>
        <script src="https://code.jquery.com/jquery-3.7.0.js"></script> <%-- 3 dong script la thu vien cua table lay o trang datatable.nets --%>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script>
            new DataTable('#example');
        </script>
        <script src="JS/validate.js"></script>
    </body>
</html>