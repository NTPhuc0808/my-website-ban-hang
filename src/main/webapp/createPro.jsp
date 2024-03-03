<%-- 
    Document   : createPro
    Created on : Oct 31, 2023, 3:27:01 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/> 
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" href="/CSS/style.css"/>
        <title>Add new product</title>
    </head>
    <body>
        <form class="container w-50 mt-5 border border-2 border-warning rounded p-4" 
              method="post" action="AdminController" enctype="multipart/form-data" onsubmit="return validatePro()"><!-- gui den noi khac moi can action -->

            <div class="validate form-outline mb-4 col">
                <label class="form-label" >Product name:  </label>
                <input type="text" name="txtName" id="txtName">
                <br/>
                <span class="error"></span>
            </div>
            <div class="validate form-outline mb-4 col">

                <label class="form-label" >Product quantity:  </label>
                <input type="number" name="quan" id="quan">
                <br/>
                <span class="error"></span>
            </div>
            <div class="validate form-outline mb-4 col">
                <label class="form-label" >Product price :</label>
                <input type="number" name="price" id="price">
                <br/>
                <span class="error"></span>
            </div>
            <div class="validate form-outline mb-4 col">
                <label class="form-label" >Product picture: </label>
                <input type="file" name="proPic" id="proPic">
                <br/>
                <span class="error "></span>
            </div>
            <div class="validate form-outline mb-4 col">
                <label class="form-label" >Product description: </label>
                <textarea name="txtDes" id="txtDes"></textarea>
                <br/>
                <span class="error"></span>
            </div>
            <div class="validate form-outline mb-4 col">
                <label class="form-label" >Categories</label>
                <select name="cat_id" id="cat_id">
                    <option value="1">Hop qua tet go</option>
                    <option value="2">Gio qua tet</option>
                    <option value="3">Tui qua tet</option>
                </select>
            </div>
            <div class="col d-flex justify-content-center">
                <input type="submit" name="btnAdd" class="btn-primary btn">
            </div>
        </form>
        <script src="/JS/validate.js"></script>
    </body>
</html>
