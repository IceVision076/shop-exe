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


<%@include file="include/header-product-management-dashboard.jsp"%>
<style>
  .cards-service {
    display: flex;
    flex-direction: row;
    gap: 15px;
  }



  .cards-service .card-service {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    text-align: center;
    height: 200px;
    width: 200px;
    border-radius: 10px;
    color: white;
    cursor: pointer;
    transition: 400ms;
  }

  .cards-service .card-service p.tip {
    font-size: 1em;
    font-weight: 700;
  }

  .cards-service .card-service p.second-text {
    font-size: .7em;
  }

  .cards-service .card-service:hover {
    transform: scale(1.05, 1.05);
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


          <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Quản lí đơn hàng</li>
        </ol>
        <h6 class="font-weight-bolder mb-0">Quản lí đơn hàng</h6>
      </nav>
      <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
        <div class="ms-md-auto pe-md-3 d-flex align-items-center">
<%--          <div class="input-group">--%>
<%--            <span class="input-group-text text-body"><i class="fas fa-search" aria-hidden="true"></i></span>--%>
<%--            <input type="text" class="form-control" placeholder="Type here...">--%>
<%--          </div>--%>
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
            <h4 style="font-family: Calibri;" class="text-center"> <i class="fa-solid fa-truck-fast" style="color: #0ebea9;"></i> Quản lí đơn hàng <i class="fa-solid fa-truck-fast" style="color: #0ebea9;"></i></h4>

          </div>
          <div class="card-body px-0 pt-0 pb-2 ">
            <div class="container">
              <div class="cards-service row mb-5 mt-3 d-flex justify-content-around">
                <a href="order-waiting" class="card-service red bg-secondary col-md-4 position-relative">
                  <p class="tip" >Đơn đang chờ
                  </p>
                  <p class="second-text">Nhấp để xem </p>
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
  ${orderWaitingAmount}
    <span class="visually-hidden">unread messages</span>
  </span>
                </a>
                <a href="order-canceled" class="card-service blue bg-danger col-md-4 position-relative">
                  <p class="tip">Đơn bị hủy</p>
                  <p class="second-text">Nhấp để xem</p>
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
${orderCanceledAmount}
    <span class="visually-hidden">unread messages</span>
  </span>
                </a>
                <a href="order-accepted" class="card-service yellow bg-primary col-md-4 position-relative">
                  <p class="tip">Đơn đang vận chuyển  </p>
                  <p class="second-text">Nhấp để xem</p>
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
 ${orderAcceptedAmount}
    <span class="visually-hidden">unread messages</span>
  </span>
                </a>
                <a href="order-success" class="card-service green bg-success col-md-4 position-relative">
                  <p class="tip">Đơn thành công  </p>
                  <p class="second-text">Nhấp để xem</p>
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
${orderSuccessAmount}
    <span class="visually-hidden">unread messages</span>
  </span>
                </a>
                <a href="order-fail" class="card-service green bg-dark col-md-4 position-relative">
                  <p class="tip">Đơn thất bại</p>
                  <p class="second-text">Nhấp để xem</p>
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
${orderFailAmount}
    <span class="visually-hidden">unread messages</span>
  </span>
                </a>
              </div>
            </div>



            <div class="mx-5 mb-2">
              <a href="product-management"><i class="fa-solid fa-arrow-left-long fa-2xl" style="color: #2e2bd4;"></i> Quay lại quản lí sản phẩm</a>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>

  <%@include file="include/footer-dashboard.jsp"%>

