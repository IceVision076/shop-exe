<%@page contentType="text/html" pageEncoding="UTF-8" %>


<%@include file="include/header-footer/header.jsp" %>
<div class="container mb-4 mt-3">
    <div class="row">

        <div class="col-lg-4 mb-5">
            <div class="card" style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;">
                <div class="card-body">
                    <div class="d-flex flex-column align-items-center text-center">
                        <img src="https://bizweb.dktcdn.net/100/438/408/files/anh-chan-dung-dep-yodyvn1.jpg?v=1683537734987"
                             alt="Admin" class="rounded-circle p-1 bg-primary" width="110" height="110" style="object-fit: cover">
                        <div class="mt-3">
                            <h4>${sessionScope.user.fullName}</h4>
                        </div>
                    </div>
                    <hr class="my-4">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <h6 class="mb-0">
                                <i class="fa-regular fa-envelope fa-lg" style="color: #1f71ff;"></i>
                                Email
                            </h6>
                            <span class="text-secondary">${sessionScope.user.email}</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <h6 class="mb-0">
                                <i class="fa-solid fa-phone fa-lg" style="color: #24f56d;"></i>
                                Số điện thoại
                            </h6>
                            <span class="text-secondary">${sessionScope.user.phone}</span>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <h6 class="mb-0">
                                <i class="fa-regular fa-user fa-lg" style="color: #ff1414;"></i>
                                Username
                            </h6>
                            <span class="text-secondary">${sessionScope.user.userName}</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                            <h6 class="mb-0">
                                <i class="fa-solid fa-location-dot fa-lg" style="color: #0ac6f5;"></i>
                                Địa chỉ
                            </h6>
                            <span class="text-secondary">${sessionScope.user.address}</span>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="col-lg-8 mb-5 pt-2 card" style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;">

            <form action="update-profile" method="post" class="card-body  g-3 needs-validation " novalidate>
                <div class="row g-3 ">
                    <div class="col-md-12 ">
                        <h3 class="text-center">Thông Tin Của Bạn</h3>
                        <label for="fullname" class="form-label">Tên:</label>
                        <div class="input-group has-validation">
                            <input maxlength="50" type="text" class="form-control" id="fullname" name="fullname"
                                   aria-describedby="inputGroupPrepend" value="${sessionScope.user.fullName}" required>
                            <div class="invalid-feedback">
                                Tối đa là 50 ký tự và không được để trống
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="phone" class="form-label">Số điện thoại: </label>
                        <div class="input-group has-validation">
                            <input maxlength="11" minlength="10" pattern="^\d{10,11}$" type="text" class="form-control"
                                   id="phone" name="phone" aria-describedby="inputGroupPrepend" value="${sessionScope.user.phone}" required>
                            <div class="invalid-feedback">
                                Tối đa 11 số và tối thiểu 10 số
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="address" class="form-label">Address:</label>
                        <div class="input-group has-validation">
                            <input maxlength="50" type="text" class="form-control" id="address" name="address"
                                   aria-describedby="inputGroupPrepend" value="${sessionScope.user.address}" required>
                            <div class="invalid-feedback">
                                Hãy chọn một địa chỉ.
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 d-flex justify-content-center mt-4">
                        <button class="btn btn-primary" type="submit">Cập nhật thông tin</button>
                    </div>
                </div>


            </form>
        </div>
    </div>


</div>


<script> // Example starter JavaScript for disabling form submissions if there are invalid fields
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
})()</script>


<%@include file="include/header-footer/footer.jsp" %>