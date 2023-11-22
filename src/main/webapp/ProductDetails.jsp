<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL-G3
  Date: 10/2/2023
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include/product/product-Header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<title>Vape Shop - Product Details</title>

<!-- Open Content -->
<section class="bg-light">
    <div class="container pb-5">
        <div class="row">
            <div class="col-lg-5 mt-5">
                <div class="card mb-3">
                    <img class="card-img img-fluid" src="${product.productTypes.get(0).imageProducts.get(0).imageUrl}"
                         alt="Card image cap" id="product-detail">
                </div>
                <div class="row">
                    <!--Start Controls-->
                    <div class="col-1 align-self-center">
                        <a href="#multi-item-example" role="button" data-bs-slide="prev">
                            <i class="text-dark fas fa-chevron-left"></i>
                            <span class="sr-only">Quay Lại</span>
                        </a>
                    </div>
                    <!--End Controls-->
                    <!--Start Carousel Wrapper-->
                    <div id="multi-item-example" class="col-10 carousel slide carousel-multi-item"
                         data-bs-ride="carousel">
                        <!--Start Slides-->
                        <div class="carousel-inner product-links-wap" role="listbox">

                            <!--First slide-->
                            <div class="carousel-item active">
                                <div class="row">
                                    <c:forEach items="${product.productTypes}" var="ip">
                                        <c:forEach items="${ip.imageProducts}" var="img">
                                            <div class="col-4 mb-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${img.imageUrl}"
                                                         alt="Product Image 1">
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </c:forEach>
                                </div>
                            </div>
                            <!--/.First slide-->

                            <!--Second slide-->
                            <div class="carousel-item">
                                <div class="row">
                                    <c:forEach items="${product.productTypes}" var="ip">
                                        <c:forEach items="${ip.imageProducts}" var="img">
                                            <div class="col-4 mb-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${img.imageUrl}"
                                                         alt="Product Image 1">
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </c:forEach>
                                </div>
                            </div>
                            <!--/.Second slide-->

                            <!--Third slide-->
                            <div class="carousel-item">
                                <div class="row">
                                    <c:forEach items="${product.productTypes}" var="ip">
                                        <c:forEach items="${ip.imageProducts}" var="img">
                                            <div class="col-4 mb-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${img.imageUrl}"
                                                         alt="Product Image 1">
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </c:forEach>
                                </div>
                            </div>
                            <!--/.Third slide-->
                        </div>
                        <!--End Slides-->
                    </div>
                    <!--End Carousel Wrapper-->
                    <!--Start Controls-->
                    <div class="col-1 align-self-center">
                        <a href="#multi-item-example" role="button" data-bs-slide="next">
                            <i class="text-dark fas fa-chevron-right"></i>
                            <span class="sr-only">Tiếp Theo</span>
                        </a>
                    </div>
                    <!--End Controls-->
                </div>
            </div>
            <!-- col end -->
            <div class="col-lg-7 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h1 class="h2">${product.productName}</h1>
                        <p class="h3 py-2">
                            <span id="product-price">
                                <fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="${product.productTypes.get(0).typePrice}"/><i class="text-success">VND</i>
                            </span><br>
<%--                            <span id="remaining-quantity"> ${product.productTypes.get(0).realAmount} Cái</span>--%>
                        </p>
                        <p></p>
                        <p class="py-2">
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-secondary"></i>
                            <span class="list-inline-item text-dark">Đánh Giá 4.8 | 36 Bình Luận</span>
                        </p>
                        <ul class="list-inline">
                            <li class="list-inline-item">
                                <h6>Hãng:</h6>
                            </li>
                            <li class="list-inline-item">
                                <p class="text-muted"><strong>${product.brand}</strong></p>
                            </li>
                            <li class="list-inline-item">
                                <h6>Số lượng còn lại:</h6>
                            </li>
                            <li class="list-inline-item">
                                <p class="text-muted" id="remaining-quantity"><strong> ${product.productTypes.get(0).realAmount} Cái</strong></p>
                            </li>
                        </ul>

                        <h6>Chi tiết sản phẩm:</h6>
                        <p>${product.detail}</p>

                        <div action="" method="GET" name="product-card">
                            <input type="hidden" name="product-title" value="Activewear">
                            <div class="row">
                                <div class="col-auto">
                                    <ul class="list-inline pb-3">
                                        <label for="product">Loại:</label>
                                        <select id="product" name="product" onchange="calculatePrice()">
                                            <option value="">Lựa Chọn Loại</option>
                                            <c:forEach items="${product.productTypes}" var="pdt">
                                                <option id="optiontype" value="${pdt.productTypeId}">${pdt.typeName}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <c:forEach items="${product.productTypes}" var="pdt">
                                            <span class="d-none" id="${pdt.productTypeId}"><fmt:formatNumber
                                                    type="number" maxFractionDigits="3"
                                                    value="${pdt.typePrice}"/>-${pdt.realAmount}</span>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="col-auto">
                                    <ul class="list-inline pb-3">
                                        <li class="list-inline-item text-right">
                                            Số Lượng
                                            <input type="hidden" name="product-quanity" id="product-quanity" value="1">
                                        </li>
                                        <li class="list-inline-item"><span class="btn btn-success" id="btn-minus"
                                                                           onclick="decreaseAmountCart()">-</span></li>
                                        <li class="list-inline-item"><span class="badge bg-secondary"
                                                                           id="var-value">1</span></li>
                                        <li class="list-inline-item"><span class="btn btn-success" id="btn-plus"
                                                                           onclick="increaseAmountCart()">+</span></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row pb-3">
                                <div class="col d-grid">
                                    <%--                                    =================================================--%>
                                    <div class="col d-grid">

                                        <form action="additem" method="get">
                                            <input id="typeidcart" type="hidden" name="typeidcart">
                                            <input id="quantity" value="1" type="hidden" name="quantity">
                                            <input id="productId" value="${product.idProduct}" type="hidden"
                                                   name="idProduct">
                                            <input id="brand" value="${product.brand}" type="hidden" name="brand">
                                            <input type="submit" class="btn btn-success btn-lg"
                                                   value="Thêm Vào Giỏ"></input>

                                        </form>
                                    </div>
                                    <c:if test="${message eq '1'}">
                                        <p class="text-danger mt-2">Vui lòng chọn loại sản phẩm</p>
                                    </c:if>
                                </div>
                            </div>
                            <%--                        =================================================--%>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Close Content -->

