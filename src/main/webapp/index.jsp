<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="include/header-footer/header.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "en_US"/>



<!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>



    <!-- Start Banner Hero -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators" hidden="hidden">
            <c:forEach items="${posterList}" var="imageUrl" varStatus="status">
                <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="${status.index}" class="${status.index == 0 ? 'active' : ''}"></li>
            </c:forEach>
        </ol>
        <div class="carousel-inner">
            <c:forEach items="${posterList}" var="imageUrl" varStatus="status">
            <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                <img class="banner-img img-fluid" src="${imageUrl.imgUrl}" alt="">
            </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
            </c:forEach>
    </div>
    <!-- End Banner Hero -->


    <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Sản Phẩm Của Tháng</h1>
                <p>
                    Sản phẩm được khánh hàng lựa chọn và đánh giá cao về chất lượng sử dụng.
                </p>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${posterListTop}" var="plt">
                <div class="product-month col-12 col-md-4 p-5 mt-3 d-flex flex-column align-items-center">
                    <a href="ProductServlet"><img src="${plt.imgUrl}" class="rounded-circle img-fluid"></a>
                    <h5 class="text-center mt-3 mb-3">vapes and essential oils</h5>
                    <p class="text-center"><a class="btn btn-success" href="ProductServlet">Go Shop</a></p>
                </div>
            </c:forEach>
        </div>
    </section>
    <!-- End Categories of The Month -->


    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Sản Phẩm Nổi Trội</h1>
                    <p>
                        Dòng sản phẩm nổi trội với thiết kế đẹp và chất lượng tiêu chuẩn cao.
                    </p>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${ProductTopList}" var="ptl">
                    <div class="col-12 col-md-4 mb-4">
                        <div class="card h-100">
                            <a href="ShowProductDetails?idProduct=${ptl.product.idProduct}&brand=${ptl.product.brand}">
                                <img src="${ptl.imageProducts.get(0).imageUrl}" class="card-img-top" alt="...">
                            </a>
                            <div class="card-body">
                                <ul class="list-unstyled d-flex justify-content-between">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                    </li>
                                    <li class="text-muted text-right"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${ptl.typePrice}" /><i class="text-success">VND</i></li>
                                </ul>
                                <a href="shop-single.html" class="h2 text-decoration-none text-dark">${ptl.product.productName}</a>
                                    <p class="card-text ">${ptl.product.brand}</p>
                                    <p class="card-text ">${ptl.product.origin}</p>
                                <p class="text-muted">Reviews (74)</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <!-- End Featured Product -->
    <%@include file="include/header-footer/footer.jsp"%>
        <script>
            $(document).ready(function() {
                $('#template-mo-zay-hero-carousel').carousel();
            });
        </script>