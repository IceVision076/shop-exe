<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <title>Boostrap Login | Ludiflex</title>
    </head>
    <body>

        <!----------------------- Main Container -------------------------->

        <div class="container d-flex justify-content-center align-items-center min-vh-100">

            <!----------------------- Login Container -------------------------->

            <div class="row border rounded-5 p-3 bg-white shadow box-area">

                <!--------------------------- Left Box ----------------------------->

                <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: #464953;">
                    <div class="featured-image mb-3">
                        <img src="images/vapeShop.jpg" class="img-fluid rounded-circle" style="width: 250px;">
                    </div>

                    <p class="text-white fs-2" style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">VAPE-Register</p>
                    <small class="text-white text-wrap text-center" style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Vaping is a smart choice for lifestyle change without compromising health.</small>
                </div> 

                <!-------------------- ------ Right Box ---------------------------->
                <%-- Kiểm tra xem có thông báo lỗi trong biến session --%>


                <div class="col-md-6 right-box">
                    <div class="row align-items-center">
                        <form action="register" method="get">
                            <div class="input-group mb-2 ">
                                <input type="text" name ="userName" class="form-control form-control-lg bg-light fs-6 " placeholder="User Name" required>
                            </div>
                            <%-- Hiển thị thông báo lỗi nếu có --%>
                            <%
                                String accoutExits = (String) request.getSession().getAttribute("accoutExits");
                                if (accoutExits != null) {
                            %>
                            <div class="alert alert-danger" style="color: red"><%= accoutExits%></div>
                            <%
                                    // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                                    request.getSession().removeAttribute("accoutExits");
                                }
                            %>



                            <div class="input-group mb-2">
                                <input type="text" name="FullName" class="form-control form-control-lg bg-light fs-6" placeholder="Your Name" required>
                            </div>

                            <div class="input-group mb-2">

                                <input type="email" name="email" class="form-control form-control-lg bg-light fs-6" placeholder="Email address"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Wrong format email" required>
                            </div>
                            <div class="input-group mb-2">
                                <input type="text" name="address" class="form-control form-control-lg bg-light fs-6" placeholder="Local address" required>
                            </div>
                            <div class="input-group mb-2">
                                <input type="password" name="pass" class="form-control form-control-lg bg-light fs-6" placeholder="PassWord" required>
                            </div>

                            <div class="input-group mb-2">
                                <input type="password" name="rePass" class="form-control form-control-lg bg-light fs-6" placeholder="re-PassWord" required>

                            </div>
                            <%
                                String rePass = (String) request.getSession().getAttribute("rePass");
                                if (rePass != null) {
                            %>
                            <div class="alert alert-danger" style="color: red"><%= rePass%></div>
                            <%
                                    // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                                    request.getSession().removeAttribute("rePass");
                                }
                            %>


                            <div class="input-group mb-5 d-flex justify-content-between">
                                <div class="form-check">
                                    <!-- <input type="checkbox" class="form-check-input" id="formCheck">
                                    <label for="formCheck" class="form-check-label text-secondary"><small>Remember Me</small></label> -->
                                </div>

                            </div>
                            <div class="input-group mb-3">
                                <button class="btn btn-lg btn-primary w-100 fs-6">Register</button>
                            </div>
                        </form>

                        <div class="row">
                            <small>Have account ? <a href="login.jsp">Login Now!</a></small>
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
</html>