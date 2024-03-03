/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

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
function validateeditPro() {
    let check = true;
    const name = document.getElementById("txtName");
    const quantity = document.getElementById("quan");
    const price = document.getElementById("price");
    const description = document.getElementById("txtDes");
    const picture = document.getElementById("proPic");
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

    if (picture.value.trim() !== "") {
        if (!checkImage(picture.value.trim())) {
            setError(picture, "file must be images");
            check = false;
        } else {
            setSuccess(picture);
        }
    }


    return check;
}


function checkImage(fileName) {
    const substrings = fileName.split(".");
    const ext = substrings[substrings.length - 1].toLowerCase(); // Lấy phần mở rộng và chuyển đổi thành chữ thường

    const imgExtensions = ["jpg", "png", "jpeg"];
    return imgExtensions.includes(ext);
}