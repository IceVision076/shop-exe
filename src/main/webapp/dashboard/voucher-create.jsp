<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/29/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>

<!--
=========================================================
* Soft UI Dashboard - v1.0.7
=========================================================

* Product Page: https://www.creative-tim.com/product/soft-ui-dashboard
* Copyright 2023 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)
* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="include/header-product-management-dashboard.jsp" %>
<style>
    /* Chrome, Safari, Edge, Opera */
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    /* Firefox */
    input[type=number] {
        -moz-appearance: textfield;
    }
</style>
<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
         navbar-scroll="true">
        <div class="container-fluid py-1 px-3">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark"
                                                           href="product-management">Voucher</a>
                    </li>

                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Thêm mã giảm giá</li>
                </ol>
                <h6 class="font-weight-bolder mb-0">Thêm mã giảm giá mới</h6>
            </nav>
            <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
                <div class="ms-md-auto pe-md-3 d-flex align-items-center">

                </div>
                <ul class="navbar-nav  justify-content-end">

                    <li class="nav-item d-flex align-items-center">
                        <a href="javascript:;" class="nav-link text-body font-weight-bold px-0">
                            <i class="fa fa-user me-sm-1"></i>
                            <span class="d-sm-inline d-none">${sessionScope.user.userName}</span>
                        </a>
                    </li>
                    <li class="nav-item d-xl-none ps-3 d-flex align-items-center">
                        <a href="javascript:;" class="nav-link text-body p-0" id="iconNavbarSidenav">
                            <div class="sidenav-toggler-inner">
                                <i class="sidenav-toggler-line"></i>
                                <i class="sidenav-toggler-line"></i>
                                <i class="sidenav-toggler-line"></i>
                            </div>
                        </a>
                    </li>
                    <li class="nav-item px-3 d-flex align-items-center">
                        <a href="javascript:;" class="nav-link text-body p-0">
                            <i class="fa fa-cog fixed-plugin-button-nav cursor-pointer"></i>
                        </a>
                    </li>
                    <li class="nav-item dropdown pe-2 d-flex align-items-center">
                        <a href="javascript:;" class="nav-link text-body p-0" id="dropdownMenuButton"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-bell cursor-pointer"></i>
                        </a>
                        <ul class="dropdown-menu  dropdown-menu-end  px-2 py-3 me-sm-n4"
                            aria-labelledby="dropdownMenuButton">
                            <li class="mb-2">
                                <a class="dropdown-item border-radius-md" href="javascript:;">
                                    <div class="d-flex py-1">
                                        <div class="my-auto">
                                            <img src="assets/img/team-2.jpg" class="avatar avatar-sm  me-3 ">
                                        </div>
                                        <div class="d-flex flex-column justify-content-center">
                                            <h6 class="text-sm font-weight-normal mb-1">
                                                <span class="font-weight-bold">New message</span> from Laur
                                            </h6>
                                            <p class="text-xs text-secondary mb-0 ">
                                                <i class="fa fa-clock me-1"></i>
                                                13 minutes ago
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="mb-2">
                                <a class="dropdown-item border-radius-md" href="javascript:;">
                                    <div class="d-flex py-1">
                                        <div class="my-auto">
                                            <img src="assets/img/small-logos/logo-spotify.svg"
                                                 class="avatar avatar-sm bg-gradient-dark  me-3 ">
                                        </div>
                                        <div class="d-flex flex-column justify-content-center">
                                            <h6 class="text-sm font-weight-normal mb-1">
                                                <span class="font-weight-bold">New album</span> by Travis Scott
                                            </h6>
                                            <p class="text-xs text-secondary mb-0 ">
                                                <i class="fa fa-clock me-1"></i>
                                                1 day
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item border-radius-md" href="javascript:;">
                                    <div class="d-flex py-1">
                                        <div class="avatar avatar-sm bg-gradient-secondary  me-3  my-auto">
                                            <svg width="12px" height="12px" viewBox="0 0 43 36" version="1.1"
                                                 xmlns="http://www.w3.org/2000/svg"
                                            >
                                                <title>credit-card</title>
                                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <g transform="translate(-2169.000000, -745.000000)" fill="#FFFFFF"
                                                       fill-rule="nonzero">
                                                        <g transform="translate(1716.000000, 291.000000)">
                                                            <g transform="translate(453.000000, 454.000000)">
                                                                <path class="color-background"
                                                                      d="M43,10.7482083 L43,3.58333333 C43,1.60354167 41.3964583,0 39.4166667,0 L3.58333333,0 C1.60354167,0 0,1.60354167 0,3.58333333 L0,10.7482083 L43,10.7482083 Z"
                                                                      opacity="0.593633743"></path>
                                                                <path class="color-background"
                                                                      d="M0,16.125 L0,32.25 C0,34.2297917 1.60354167,35.8333333 3.58333333,35.8333333 L39.4166667,35.8333333 C41.3964583,35.8333333 43,34.2297917 43,32.25 L43,16.125 L0,16.125 Z M19.7083333,26.875 L7.16666667,26.875 L7.16666667,23.2916667 L19.7083333,23.2916667 L19.7083333,26.875 Z M35.8333333,26.875 L28.6666667,26.875 L28.6666667,23.2916667 L35.8333333,23.2916667 L35.8333333,26.875 Z"></path>
                                                            </g>
                                                        </g>
                                                    </g>
                                                </g>
                                            </svg>
                                        </div>
                                        <div class="d-flex flex-column justify-content-center">
                                            <h6 class="text-sm font-weight-normal mb-1">
                                                Payment successfully completed
                                            </h6>
                                            <p class="text-xs text-secondary mb-0 ">
                                                <i class="fa fa-clock me-1"></i>
                                                2 days
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="container-fluid py-4">
        <div class="row">
            <div class="col-12">
                <div class="card mb-4">
                    <div class="card-header pb-0">
                        <h4 style="font-family: Calibri;" class="text-center"><i
                                class="fa-solid fa-kiwi-bird fa-spin-pulse" style="color: #b01cba;"></i> Thêm mã giảm
                            giá mới <i class="fa-solid fa-kiwi-bird fa-spin-pulse" style="color: #b01cba;"></i></h4>

                    </div>
                    <div class="card-body px-0 pt-0 pb-2">

                        <%--                        public Voucher(String id, String voucherName, double voucherPercent, LocalDateTime createDate, LocalDateTime closeDate, char status) {--%>

                        <form class="row g-3 needs-validation p-4" novalidate action="voucher-create"
                              method="post">

                            <%--                        Tên mã mới--%>
                            <div class="col-12">
                                <label for="voucherName" class="form-label text-lg">Tên mã giảm giá <span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="text" class="form-control  text-lg" placeholder="Nhập tên mã giảm giá"
                                           id="voucherName" name="voucherName" maxlength="100"
                                           required>
                                    <div class="invalid-feedback  text-lg">
                                        Tên không được bỏ trống và tối đa 100 kí tự
                                    </div>
                                </div>
                            </div>


                            <%--                        %  giảm--%>
                            <div class="col-12">
                                <label for="voucherPercent" class="form-label  text-lg">Tỷ lệ giảm(%) <span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="number" class="form-control  text-lg" min="1" max="70"
                                           id="voucherPercent"
                                           name="voucherPercent" placeholder="Nhập tỉ lệ % giảm(1-70)" required>
                                    <div class="invalid-feedback  text-lg">
                                        Vui lòng điền số hợp lệ từ 1 đến 70
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="voucherAmount" class="form-label  text-lg">Số lượng mã (Không giới hạn nếu
                                    không nhập)</label>
                                <div class="input-group has-validation">
                                    <input type="number" class="form-control  text-lg" min="1" max="1000"
                                           id="voucherAmount"
                                           name="voucherAmount" placeholder="Nhập số lượng mã từ 1 đến 1000 mã">
                                    <div class="invalid-feedback  text-lg">
                                        Vui lòng điền số hợp lệ từ 1 đến 1000
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="openDate" class="form-label  text-lg">Ngày bắt đầu <span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="datetime-local" format="DD-MM-YYYY hh:mm" class="form-control  text-lg"
                                           id="openDate" name="openDate" required>
                                    <div class="invalid-feedback  text-lg">
                                        Vui lòng chọn ngày bắt đầu
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="closeDate" class="form-label text-lg">Ngày kết thúc <span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="datetime-local" format="DD-MM-YYYY hh:mm" class="form-control  text-lg"
                                           id="closeDate" name="closeDate" required>
                                    <div class="invalid-feedback text-lg">
                                        Vui lòng chọn ngày kết thúc
                                    </div>
                                </div>
                            </div>
                            <c:if test="${error eq 1}">
                                <div class="bg-danger text-warning text-center d-flex justify-content-center align-items-center"
                                     style="height: 50px;border-radius: 10px"><b>Ngày bắt đầu phải lớn hơn ngày kết
                                    thúc</b></div>
                            </c:if>
                            <c:if test="${success eq 1}">
                                <div class="bg-success text-white text-center d-flex justify-content-center align-items-center"
                                     style="height: 50px;border-radius: 10px"><b>Thêm mã thành công</b></div>
                            </c:if>
                            <div class="col-12">
                                <button class="btn btn-primary" type="submit">Lưu <i
                                        class="fa-solid fa-rocket fa-bounce fa-lg" style="color: #f2df07;"></i></button>
                            </div>
                        </form>


                        <div class="mx-5 mb-2">
                            <a href="voucher-page"><i class="fa-solid fa-arrow-left-long fa-2xl"
                                                      style="color: #2e2bd4;"></i> Quay lại quản lí voucher</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <script>
        // Get the datetime-local input field
        var closeDate = document.getElementById("closeDate");
        var openDate = document.getElementById("openDate");
        // Get the current date
        var today = new Date();
        openDate.min = today.toISOString().substring(0, 10) + "T00:00:00";
        console.log(today);
        // Increment the day by 1 to get tomorrow's date
        var tomorrow = new Date(today.setDate(today.getDate() + 1));

        // Set the minimum time to tomorrow's date at 00:00:00
        closeDate.min = tomorrow.toISOString().substring(0, 10) + "T00:00:00";


    </script>
    <%@include file="include/footer-dashboard.jsp" %>

