<%-- 
    Document   : lienhe
    Created on : Nov 3, 2023, 3:41:11 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="head.jsp" %>
        <div class="container mt-5">
            <div class="row d-flex">

                <iframe class="border border-4 col-md-7" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7372162763418!2d106.71502047486966!3d10.831411058177444!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529965318385f%3A0x143f782db1eddc22!2zUVXDgCBU4bq-VCBWSeG7hlQgNjg!5e0!3m2!1sen!2s!4v1699000962008!5m2!1sen!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>

                <div class="col-md-5">
                    <div>
                        <label class="text-danger fw-bold">Địa Chỉ</label>
                        <p>
                            181 Bùi Hữu Nghĩa, P1, Q. Bình Thạnh, TPHCM
                        </p>
                    </div>
                    <div>
                        <label class="text-danger fw-bold">Điện Thoại</label>
                        <p>
                            0949 8080 26 - (028) 6258 1056
                        </p>
                    </div>
                    <div>
                        <label class="text-danger fw-bold">Email</label>
                        <p>
                            info@quatetonline.net - quatangminhan@gmail.com
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
