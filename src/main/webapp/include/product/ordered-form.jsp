<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 11/6/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "en_US"/>
<!DOCTYPE html>
<div class="container-fluid">
    <div class="container">
        <div class="donhang">
            <div class="border-start border-5 border-primary ps-5 mb-5 mt-5">
                <h6 class="text-primary text-uppercase">Đơn hàng</h6>
                <h1 class="display-5 text-uppercase mb-0">Kiểm tra đơn hàng của bạn</h1>
            </div>
            <div class="d-flex justify-content-center">
                <h2 class="text-primary m-1 p-0">Tình trạng đơn hàng của bạn: </h2>
<%--                <h2 class="text-danger m-1 p-0"> ${orderStatus}</h2>--%>
<%--                <c:if test="${orderStatus.equals('0')}">--%>
<%--                    <h2 class="text-danger m-1 p-0">Đang xử lý - COD</h2>--%>
<%--                </c:if>--%>
<%--                <c:if test="${orderStatus.equals('1')}">--%>
<%--                    <h2 class="text-danger m-1 p-0">Đang xử lý - CK</h2>--%>
<%--                </c:if>--%>
<%--                <c:if test="${orderStatus.equals('2')}">--%>
<%--                    <h2 class="text-danger m-1 p-0">Đã xử lý</h2>--%>
<%--                </c:if>--%>
<%--                <c:if test="${orderStatus.equals('3')}">--%>
<%--                    <h2 class="text-danger m-1 p-0">Đã Hủy</h2>--%>
<%--                </c:if>--%>
<%--                <c:if test="${orderStatus.equals('4')}">--%>
<%--                    <h2 class="text-danger m-1 p-0">Giao Hàng Thành Công</h2>--%>
<%--                </c:if>--%>
<%--                ------------------%>
                <c:if test="${orderStatus.equals('0')}">
                    <h2 class="text-warning m-1 p-0">Đang xử lý - COD</h2>
                </c:if>
                <c:if test="${orderStatus.equals('1')}">
                    <h2 class="text-warning m-1 p-0">Đang xử lý - CK</h2>
                </c:if>
                <c:if test="${orderStatus.equals('2')}">
                    <h2 class="text-primary m-1 p-0">Đã xử lý</h2>
                </c:if>
                <c:if test="${orderStatus.equals('3')}">
                    <h2 class="text-danger m-1 p-0">Đã Hủy</h2>
                </c:if>
                <c:if test="${orderStatus.equals('4')}">
                    <h2 class="text-success m-1 p-0">Giao Hàng Thành Công</h2>
                </c:if>
                <c:if test="${orderStatus.equals('5')}">
                    <h2 class="text-danger m-1 p-0">Giao Hàng thất bại</h2>
                </c:if>
            </div>
            <div class="mt-5 text-center">
                <p class="">Khách vui lòng đồng kiểm với bưu tá khi nhận hàng và quay video để đảm bảo nhận hàng đầy
                    đủ.</p>
                <p>Đơn hàng của quý khách đã được gửi cho hãng vận chuyển Viettel Post</p>
                <p class="text-danger">Mã đơn hàng: ${orderId}</p>
            </div>
            <div class="d-flex justify-content-center">
                <div class="d-flex justify-content-around border shadow-md rounded-3 p-5" style="width: 80%;background-color: #E9EEF5;box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
                    <div class="row pt-3 col-12 kt-left">
                        <div class="col-md-6">
                            <h3>Thông tin khách hàng</h3>
                            <div class="my-3">
                                <h6> Họ Và Tên: ${sessionScope.user.fullName}</h6>
                                <h6>Số Điện Thoại: ${sessionScope.user.phone}</h6>
                                <h6>Địa Chỉ: ${sessionScope.user.address}</h6>
                                <h6>Email: ${sessionScope.user.email}</h6>
                            </div>
                            <div class="pt-2 d-flex justify-content-between" style="width: 90%;border-top: 2px solid #448c8f">
                                <h5>Tổng giá trị sản phẩm:</h5>
                                <strong style="font-size:18px;font-weight:500">${orderedCart.getThanhTienStringAfterPurchase(0)}<i class="text-success">VND</i></strong>
                            </div>
                            <div class=" d-flex justify-content-between" style="width: 90%">
                                <h5>Phí vận chuyển:</h5>
                                <strong style="font-size:18px;font-weight:500"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "30000" /><i class="text-success">VND</i></strong>
                            </div>
                            <div class="mb-sm-5 border-top pt-2 mt-3 d-flex justify-content-between" style="width: 90%">
                                <h5>Tổng cộng:</h5>
                                <c:if test="${orderedCart.discountCode == null}">
                                    <strong style="font-size:18px;font-weight:500">${orderedCart.getThanhTienStringAfterPurchase(30000)}<i class="text-success">VND</i></strong>
                                </c:if>
                                <c:if test="${orderedCart.discountCode != null}">
                                    <strong style="font-size:18px;font-weight:500">
                                        <del>${orderedCart.getThanhTienStringAfterPurchase(30000)} </del>
                                            ${orderedCart.getThanhTienStringAfterPurchaseDiscount(30000)}</strong>

                                </c:if>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3 " style="border-left: 2px solid #448c8f">
                            <h3>Thông tin đơn hàng</h3>
                            <c:forEach items="${orderedCart.cart}" var="i">
                                <div >
                                    <div class="d-flex">
                                        <div class="p-1">
                                            <img width="60px" height="60px" src="${i.productType.imageProducts.get(0).imageUrl}" alt="">
                                        </div>
                                        <div class="p-1">
                                            <strong>${i.productType.product.productName}</strong>
                                            <p>${i.productType.typeName}</p>
                                        </div>
                                    </div>
                                    <div style="text-align: right; font-size: larger;" class="p-1">
                                        <strong><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${i.productType.typePrice}" /><i class="text-success">VND</i> </strong>
                                        <strong>X ${i.getAmmout()}</strong>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        <div class="mt-5 d-flex justify-content-center">
            <p>Nếu bạn có bất cứ câu hỏi nào, đừng ngần ngại liên lạc với chúng tôi qua Hotline: 0123456789 (9h
                -
                19h các ngày thứ 2 đến thứ 7)</p>
        </div>
    </div>

</div>
</div>
