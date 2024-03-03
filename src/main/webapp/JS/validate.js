/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const username = document.getElementById("userN");
const password = document.getElementById("pwd");
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
function validateInputs() {
    let check = true;
    const user = username.value.trim();
    const pwd = password.value.trim();
    if (user === "") {
        setError(username, "username is require!");
        check = false;
    } else if (user.length > 100) {
        setError(username, "username length cannot greater than 100 character");
        check = false;
    } else {
        setSuccess(username);
    }

    if (pwd === "") {
        setError(password, "password is require!");
        check = false;
    } else {
        setSuccess(password);
    }
    return check;
}

// validate form create and update product


function validateCreateAcc() {
    let check = true;
    const fullname = document.getElementById("fullname");
    const male = document.getElementById("male");
    const female = document.getElementById("female");
    const birthday = document.getElementById("bd");
    const username = document.getElementById("user");
    const password = document.getElementById("pass");
    if (fullname.value.trim() === "") {
        setError(fullname, "fullname is require!");
        check = false;
    } else {
        setSuccess(fullname);
    }

    if (birthday.value.trim() === "") {
        setError(birthday, "birthday is require!");
        check = false;
    } else {
        setSuccess(birthday);
    }
    if (password.value.trim() === "") {
        setError(password, "password is require!");
        check = false;
    } else {
        setSuccess(password);
    }

    if (username.value.trim() === "") {
        setError(username, "username is require!");
        check = false;
    } else if (username.value.length > 100) {
        setError(username, "username length cannot greater than 100 character");
        check = false;
    } else {
        setSuccess(username);
    }

    if (!male.checked && !female.checked) {
        setError(male, "please choose your gender");
        check = false;
    } else {
        setSuccess(male);
    }

    return check;
}


function validateCheckBox() {
    var checkboxes = document.querySelectorAll(".checkBuy");
    let atLeastOneChecked = false;
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            atLeastOneChecked = true;
            break;
        }
    }

    if (!atLeastOneChecked) {
        alert("You must select at least one checkbox.");
        atLeastOneChecked = false;
    }

    return atLeastOneChecked;
}



function validatePro() {
    let check = true;
    const name = document.getElementById("txtName");
    const quantity = document.getElementById("quan");
    const price = document.getElementById("price");
    const picture = document.getElementById("proPic");
    const description = document.getElementById("txtDes");
    const picValue = picture.value.trim();
    if (name.value.trim() === "") {
        setError(name, "Name of product is require!");
        check = false;
    } else if (name.value.trim().length < 5 || name.value.trim().length > 500) {
        setError(name, "Length of product name must greater than 5 and less or equal 500!");
        check = false;
    } else {
        setSuccess(name);
    }

    if (description.value.trim() === "") {
        setError(description, "Description of product is require!");
        check = false;
    } else if (description.value.trim().length < 10 || description.value.trim().length > 1000) {
        setError(description, "Length of product name must greater than 10 and less or equal 1000!");
        check = false;
    } else {
        setSuccess(description);
    }


    if (isNaN(price.value.trim()) || price.value.trim() === "") {
        setError(price, "Price must be require");
        check = false;
    } else if (price.value.trim() <= 0) {
        setError(price, "Price of product must be greater than 0");
        check = false;
    } else {
        setSuccess(price);
    }
    if (isNaN(quantity.value.trim()) || quantity.value.trim() === "") {
        setError(quantity, "quantity must be require");
        check = false;
    } else if (quantity.value.trim() <= 0) {
        setError(quantity, "quantity of product must be greater than 0");
        check = false;
    } else {
        setSuccess(quantity);
    }
    if (picture.value.trim() === "") {
        setError(picture, "picture of product is require");
        check = false;
    } else if (!checkImage(picValue)) {
        setError(picture, "file must be images");
        check = false;
    } else {
        setSuccess(picture);
    }
    return check;
}

function checkImage(fileName) {
    const substrings = fileName.split(".");
    const ext = substrings[substrings.length - 1].toLowerCase(); // Lấy phần mở rộng và chuyển đổi thành chữ thường

    const imgExtensions = ["jpg", "png", "jpeg"];
    return imgExtensions.includes(ext);
}


function validateOrder() {
    let check = true;
    const address = document.getElementById("add");
    const phone = document.getElementById("phone");

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
