<%@include file="include/header-footer/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
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
  <ol class="carousel-indicators">
    <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
    <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
    <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
  </ol>
  <style>
    .carousel-item {
      background-color: black;
    }
  </style>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="container">
        <div class="row p-2">
          <div class="col-md-12 mb-0 d-flex align-items-center"
               style="background-size: cover; margin-top: 3%">
            <img class="img-fluid"
                 src="https://lh3.googleusercontent.com/pw/AP1GczNx1D9D4Agrf3U24UHJ1iSF7VwtErRDj3dVKZEfeDYCHh7ijYKw0_Bgh0vsVr3HFNjyXCMbgUZ2MaWVVxQsFfrqc2Wn1H_0C_pfpgiwjsCh4TLP7y5hj_QgrKFTT3Wq7QrBLW-UgVzVrZNjG9wLomh7=w1906-h953-s-no-gm?authuser=1"
                 alt="">
          </div>
        </div>
      </div>
    </div>
    <div class="carousel-item">
      <div class="container">
        <div class="row p-2">
          <div class="col-md-12 mb-0 d-flex align-items-center"
               style="background-size: cover; margin-top: 3%">
            <img class="img-fluid"
                 src="https://lh3.googleusercontent.com/pw/AP1GczPGwKb_1VwB7kOK_M59dP7Z02sAOR3F1NdPgk5VEN5TCAe7sLi6U6YhN1_uX2b0BehSOJOXAlZLYKSQilIx5z1q6ttm_ga4VPlR29QV1r5sZ7LRZ2YgZp4YBG1TYNcL8GHrzbxESUkdfj8vNIqOVn_G=w1906-h953-s-no-gm?authuser=1"
                 alt="">
          </div>
        </div>
      </div>
    </div>
    <div class="carousel-item">
      <div class="container">
        <div class="row p-2">
          <div class="col-md-12 mb-0 d-flex align-items-center"
               style="background-size: cover; margin-top: 3%">
            <img class="img-fluid"
                 src="https://lh3.googleusercontent.com/pw/AP1GczNRQNxcOwb0izd_IW2P2tXtBOAptdQ7ZExKS_tOzrrEFlR55Kp7GARe-oU-7rVkAsdjK3_WUozOVTlSIemgr8F01OQHVovqU57wv_fwYktcXSh99X-0csQWEDv80tVQaq6zy2mdQCALQEaDXEq5O_xo=w1906-h953-s-no-gm?authuser=1"
                 alt="">
          </div>
        </div>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel"
     role="button" data-bs-slide="prev">
    <i class="fas fa-chevron-left"></i>
  </a>
  <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel"
     role="button" data-bs-slide="next">
    <i class="fas fa-chevron-right"></i>
  </a>
</div>
<!-- End Banner Hero -->


<section id="about-us">
  <div class="container col-md-12">
    <div class="row align-items-center justify-content-between g-5 mt-4"
         style="background-color: #F6F5F2; border-radius: 15px">
      <div class="col-lg-6">
        <div class="image-holder mb-4 jarallax">
          <img src="https://domingocoffee.com.vn/wp-content/uploads/2021/10/setup-quan-cafe-1.jpg"
               style="border-radius: 10px 3px 3px 10px"
               alt="single" class="img-fluid jarallax-img">
        </div>
      </div>
      <div class="col-lg-6">
        <div class="detail p-5">
          <div class="display-header">
            <h2 class="display-2 text-uppercase text-dark pb-2" style="font-family: Algerian">"SOU-COFFEE"</h2>
            <p class="pb-3"> Giới Thiệu <span style="font-family: Algerian">SOU-COFFEE</span> - Nơi Đam Mê
              Gặp Gỡ và Khám Phá.</p>
            <p>Chào mừng bạn đến với <span style="font-family: Algerian">"SOU-COFFEE"</span> - Nơi đẳng cấp
              cho những người yêu thích và tìm kiếm trải nghiệm vape tuyệt vời.</p>
            <p>"Sou Coffee" không chỉ là nơi bạn thưởng thức những tách cà phê tinh tế, mà còn là điểm dừng chân lý tưởng để tìm cho mình những món quà ý nghĩa, độc đáo và mới lạ.
                Chúng tôi tự hào là địa chỉ tin cậy cho những ai muốn tặng những món quà mang ý nghĩa và tình cảm trong những dịp đặc biệt.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>




<!-- Start Categories of The Month -->
<%--<section class="container py-5">--%>
<%--  <div class="row text-center pt-3 ">--%>
<%--    <div class="col-lg-6 m-auto">--%>
<%--      <h1 class="h1" style="font-family: Bahnschrift">Những founder và co-founder của Vapeshop</h1>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--  <div class="row">--%>
<%--    <div class="col-12 col-md-4 p-5 mt-3">--%>
<%--      <a href="#"><img src="https://vn.smissvape.com/uploads/202235368/magnetic-e-pod34088252001.jpg"--%>
<%--                       class="rounded-circle img-fluid border"></a>--%>
<%--      <h5 class="text-center mt-3 mb-3"></h5>--%>
<%--    </div>--%>
<%--    <div class="col-12 col-md-4 p-5 mt-3 ">--%>
<%--      <a href="#"><img--%>
<%--              src="https://vn.newecigarettes.com/uploads/202125334/4500-puffs-electronic-e-cigarette02373276289.jpg"--%>
<%--              class="rounded-circle img-fluid border"></a>--%>
<%--      <h2 class="h5 text-center mt-3 mb-3"></h2>--%>
<%--    </div>--%>
<%--    <div class="col-12 col-md-4 p-5 mt-3">--%>
<%--      <a href="#"><img--%>
<%--              src="https://www.vapewholesaleglobal.com/cdn/shop/products/Geekvape-T200-Aegis-Touch-Box-Mod-kit-6-111166_1024x.jpg?v=1662610441"--%>
<%--              class="rounded-circle img-fluid border"></a>--%>
<%--      <h2 class="h5 text-center mt-3 mb-3"></h2>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</section>--%>

<!-- End Categories of The Month -->


<!-- Start Featured Product -->
<!-- End Featured Product -->
<%@include file="include/header-footer/footer.jsp" %>
