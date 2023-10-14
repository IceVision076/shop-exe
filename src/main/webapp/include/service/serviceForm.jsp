<%--
  Created by IntelliJ IDEA.
  User: NGO THANH
  Date: 9/29/2023
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Service Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        html, body {
            width: 100%;
            height: 100%;
            margin: 0px;
        }

        body {
            background: linear-gradient(135deg, #71b7e6, #9b59b6);
            padding: 10px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="service col-md-12">
            <form class="row g-3 needs-validation p-4" novalidate action="service-tracking-sender"
                  method="post">

                <div class="col-12">
                    <label for="title" class="form-label">Tiêu đề <span class="text-danger"> *</span></label>
                    <div class="input-group has-validation">
                        <input type="text" class="form-control" placeholder="Nhập tiêu đề yêu cầu dịch vụ"
                               id="title" name="title"
                               required>
                        <div class="invalid-feedback">
                            Không được bỏ trống tiêu đề
                        </div>
                    </div>
                </div>
                <%--                        Nhãn hàng--%>


                <%-- Mô tả sản phẩm--%>
                <div class="col-12">
                    <label for="userDescription" class="form-label">Mô tả <span
                            class="text-danger"> *</span></label>
                    <div class="input-group has-validation">
                                    <textarea cols="30" rows="10" class="form-control" id="userDescription"
                                              name="userDescription"
                                              placeholder="Nhập mô tả yêu cầu dịch vụ" required></textarea>
                        <div class="invalid-feedback">
                            Vui lòng điền mô tả
                        </div>
                    </div>
                </div>

                <div class="col-12">
                    <button onclick="run()" class="btn btn-primary" type="submit">Xác Nhận <i class="fa-solid fa-rocket fa-bounce fa-lg"
                                                                              style="color: #f2df07;"></i></button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function run() {
        alert("Cảm ơn vì đã phản hồi!!!")
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
                        vent.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
