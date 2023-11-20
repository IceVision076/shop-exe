<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/10/2023
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="include/header-product-management-dashboard.jsp" %>
<fmt:setLocale value="en_US"/>
<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
         navbar-scroll="true">
        <div class="container-fluid py-1 px-3">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Pages</a>
                    </li>
                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Dashboard</li>
                </ol>
                <h6 class="font-weight-bolder mb-0">Dashboard</h6>
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
                                            <img src="../assets/img/team-2.jpg" class="avatar avatar-sm  me-3 ">
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
                                            <img src="../assets/img/small-logos/logo-spotify.svg"
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
        <h3 class="text-center">Phần thống kê thu nhập từ bán hàng</h3>
        <div class="row">
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Thu nhập hôm nay</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value="${totalMoneyToday}"/> <span
                                            class="text-success">VNĐ</span>
                                    </h5>


                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2 hidden-sm"></div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Thu nhập tháng này</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value=" ${totalMoneyOnMonth}"/> <span
                                            class="text-success">VNĐ</span>

                                        <c:if test="${totalMoneyOnMonth>totalMoneyBeforeMonth}">
                                            <br>
                                            <span class="text-success text-sm font-weight-bolder">Tăng so với tháng trước +
                                     <fmt:formatNumber type="number" maxFractionDigits="3"
                                                       value=" ${totalMoneyOnMonth-totalMoneyBeforeMonth}"/> <span
                                                        class="text-success">VNĐ</span>
                                         </span>
                                        </c:if>
                                        <c:if test="${totalMoneyOnMonth<totalMoneyBeforeMonth}">
                                            <br>
                                            <span class="text-danger text-sm font-weight-bolder">Giảm so với tháng trước -
                                     <fmt:formatNumber type="number" maxFractionDigits="3"
                                                       value=" ${-totalMoneyOnMonth+totalMoneyBeforeMonth}"/> <span
                                                        class="text-danger">VNĐ</span>
                                         </span>
                                        </c:if>


                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Thu nhập tháng trước</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value=" ${totalMoneyBeforeMonth}"/> <span
                                            class="text-success">VNĐ</span>
                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Tổng Thu Nhập Bán Hàng
                                        Trong Năm</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value=" ${totalMoneyInYear}"/> <span
                                            class="text-success">VNĐ</span>
                                        <c:if test="${totalMoneyInYear>totalMoneyBeforeYear}">
                                            <br>
                                            <span class="text-success text-sm font-weight-bolder">Tăng so với năm trước +
                                     <fmt:formatNumber type="number" maxFractionDigits="3"
                                                       value=" ${totalMoneyInYear-totalMoneyBeforeYear}"/> <span
                                                        class="text-success">VNĐ</span>
                                         </span>
                                        </c:if>
                                        <c:if test="${totalMoneyInYear<totalMoneyBeforeYear}">
                                            <br>
                                            <span class="text-danger text-sm font-weight-bolder">Giảm so với năm trước -
                                     <fmt:formatNumber type="number" maxFractionDigits="3"
                                                       value=" ${-totalMoneyInYear+totalMoneyBeforeYear}"/> <span
                                                        class="text-danger">VNĐ</span>
                                         </span>
                                        </c:if>

                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">

                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Tổng thu nhập bán hàng năm
                                        trước</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value=" ${totalMoneyBeforeYear}"/> <span
                                            class="text-success">VNĐ</span>

                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-12 mb-xl-0 mb-4 mt-2">\

                <h3 class="text-center"> Phần thống kê thu nhập cho từng loại sản phẩm</h3>
            </div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Tổng thu nhập bán tinh dầu
                                        trong năm</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value=" ${totalMoneyJuiceInYear}"/> <span
                                            class="text-success">VNĐ</span>

                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Tổng thu nhập bán phụ kiện
                                        trong năm</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value=" ${totalMoneyAccessoryInYear}"/> <span
                                            class="text-success">VNĐ</span>

                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Tổng thu nhập bán vape
                                        trong năm</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value=" ${totalMoneyVapeInYear}"/> <span
                                            class="text-success">VNĐ</span>
                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 mb-xl-0 mb-4 mt-5">
                <h3 class="text-center"> Phần thống kê người dùng trong hệ thống</h3>
            </div>
            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Tổng nhân viên đang làm
                                        việc</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        ${totalEmployeeWorking}
                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Tổng số khách hàng</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        ${totalUser}
                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-world text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4 mt-2">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-8">
                                <div class="numbers">
                                    <p class="text-sm mb-0 text-capitalize font-weight-bold">Số lượng người dùng vi
                                        phạm</p>
                                    <h5 class="font-weight-bolder mb-0">
                                        ${totalCustomerIsLocked}
                                    </h5>
                                </div>
                            </div>
                            <div class="col-4 text-end">
                                <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                    <i class="ni ni-cart text-lg opacity-10" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="row mt-4">
            <div class="col-lg-7 mb-lg-0 mb-4">
                <div class="card">
                    <div class="card-body p-3">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="d-flex flex-column h-100">
                                    <p class="mb-1 pt-2 text-bold"></p>
                                    <h5 class="font-weight-bolder">Chào bạn hôm nay bạn thế nào <i
                                            class="fa-solid fa-seedling fa-flip-horizontal fa-sm"
                                            style="color: #09c84c;"></i></h5>
                                    <p class="mb-5">Đội ngũ vapeshop chúc bạn một ngày mới vui vẻ <i
                                            class="fa-solid fa-heart-pulse fa-fade fa-xl" style="color: #d8220e;"></i>
                                    </p>

                                </div>
                            </div>
                            <div class="col-lg-5 ms-auto text-center mt-5 mt-lg-0">
                                <div class="bg-success border-radius-lg  h-100">
                                    <img class="border-radius-lg h-100"
                                         src="https://img1.kienthucvui.vn/uploads/2019/10/09/anh-bau-troi-dep-hoang-hon-huyen-bi_042052103.jpg"
                                         style="width: 100%;" alt="waves">
                                    <%--                                    <div class="position-relative d-flex align-items-center justify-content-center h-100">--%>
                                    <%--                                        <img class="w-100 position-relative z-index-2 pt-4" src="dashboard/assets/img/page-weather.jpg" alt="rocket">--%>
                                    <%--                                    </div>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-5">
                <div class="card h-100 p-3">
                    <div class="overflow-hidden position-relative border-radius-lg bg-cover h-100"
                         style="background-image: url('../assets/img/ivancik.jpg');">
                        <span class="mask bg-gradient-dark"></span>
                        <div class="card-body position-relative z-index-1 d-flex flex-column h-100 p-3">
                            <h5 class="text-white font-weight-bolder mb-4 pt-2">Mách bạn</h5>
                            <p class="text-white fw-bolder text-center">"Lao động là thước đo giá trị của con
                                người" </p>

                            <p class="text-center text-white fw-bolder">-(Khổng Tử)-</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-4">

            <div class="col-12">
                <div class="card z-index-2">
                    <div class="card-header pb-0">
                        <h6>Thống kê bán hàng theo tháng</h6>
                        <%--                        <p class="text-sm">--%>
                        <%--                            <i class="fa fa-arrow-up text-success"></i>--%>
                        <%--                            <span class="font-weight-bold">4% more</span> in 2021--%>
                        <%--                        </p>--%>
                    </div>
                    <div class="card-body p-3">
                        <div class="chart">
                            <canvas id="chart-line" class="chart-canvas" height="300"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row my-4">
            <div class="col-12 mb-md-0 mb-4 ">
                <div class="card">
                    <div class="card-header pb-0">
                        <div class="row">
                            <div class="col-lg-6 col-7">
                                <h6 class="text-lg">Top 5 sản phẩm bán chạy</h6>

                            </div>

                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <div class="table-responsive">
                            <table class="table align-items-center mb-0">
                                <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-lg font-weight-bolder ">
                                        Tên sản phẩm
                                    </th>
                                    <th class="text-uppercase text-secondary text-lg font-weight-bolder  ps-2">
                                        Loại sản phẩm
                                    </th>
                                    <th class="text-center text-uppercase text-secondary text-lg font-weight-bolder ">
                                        Giá sản phẩm
                                    </th>
                                    <th class="text-center text-uppercase text-secondary text-lg font-weight-bolder">
                                        Số lượng đã bán
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${top5ProductTypeBestSellOnMonth}" var="p">
                                    <tr>
                                        <td>
                                            <div class="d-flex px-2 py-1">
                                                <div>
                                                    <img src="${p.imageProducts.get(0).imageUrl}"
                                                         class="avatar avatar-sm me-3 img-thumbnail " alt="xd">
                                                </div>
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="mb-0 text-lg">${p.product.productName}</h6>
                                                    <h6 class="mb-0 text-lg">${p.productTypeId}</h6>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <p class="font-weight-bold">${p.typeName}</p>
                                        </td>
                                        <td class=" text-center ">
                                            <p class="text-lg font-weight-bold">
                                                <fmt:formatNumber type="number" maxFractionDigits="3"
                                                                  value="${p.typePrice}"/> <span
                                                    class="text-success">VNĐ</span>

                                            </p>
                                        </td>
                                        <td>
                                            <p class="text-center text-lg font-weight-bold">${p.selledAmount}</p>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row my-4">
            <div class="col-12 mb-md-0 mb-4 ">
                <div class="card">
                    <div class="card-header pb-0">
                        <div class="row">
                            <div class="col-lg-6 col-7">
                                <h6 class="text-lg">Top 10 người mua hóa đơn có giá trị cao</h6>

                            </div>

                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <div class="table-responsive">
                            <table class="table align-items-center mb-0">
                                <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-lg font-weight-bolder ">
                                        Id khách hàng
                                    </th>
                                    <th class="text-uppercase text-secondary text-lg font-weight-bolder  ps-2">
                                        Tên khách hàng
                                    </th>
                                    <th class="text-center text-uppercase text-secondary text-lg font-weight-bolder ">
                                       Tổng tiền mua
                                    </th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${top10MostPurchased.userPurchaseds}" var="u">
                                    <tr>
                                        <td>
                                            <div class="d-flex px-2 py-1">

                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="mb-0 text-lg">${u.user.id}</h6>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <p class="font-weight-bold">${u.user.fullName}</p>
                                        </td>
                                        <td class=" text-center ">
                                            <p class="text-lg font-weight-bold">
                                                <fmt:formatNumber type="number" maxFractionDigits="3"
                                                                  value="${u.total}"/> <span
                                                    class="text-success">VNĐ</span>

                                            </p>
                                        </td>

                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row my-4" >
            <div class="col-12 card mb-3">
                <div class="card-header">
                    <h6 class="font-weight-bold text-lg">Thu nhập trong tuần</h6>
                </div>
                <div class="card-body">
                    <canvas id="moneyWeek"></canvas>
                </div>
            </div>
            <div class="col-5    card">
                <div class="card-header">
                    <h3 class="text-center">Biểu đồ thống kê số lượng sản phẩm trong hệ thống </h3>
                </div>
                <div class="card-body">
                    <canvas id="productAmount"></canvas>
                </div>

                <div class="card-footer text-bold text-lg text-center">

                        <span style="color: rgb(255, 99, 132)">Phụ kiện:
                            <fmt:formatNumber
                                    value="  ${productAmountChart[0]/(productAmountChart[0]+productAmountChart[1]+productAmountChart[2])*100}"
                                    maxFractionDigits="2"
                            ></fmt:formatNumber>%
                          </span>
                    <span> - </span>
                    <span style="color: rgb(54, 162, 235)">Dầu:
                            <fmt:formatNumber
                                    value="  ${productAmountChart[1]/(productAmountChart[0]+productAmountChart[1]+productAmountChart[2])*100}"
                                    maxFractionDigits="2"
                            ></fmt:formatNumber>%</span>
                    <span> - </span>
                    <span style="color: rgb(117,255,86)">Vape:
                            <fmt:formatNumber
                                    value="  ${productAmountChart[2]/(productAmountChart[0]+productAmountChart[1]+productAmountChart[2])*100}"
                                    maxFractionDigits="2"
                            ></fmt:formatNumber>%</span>


                </div>
            </div>
        </div>

        <%--=========================================== Chart product amount===========================================--%>


        <footer class="footer pt-3  ">
            <div class="container-fluid">
                <div class="row align-items-center justify-content-lg-between">
                    <div class="col-lg-6 mb-lg-0 mb-4">
                        <div class="copyright text-center text-sm text-muted text-lg-start">
                            ©
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            ,
                            made with <i class="fa fa-heart"></i> by
                            <a href="https://www.creative-tim.com" class="font-weight-bold" target="_blank">Creative
                                Tim</a>
                            for a better web.
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <ul class="nav nav-footer justify-content-center justify-content-lg-end">
                            <li class="nav-item">
                                <a href="https://www.creative-tim.com" class="nav-link text-muted" target="_blank">Creative
                                    Tim</a>
                            </li>
                            <li class="nav-item">
                                <a href="https://www.creative-tim.com/presentation" class="nav-link text-muted"
                                   target="_blank">About Us</a>
                            </li>
                            <li class="nav-item">
                                <a href="https://www.creative-tim.com/blog" class="nav-link text-muted"
                                   target="_blank">Blog</a>
                            </li>
                            <li class="nav-item">
                                <a href="https://www.creative-tim.com/license" class="nav-link pe-0 text-muted"
                                   target="_blank">License</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</main>
