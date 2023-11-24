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

    <title>Đăng nhập</title>
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
                <img src="assets/img/vapeShop.jpg" class="img-fluid rounded-circle" style="width: 250px;">
            </div>

            <p class="text-white fs-2" style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">
                VAPE-Register</p>
            <small class="text-white text-wrap text-center"
                   style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Vaping is a smart choice for
                lifestyle change without compromising health.</small>
        </div>

        <!-------------------- ------ Right Box ---------------------------->
        <%-- Kiểm tra xem có thông báo lỗi trong biến session --%>


        <div class="col-md-6 right-box">
            <div class="row align-items-center">
                <form class="needs-validation" action="register" method="post" novalidate>

                    <div class="input-group mb-2 has-validation ">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-user fa-bounce"
                                                                 style="color: #000000;"></i> <span class="text-danger">*</span></div>
                        </div>

                        <input type="text" name="userName" class="form-control form-control-lg bg-light fs-6 p-1 "placeholder="Tên người dùng" pattern="^[A-Za-z][A-Za-z0-9_]{7,29}$" maxlength="20" required>

                        <div class="invalid-feedback">
                         <span>Vui lòng điền vào trường này và tối đa 20 ký tự trở xuống</span>
                        </div>
                    </div>


                    <%-- Hiển thị thông báo lỗi nếu có --%>
                    <%
                        String accoutExits = (String) request.getSession().getAttribute("accoutExits");
                        if (accoutExits != null) {
                    %>
                    <div class="text-danger" style="color: red"><%= accoutExits%>
                    </div>
                    <%
                            // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                            request.getSession().removeAttribute("accoutExits");
                        }
                    %>




                    <div class="input-group mb-2 has-validation">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-user-pen fa-bounce"
                                                                 style="color: #000000;"></i> <span class="text-danger">*</span></div>
                        </div>
                        <input type="text" name="FullName" class="form-control form-control-lg bg-light fs-6 p-1"
                               placeholder="Tên của bạn" maxlength="50" required>
                        <div class="invalid-feedback">
                            <span>Vui lòng điền vào trường này và tối đa 50 ký tự trở xuống</span>
                        </div>
                    </div>

                    <div class="input-group mb-2 has-validation ">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-regular fa-envelope fa-bounce"
                                                                 style="color: #000000;"></i> <span class="text-danger">*</span></div>
                        </div>
                        <input class="form-control form-control-lg bg-light fs-6 p-1" type="email" id="psw" name="email"
                               pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="
                                        Sai định dạng email" placeholder="Địa chỉ Email" maxlength="100" required>
                        <div class="invalid-feedback">
                            <span>Vui lòng điền email hợp lệ(chỉ bao gồm 1 dấu @ và không có khoảng cách)</span> <br>
                            <span>Example@gmail.com</span>

                        </div>
                    </div>

                    <%
                        String mess = (String) request.getSession().getAttribute("mess");
                        if (mess != null) {
                    %>
                    <div class="text-danger" style="color: red"><%= mess%>
                    </div>
                    <%
                            // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                            request.getSession().removeAttribute("mess");
                        }
                    %>

                    <div class="input-group mb-2 ">

                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-location-dot fa-bounce"
                                                                 style="color: #000000;"></i><span class="text-danger">*</span></div>
                        </div>
                        <select class="form-control form-control-lg bg-light fs-6 p-1" id="city" required>
                            <option value="" selected>Chọn tỉnh thành</option>
                        </select>

                        <div class="invalid-feedback">
                            <span>Vui Lòng Chọn Tỉnh Thành Phố</span> <br>


                        </div>
                    </div>



                    <div class="input-group mb-2 ">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-location-dot fa-bounce"
                                                                 style="color: #000000;"></i><span class="text-danger">*</span></div>
                        </div>
                        <select  class="form-control form-control-lg bg-light fs-6 p-1" id="district" required>
                            <option value="" selected>Chọn quận huyện</option>
                        </select>

                        <div class="invalid-feedback">
                            <span>Vui Lòng Chọn quận huyện</span> <br>


                        </div>
                    </div>
                    <div class="input-group mb-2 has-">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-location-dot fa-bounce"
                                                                 style="color: #000000;"></i><span class="text-danger">*</span></div>
                        </div>
                        <select  class="form-control form-control-lg bg-light fs-6 p-1" id="ward" required>
                            <option value="" selected>Chọn phường xã</option>
                        </select>

                        <div class="invalid-feedback">
                            <span>Vui Lòng Chọn phường xã</span> <br>


                        </div>
                    </div>





                        <input type="hidden" id="addressInput" name="address1" class="form-control form-control-lg bg-light fs-6 p-1"
                               placeholder="Địa chỉ của bạn" required>




                    <div class="input-group mb-2 has-validation">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-location-dot fa-bounce"
                                                                 style="color: #000000;"></i> <span class="text-danger">*</span></div>
                        </div>
                        <input type="text" name="address" class="form-control form-control-lg bg-light fs-6 p-1" pattern="^[a-zA-Z0-9\s,./-]{20,50}$"
                               placeholder="Địa chỉ của bạn" maxlength="200"  required>
                        <div class="invalid-feedback">
                            <span>Vui lòng điền vào trường này và tối đa 100 ký tự trở xuống</span>
                        </div>
                    </div>


                    <div class="input-group mb-2 has-validation">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-key fa-bounce"
                                                                 style="color: #000000;"></i>  <span class="text-danger">*</span></div>
                        </div>
                        <input class="form-control form-control-lg bg-light fs-6 p-1" type="password" id="pass1"
                               name="password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\S{8,50}$" title="
                                        Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và ít nhất 8 ký tự trở lên"
                               placeholder="Mật khẩu" required>
                        <div class="invalid-feedback">
                            <span>Vui lòng điền vào trường này và  Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và ít nhất 8 ký tự trở lênm</span>
                        </div>
                    </div>

                    <div class="input-group mb-2 has-validation">
                        <div class="input-group-prepend ">
                            <div class="input-group-text p-3"><i class="fa-solid fa-key fa-bounce"
                                                                 style="color: #000000;"></i>  <span class="text-danger">*</span></div>
                        </div>
                        <input type="password" name="rePass" id="pass2"
                               class="form-control form-control-lg bg-light fs-6 p-1"
                               placeholder="Nhập lại mật khẩu" required>
                        <div class="invalid-feedback">
                            <span>Vui lòng điền vào trường này</span>
                        </div>

                    </div>
                    <%
                        String rePass = (String) request.getSession().getAttribute("rePass");
                        if (rePass != null) {
                    %>
                    <div class="text-danger" style="color: red"><%= rePass%>
                    </div>
                    <%
                            // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                            request.getSession().removeAttribute("rePass");
                        }
                    %>




                    <div class="input-group mb-5 d-flex justify-content-between">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="formCheck" onclick="myFunction()">
                            <label for="formCheck" class="form-check-label text-secondary"><small>Hiện thị mật
                                khẩu</small>

                            </label>
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <button class="btn btn-lg btn-primary w-100 fs-6" type="submit"><i
                                class="fa-solid fa-right-to-bracket fa-beat-fade" style="color: #000000;"></i> Đăng ký
                        </button>
                    </div>
                </form>

                <div class="row">
                    <small>Có tài khoản? <a href="login.jsp">Đăng nhập ngay</a> </small>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script>
    const host = "https://provinces.open-api.vn/api/";

    const callAPI = (api) => {
        return axios.get(api)
            .then((response) => {
                renderData(response.data, "city");
            });
    }

    callAPI('https://provinces.open-api.vn/api/?depth=1');

    const callApiDistrict = (api) => {
        return axios.get(api)
            .then((response) => {
                renderData(response.data.districts, "district");
            });
    }

    const callApiWard = (api) => {
        return axios.get(api)
            .then((response) => {
                renderData(response.data.wards, "ward");
            });
    }

    const renderData = (array, select) => {
        let row = ' <option disable value="">Chọn Tỉnh Thành Phố</option>';
        console.log(array)
        array.forEach(element => {
            let addressCode = JSON.stringify(element.code);
            let addressName = JSON.stringify(element.name).slice(1,-1);
            console.log(addressCode+addressName)
            row += `<option data-id="`+addressCode+`" value="`+addressName+`">`+addressName+`</option>`
        });
        document.querySelector("#" + select).innerHTML = row
    }

    $("#city").change(() => {
        callApiDistrict(host + "p/" + $("#city").find(':selected').data('id') + "?depth=2");
        printResult();
    });

    $("#district").change(() => {
        callApiWard(host + "d/" + $("#district").find(':selected').data('id') + "?depth=2");
        printResult();
    });

    $("#ward").change(() => {
        printResult();
    })

    const printResult = () => {
        if ($("#district").find(':selected').data('id') != "" && $("#city").find(':selected').data('id') != "" &&
            $("#ward").find(':selected').data('id') != "") {
            let result = $("#city option:selected").text() +
                ", " + $("#district option:selected").text() + ", " +
                $("#ward option:selected").text();
            $("#result").text(result);

            // Set the value of the input field with the selected address
            $("#addressInput").val(result);
            console.log(result)
        }
    }

    const getResult = () =>{
        if ($("#city").val() && $("#district").val() && $("#ward").val()) {
            alert("Form đã được submit! Địa chỉ đã chọn: " + $("#result").text());
        } else {
            alert("Vui lòng chọn đầy đủ thông tin địa chỉ trước khi submit!");
        }
    }
</script>



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
<script>
    function myFunction() {
        var input1 = document.getElementById("pass1");
        var input2 = document.getElementById("pass2");
        if (input1.type === "password" && input2.type === "password") {
            input1.type = "text";
            input2.type = "text"
        } else {
            input1.type = "password";
            input2.type = "password";
        }
    }



    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()

</script>


<script src="https://kit.fontawesome.com/fc6bd51969.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</html>