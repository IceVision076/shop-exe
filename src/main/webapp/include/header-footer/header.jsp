<%--
  Created by IntelliJ IDEA.
  User: HUNTER
  Date: 10/11/2023
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>vapeShop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
    <link rel="stylesheet" href="assets/css/custom.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    <!--

    TemplateMo 559 Zay Shop

    https://templatemo.com/tm-559-zay-shop

    -->
</head>

<body>
<!-- Start Top Nav -->
<nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
    <div class="container text-light">
        <div class="w-100 d-flex justify-content-end">
            <div>
                <i class="fa fa-envelope mx-2"></i>
                <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                <i class="fa fa-phone mx-2"></i>
                <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
            </div>
            <div>
                <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i
                        class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                <a class="text-light" href="https://www.instagram.com/" target="_blank"><i
                        class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                <a class="text-light" href="https://twitter.com/" target="_blank"><i
                        class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i
                        class="fab fa-linkedin fa-sm fa-fw"></i></a>

            </div>
        </div>
    </div>
</nav>
<!-- Close Top Nav -->

<!-- Header -->
<!-- Navbar Start -->
<nav class="navbar navbar-expand-lg navbar-light shadow">
    <div class="container d-flex justify-content-between align-items-center">

        <a class="navbar-brand text-success logo h1 align-self-center" href="Home" style="text-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
            VapeShop
        </a>

        <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
            <div class="flex-fill ms-5">
                <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="Home">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html">Thông Tin Cửa Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ProductServlet">Của Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="service-tracking-sender">Dịch Vụ</a>
                    </li>
                    <li>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Blog</a>
                            <div class="dropdown-menu m-0">
                                <a href="testmonial.jsp" class="dropdown-item">Chứng Thực</a>
                                <a href="blog.jsp" class="dropdown-item">Bài Viết</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <c:if test="${sessionScope.user==null}">
                <a href="login.jsp" class="nav-item nav-link nav-contact bg-success text-white px-5 ms-lg-5">Đăng Nhập <i class="bi bi-arrow-right"></i></a>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <div class="nav-item dropdown">
<%--                    <a href="#" class="nav-link dropdown-toggle bg-primary text-white pe-5 ms-lg-5 justify-content-center" data-bs-toggle="dropdown">${sessionScope.user.userName}</a>--%>
                                        <a class="nav-link dropdown-toggle position-relative text-decoration-none" data-bs-toggle="dropdown" href="#">
                                                <img src="${sessionScope.user.avatarImg}" alt=""
                                                     style="width: 50px;
                                                     height: 50px;
                                                     border-radius: 50%;
                                                     object-fit: cover;">
                                        </a>
                    <div class="dropdown-menu m-0">
                        <a href="update-profile" class="dropdown-item">Thông tin cá nhân</a>
                            <%--                        <c:if test="${sessionScope.user.userRole.equals('admin')}">--%>
                            <%--                            <a href="admin.jsp" class="dropdown-item">Admin</a>--%>
                            <%--                        </c:if>--%>

                        <a href="cart.jsp" class="dropdown-item">Giỏ Hàng</a>
                        <a href="getorderhistory" class="dropdown-item">Lịch sử đặt hàng</a>
                        <a href="logout" class="dropdown-item text-danger">Đăng Xuất</a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</nav>
<!-- Close Header -->



