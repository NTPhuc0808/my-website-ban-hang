<%-- 
    Document   : Ordered
    Created on : Oct 29, 2023, 12:25:26 AM
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
                    <c:forEach items="${orders}" var="o">
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
                                <a class="btn btn-danger" href="/OrderController/Ordered/cancel/${o.o_id}">Cancel</a>
                                <a class="btn btn-info" href="/OrderController/Ordered/detail/${o.o_id}">Detail</a>
                                
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.7.0.js"></script> <%-- 3 dong script la thu vien cua table lay o trang datatable.nets --%>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script>
            new DataTable('#example');
        </script>
        <script src="JS/validate.js"></script>
    </body>
</html>
