<%--
  Created by IntelliJ IDEA.
  User: DELL-G3
  Date: 10/30/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/product/product-Header.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- Start Content -->
<div class="container py-5">
    <div class="row">

        <div class="col-lg-3">
            <h1 class="h2 pb-4">Your Choice</h1>
            <ul class="list-unstyled templatemo-accordion">
                <li class="pb-3">
                    <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                        Category
                        <i class="fa fa-fw fa-chevron-circle-down mt-1"></i>
                    </a>
                    <ul class="collapse show list-unstyled pl-3">
                        <c:forEach items="${listBrand}" var="listbrand">
                            <li><a class="text-decoration-none" href="ProductServlet?filterProduct=${listbrand.product.brand}">${listbrand.product.brand}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="pb-3">
                    <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                        Price
                        <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                    </a>
                    <ul id="collapseTwo" class="collapse list-unstyled pl-3">
                        <li><a class="text-decoration-none" href="ProductServlet?filterProduct=rangePrice&priceFrom=0&priceTo=100000">Less than <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "100000" /><i class="text-success">VND</i></a></li>
                        <li><a class="text-decoration-none" href="ProductServlet?filterProduct=rangePrice&priceFrom=100000&priceTo=200000"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "100000" /> - <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "200000" /><i class="text-success">VND</i></a></li>
                        <li><a class="text-decoration-none" href="ProductServlet?filterProduct=rangePrice&priceFrom=200000&priceTo=500000"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "200000" /> - <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "500000" /><i class="text-success">VND</i></a></li>
                        <li><a class="text-decoration-none" href="ProductServlet?filterProduct=rangePrice&priceFrom=500000&priceTo=10000000">More than <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "500000" /><i class="text-success">VND</i></a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <div class="col-lg-9">
            <div class="row">
                <div class="col-md-6 pb-4">
                    <div class="d-flex">
                        <select class="form-control" id="filterProduct" onchange="sendRequest()">
                            <option>Featured</option>
                            <option  value="sortAlphabet">A to Z</option>
                            <option  value="priceDecrease">High -> Low</option>
                            <option  value="priceIncrease">Low -> High</option>
                        </select>
                    </div>
                </div>
            </div>
            <%--      Product--%>
            <div class="row">
                <c:forEach items="${productSearchList}" var="psl">
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="${psl.imageProducts.get(0).imageUrl}" >
                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <li><a class="btn btn-success text-white" href="shop-single.html"><i class="far fa-heart"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="ShowProductDetails?idProduct=${psl.product.idProduct}&brand=${psl.product.brand}"><i class="far fa-eye"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="fas fa-cart-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                <a href="ShowProductDetails?idProduct=${psl.product.idProduct}&brand=${psl.product.brand}" class="h3 text-decoration-none">${psl.product.productName}</a>
                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                    <li>${psl.typeName}</li>
                                    <li class="pt-2">
                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                    </li>
                                </ul>
                                <ul class="list-unstyled d-flex justify-content-center mb-1">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                    </li>
                                </ul>
                                <p class="text-center mb-0"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${psl.typePrice}" /><i class="text-success">VND</i></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <%--      End Product--%>

            <div div="row">
                <ul class="pagination pagination-lg justify-content-end " >
                    <c:if test="${tag>1}">
                        <li class="page-item ">
                            <a class="page-link rounded-0 mr-3 shadow-sm  text-dark" href="${urlSearch}index=${tag-1}" tabindex="-1"><i class="text-dark fas fa-chevron-left"></i></a>
                        </li>
                    </c:if>
                    <c:if test="${endPage >3}">
                        <c:set var="beginIndex" value="${tag - 1}" />
                        <c:set var="endIndex" value="${tag + 1}" />
                        <c:if test="${beginIndex < 1}">
                            <c:set var="beginIndex" value="1" />
                        </c:if>
                        <c:if test="${endIndex > endPage}">
                            <c:set var="endIndex" value="${endPage}" />
                        </c:if>
                        <c:forEach begin="${beginIndex}" end="${endIndex}" var="i" step="1">
                            <li class="page-item">
                                <a class="page-link rounded-0 mr-3 shadow-sm  text-dark  ${tag == i?"active":""}" href="${urlSearch}index=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${tag<endPage}">
                        <li class="page-item">
                            <a class="page-link rounded-0 shadow-sm  text-dark" href="${urlSearch}index=${tag+1}"><i class="text-dark fas fa-chevron-right"></i></a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>

    </div>
</div>
<!-- End Content -->

<!-- Start Brands -->
<section class="bg-light py-5">
    <div class="container my-4">
        <div class="row text-center py-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Our Brands</h1>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    Lorem ipsum dolor sit amet.
                </p>
            </div>
            <div class="col-lg-9 m-auto tempaltemo-carousel">
                <div class="row d-flex flex-row">
                    <!--Controls-->
                    <div class="col-1 align-self-center">
                        <a class="h1" href="#multi-item-example" role="button" data-bs-slide="prev">
                            <i class="text-light fas fa-chevron-left"></i>
                        </a>
                    </div>
                    <!--End Controls-->

                    <!--Carousel Wrapper-->
                    <div class="col">
                        <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="multi-item-example" data-bs-ride="carousel">
                            <!--Slides-->
                            <div class="carousel-inner product-links-wap" role="listbox">

                                <!--First slide-->
                                <div class="carousel-item active">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End First slide-->

                                <!--Second slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End Second slide-->

                                <!--Third slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                        </div>
                                        <div class="col-3 p-md-5">
                                            <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                        </div>
                                    </div>
                                </div>
                                <!--End Third slide-->

                            </div>
                            <!--End Slides-->
                        </div>
                    </div>
                    <!--End Carousel Wrapper-->

                    <!--Controls-->
                    <div class="col-1 align-self-center">
                        <a class="h1" href="#multi-item-example" role="button" data-bs-slide="next">
                            <i class="text-light fas fa-chevron-right"></i>
                        </a>
                    </div>
                    <!--End Controls-->
                </div>
            </div>
        </div>
    </div>
</section>
<!--End Brands-->
<%@include file="include/product/Product-Footer.jsp"%>
<script>
    function sendRequest() {
// Get the value of the option.
        const filterProduct = document.getElementById("filterProduct").value;

// Create a new request with the necessary values.

        location.replace("ProductServlet?filterProduct=" + filterProduct)
// Send the request to the servlet.
    }
</script>