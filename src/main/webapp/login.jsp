

<%--
    Document   : index
    Created on : Oct 2, 2023, 11:48:11 AM
    Author     : HUNTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/vapeShop.jpg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <title>Đăng Nhập</title>
</head>
<body>

<!----------------------- Main Container -------------------------->

<div class="container d-flex justify-content-center align-items-center min-vh-100">

    <!----------------------- Login Container -------------------------->

    <div class="row border rounded-5 p-3 bg-white shadow box-area">

        <!--------------------------- Left Box ----------------------------->

        <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: #464953;">
            <div class="featured-image mb-3">
                <img src="assets/img/soulogo.png" class="img-fluid rounded-circle" style="width: 250px;">
            </div>

            <p class="text-white fs-2" style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">SOU-Login</p>
            <small class="text-white text-wrap text-center" style="width: 17rem;font-family: 'Courier New', Courier, monospace;">You can't buy happiness, but you can buy coffee, and that's pretty close</small>
        </div>

        <!-------------------- ------ Right Box ---------------------------->

        <div class="col-md-6 right-box">
            <div class="row align-items-center">
                <div class="header-text mb-4">
                    <h2> Xin chào <i class="fa-solid fa-heart fa-beat-fade" style="color: #ff0000;"></i> </h2>
                    <p>Chúng tôi rất vui khi có bạn trở lại.${error}</p>
                </div>

                <form action="login" method="post">
                <div class="input-group  mb-3" >
                    <div class="input-group-prepend ">
                        <div class="input-group-text p-3"><i class="fa-solid fa-user fa-bounce" style="color: #000000;"></i></div>
                    </div>
                    <input maxlength="100" type="text" name="userOrEmail" class="form-control form-control-lg bg-light fs-6 p-1" placeholder=" Địa chỉ email hoặc Người dùng">
                </div>
                <div class="input-group mb-1">
                    <div class="input-group-prepend ">
                        <div class="input-group-text p-3"><i class="fa-solid fa-key fa-bounce" style="color: #050505;"></i></div>
                    </div>
                    <input maxlength="50" type="password" name="passWord" id="myInput" class="form-control form-control-lg bg-light fs-6  p-1" placeholder=" Mật Khẩu" >

                </div>

                <%
                    String userOrEmail = (String) request.getSession().getAttribute("userOrEmail");
                    if (userOrEmail != null) {
                %>
                <div class="alert alert-danger" style="color: red"><%= userOrEmail%></div>
                <%
                        // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                        request.getSession().removeAttribute("userOrEmail");
                    }
                %>

                <c:if test="${error == 1}">
                    <div class="alert alert-danger" style="color: red">Tài khoản này đang tạm khóa vui lòng liên hệ admin</div>
                </c:if>
                <div class="input-group mb-5 d-flex justify-content-between">
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="formCheck" onclick="myFunction()" >
                        <label for="formCheck" class="form-check-label text-secondary"><small>Hiện thị mật khẩu</small>

                        </label>
                    </div>
                    <div class="forgot">
                        <small><a href="forgotPassword.jsp">Quên mật khẩu?</a></small>
                    </div>
                </div>
                <div class="input-group mb-3">

                    <button class="btn btn-lg btn-primary w-100 fs-6"><i class="fa-solid fa-right-to-bracket fa-beat-fade" style="color: #000000;"></i>  Đăng nhập</button>


                </div>
                </form>
                <div class="row">
                    <small>Không có tài khoản? <a href="register.jsp">Đăng ký ngay</a></small>
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
</style>

<script>
    function myFunction() {
        var x = document.getElementById("myInput");
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