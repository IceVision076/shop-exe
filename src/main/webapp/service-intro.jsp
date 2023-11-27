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
        .carousel-item{
            background-color: black;
        }
    </style>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <div class="container">
                <div class="row p-2">
                    <div class="col-md-12 mb-0 d-flex align-items-center" style="background-size: cover; margin-top: 3%">
                        <img class="img-fluid" src="https://cdn6.f-cdn.com/contestentries/1470823/17506344/5c5b224753e39_thumb900.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <div class="container">
                <div class="row p-2">
                    <div class="col-md-12 mb-0 d-flex align-items-center" style="background-size: cover; margin-top: 3%">
                        <img class="img-fluid" src="https://cdn2.f-cdn.com/contestentries/1470823/19271572/5c5da29b97a9c_thumb900.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <div class="container">
                <div class="row p-2">
                    <div class="col-md-12 mb-0 d-flex align-items-center" style="background-size: cover; margin-top: 3%">
                        <img class="img-fluid" src="https://cdn3.f-cdn.com/contestentries/1470823/19271572/5c5d9fa53719e_thumb900.jpg" alt="">
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
        <div class="row align-items-center justify-content-between g-5 mt-4" style="background-color: #F6F5F2; border-radius: 15px">
            <div class="col-lg-6">
                <div class="image-holder mb-4 jarallax">
                    <img src="https://turtlegrass.net/wp-content/uploads/2023/04/top-10-shop-thuoc-la-dien-tu-chinh-hang-uy-tin-nhat-Viet-Nam.jpg" style="border-radius: 10px 3px 3px 10px"
                         alt="single" class="img-fluid jarallax-img">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="detail p-5">
                    <div class="display-header">
                        <h2 class="display-2 text-uppercase text-dark pb-2" style="font-family: Algerian">"Vape shop"</h2>
                        <p class="pb-3"> Giới Thiệu <span style="font-family: Algerian">Vape Shop</span> - Nơi Đam Mê Gặp Gỡ và Khám Phá.</p>
                        <p>Chào mừng bạn đến với  <span style="font-family: Algerian">"Vape Shop"</span>  - nơi đẳng cấp cho những người yêu thích và tìm kiếm trải nghiệm vape tuyệt vời.</p>
                        <p>Chúng tôi tự hào là địa chỉ lý tưởng cho cộng đồng vape, nơi mà đam mê hội tụ và sự sáng tạo bùng nổ.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<style>
    body {
        vertical-align: baseline;
    }
    :focus {
        outline: 0;
        line-height: 1;
        color: black;
        background: white;
    }
    main, article, section, aside, hgroup, nav, header, footer, figure, figcaption {
        display: block;
    }

    /* ============ *\
       GENERAL TAGS
    \* ============ */

    * {
        box-sizing: border-box;
    }
    p {
        padding: 5px 0;
        font-family: 'Roboto', sans-serif;

    }

    h1,
    h2,
    h3 {
        font-family: 'Open Sans Condensed', sans-serif;
    }

    h1,
    h2 {
        font-size: 60px;
        line-height: 60px;
        letter-spacing: 0.5px;
        text-transform: uppercase;
        font-weight: bold;
    }

    h3 {
        font-size:30px;
        line-height: 30px;
        padding-top: 5px;
        text-transform: uppercase;
        left: 0.75px;
    }

    ::selection {
        background: #000000;
        color: #ffffff;
    }

    ::-moz-selection {
        background: #000000;
        color: #ffffff;
    }

    sub, sup {
        font-size: 75%;
        line-height: 0;
        position: relative;
        vertical-align: baseline;
    }

    /* ============ *\
       STRUCTURE
    \* ============ */

    .item1 { grid-area: product; }
    .item2 { grid-area: cloud; }
    .item3 { grid-area: sephiroth; }
    .item4 { grid-area: tifa; }
    .item5 { grid-area: playstation; }
    .item6 { grid-area: squareenix; }
    .item7 { grid-area: aerith; }
    .item8 { grid-area: barret; }

    .info-product {
        max-width: 1750px;
        margin: 50px auto;
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        grid-template-rows: repeat(4, 1fr);
        grid-template-areas:
	"product product cloud cloud"
	"product product sephiroth sephiroth"
	"tifa tifa playstation barret"
	"squareenix aerith aerith barret";
    }

    .info-product > div {
        display: grid;
        min-height: 440px;
        align-items: center;
        transition: all .3s ease-in-out;
        -webkit-transition: all .3s ease-in-out;
        -ms-transition: all .3s ease-in-out;
    }

    /* PRODUCT */
    .item1 {
        position: relative;
        background: url('https://toantuoitho.vn/wp-content/uploads/2022/12/tinh-dau-vape-ni-cao.jpg') center center/cover no-repeat #000000;
        color: #FFFFFF;
        text-shadow: 0 2px 2px rgba(0,0,0,0.50);
    }

    .item1 div {
        max-width: 45%;
        justify-self: center;
        text-align: center;
        color: #ffffff;
    }

    .item1 .copy {
        max-width: 80%;
    }

    /* CLOUD */
    .item2 {
        position: relative;
        background-image: url('https://vapemaxcloud.com/wp-content/uploads/2021/11/cach-hut-vape-3.jpg');
        background-size: cover;
        color: #3D3D3D;
    }

    .item2 div {
        width: 60%;
        padding: 5%;
    }

    .item2 div h2 {
        color: #000000;
    }

    .item2 div h3 {
        color: #14AF95;
    }

    .item2 div img {
        display: block;
        position: absolute;
        bottom: 0px;
        right: 2%;
        width: 40%;
    }

    /* SEPHIROTH */
    .item3 {
        position: relative;
        background-image: url("https://png.pngtree.com/thumb_back/fw800/background/20230713/pngtree-3d-rendering-of-vape-in-red-background-with-electronic-cigarette-image_3866511.jpg");
        background-size: cover;
        color: #CCCCCC;
        text-shadow: 0 2px 2px rgba(0,0,0,0.50);
    }

    .item3 div {
        width: 100%;
        padding: 5% 5% 20%;
    }

    .item3 div h2 {
        color: #ffffff;
    }

    .item3 div img {
        display: block;
        position: absolute;
        bottom: 0px;
        left: 0;
        width: 30%;
    }

    /* TIFA */
    .item4 {
        position: relative;
        background-image: url("https://www.shutterstock.com/image-photo/vaping-accessories-close-shot-260nw-515488939.jpg");
        background-size: cover;
        color: #000000;
    }

    .item4 div {
        width: 100%;
        padding:0% 5% 5% 5%;
    }

    .item4 div h2 {
        color: #000000;
    }

    .item4 div h3 {
        color: #ffffff;
    }

    .item4 div img {
        display: block;
        position: absolute;
        bottom: 0px;
        left: 0;
        width: 40%;
    }

    /* PLAYSTATION */
    .item5 {
        position: relative;
        background: black ;
        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#02a9d9', endColorstr='#024992',GradientType=1 );
        color: #FFFFFF;
        text-align: center;
    }

    .item5 img {
        margin-bottom: 5px;
    }

    /* SQUARE ENIX */
    .item6 {
        background-image: linear-gradient(0deg, #D8D8D8 0%, #FFFFFF 100%);
        text-align: center;
    }

    .item6 img {
        width: 80%;
    }

    /* AERITH */
    .item7 {
        position: relative;
        background-image: linear-gradient(135deg, #220202 0%, #452929 100%);
        color: #FFFFFF;
    }

    .item7 div {
        width: 100%;
        padding: 5% 6% 5% 45%;
    }

    .item7 div h2 {
        color: #FFFFFF;
    }

    .item7 div h3 {
        color: #A52639;
    }

    .item7 div img {
        display: block;
        position: absolute;
        bottom: 0px;
        left: 2%;
        width: 38%;
    }

    /* BARRET */
    .container .item8 {
        align-items: start;
    }

    .item8 {
        position: relative;
        background-image: url("https://img4.thuthuatphanmem.vn/uploads/2021/06/04/hinh-khoi-vape-da-dang-sac-thai_022736570.jpg");
        background-size: cover;
        color: #3D3D3D;
    }

    .item8 div {
        padding: 16% 10% 10% 10%;
    }

    .item8 div h2 {
        color: #000000;
    }

    .item8 div h3 {
        color: #454417;
    }

    .item8 div img {
        display: block;
        position: absolute;
        bottom: 0px;
        left: 0%;
        width: 90%;
    }
</style>
<div class="container info-product">

    <!-- PRODUCT -->
    <div class="item1">
        <div class="copy">
            <h1>Vapeshop</h1>
            <br>
            <h4>Sứ Mệnh của Chúng Tôi</h4>
            <br>
            <h5><i style="font-family: 'Bahnschrift'; font-size: x-large">Tại Vape Shop, chúng tôi không chỉ là một cửa hàng bán vape thông thường mà còn là không gian
                tôn vinh nghệ thuật và sự đa dạng trong thế giới Vape</i></h5>
        </div>
    </div>

    <!-- CLOUD -->
    <div class="item2">
        <div>
            <h2 style="color: white"><span style="color: lightcoral; font-size: 80px">Cloud</span>
                Heaven</h2>
            <b style="color: white"><i>Sứ mệnh của chúng tôi là mang đến cho khách hàng không chỉ là sản phẩm chất lượng mà còn là trải nghiệm đặc biệt,
                kết nối cộng đồng và khám phá những hương vị mới lạ.</i></b>
        </div>
    </div>

    <!-- SEPHIROTH -->
    <div class="item3">
        <div>
            <h2 style="color: #00CC33">Sản phẩm đa dạng và chất lượng</h2>
            <br>
            <h5><b style="color: white"><i>Chúng tôi tự hào cung cấp một bộ sưu tập đa dạng của các loại vape, từ các thiết bị mới nhất đến những hương vị độc đáo</i></b></h5>
        </div>
    </div>

    <!-- TIFA -->
    <div class="item4">
        <div>
            <h3>E-juice</h3>
            <i style="color: white; font-size: x-large; font-weight: bold; color: white">Sản phẩm của chúng tôi được lựa chọn kỹ lưỡng để đảm bảo chất lượng và an toàn cho khách hàng. Bạn sẽ không chỉ tìm thấy
                những thiết bị vape hàng đầu mà còn được tư vấn chuyên sâu về cách sử dụng và bảo quản.</i>
        </div>
    </div>

    <!-- PS -->
    <div class="item5">
        <div>
            <img src="https://img.freepik.com/premium-vector/vape-logo-design-vape-shop_642050-57.jpg" style="width: 300px; height: 300px"
                 alt="Playstation Logo"/>
            <h3>Bản lĩnh đàn ông</h3>
        </div>
    </div>

    <!-- SQUARE ENIX -->
    <div class="item6">
        <div>
            <img src="" alt="">
            <h3 style="font-family: Algerian;font-size: xxx-large">Vape Shop</h3>
        </div>
    </div>

    <!-- AERITH -->
    <div class="item7">
        <div>
            <h3>Không gian</h3>
            <h4 style="font-family: 'Agency FB'; font-size: xx-large">Thân Thiện và Sáng Tạo</h4>
            <p>Chúng tôi cam kết mang đến trải nghiệm mua sắm tốt nhất cho khách hàng.
                Đội ngũ nhân viên chăm sóc khách hàng của chúng tôi không chỉ là người bán hàng mà còn là những người đam mê vape,
                luôn sẵn lòng hỗ trợ và chia sẻ thông tin hữu ích.</p>

            <img src="https://raw.githubusercontent.com/lezusrocks/CSS-Grid-Excercise/master/images/aerith.png"
                 alt="Aerith"/>
        </div>
    </div>

    <!-- BARRET -->
    <div class="item8">
    </div>

</div>
<!-- /CONTAINER -->
</div>
<%--text phan anh chạy qua chạy lại--%>

<!-- Start Categories of The Month -->
<section class="container py-5">
    <div class="row text-center pt-3">
        <div class="col-lg-6 m-auto">
            <h1 class="h1" style="font-family: Bahnschrift">Một số sản phẩm tiêu biểu của tháng</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-12 col-md-4 p-5 mt-3">
            <a href="#"><img src="https://vn.smissvape.com/uploads/202235368/magnetic-e-pod34088252001.jpg" class="rounded-circle img-fluid border"></a>
            <h5 class="text-center mt-3 mb-3">Magnetic E Pod</h5>
        </div>
        <div class="col-12 col-md-4 p-5 mt-3">
            <a href="#"><img src="https://vn.newecigarettes.com/uploads/202125334/4500-puffs-electronic-e-cigarette02373276289.jpg" class="rounded-circle img-fluid border"></a>
            <h2 class="h5 text-center mt-3 mb-3">4500 Puffs</h2>
        </div>
        <div class="col-12 col-md-4 p-5 mt-3">
            <a href="#"><img src="https://www.vapewholesaleglobal.com/cdn/shop/products/Geekvape-T200-Aegis-Touch-Box-Mod-kit-6-111166_1024x.jpg?v=1662610441" class="rounded-circle img-fluid border"></a>
            <h2 class="h5 text-center mt-3 mb-3">Geekvape</h2>
        </div>
    </div>
</section>
<!-- End Categories of The Month -->


<!-- Start Featured Product -->
<section class="bg-light">
    <div class="container py-5">
        <div class="row text-center py-3 mb-4">
            <div class="col-lg-6 m-auto">
                <h1 class="h1" style="font-family: 'Andale Mono'">Vape Shop - Nơi Đam Mê Gặp Gỡ và Khám Phá!</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 p-2" style="background-color: whitesmoke; border-radius: 5px ">
                <div class="row">
                    <div class="col-md-6">
                        <div class="map">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7671.51701320954!2d108.2555356409651!3d15.973982838766927!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142116949840599%3A0x365b35580f52e8d5!2zxJDhuqFpIGjhu41jIEZQVCDEkMOgIE7hurVuZw!5e0!3m2!1svi!2s!4v1700188986646!5m2!1svi!2s" width="600" height="600" style="border:0; border-radius: 20px" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-feeback">
                            <form class="row g-3 needs-validation p-4" novalidate action="service-tracking-sender"
                                  method="post">
                                <div class="alert m-1">
                                    <h4><i> Hãy cho chúng tôi biết vấn đề của bạn<span class="text-danger"> * </span> </i></h4>
                                </div>

                                <div class="col-12">
                                    <label for="title" class="form-label fw-bolder text-lg">Tiêu đề <span class="text-danger"> *</span></label>
                                    <div class="input-group has-validation mt-1">
                                        <input type="text" class="form-control text-lg" placeholder="Nhập tiêu đề"
                                               maxlength="50"
                                               id="title" name="title"
                                               required>
                                        <div class="invalid-feedback">
                                            Không được bỏ trống tiêu đề và độ dài tối đa là 50 kí tự
                                        </div>
                                    </div>
                                </div>


                                <div class="col-12 mt-4">
                                    <label for="userDescription" class="form-label fw-bolder text-lg">Mô tả <span
                                            class="text-danger"> *</span></label>
                                    <div class="input-group has-validation">
                                        <textarea cols="30" rows="10" class="form-control text-lg" id="userDescription"
                                                  name="userDescription" maxlength="250"
                                                  placeholder="Nhập mô tả" required></textarea>
                                        <div class="invalid-feedback">
                                            Vui lòng điền mô tả và độ dài tối đa 250 ki tự
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 mt-3" style="margin: 0">
                                    <button onclick="run()" class="btn btn-success" type="submit">Xác Nhận <i
                                            class="fa-solid fa-rocket fa-bounce fa-lg"
                                            style="color: #f2df07;"></i></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function run() {
            alert(
            <c:if test="${not empty sessionScope.user}">
                ${"CẢM ƠN BẠN ĐÃ PHẢN HỒI (^.^)"}
                </c:if>
            <c:if test="${empty sessionScope.user}">
            "Vui lòng đăng nhập để sử dụng tính năng"
            </c:if>
            )
        }

        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
    </script>
    <script>
        (function () {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
    </script>
</section>
<!-- End Featured Product -->
<%@include file="include/header-footer/footer.jsp" %>
