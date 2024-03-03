<%-- 
    Document   : adCreateOrder
    Created on : Nov 1, 2023, 10:27:50 PM
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
        <form class="container" action="AdminController" method="post">
            <div class="form-group pb-4 validate">
                <label>Order id:</label>
                <input type="text" class="form-control" readonly value="${orders.o_id}" name="txtId">
            </div>
            <div class="form-group pb-4 validate">
                <label>Account id:</label>
                <input type="text" class="form-control" readonly value="${orders.acc_id}">
            </div>
            <div class="form-group pb-4 validate">
                <label>address:</label>
                <input type="text" class="form-control" name="address" readonly value="${orders.o_address}">
            </div>
            <div class="form-group pb-4 validate">
                <label>phone number:</label>
                <input type="number" class="form-control" name="phone" readonly value="${orders.o_phone}">
            </div>
            <div class="form-group pb-4 validate">
                <label>Total price:</label>
                <input type="text" class="form-control" value="${orders.total_price}" readonly>
            </div>
            <div class="form-group pb-4 validate">
                <label>Order date:</label>
                <input type="date" class="form-control" value="${orders.o_date}" readonly>
            </div>
            <div class="form-group pb-4 validate">
                <select name="o_status">
                    <option value="Order"
                            <c:if test="${orders.order_status== 'Order'}">
                                selected
                            </c:if>
                            >Đã đặt hàng</option>
                    <option
                        value="Processing"
                        <c:if test="${orders.order_status == 'Processing'}">
                            selected
                        </c:if>
                        >Đang xử lý</option>
                    <option
                        value="Shipped"
                        <c:if test="${orders.order_status== 'Shipped'}">
                            selected
                        </c:if>
                        >Đã vận chuyển</option>
                    <option
                        value="Delivered"
                        <c:if test="${orders.order_status== 'Delivered'}">
                            selected
                        </c:if>
                        >Đã giao hàng</option>
                    <option
                        value="Cancelled"
                        <c:if test="${orders.order_status== 'Cancelled'}">
                            selected
                        </c:if>
                        >Đã hủy</option>
                </select>
            </div>
            <input type="submit" class="btn btn-primary" name="btnEditOrder" value="Check out">
        </form>



        <script src="https://code.jquery.com/jquery-3.7.0.js"></script> <%-- 3 dong script la thu vien cua table lay o trang datatable.nets --%>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script>
            new DataTable('#example');
        </script>
        <script src="JS/validate.js"></script>
    </body>
</html>
