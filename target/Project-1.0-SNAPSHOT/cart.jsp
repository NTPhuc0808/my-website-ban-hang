<%-- 
    Document   : cart
    Created on : Oct 26, 2023, 4:59:09 AM
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
        <form method="post" class="form-inline container mt-3" action="OrderController" onsubmit="return validateCheckBox()">
            <table id="example" class="display border border-2">
                <thead>
                    <tr>
                        <th>Chọn mua</th>
                        <th>Mã sản phẩm</th>
                        <th>Sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                        <th>Cancel</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cart_list}" var="c">
                        <tr>
                            <td>
                                <input type="checkbox" name="checkbox" class="checkBuy" value="${c.cart_id}">
                            </td>
                            <td>
                                ${c.pro_id}
                            </td>

                            <td>
                                ${c.pro_name}
                            </td>
                            <td>
                                ${c.price}
                            </td>
                            <td class="w-25">
                                <div class="form-group d-flex justify-content-between">
                                    <a class="btn btn-sm btn-decre" href="/CartController/DecQuan/${c.pro_id}"><i class="fas fa-minus-square"></i></a>
                                    <input type="text" name="quantity" class="form-control" value="${c.pro_quantity}" readonly>
                                    <a class="btn bnt-sm btn-incre" href="/CartController/IncQuan/${c.pro_id}"><i class="fas fa-plus-square"></i></a>
                                </div>
                            </td>
                            <td>
                                ${c.total_price}
                            </td>
                            <td><a onclick="return confirm('Do you want to delete this cart?')" href="/CartController/Delete/${c.cart_id}"class="btn btn-sm btn-danger">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${cart_list.size()!=0}">
                <input type="submit" class="btn btn-success" value="Buy now" name="btnBuy">
            </c:if>

        </form>
        <script src="https://code.jquery.com/jquery-3.7.0.js"></script> <%-- 3 dong script la thu vien cua table lay o trang datatable.nets --%>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script>
                                new DataTable('#example');
        </script>
        <script src="JS/validate.js"></script>
    </body>
</html>
