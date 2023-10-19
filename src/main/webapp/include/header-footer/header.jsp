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
    <title>Zay Shop eCommerce HTML CSS Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

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
<nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0">
    <a href="index.jsp" class="navbar-brand ms-lg-5">
        <h1 class="navbar-brand text-success logo h1 align-self-center"><i class="bi bi-shop fs-1 text-primary me-3"></i>VapeShop</h1>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse d-flex justify-content-end " id="navbarCollapse">
        <div class="navbar-nav ms-auto py-0 d-flex ">
            <a href="index.jsp" class="nav-item nav-link active">Home</a>
            <a href="about.jsp" class="nav-item nav-link">About</a>
            <a href="service.jsp" class="nav-item nav-link">Service</a>
            <a href="ProductServlet" class="nav-item nav-link">Product</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                <div class="dropdown-menu m-0">
                    <a href="testmonial.jsp" class="dropdown-item">Testimonial</a>
                    <a href="blog.jsp" class="dropdown-item">Blog Grid</a>
                    <a href="detail.jsp" class="dropdown-item">Blog Detail</a>
                </div>
            </div>
            <c:if test="${sessionScope.user==null}">
                <a href="login.jsp" class="nav-item nav-link nav-contact bg-success text-white px-5 ms-lg-5">Log in <i class="bi bi-arrow-right"></i></a>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle bg-primary text-white px-5 ms-lg-5" data-bs-toggle="dropdown">${sessionScope.user.userName}</a>
                    <div class="dropdown-menu m-0">
                        <a href="update-profile" class="dropdown-item">Thông tin cá nhân</a>
<%--                        <c:if test="${sessionScope.user.userRole.equals('admin')}">--%>
<%--                            <a href="admin.jsp" class="dropdown-item">Admin</a>--%>
<%--                        </c:if>--%>

                        <a href="cart.jsp" class="dropdown-item">Your cart</a>
                        <a href="getorderhistory" class="dropdown-item">History order</a>
                        <a href="logout" class="dropdown-item text-danger">Log out</a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</nav>
<!-- Close Header -->

