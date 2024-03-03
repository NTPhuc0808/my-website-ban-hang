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
        <link rel="stylesheet" href="/CSS/style.css">
    </head>
    <body>
        <%@include file="head.jsp" %>
        <div class="container mt-4">

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
                    <tr>
                        <td>
                            ${proBuy.pro_id}
                        </td>

                        <td>
                            ${proBuy.pro_name}
                        </td>
                        <td>
                            ${proBuy.pro_price}
                        </td>
                        <td>
                            1
                        </td>
                        <td>
                            ${proBuy.pro_price}
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <form class="container" action="OrderController" method="post" onsubmit="return validateOrders()">
            <div class="form-group pb-4 validate">
                <label>Fulname:</label>
                <input type="text" class="form-control" readonly value="${account.fullname}">
            </div>
            <div class="validate form-group pb-4 validate">
                <label>address:</label>
                <input type="text" id="address" class="form-control"placeholder="Enter your adsress" name="address">
                <br/>
                <span class="error"></span>
            </div>
            <div class="validate form-group pb-4 validate">
                <label>Your phone number:</label>
                <input type="text" id="phones" class="form-control" placeholder="phone number" name="phone" >
                <br/>
                <span class="error"></span>
            </div>

            <p class="fs-5">so tien: ${proBuy.pro_price}</p>
            <input type="submit" class="btn btn-primary" name="btnBuyNow" value="Check out">
        </form>
        <script src="https://code.jquery.com/jquery-3.7.0.js"></script> <%-- 3 dong script la thu vien cua table lay o trang datatable.nets --%>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

        <script>
            new DataTable('#example');
        </script>
        <script>



            function validateOrders() {
                const setSuccess = (element) => {
                    const inputControl = element.parentElement;
                    const errorDisplay = inputControl.querySelector("span");
                    errorDisplay.innerText = "";
                    inputControl.classList.add("success");
                    inputControl.classList.remove("error");
                };
                const setError = (element, message) => {
                    const inputControl = element.parentElement;
                    const errorDisplay = inputControl.querySelector("span");
                    errorDisplay.innerText = message;
                    inputControl.classList.add("error");
                    inputControl.classList.remove("success");
                };
                let check = true;
                const address = document.getElementById("address");
                const phone = document.getElementById("phones");

                if (address.value.trim() === "") {
                    setError(address, "address is require!");
                    check = false;
                } else if (address.value.trim().length < 10 || address.value.trim().length > 1000) {
                    setError(address, "The length of address must greater than 10 and less or equal 1000");
                    check = false;
                } else {
                    setSuccess(address);
                }

                if (phone.value.trim() === "") {
                    setError(phone, "phone is require!");
                    check = false;
                } else if (!isVietnamesePhoneNumber(phone.value.trim())) {
                    setError(phone, "phone number must is vietnamese phone number!");
                    check = false;
                } else {
                    setSuccess(phone);
                }
                return check;

            }

            function isVietnamesePhoneNumber(number) {
                return /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test(number);
            }
        </script>
    </body>
</html>