<!-- Start Article -->
<section class="py-5">
    <div class="container">
        <div class="row text-left p-2 pb-3">
            <h4>Related Products</h4>
        </div>

        <!--Start Carousel Wrapper-->
        <div id="carousel-related-product">
            <c:forEach items="${productTypeArrayList}" var="pta">
                <div class="p-2 pb-3 ">
                    <div class="product-wap card rounded-0 d-lg-flex-flex align-items-lg-centercenter justify-content-lg-center">
                        <div class="card rounded-0">
                            <img class="card-img rounded-0 img-fluid" src="${pta.imageProducts.get(0).imageUrl}">
                            <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                <ul class="list-unstyled">
                                    <li><a class="btn btn-success text-white" href="shop-single.html"><i
                                            class="far fa-heart"></i></a></li>
                                    <li><a class="btn btn-success text-white mt-2"
                                           href="ShowProductDetails?idProduct=${pta.product.idProduct}&brand=${pta.product.brand}"><i
                                            class="far fa-eye"></i></a></li>
                                    <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i
                                            class="fas fa-cart-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="card-body">
                            <div style="white-space: nowrap;width: 100%;overflow: hidden;text-overflow: clip;">
                                <a href="ShowProductDetails?idProduct=${pta.product.idProduct}&brand=${pta.product.brand}"
                                   class="h3 text-decoration-none">${pta.product.productName}</a>
                            </div>
                            <ul class="w-100 list-unstyled d-flex justify-content-between mb-3">
                                <li>${pta.typeName}</li>
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
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                            </ul>
                            <p class="text-center mb-0"><fmt:formatNumber type="number" maxFractionDigits="3"
                                                                          value="${pta.typePrice}"/><i
                                    class="text-success">VND</i></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- End Article -->


<%@include file="include/product/Product-Footer.jsp" %>

<!-- Start Slider Script -->
<script src="assets/js/slick.min.js"></script>
<script>
    $('#carousel-related-product').slick({
        infinite: true,
        arrows: false,
        slidesToShow: 4,
        slidesToScroll: 3,
        dots: true,
        responsive: [{
            breakpoint: 1024,
            settings: {
                slidesToShow: 3,
                slidesToScroll: 3
            }
        },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 3
                }
            }
        ]
    });
</script>
<!-- End Slider Script -->
<script>
    let maxQuantityProduct = 100;
    function calculatePrice() {
        const id = document.getElementById("product").value;
        console.log(id);
        const value = document.getElementById(id).textContent.split("-");
        console.log(value);
        const price = document.getElementById('product-price');
        const remainingQuantity = document.getElementById('remaining-quantity');
        remainingQuantity.setAttribute("class","text-muted")
        const quantityInfo = document.getElementById(id).textContent.split("-");
        remainingQuantity.innerHTML =+ quantityInfo[1] + " Cái";
        price.innerHTML = value[0];
        const priceDetail = document.createElement("i");
        priceDetail.setAttribute('class', 'text-success');
        priceDetail.innerHTML = 'VND';
        price.appendChild(priceDetail);
        document.getElementById("typeidcart").setAttribute("value", id);
        maxQuantityProduct = value[1];
        let orderAmount1 = document.getElementById("var-value");
        let orderAmount2 = document.getElementById("product-quanity");
        let orderAmount3 = document.getElementById("quantity");
        if (value[1] == 0){
            orderAmount1.innerHTML = 0;
            orderAmount2.setAttribute("value",0);
            orderAmount3.setAttribute("value",0);
        }else{
            orderAmount1.innerHTML = 1;
            orderAmount2.setAttribute("value",1);
            orderAmount3.setAttribute("value",1);
        }
    }

    function increaseAmountCart() {
        let amount = document.getElementById("var-value");
        if (parseInt(amount.textContent)<maxQuantityProduct){
            document.getElementById("quantity").setAttribute("value", parseInt(amount.textContent) + 1);
        }else {
            amount.innerHTML = maxQuantityProduct-1;
        }
    }

    function decreaseAmountCart() {

        let amount = document.getElementById("var-value").textContent;
        if (amount != 1) {
            document.getElementById("quantity").setAttribute("value", parseInt(amount) - 1);
        }
    }
</script>
</body>

</html>