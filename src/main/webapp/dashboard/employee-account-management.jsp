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
<style>
    /* === removing default button style ===*/
    /* === removing default button style ===*/
    .button-open {
        margin: 0;
        height: auto;
        background: transparent;
        padding: 0;
        border: none;
        cursor: pointer;

    }

    /* button styling */
    .button-open {
        --border-right: 6px;
        --text-stroke-color: rgba(255,255,255,0.6);
        --animation-color: #37FF8B;
        --fs-size: 20px;
        letter-spacing: 3px;
        text-decoration: none;
        font-size: var(--fs-size);
        font-family: "Arial";
        position: relative;
        text-transform: uppercase;
        color: transparent;
        -webkit-text-stroke: 1px var(--text-stroke-color);
        border-radius: 5px;

    }
    /* this is the text, when you hover on button */
    .hover-text-open {
        position: absolute;
        box-sizing: border-box;
        content: attr(data-text);
        color: var(--animation-color);
        width: 0%;
        inset: 0;
        border-right: var(--border-right) solid var(--animation-color);
        overflow: hidden;
        transition: 0.5s;
        -webkit-text-stroke: 1px var(--animation-color);
    }
    /* hover */
    .button-open:hover .hover-text-open {
        width: 100%;
        filter: drop-shadow(0 0 23px var(--animation-color))
    }


    /* === removing default button style ===*/
    .button-close {
        margin: 0;
        height: auto;
        background: transparent;
        padding: 0;
        border: none;
        cursor: pointer;
    }

    /* button styling */
    .button-close {
        --border-right: 6px;
        --text-stroke-color: rgba(255,255,255,0.6);
        --animation-color-c: red;
        --fs-size: 20px;
        letter-spacing: 3px;
        text-decoration: none;
        font-size: var(--fs-size);
        font-family: "Arial";
        position: relative;
        text-transform: uppercase;
        color: transparent;
        -webkit-text-stroke: 1px var(--text-stroke-color);
        border-radius: 5px;
    }
    /* this is the text, when you hover on button */
    .hover-text-close {
        position: absolute;
        box-sizing: border-box;
        content: attr(data-text);
        color: var(--animation-color-c);
        width: 0%;
        inset: 0;
        border-right: var(--border-right) solid var(--animation-color-c);
        overflow: hidden;
        transition: 0.5s;
        -webkit-text-stroke: 1px var(--animation-color-c);
    }
    /* hover */
    .button-close:hover .hover-text-close {
        width: 100%;
        filter: drop-shadow(0 0 23px var(--animation-color-c))
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
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Quản lí tài khoản</a>
                    </li>
                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Quản lí tài khoản nhân viên</li>
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
                        <h6>Bảng quản lí nhân viên (Trang ${page}/${maxPage})</h6>
                        <a href="employee-add-account" class="fa-solid fa-user-plus fa-xl d-flex flex-row-reverse"
                           style="color: #d31798;"> <span style="font-family: Courier;font-size: 20px;">Thêm tài khoản nhân viên</span>
                        </a>

                    </div>
                    <div class="card-body px-0 pt-0 pb-2">
                        <div class="table-responsive p-0">
                            <table class="table align-items-center mb-0">
                                <thead>
                                <tr>
                                    <th>Ảnh đại diện</th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Tên nhân viên
                                    </th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                                        Tên đăng nhập
                                    </th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Email
                                    </th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Điện thoại
                                    </th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Địa chỉ
                                    </th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Trạng thái
                                    </th>
                                    <th class="text-secondary text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Hành động
                                    </th>
                                </tr>
                                </thead>
                                <tbody>

                                <%--                                User{id=AC00000005, userName=Leo, passWord=null, fullName=Leo Đặng, email=Leo@gmail.com,--%>
                                <%--                                role=null, phone=01234567891, status=null, avatarImg=https://img.websosanh.vn/v2/users/review/images/4wvuq0i4ozs1q.jpg?compress=85, --%>
                                <%--                                address=128 Hoàng Diệu , Đà Nẵng, Việt Nam}--%>
                                <c:forEach items="${listEmployee}" var="e">

                                    <tr>
                                        <td>
                                            <div>
                                                <img src="${e.avatarImg}"
                                                     class="m-2 img-thumbnail "
                                                     style="width: 100px;" alt="user1">
                                            </div>
                                        </td>
                                        <td>
                                            <div class="d-flex px-2 py-1">

                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="mb-0 text-sm">${e.fullName}</h6>

                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <p class="text-xs font-weight-bold mb-0">${e.userName}</p>

                                        </td>

                                        <td class="align-middle text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${e.email}</span>
                                        </td>
                                        <td class="align-middle text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${e.phone}</span>
                                        </td>
                                        <td class="align-middle text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${e.address}</span>
                                        </td>
                                        <td class="align-middle text-center text-sm">
                                            <c:if test="${e.status eq '1'}">
                                                <span class="badge badge-sm bg-gradient-success ">Có thể truy cập</span>
                                            </c:if>
                                            <c:if test="${e.status eq '0'}">
                                                <span class="badge badge-sm bg-gradient-danger ">Bị khóa</span>
                                            </c:if>
                                        </td>
                                        <td class="align-middle">
                                            <c:if test="${e.status eq '1'}">
                                                <form action="employee-account-management" method="post">
                                                    <input type="hidden" name="action" value="lock">
                                                    <input type="hidden" name="id" value="${e.id}">
                                                    <input type="hidden" name="page" value="${page==null?1:page}">
                                                    <button type="submit" class="button-close bg-secondary" data-text="Awesome">
                                                        <span class="actual-text-close">&nbsp;Khóa&nbsp;</span>
                                                        <span aria-hidden="true"
                                                              class="hover-text-close">&nbsp;Khóa&nbsp;</span>
                                                    </button>
                                                </form>
                                            </c:if>
                                            <c:if test="${e.status eq '0'}">
                                                <form action="employee-account-management" method="post">
                                                    <input type="hidden" name="action" value="open">
                                                    <input type="hidden" name="id" value="${e.id}">
                                                    <input type="hidden" name="page" value="${page==null?1:page}">
                                                    <button type="submit" class="button-open bg-secondary"
                                                            data-text="Awesome">
                                                        <span class="actual-text-open">&nbsp;Mở khóa&nbsp;</span>
                                                        <span aria-hidden="true"
                                                              class="hover-text-open">&nbsp;Mở khóa&nbsp;</span>
                                                    </button>
                                                </form>
                                            </c:if>
                                        </td>
                                    </tr>


                                </c:forEach>

                                </tbody>
                            </table>
                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                <ul class="pagination">

                                    <c:if test="${page>1}">

                                        <li class="page-item">
                                            <a class="page-link" href="employee-account-management?page=${page-1}"
                                               aria-label="Previous">
                                                <span aria-hidden="true">&laquo;</span>
                                                <span class="sr-only">Previous</span>
                                            </a>
                                        </li>

                                    </c:if>

                                    <c:forEach var="i" begin="${page-1}" end="${page+1}">
                                        <c:if test="${i>=1&&i<=maxPage}">
                                            <li class="page-item"><a class="page-link"
                                                                     href="employee-account-management?page=${i}">${i}</a></li>
                                        </c:if>

                                    </c:forEach>


                                    <c:if test="${page<maxPage}">
                                        <li class="page-item">

                                            <a class="page-link" href="employee-account-management?page=${page+1}"
                                               aria-label="Next">
                                                <span aria-hidden="true">&raquo;</span>
                                                <span class="sr-only">Next</span>
                                            </a>
                                        </li>
                                    </c:if>

                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="include/footer-dashboard.jsp" %>

