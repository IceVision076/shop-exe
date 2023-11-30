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
<%@ include file="include/header-product-management-dashboard.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>
<%@ page import="java.time.format.DateTimeFormatter" %>
<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
         navbar-scroll="true">
        <div class="container-fluid py-1 px-3">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Quản lí đơn</li>
                </ol>
                <h6 class="font-weight-bolder mb-0">Chi tiết đơn hàng</h6>
            </nav>
            <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
                <div class="ms-md-auto pe-md-3 d-flex align-items-center">
                    <div class="input-group">
                      
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
                    <div class="text-center card-header pb-0">
                        <h3>Thông tin đơn hàng <i class="fa-solid fa-cart-shopping fa-bounce"
                                                  style="color: #0452d7;"></i></h3>
                    </div>
                    <div class="card-body px-0 pt-0 pb-2">
                        <div class="d-flex justify-content-center">
                            <a class="btn btn-success" href="download-order?filepath=${downloadUrl}&orderId=${order.orderId}" download>
                               Xuất hóa đơn
                            </a>
                        </div>
                        <div class="table-responsive p-0">
                            <table class="table align-items-center mb-0 p-5">
                                <tbody>
                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-lg">Mã hóa đơn</h6>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h6 class="mb-0 text-lg">${order.orderId}</h6>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-lg">Tên khách hàng</h6>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h6 class="mb-0 text-lg">${order.user.fullName}</h6>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-lg">Ngày tạo đơn</h6>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h6 class="mb-0 text-lg">
                                            ${order.createDate.format(DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd"))}

                                        </h6>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-lg">Trạng thái đơn</h6>

                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h6 class="mb-0 text-lg">
                                            <c:if test="${order.status eq '0'.charAt(0)}">
                                                <h6 class="text-warning m-1 p-0">Đang xử lý - COD</h6>
                                            </c:if>
                                            <c:if test="${order.status eq '1'.charAt(0)}">
                                                <h6 class="text-warning m-1 p-0">Đang xử lý - CK</h6>
                                            </c:if>
                                            <c:if test="${order.status eq '2'.charAt(0)}">
                                                <h6 class="text-primary m-1 p-0">Đã xử lý</h6>
                                            </c:if>
                                            <c:if test="${order.status eq '3'.charAt(0)}">
                                                <h6 class="text-danger m-1 p-0">Đã Hủy</h6>
                                            </c:if>
                                            <c:if test="${order.status eq '4'.charAt(0)}">
                                                <h6 class="text-success m-1 p-0">Giao Hàng Thành Công</h6>
                                            </c:if>
                                            <c:if test="${order.status eq '5'.charAt(0)}">
                                                <h6 class="text-danger m-1 p-0">Giao Hàng thất bại</h6>
                                            </c:if>
                                        </h6>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-lg">Mã khuyến mã</h6>

                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h6 class="mb-0 text-lg">

                                            <c:if test="${empty order.voucher.id}"> Không có mã khuyến mãi</c:if>
                                            <c:if test="${not empty order.voucher.id}">
                                                ${order.voucher.id}
                                                (
                                                <fmt:formatNumber value="${order.voucher.voucherPercent*100}"
                                                                  maxFractionDigits="0"></fmt:formatNumber>
                                                %
                                                )
                                            </c:if>
                                        </h6>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-lg">Địa chỉ giao hàng</h6>

                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h6 class="mb-0 text-lg">${order.orderAddress}</h6>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-lg">Số điện thoại</h6>

                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <h6 class="mb-0 text-lg">${order.user.phone}</h6>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card mb-4">
                    <div class="card-body px-0 pt-0 pb-2">
                        <div class="table-responsive p-0" style="height: auto">
                            <div class="text-center card-header pb-0 p-5">
                                <h3>Thanh toán <i class="fa-solid fa-money-check-dollar fa-bounce"
                                                  style="color: #0d55c9;"></i></h3>
                            </div>
                            <div class="container-fluid py-4">
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card mb-4">
                                            <div class="card-body px-0 pt-0 pb-2">
                                                <div class="table-responsive p-0">
                                                    <table class="table align-items-center mb-0">
                                                        <thead>
                                                        <tr>
                                                            <th class="text-uppercase text-secondary text-xxl font-weight-bolder ">
                                                                <i class="fa-regular fa-image fa-bounce"
                                                                   style="color: #0ee1ad;"></i> Hình ảnh
                                                            </th>
                                                            <th class="text-uppercase text-secondary text-xxl-start font-weight-bolder ">
                                                                <i class="fa-brands fa-product-hunt fa-flip"
                                                                   style="color: #97e10e;"></i> Tên sản phẩm
                                                            </th>
                                                            <th class="text-center text-uppercase text-secondary text-xxl-center font-weight-bolder ">
                                                                <i class="fa-brands fa-quinscape fa-spin"
                                                                   style="color: #8de010;"></i> Giá tiền
                                                            </th>
                                                            <th class="text-center text-uppercase text-secondary text-xxl-center font-weight-bolder ">
                                                                <i class="fa-brands fa-quinscape fa-spin"
                                                                   style="color: #8de010;"></i> Số lượng
                                                            </th>
                                                            <th class="text-center text-uppercase text-secondary text-xxl font-weight-bolder ">
                                                                <i class="fa-solid fa-check fa-bounce"
                                                                   style="color: #d5340b;"></i> Thành tiền
                                                            </th>

                                                        </tr>
                                                        </thead>
                                                        <tbody>

                                                        <c:forEach items="${order.orderDetails}" var="od">
                                                            <tr>
                                                                <td>
                                                                    <div class="align-middle text-center">
                                                                        <img src="${od.productType.imageProducts.get(0).imageUrl}"
                                                                             class="avatar avatar-lg me-3" alt="user1">
                                                                    </div>
                                                                </td>
                                                                <td>
                                                                    <div class="d-flex px-2 py-1">
                                                                        <div class="d-flex flex-column justify-content-center">
                                                                            <h6 class="mb-0 text-lg">${od.productType.product.productName}</h6>
                                                                            <p class="mb-0 text-lg">${od.productType.typeName}</p>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td class="align-middle text-center">
                                                                    <p class="text-secondary text-lg font-weight-bold">
                                                                         <fmt:formatNumber type="number"
                                                                                           maxFractionDigits="3" value=" ${od.priceAtPurchase}"/> <span
                                                                            class="text-success">VND</span></p>
                                                                           </p>
                                                                </td>
                                                                <td class="align-middle text-center text-lg">
                                                                    <p class="badge badge-sm bg-gradient-faded-danger">${od.amount}</p>
                                                                </td>
                                                                <td class="align-middle text-center">
                                                                    <p class="text-secondary text-lg font-weight-bold">
                                                                             <fmt:formatNumber type="number"
                                                                                               maxFractionDigits="3" value="${od.priceAtPurchase*od.amount}"/> <span
                                                                            class="text-success">VND</span></p>
                                                                           </p>
                                                                </td>

                                                            </tr>
                                                        </c:forEach>

                                                        </tbody>
                                                    </table>
                                                    <div class="col-12" style="overflow-x: hidden">
                                                        <div class="row text-uppercase"
                                                             style="height: auto; overflow-x: hidden ">
                                                            <div class="col-7 right-text align-middle p-2"
                                                                 style="background-color: #E8EFFF; border-radius: 20px 5px 5px 30px">
                                                                <h6 class="fw-bold fst-italic"
                                                                    style="margin-left: 5%; font-family: 'Roboto', sans-serif">
                                                                    ghi chú:</h6>
                                                                <p class="text-bold text-2xl" style="padding-left: 100px">
                                                                    <c:if test="${empty order.voucher.id}">
                                                                        Chưa áp mã giảm giá
                                                                    </c:if>
                                                                    <c:if test="${not empty order.voucher.id}">
                                                                       Đã áp mã giảm giá   <fmt:formatNumber value="${order.voucher.voucherPercent*100}"
                                                                                                             maxFractionDigits="0"></fmt:formatNumber>
                                                                        %
                                                                    </c:if>
                                                                </p>
                                                            </div>
                                                            <div class="col-5 left-text align-middle text-center p-2"
                                                                 style="background:#F26969; border-radius: 5px 20px 30px 5px;">
                                                                <h6 style="color: whitesmoke; font-family: 'Roboto', sans-serif">
                                                                    tổng:</h6>
                                                                <span class="font-italic font-weight-bold text-2xl"
                                                                      style="font-family: Algerian; color: whitesmoke">
                                                                    <c:set var="sum" value="0" scope="page">
                                                                    </c:set>
                                                                    <c:if test="${empty order.voucher.id}">
                                                                        <c:forEach items="${order.orderDetails}"
                                                                                   var="od">
                                                                            <c:set var="sum"
                                                                                   value="${sum + od.priceAtPurchase*od.amount}"
                                                                                   scope="page">
                                                                            </c:set>
                                                                        </c:forEach>
                                                                   
                                                                        <fmt:formatNumber type="number"
                                                                                          maxFractionDigits="3" value=" ${sum}"/>
                                                                    </c:if><c:if test="${not empty order.voucher.id}">
                                                                    <c:forEach items="${order.orderDetails}"
                                                                               var="od">
                                                                        <c:set var="sum"
                                                                               value="${sum + od.priceAtPurchase*od.amount}"
                                                                               scope="page">
                                                                        </c:set>
                                                                    </c:forEach>
                                                                    <fmt:formatNumber type="number"
                                                                                      maxFractionDigits="3" value="${sum*order.voucher.voucherPercent}"/>

                                                                </c:if>

                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="include/footer-dashboard.jsp" %>
