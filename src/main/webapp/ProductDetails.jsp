<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL-G3
  Date: 10/2/2023
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include/product/product-Header.jsp"%>
<title>Vape Shop - Product Details</title>

<!-- Open Content -->
<section class="bg-light">
    <div class="container pb-5">
        <div class="row">
            <div class="col-lg-5 mt-5">
                    <div class="card mb-3">
                        <img class="card-img img-fluid" src="${product.imgURL}" alt="Card image cap" id="product-detail">
                    </div>
                <div class="row">
                    <!--Start Controls-->
                    <div class="col-1 align-self-center">
                        <a href="#multi-item-example" role="button" data-bs-slide="prev">
                            <i class="text-dark fas fa-chevron-left"></i>
                            <span class="sr-only">Previous</span>
                        </a>
                    </div>
                    <!--End Controls-->
                    <!--Start Carousel Wrapper-->
                    <div id="multi-item-example" class="col-10 carousel slide carousel-multi-item" data-bs-ride="carousel">
                        <!--Start Slides-->
                        <div class="carousel-inner product-links-wap" role="listbox">

                            <!--First slide-->
                            <div class="carousel-item active">
                                <div class="row">
                                        <c:forEach items="${imageProducts}" var="ip">
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${ip.imgURL}" alt="Product Image 1">
                                                </a>
                                            </div>
                                        </c:forEach>
                                </div>
                            </div>
                            <!--/.First slide-->

                            <!--Second slide-->
                            <div class="carousel-item">
                                <div class="row">
                                    <c:forEach items="${imageProducts}" var="ip">
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${ip.imgURL}" alt="Product Image 1">
                                            </a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!--/.Second slide-->

                            <!--Third slide-->
                            <div class="carousel-item">
                                <div class="row">
                                    <c:forEach items="${imageProducts}" var="ip">
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${ip.imgURL}" alt="Product Image 1">
                                            </a>
                                        </div>
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
                            <span class="sr-only">Next</span>
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
                        <p class="h3 py-2" id="product-price">${product.price}<i class="text-warning">VND</i></p>
                        <p class="py-2">
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-warning"></i>
                            <i class="fa fa-star text-secondary"></i>
                            <span class="list-inline-item text-dark">Rating 4.8 | 36 Comments</span>
                        </p>
                        <ul class="list-inline">
                            <li class="list-inline-item">
                                <h6>Brand:</h6>
                            </li>
                            <li class="list-inline-item">
                                <p class="text-muted"><strong>${product.brand}</strong></p>
                            </li>
                        </ul>

                        <h6>Description:</h6>
                        <p>${product.detail}</p>

                        <form action="" method="GET" name="product-card">
                            <input type="hidden" name="product-title" value="Activewear">
                            <div class="row">
                                <div class="col-auto">
                                    <ul class="list-inline pb-3">
                                            <label for="product">Type:</label>
                                            <select id="product" name="product" onchange="calculatePrice()">
                                                <option value="">Select a type</option>
                                                <c:forEach items="${productTypes}" var="pdt">
                                                    <option id="optiontype" value="${pdt.id}">${pdt.name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        <c:forEach items="${productTypes}" var="pdt">
                                                <span class="d-none" id="${pdt.id}">${pdt.price}</span>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="col-auto">
                                    <ul class="list-inline pb-3">
                                        <li class="list-inline-item text-right">
                                            Quantity
                                            <input type="hidden" name="product-quanity" id="product-quanity" value="1">
                                        </li>
                                        <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                        <li class="list-inline-item"><span class="badge bg-secondary" id="var-value">1</span></li>
                                        <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row pb-3">
                                <div class="col d-grid">
                                    <button type="submit" class="btn btn-success btn-lg" name="submit" value="buy">Buy</button>
                                </div>
                                <div class="col d-grid">
                                    <button type="submit" class="btn btn-success btn-lg" name="submit" value="addtocard">Add To Cart</button>
                                </div>
                            </div>
                        </form>

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
            <c:forEach items="${productList}" var="pl">
                <div class="p-2 pb-3">
                    <div class="product-wap card rounded-0">
                        <div class="card rounded-0">
                            <img class="card-img rounded-0 img-fluid" src="${pl.imgURL}">
                            <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                <ul class="list-unstyled">
                                    <li><a class="btn btn-success text-white" href="shop-single.html"><i class="far fa-heart"></i></a></li>
                                    <li><a class="btn btn-success text-white mt-2" href="ShowProductDetails?idProduct=${pl.idProduct}"><i class="far fa-eye"></i></a></li>
                                    <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="fas fa-cart-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="card-body">
                            <a href="ShowProductDetails?idProduct=${pl.idProduct}" class="h3 text-decoration-none">${pl.productName}</a>
                            <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                <li>${pl.typeName}</li>
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
                            <p class="text-center mb-0">${pl.price}<i class="text-warning">VND</i></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>


    </div>
</section>
<!-- End Article -->


<%@include file="include/product/Product-Footer.jsp"%>

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
    function calculatePrice() {
        const id = document.getElementById("product").value;
        console.log(id);
        const value = document.getElementById(id).textContent;
        console.log(value);
        const price = document.getElementById('product-price');
        price.innerHTML=value;
    }
</script>
</body>

</html>