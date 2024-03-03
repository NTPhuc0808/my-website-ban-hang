<%-- 
    Document   : login
    Created on : Oct 21, 2023, 12:43:47 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="CSS/style.css" />
        <title>Login Form</title>

    </head>

    <body>
        <section class="gradient-form" style="background-color: #f2f2b1;">
            <div class="container py-5">
                <div class="row d-flex justify-content-center align-items-center  h-75">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                            <div class="row g-0 ">
                                <div class="col-lg-6 ">
                                    <div class="card-body p-md-5 mx-md-4">

                                        <div class="text-center">
                                            <img src="images/logo.png" style="width: 185px;" alt="logo">
                                            <h4 class="mt-1 mb-5 pb-1">Login Form</h4>
                                        </div>

                                        <form id="form" class="container" method="post" action="LoginController"
                                              onsubmit="return validateInputs();">
                                            <p>Please login to your account</p>

                                            <div class="form-outline mb-4 validate">
                                                <label class="form-label" for="form2Example11">Username</label>
                                                <input type="text" class="form-control" id="userN" name="txtUS">
                                                <span class="error"></span>

                                            </div>

                                            <div class="form-outline mb-4 validate">
                                                <label class="form-label" for="form2Example22">Password</label>
                                                <input type="password" class="form-control" id="pwd" name="txtPwd">
                                                <span class="error"></span>

                                            </div>

                                            <div class="text-center pt-1 mb-5 pb-1">

                                                <!-- Checkbox -->
                                                <input type="submit" class="p-2 btn btn-primary" name="btnSubmit"
                                                       value="  login  ">

                                            </div>

                                            <div class="d-flex align-items-center justify-content-center pb-4">
                                                <p class="mb-0 me-2">Don't have an account?</p>
                                                <button type="button" class="btn btn-outline-danger">
                                                    <a href="/LoginController/Create">Create new</a>
                                                </button>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6 align-items-center gradient-custom-2">
                                    <img src="images/tet.jpg" class="w-100 rounded-3" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/JS/validate.js"></script>
    </body>

</html>
