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
<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
         navbar-scroll="true">
        <div class="container-fluid py-1 px-3">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="product-management">Quản lí
                        tài khoản</a>
                    </li>

                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Quản lí tài khoản nhân
                        viên
                    </li>
                </ol>
                <h6 class="font-weight-bolder mb-0">Quản lí tài khoản nhân viên</h6>
            </nav>
            <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
                <div class="ms-md-auto pe-md-3 d-flex align-items-center">
                    <div class="input-group">
                        <span class="input-group-text text-body"><i class="fas fa-search" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" placeholder="Type here...">
                    </div>
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
                                class="fa-solid fa-kiwi-bird fa-spin-pulse" style="color: #b01cba;"></i> Thêm nhân viên
                            mới <i class="fa-solid fa-kiwi-bird fa-spin-pulse" style="color: #b01cba;"></i></h4>

                    </div>
                    <div class="card-body px-0 pt-0 pb-2">


                        <form class="row g-3 needs-validation p-4" novalidate action="employee-add-account"
                              method="post"     >
                            <%--                            User(id, userName, passWord, fullName, email, role, phone, status, avatarImg, address);--%>
                            <div class="col-12">
                                <label for="userName" class="form-label">Username<span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="text" pattern="^[a-z]\w{6,20}$" class="form-control"
                                           placeholder="Nhập username"
                                           id="userName" name="userName"
                                           required>
                                    <div class="invalid-feedback">
                                        Username phải bắt đầu bằng chữ cái thường không dấu, tối thiểu 6 kí tự và tối đa
                                        20 kí tự
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="passWord" class="form-label">Mật khẩu<span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="text" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{7,50}$"
                                           class="form-control" placeholder="Nhập mật khẩu"
                                           id="passWord" name="passWord"
                                           required>
                                    <div class="invalid-feedback">
                                        Mật khẩu phải chứa ít nhất một chữ cái in hoa, một chữ cái in thường, một số và
                                        có độ dài từ 7 đến 50 kí tự
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="fullName" class="form-label">Tên nhân viên<span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="text" class="form-control" pattern="^[a-zA-ZaAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ
fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ\s]{1,50}$" placeholder="Nhập tên nhân viên"
                                           id="fullName" name="fullName"
                                           required>
                                    <div class="invalid-feedback">
                                        Tên không được bỏ trống có độ dài tối đa là 50 kí tự
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="email" class="form-label">Email<span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="email" class="form-control" placeholder="Nhập email"
                                           id="email" name="email"
                                           required>
                                    <div class="invalid-feedback">
                                        Email không được bỏ trống
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="phone" class="form-label">Điện thoại<span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="text" pattern="^[0-9]{10,11}$" class="form-control"
                                           placeholder="Nhập điện thoại"
                                           id="phone" name="phone"
                                           required>
                                    <div class="invalid-feedback">
                                        Email không được bỏ trống
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="address" class="form-label">Địa chỉ<span
                                        class="text-danger"> *</span></label>
                                <div class="input-group has-validation">
                                    <input type="text" pattern="^[a-zA-ZaAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ
fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ\s]{1,50}$"
                                           class="form-control" placeholder="Nhập địa chỉ"
                                           id="address" name="address"
                                           required>
                                    <div class="invalid-feedback">
                                        Địa chỉ không được bỏ trống
                                    </div>
                                </div>
                            </div>
                            <button class="btn btn-primary" type="submit">Lưu <i
                                    class="fa-solid fa-rocket fa-bounce fa-lg" style="color: #f2df07;"></i></button>
                    </div>
                    </form>
                    <div class="mx-5 mb-2">
                        <a href="product-management"><i class="fa-solid fa-arrow-left-long fa-2xl"
                                                        style="color: #2e2bd4;"></i> Quay lại quản lí sản phẩm</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
    </div>

    <%@include file="include/footer-dashboard.jsp" %>

