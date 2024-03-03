<%-- 
    Document   : orderDetail
    Created on : Nov 2, 2023, 1:21:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lisDetail}" var="o">
                        <tr>
                            <td>
                                ${o.o_id}
                            </td>
                            <td>
                                ${o.pro_id}
                            </td>

                            <td>
                                ${o.pro_name}
                            </td>
                            <td>
                                ${o.pro_price}
                            </td>
                            <td>
                                ${o.pro_quantity}
                            </td>
                            <td>
                                ${o.total_price}
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
    </body>
</html>
