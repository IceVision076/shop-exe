

<%--
    Document   : index
    Created on : Oct 2, 2023, 11:48:11 AM
    Author     : HUNTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>


</head>
<body>

<!----------------------- Main Container -------------------------->

<div class="container d-flex justify-content-center align-items-center min-vh-100">

    <!----------------------- Login Container -------------------------->

    <div class="row border rounded-5 p-3 bg-white shadow box-area">

        <!--------------------------- Left Box ----------------------------->

        <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: #464953;">
            <div class="featured-image mb-3">
                <img src="assets/img/vapeShop.jpg" class="img-fluid rounded-circle" style="width: 200px;" alt="VAPE">
            </div>

            <p class="text-white fs-2" style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">VAPE-OTP</p>
            <small class="text-white text-wrap text-center" style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Vaping is a smart choice for lifestyle change without compromising health.</small>
        </div>

        <!-------------------- ------ Right Box ---------------------------->

        <div class="col-md-6 right-box">
            <div class="row align-items-center">
                <div class="header-text mb-4">
                    <h2> Xin chào <i class="fa-solid fa-heart fa-beat-fade" style="color: #ff0000;"></i> </h2>
                    <p>Chúng tôi rất vui khi có bạn trở lại.</p>
                </div>

                <form action="newPassword" method="post">
                    <div class="input-group  mb-3" >
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-key fa-bounce" style="color: #000000;"></i></div>
                        </div>
                        <input  class="form-control form-control-lg bg-light fs-6" type="password" id="psw" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="
                                        Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và ít nhất 8 ký tự trở lên"  placeholder="Mật khẩu" required>
                    </div>



                    <div class="input-group mb-5 d-flex justify-content-between">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="formCheck" onclick="myFunction()" >
                            <label for="formCheck" class="form-check-label text-secondary"><small>Hiện thị mật khẩu</small>

                            </label>
                        </div>

                    </div>

                    <div class="input-group mb-3">
                        <button class="btn btn-lg btn-danger w-100 fs-6"> <i class="fa-solid fa-right-to-bracket fa-bounce" style="color: #ffffff;"></i> Đặt lại mật khẩu của bạn</button>
                    </div>
                </form>

                <div class="mess" id="message">
                    <h3 >Password must contain the following:</h3>
                    <p id="letter" class="invalid">Một <b>Chữ cái</b> viết thường</p>
                    <p id="capital" class="invalid">Một <b>chữ cái</b> viết hoa</p>
                    <p id="number" class="invalid">Một <b>số</b></p>
                    <p id="length" class="invalid">Tối thiểu <b> 8 ký tự</b></p>
                </div>

            </div>
        </div>

    </div>
</div>

</body>

<style>

    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

    body{
        font-family: 'Poppins', sans-serif;
        background: #ececec;
    }

    /*------------ Login container ------------*/

    .box-area{
        width: 930px;
    }

    /*------------ Right box ------------*/

    .right-box{
        padding: 40px 30px 40px 40px;
    }

    /*------------ Custom Placeholder ------------*/

    ::placeholder{
        font-size: 16px;
    }

    .rounded-4{
        border-radius: 20px;
    }
    .rounded-5{
        border-radius: 30px;
    }


    /*------------ For small screens------------*/

    @media only screen and (max-width: 768px){

        .box-area{
            margin: 0 10px;

        }
        .left-box{
            height: 100px;
            overflow: hidden;
        }
        .right-box{
            padding: 20px;
        }





    }


    .mess h3 {
        font-size: 15px;
    }

    /* Add a green text color and a checkmark when the requirements are right */
    .valid {
        color: green;
    }

    .valid:before {
        position: relative ;

        right: -250px;
        content: "✔    ";

    }

    /* Add a red text color and an "x" when the requirements are wrong */
    .invalid {
        color: red;

    }

    .invalid:before {
        position: relative ;

        right: -250px;
        content: "✖";
    }

</style>


<script>
    var myInput = document.getElementById("psw");
    var letter = document.getElementById("letter");
    var capital = document.getElementById("capital");
    var number = document.getElementById("number");
    var length = document.getElementById("length");

    // When the user clicks on the password field, show the message box
    myInput.onfocus = function () {
        document.getElementById("message").style.display = "block";
    }

    // When the user clicks outside of the password field, hide the message box
    myInput.onblur = function () {
        document.getElementById("message").style.display = "none";
    }

    // When the user starts to type something inside the password field
    myInput.onkeyup = function () {
        // Validate lowercase letters
        var lowerCaseLetters = /[a-z]/g;
        if (myInput.value.match(lowerCaseLetters)) {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
        } else {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        // Validate capital letters
        var upperCaseLetters = /[A-Z]/g;
        if (myInput.value.match(upperCaseLetters)) {
            capital.classList.remove("invalid");
            capital.classList.add("valid");
        } else {
            capital.classList.remove("valid");
            capital.classList.add("invalid");
        }

        // Validate numbers
        var numbers = /[0-9]/g;
        if (myInput.value.match(numbers)) {
            number.classList.remove("invalid");
            number.classList.add("valid");
        } else {
            number.classList.remove("valid");
            number.classList.add("invalid");
        }

        // Validate length
        if (myInput.value.length >= 8) {
            length.classList.remove("invalid");
            length.classList.add("valid");
        } else {
            length.classList.remove("valid");
            length.classList.add("invalid");
        }
    }



    function myFunction() {
        var x = document.getElementById("psw");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>    <title>Boostrap Login | Ludiflex</title>
<script src="https://kit.fontawesome.com/fc6bd51969.js" crossorigin="anonymous"></script>

</html>