<div class="fixed-plugin">
    <a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
        <i class="fa fa-cog py-2"> </i>
    </a>
    <div class="card shadow-lg ">
        <div class="card-header pb-0 pt-3 ">
            <div class="float-start">
                <h5 class="mt-3 mb-0">Soft UI Configurator</h5>
                <p>See our dashboard options.</p>
            </div>
            <div class="float-end mt-4">
                <button class="btn btn-link text-dark p-0 fixed-plugin-close-button">
                    <i class="fa fa-close"></i>
                </button>
            </div>
            <!-- End Toggle Button -->
        </div>
        <hr class="horizontal dark my-1">
        <div class="card-body pt-sm-3 pt-0">
            <!-- Sidebar Backgrounds -->
            <div>
                <h6 class="mb-0">Sidebar Colors</h6>
            </div>
            <a href="javascript:void(0)" class="switch-trigger background-color">
                <div class="badge-colors my-2 text-start">
                    <span class="badge filter bg-gradient-primary active" data-color="primary"
                          onclick="sidebarColor(this)"></span>
                    <span class="badge filter bg-gradient-dark" data-color="dark" onclick="sidebarColor(this)"></span>
                    <span class="badge filter bg-gradient-info" data-color="info" onclick="sidebarColor(this)"></span>
                    <span class="badge filter bg-gradient-success" data-color="success"
                          onclick="sidebarColor(this)"></span>
                    <span class="badge filter bg-gradient-warning" data-color="warning"
                          onclick="sidebarColor(this)"></span>
                    <span class="badge filter bg-gradient-danger" data-color="danger"
                          onclick="sidebarColor(this)"></span>
                </div>
            </a>
            <!-- Sidenav Type -->
            <div class="mt-3">
                <h6 class="mb-0">Sidenav Type</h6>
                <p class="text-sm">Choose between 2 different sidenav types.</p>
            </div>
            <div class="d-flex">
                <button class="btn bg-gradient-primary w-100 px-3 mb-2 active" data-class="bg-transparent"
                        onclick="sidebarType(this)">Transparent
                </button>
                <button class="btn bg-gradient-primary w-100 px-3 mb-2 ms-2" data-class="bg-white"
                        onclick="sidebarType(this)">White
                </button>
            </div>
            <p class="text-sm d-xl-none d-block mt-2">You can change the sidenav type just on desktop view.</p>
            <!-- Navbar Fixed -->
            <div class="mt-3">
                <h6 class="mb-0">Navbar Fixed</h6>
            </div>
            <div class="form-check form-switch ps-0">
                <input class="form-check-input mt-1 ms-auto" type="checkbox" id="navbarFixed"
                       onclick="navbarFixed(this)">
            </div>
            <hr class="horizontal dark my-sm-4">
            <a class="btn bg-gradient-dark w-100" href="https://www.creative-tim.com/product/soft-ui-dashboard">Free
                Download</a>
            <a class="btn btn-outline-dark w-100"
               href="https://www.creative-tim.com/learning-lab/bootstrap/license/soft-ui-dashboard">View
                documentation</a>
            <div class="w-100 text-center">
                <a class="github-button" href="https://github.com/creativetimofficial/soft-ui-dashboard"
                   data-icon="octicon-star" data-size="large" data-show-count="true"
                   aria-label="Star creativetimofficial/soft-ui-dashboard on GitHub">Star</a>
                <h6 class="mt-3">Thank you for sharing!</h6>
                <a href="https://twitter.com/intent/tweet?text=Check%20Soft%20UI%20Dashboard%20made%20by%20%40CreativeTim%20%23webdesign%20%23dashboard%20%23bootstrap5&amp;url=https%3A%2F%2Fwww.creative-tim.com%2Fproduct%2Fsoft-ui-dashboard"
                   class="btn btn-dark mb-0 me-2" target="_blank">
                    <i class="fab fa-twitter me-1" aria-hidden="true"></i> Tweet
                </a>
                <a href="https://www.facebook.com/sharer/sharer.php?u=https://www.creative-tim.com/product/soft-ui-dashboard"
                   class="btn btn-dark mb-0 me-2" target="_blank">
                    <i class="fab fa-facebook-square me-1" aria-hidden="true"></i> Share
                </a>
            </div>
        </div>
    </div>
