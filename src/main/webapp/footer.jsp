<%-- 
    Document   : footer
    Created on : Oct 23, 2023, 11:25:23 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Footer</title>
    </head>
    <body>
        <footer class="text-center text-lg-start text-white mt-5" style="background-color: #000000">
            <!-- Grid container -->
            <div class="container p-4 pb-0">
                <!-- Section: Links -->
                <section class="">
                    <!--Grid row-->
                    <div class="row">
                        <!-- Grid column -->
                        <div class="col-md-4 col-lg-4 col-xl-5 mx-auto mt-3">
                            <h6 class="text-uppercase mb-4 font-weight-bold">Liên hệ với chúng tôi</h6>
                            <p><i class="fas fa-home mr-3 p-1"></i>  CÔNG TY TNHH TM DV PT MINH AN</p>
                            <p><i class="fas fa-map-marker mr-3 p-1"></i>  181 Bùi Hữu Nghĩa, P1, Q. Bình Thạnh, TPHCM</p>
                            <p><i class="fas fa-phone mr-3 p-1"></i>  0949 8080 26 - (028) 6258 1056</p>
                            <p><i class="fas fa-envelope mr-3 p-1"></i>  quatangtet@gmail.com</p>
                            <a href="http://online.gov.vn/Home/WebDetails/46249" id="logo">
                                <img src="/images/thongbao.png" alt="LogoThongBao" style="max-width: 180px;">
                            </a>
                        </div>
                        <!--Close Grid column -->

                        <hr class="w-100 clearfix d-md-none" />

                        <!-- Grid column -->
                        <div class="col-md-4 col-lg-4 col-xl-3 mx-auto mt-3">
                            <h6 class="text-uppercase mb-4 font-weight-bold">
                                Thông tin
                            </h6>
                            <p>
                                <a class="text-white" href="/HomeController">Trang Chủ</a>
                            </p>
                            <p>
                                <a class="text-white" href="/ProductController">Sản Phẩm</a>
                            </p>
                            <p>
                                <a class="text-white" href="/LienHeController">Liên Hệ</a>
                            </p>
                            

                        </div>

                        <!--Close Grid column -->
                        <hr class="w-100 clearfix d-md-none" />

                        <!-- Grid column -->
                        <div class="col-md-4 col-lg-4 col-xl-4 mx-auto mt-3">
                            <h6 class="text-uppercase mb-4 font-weight-bold">
                                Fanpage
                            </h6>
                            <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Fquatetonline.com.vn%2F%3Fref%3Dembed_page&tabs&width=340px&height=150px&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId" width="340px" height="150px" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowfullscreen="true" allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
                        </div>
                        <!--Close Grid column -->

                    </div>
                    <!--Close Grid row-->
                </section>
                <!-- Section: Links -->

                <hr class="my-3">

                <!-- Section: Copyright -->
                <section class="p-3 pt-0">
                    <div class="row d-flex align-items-center">
                        <!-- Grid column -->
                        <div class="col-md-7 col-lg-8 text-center text-md-start">
                            <!-- Copyright -->
                            <div class="p-3">
                                © 2023 Copyright:
                                <a class="text-white" href=""></a>
                            </div>
                            <!-- Copyright -->
                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-md-5 col-lg-4 ml-lg-0 text-center text-md-end">
                            <!-- Facebook -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i
                                    class="fab fa-facebook-f"></i></a>

                            <!-- Twitter -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i
                                    class="fab fa-twitter"></i></a>

                            <!-- Google -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i
                                    class="fab fa-google"></i></a>

                            <!-- Instagram -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i
                                    class="fab fa-instagram"></i></a>
                        </div>
                        <!--Close Grid column -->
                    </div>
                </section>
                <!--Close Section: Copyright -->
            </div>
            <!--Close Grid container -->
        </footer>
        <!--Close Footer -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/2f7a8164b8.js" crossorigin="anonymous"></script>
    </body>
</html>
