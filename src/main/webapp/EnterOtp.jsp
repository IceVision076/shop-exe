<%--
    Document   : index
    Created on : Oct 2, 2023, 11:48:11 AM
    Author     : HUNTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>Boostrap Login | Ludiflex</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>


</head>
<body>

<!----------------------- Main Container -------------------------->

<div class="container d-flex justify-content-center align-items-center min-vh-100">

    <!----------------------- Login Container -------------------------->

    <div class="row border rounded-5 p-3 bg-white shadow box-area">

        <!--------------------------- Left Box ----------------------------->

        <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box"
             style="background: #464953;">
            <div class="featured-image mb-3">
                <img src="assets/img/vapeShop.jpg" class="img-fluid rounded-circle" style="width: 150px;" alt="vape">
            </div>

            <p class="text-white fs-2" style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">
                VAPE-OTP</p>
            <small class="text-white text-wrap text-center"
                   style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Vaping is a smart choice for
                lifestyle change without compromising health.</small>
        </div>

        <!-------------------- ------ Right Box ---------------------------->

        <div class="col-md-6 right-box">
            <div class="row align-items-center">
                <div class="header-text mb-4">
                    <h2> Xin chào <i class="fa-solid fa-heart fa-beat-fade" style="color: #ff0000;"></i> </h2>
                    <p>Chúng tôi rất vui khi có bạn trở lại.</p>
                </div>

                <form action="ValidateOtp" method="post">
                    <div class="input-group  mb-3">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-lock fa-bounce" style="color: #000000;"></i></div>
                        </div>
                        <input type="number" name="otp" class="form-control form-control-lg bg-light fs-6 p-1"
                               placeholder="  Enter OTP"  required>
                    </div>
                    <%
                        if (request.getAttribute("message") != null) {
                            out.print("<p class='text-danger ml-1'>" + request.getAttribute("message") + "</p>");
                        }

                    %>


                    <div class="input-group mb-3">
                        <button class="btn btn-lg btn-danger w-100 fs-6"> <i class="fa-solid fa-right-to-bracket fa-bounce" style="color: #ffffff;"></i> Đặt lại mật khẩu của bạn</button>
                    </div>
                </form>

            </div>
        </div>

    </div>
</div>

</body>

<style>

    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

    body {
        font-family: 'Poppins', sans-serif;
        background: #ececec;
    }

    /*------------ Login container ------------*/

    .box-area {
        width: 930px;
    }

    /*------------ Right box ------------*/

    .right-box {
        padding: 40px 30px 40px 40px;
    }

    /*------------ Custom Placeholder ------------*/

    ::placeholder {
        font-size: 16px;
    }

    .rounded-4 {
        border-radius: 20px;
    }

    .rounded-5 {
        border-radius: 30px;
    }


    /*------------ For small screens------------*/

    @media only screen and (max-width: 768px) {

        .box-area {
            margin: 0 10px;

        }

        .left-box {
            height: 100px;
            overflow: hidden;
        }

        .right-box {
            padding: 20px;
        }

    }
</style>
<script src="https://kit.fontawesome.com/fc6bd51969.js" crossorigin="anonymous"></script>

</html>