</div>
<!-- Core JS Files -->
<script src="dashboard/assets/js/core/popper.min.js"></script>
<script src="dashboard/assets/js/core/bootstrap.min.js"></script>
<script src="dashboard/assets/js/plugins/perfect-scrollbar.min.js"></script>
<script src="dashboard/assets/js/plugins/smooth-scrollbar.min.js"></script>
<script src="dashboard/assets/js/plugins/chartjs.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<%--Biểu đồ thống kê số lượng sản phẩm trong hệ thống--%>


<%--Biểu đồ thống kê số lượng sản phẩm trong hệ thống--%>
<script>
    var testChart = document.getElementById('productAmount');
    new Chart(testChart, {
            type: 'doughnut',
            data: {
                labels: [
                    'Phụ kiện',
                    'Dầu',
                    'Vape'
                ],
                datasets: [{
                    label: 'Số lượng',
                    data: [
                        <c:forEach var="productAmount" items="${productAmountChart}">
                        ${productAmount},
                        </c:forEach>
                    ],
                    backgroundColor: [
                        'rgb(255, 99, 132)',
                        'rgb(54, 162, 235)',
                        'rgb(117,255,86)'
                    ],
                    hoverOffset: 4
                }]
            }
        }
    )
</script>
<script>
    <%--var ctx = document.getElementById("chart-bars").getContext("2d");--%>

    <%--new Chart(ctx, {--%>
    <%--    type: "bar",--%>
    <%--    data: {--%>
    <%--        labels: [--%>
    <%--            "Tháng Giêng",--%>
    <%--            "Tháng Hai",--%>
    <%--            "Tháng Ba",--%>
    <%--            "Tháng Tư",--%>
    <%--            "Tháng Năm",--%>
    <%--            "Tháng Sáu",--%>
    <%--            "Tháng Bảy",--%>
    <%--            "Tháng Tám",--%>
    <%--            "Tháng Chín",--%>
    <%--            "Tháng Mười",--%>
    <%--            "Tháng Mười Một",--%>
    <%--            "Tháng Mười Hai"--%>
    <%--        ],--%>
    <%--        datasets: [{--%>
    <%--            label: "Sales",--%>
    <%--            tension: 0.4,--%>
    <%--            borderWidth: 0,--%>
    <%--            borderRadius: 4,--%>
    <%--            borderSkipped: false,--%>
    <%--            backgroundColor: "#fff",--%>
    <%--            data: [--%>
    <%--                <c:forEach var="m" items="${moneyWithMonth.eachMonths}">--%>
    <%--                ${m.totalMoney},--%>
    <%--                </c:forEach>--%>
    <%--            ],--%>
    <%--            maxBarThickness: 6--%>
    <%--        },],--%>
    <%--    },--%>
    <%--    options: {--%>
    <%--        responsive: true,--%>
    <%--        maintainAspectRatio: false,--%>
    <%--        plugins: {--%>
    <%--            legend: {--%>
    <%--                display: false,--%>
    <%--            }--%>
    <%--        },--%>
    <%--        interaction: {--%>
    <%--            intersect: false,--%>
    <%--            mode: 'index',--%>
    <%--        },--%>
    <%--        scales: {--%>
    <%--            y: {--%>
    <%--                grid: {--%>
    <%--                    drawBorder: false,--%>
    <%--                    display: false,--%>
    <%--                    drawOnChartArea: false,--%>
    <%--                    drawTicks: false,--%>
    <%--                },--%>
    <%--                ticks: {--%>
    <%--                    suggestedMin: 0,--%>
    <%--                    suggestedMax: 500,--%>
    <%--                    beginAtZero: true,--%>
    <%--                    padding: 15,--%>
    <%--                    font: {--%>
    <%--                        size: 14,--%>
    <%--                        family: "Open Sans",--%>
    <%--                        style: 'normal',--%>
    <%--                        lineHeight: 2--%>
    <%--                    },--%>
    <%--                    color: "#fff"--%>
    <%--                },--%>
    <%--            },--%>
    <%--            x: {--%>
    <%--                grid: {--%>
    <%--                    drawBorder: false,--%>
    <%--                    display: false,--%>
    <%--                    drawOnChartArea: false,--%>
    <%--                    drawTicks: false--%>
    <%--                },--%>
    <%--                ticks: {--%>
    <%--                    display: false--%>
    <%--                },--%>
    <%--            },--%>
    <%--        },--%>
    <%--    },--%>
    <%--});--%>


    var ctx2 = document.getElementById("chart-line").getContext("2d");

    var gradientStroke1 = ctx2.createLinearGradient(0, 230, 0, 50);

    gradientStroke1.addColorStop(1, 'rgba(203,12,159,0.2)');
    gradientStroke1.addColorStop(0.2, 'rgba(72,72,176,0.0)');
    gradientStroke1.addColorStop(0, 'rgba(203,12,159,0)'); //purple colors

    var gradientStroke2 = ctx2.createLinearGradient(0, 230, 0, 50);

    gradientStroke2.addColorStop(1, 'rgba(20,23,39,0.2)');
    gradientStroke2.addColorStop(0.2, 'rgba(72,72,176,0.0)');
    gradientStroke2.addColorStop(0, 'rgba(20,23,39,0)'); //purple colors

    new Chart(ctx2, {
        type: "line",
        data: {
            labels: ["Tháng 1", " Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
            datasets: [{
                label: "Năm nay",
                tension: 0.4,
                borderWidth: 0,
                pointRadius: 0,
                borderColor: "#cb0c9f",
                borderWidth: 3,
                backgroundColor: gradientStroke1,
                fill: true,
                data: [<c:forEach var="m" items="${moneyWithMonth.eachMonths}">
                    ${m.totalMoney},
                    </c:forEach>],
                maxBarThickness: 6

            },
                {
                    label: "Năm trước",
                    tension: 0.4,
                    borderWidth: 0,
                    pointRadius: 0,
                    borderColor: "#3A416F",
                    borderWidth: 3,
                    backgroundColor: gradientStroke2,
                    fill: true,
                    data: [<c:forEach var="m" items="${moneyWithMonthLastYear.eachMonths}">
                        ${m.totalMoney},
                        </c:forEach>],
                    maxBarThickness: 6
                },
            ],
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    display: false,
                }
            },
            interaction: {
                intersect: false,
                mode: 'index',
            },
            scales: {
                y: {
                    grid: {
                        drawBorder: false,
                        display: true,
                        drawOnChartArea: true,
                        drawTicks: false,
                        borderDash: [5, 5]
                    },
                    ticks: {
                        display: true,
                        padding: 10,
                        color: '#b2b9bf',
                        font: {
                            size: 11,
                            family: "Open Sans",
                            style: 'normal',
                            lineHeight: 2
                        },
                    }
                },
                x: {
                    grid: {
                        drawBorder: false,
                        display: false,
                        drawOnChartArea: false,
                        drawTicks: false,
                        borderDash: [5, 5]
                    },
                    ticks: {
                        display: true,
                        color: '#b2b9bf',
                        padding: 20,
                        font: {
                            size: 11,
                            family: "Open Sans",
                            style: 'normal',
                            lineHeight: 2
                        },
                    }
                },
            },
        },
    });
</script>


<script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
        var options = {
            damping: '0.5'
        }
        Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
</script>
<script>
    const moneyWeek = document.getElementById('moneyWeek');

    new Chart(moneyWeek, {
        type: 'line',
        data: {
            labels: [
                , "Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy"
            ],
            datasets: [{
                label: 'Thu nhập',
                data: [<c:forEach var="w" items="${moneyWithWeek.eachDays}">, ${w.totalMoney}</c:forEach>],
                borderWidth: 1,
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });


</script>


<!-- Github buttons -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<script src="dashboard/assets/js/soft-ui-dashboard.min.js?v=1.0.7"></script>
<script src="https://kit.fontawesome.com/fc6bd51969.js" crossorigin="anonymous"></script>
</body>

</html>
