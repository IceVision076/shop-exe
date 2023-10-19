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
                        sản phẩm</a>
                    </li>
                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Chi tiết sản phẩm</li>
                </ol>
                <h6 class="font-weight-bolder mb-0">Chi tiết sản phẩm: <u
                        class="font-weight-normal">${product.productName}</u></h6>
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
                            <span class="d-sm-inline d-none">Sign In</span>
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
                        <h6>Bảng loại sản phẩm (Trang ${page}/${maxPage})</h6>
                        <a href="product-type-create?productId=${product.idProduct}"
                           class="fa-solid fa-circle-plus fa-xl d-flex flex-row-reverse" style="color: #d31798;"> <span
                                style="font-family: Courier;font-size: 20px;">Thêm loại sản phẩm mới</span> </a>
                    </div>
                    <div class="card-body px-0 pt-0 pb-2">
                        <div class="table-responsive p-0">
                            <table class="table align-items-center mb-0">
                                <thead>
                                <tr>

                                    <th></th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        Tên loại sản phẩm
                                    </th>

                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                        giá
                                    </th>
                                    <th class="text-secondary opacity-7"></th>
                                    <th class="text-secondary opacity-7"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listProductType}" var="p">

                                    <tr>
                                        <td>
                                            <div>
                                                <img src="${p.imageProducts.get(0).imageUrl}" class="m-2 img-thumbnail "
                                                     style="width: 100px;" alt="user1">
                                            </div>
                                        </td>
                                        <td>
                                            <div class="d-flex px-2 py-1">

                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="mb-0 text-sm">${p.typeName}</h6>
                                                    <p class="text-xs text-secondary mb-0">${p.productTypeId}</p>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <p class="text-xs font-weight-bold mb-0">${p.typePrice}</p>
                                        </td>

                                            <%--                                        Modal thay đổi thông tin--%>
                                        <td class="align-middle">
                                            <!-- Button trigger modal -->
                                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                    data-bs-target="#${p.productTypeId}">
                                                Chỉnh sửa
                                            </button>

                                            <!-- Modal -->
                                            <div class="modal modal-lg fade" id="${p.productTypeId}" tabindex="-1"
                                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h4 class="modal-title">Chỉnh sửa thông tin loại sản
                                                                phẩm ${p.productTypeId}</h4>
                                                            <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close">
                                                                <i class="fa-solid fa-xmark fa-lg" style="color: #f00000;"></i>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body p-2">

                                                            <form class="row g-3 needs-validation p-2" novalidate
                                                                  action="product-type-update" method="post">
                                                                <div class="col-12">
                                                                    <label for="name" class="form-label">Tên sản
                                                                        phẩm</label>
                                                                    <div class="input-group has-validation">
                                                                        <input type="text" class="form-control"
                                                                               id="name" name="name"
                                                                               value="${p.typeName}" required>
                                                                        <div class="invalid-feedback">
                                                                            Tên không được bỏ trống
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-12">
                                                                    <label for="price" class="form-label">Giá sản
                                                                        phẩm</label>
                                                                    <div class="input-group has-validation">
                                                                        <input type="text" class="form-control"
                                                                               id="price" name="price"
                                                                               value="${p.typePrice}" required>
                                                                        <div class="invalid-feedback">
                                                                            Vui lòng điền giá hợp lệ
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-12">
                                                                    <div class="input-group has-validation">
                                                                        <input type="hidden" class="form-control"
                                                                               id="id" name="id"
                                                                               value="${p.productTypeId}" required>
                                                                    </div>
                                                                </div>
                                                                <div class="col-12">
                                                                    <div class="input-group has-validation">
                                                                        <input type="hidden" class="form-control"
                                                                               id="productId" name="productId"
                                                                               value="${product.idProduct}" required>
                                                                    </div>
                                                                </div>
                                                                <div class="col-12">
                                                                    <button class="btn btn-primary" type="submit">Lưu
                                                                    </button>
                                                                </div>
                                                            </form>


                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-danger"
                                                                    data-bs-dismiss="modal">Đóng
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                            <%--                                        Modal thay đổi thông tin--%>

                                        <td><a href="product-import?productTypeId=${p.productTypeId}"
                                               class="btn btn-behance">Nhập hàng</a></td>
                                    </tr>


                                </c:forEach>

                                </tbody>
                            </table>

                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                <ul class="pagination">

                                    <c:if test="${page>1}">

                                        <li class="page-item">
                                            <a class="page-link" href="product-management?page=${page-1}"
                                               aria-label="Previous">
                                                <span aria-hidden="true">&laquo;</span>
                                                <span class="sr-only">Previous</span>
                                            </a>
                                        </li>

                                    </c:if>

                                    <c:forEach var="i" begin="${page-1}" end="${page+1}">
                                        <c:if test="${i>=1&&i<=maxPage}">
                                            <li class="page-item"><a class="page-link"
                                                                     href="product-management?page=${i}">${i}</a></li>
                                        </c:if>

                                    </c:forEach>


                                    <c:if test="${page<maxPage}">
                                        <li class="page-item">

                                            <a class="page-link" href="product-management?page=${page+1}"
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
        <div class="row">
            <div class="col-12">
                <div class="card mb-4">
                    <div class="card-header pb-0">
                        <h6>Chỉnh sửa thông tin sản phẩm</h6>
                        <h6 class="bg-success text-white">${mess}</h6>
                    </div>
                    <div class="p-5">

                        <form action="product-update" method="post" class="row g-3 needs-validation" novalidate>
                            <div class="col-12">
                                <input type="hidden" name="id" value="${product.idProduct}">
                            </div>

                            <div class="col-md-6">
                                <label for="productName" class="form-label">Tên sản phẩm</label>
                                <input type="text" class="form-control" id="productName" name="productName"
                                       value="${product.productName}" required>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                                <div class="invalid-feedback">
                                    You must agree before submitting.
                                </div>
                            </div>

                            <div class="col-md-6">
                                <label for="brand" class="form-label">Nhãn hàng</label>
                                <input type="text" class="form-control" id="brand" name="brand" value="${product.brand}"
                                       required>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                                <div class="invalid-feedback">
                                    You must agree before submitting.
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="origin" class="form-label">Xuất xứ</label>
                                <input type="text" class="form-control" id="origin" name="origin"
                                       value="${product.origin}" required>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                                <div class="invalid-feedback">
                                    You must agree before submitting.
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="status" class="form-label">Trạng thái</label>
                                <select class="form-select" name="status" id="status">
                                    <option value="1">Đang bán</option>
                                    <option value="0">Dừng bán</option>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <label for="detail" class="form-label">Mô tả sản phẩm</label>
                                <textarea cols="30" rows="10" class="form-control" id="detail" name="detail"
                                          required>${product.detail}</textarea>

                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                                <div class="invalid-feedback">
                                    You must agree before submitting.
                                </div>
                            </div>

                            <div class="col-12">
                                <button class="btn btn-primary" type="submit">Lưu thông tin sản phẩm</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="include/footer-dashboard.jsp" %>>


        <%--Default select input--%>

        <script>

            const select = document.querySelector("select");
            const option = select.querySelector("option[value='${product.status+""}']");

            option.setAttribute("selected", true);
        </script>
