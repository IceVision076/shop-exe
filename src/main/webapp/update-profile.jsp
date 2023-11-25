<%@page contentType="text/html" pageEncoding="UTF-8" %>


<%@include file="include/header-footer/header.jsp" %>
<div class="container mb-4 mt-3">
    <div class="row">

        <div class="col-lg-4 mb-5">
            <div class="card" style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;">
                <div class="card-body">
                    <div class="d-flex flex-column align-items-center text-center">
                        <img src="${sessionScope.user.avatarImg}"
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
                        <label for="fullname" class="form-label fw-bolder">Tên:</label>
                        <div class="input-group has-validation">
                            <input maxlength="100" type="text" class="form-control" id="fullname" name="fullname"
                                   aria-describedby="inputGroupPrepend" value="${sessionScope.user.fullName}" required>
                            <div class="invalid-feedback">
                                Tối đa là 50 ký tự và không được để trống
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="phone" class="form-label fw-bolder">Số điện thoại: </label>
                        <div class="input-group has-validation">
                            <input maxlength="11" minlength="10" pattern="^\d{10,11}$" type="text" class="form-control"
                                   id="phone" name="phone" aria-describedby="inputGroupPrepend" value="${sessionScope.user.phone}" required>
                            <div class="invalid-feedback">
                                Tối đa 11 số và tối thiểu 10 số
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="phone" class="form-label fw-bolder">Tỉnh/Thành: </label>
                        <select class="form-control" id="city" required>
                            <option value="" selected></option>
                        </select>
                        <div class="invalid-feedback">
                            <span>Vui Lòng Chọn Tỉnh Thành Phố</span> <br>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="phone" class="form-label fw-bolder">Quận/Huyện: </label>
                        <select class="form-control" id="district" required>
                            <option value="" selected></option>
                        </select>
                        <div class="invalid-feedback">
                            <span>Vui Lòng Chọn quận huyện</span> <br>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="phone" class="form-label fw-bolder">Phường/Xã: </label>
                        <select class="form-control" id="ward" required>
                            <option value="" selected></option>
                        </select>
                        <div class="invalid-feedback">
                            <span>Vui Lòng Chọn phường xã</span> <br>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="addressInput" class="form-label fw-bolder">Địa Chỉ:</label>
                        <div class="input-group has-validation">
                            <input maxlength="100" type="text" class="form-control" id="addressInput" name="address"
                                   aria-describedby="inputGroupPrepend" value="${sessionScope.user.address}" required>
                            <div class="invalid-feedback">
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
        let row = ' <option disable value="">Lựa Chọn</option>';
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
                " , " + $("#district option:selected").text() + " , " +
                $("#ward option:selected").text();
            $("#result").text(result);

            // Set the value of the input field with the selected address
            $("#addressInput").val(result);
            console.log(result)
        }
    }
    //
    // const getResult = () =>{
    //     if ($("#city").val() && $("#district").val() && $("#ward").val()) {
    //         alert("Form đã được submit! Địa chỉ đã chọn: " + $("#result").text());
    //     } else {
    //         alert("Vui lòng chọn đầy đủ thông tin địa chỉ trước khi submit!");
    //     }
    // }
</script>


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