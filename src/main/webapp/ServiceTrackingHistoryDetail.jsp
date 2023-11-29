<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<fmt:setLocale value = "en_US"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/header-footer/header.jsp" %>
<div class="container-fluid">
    <div class="container">
        <div class="donhang">
            <div class="border-start border-5 border-primary ps-5 mb-5 mt-5">
                <h6 class="text-primary text-uppercase">Chi tiết đơn đặt dịch vụ</h6>
                <h1 class="display-5 text-uppercase mb-0">Kiểm tra đơn đặt dịch vụ của bạn</h1>
            </div>
            <div class="d-flex justify-content-center">
                <h2 class="text-primary m-1 p-0">Tình trạng đơn dịch vụ của bạn: </h2>
                <c:if test="${serviceTrackingDetail.status eq '0'.charAt(0)}">
                    <h2 class="text-warning m-1 p-0">Từ chối</h2>
                </c:if>
                <c:if test="${serviceTrackingDetail.status eq '1'.charAt(0)}">
                    <h2 class="text-warning m-1 p-0">Đang chờ</h2>
                </c:if>
                <c:if test="${serviceTrackingDetail.status eq '2'.charAt(0)}">
                    <h2 class="text-primary m-1 p-0">Đồng ý</h2>
                </c:if>
                <c:if test="${serviceTrackingDetail.status eq '3'.charAt(0)}">
                    <h2 class="text-danger m-1 p-0">Thất bại</h2>
                </c:if>
                <c:if test="${serviceTrackingDetail.status eq '4'.charAt(0)}">
                    <h2 class="text-success m-1 p-0">Thành công</h2>
                </c:if>
            </div>
            <div class="mt-5 text-center">
                <p class="">Khách vui lòng đồng kiểm với bưu tá khi nhận hàng và quay video để đảm bảo nhận hàng đầy
                    đủ.</p>
                <p>Đơn hàng của quý khách đã được gửi cho hãng vận chuyển Viettel Post</p>
                <p class="text-danger">Mã đơn hàng: ${serviceTrackingDetail.id}</p>
            </div>
            <div class="d-flex justify-content-center">
                <div class="d-flex justify-content-around border shadow-md rounded-3 p-5" style="width: 80%;background-color: #E9EEF5;box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
                    <div class="row pt-3 col-12 kt-left">
                        <div class="col-md-6">
                            <h3>Thông tin khách hàng</h3>
                            <div class="my-3">
                                    <h5> Họ Và Tên: <h6>${sessionScope.user.fullName}</h6></h5>
                                <h5>Số Điện Thoại: <h6>${sessionScope.user.phone}</h6></h5>
                                <h5>Địa Chỉ: <h6>${sessionScope.user.address}</h6></h5>
                                <h5>Email: <h6>${sessionScope.user.email}</h6></h5>
                            </div>
                        </div>
                        <div class="col-md-6 border-start border-3 border-primary">
                            <h3>Thông tin dịch vụ</h3>
                            <div class="my-3">
                                <h5>Tiêu đề: <h6>${serviceTrackingDetail.title}</h6></h5>
                                <h5>Ngày đặt dịch vụ: <h6>${serviceTrackingDetail.createDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss "))}</h6></h5>
                                <h5>Chi tiết dịch vụ: </h5><textarea cols="50" rows="5" style="border-radius: 5px" readonly>${serviceTrackingDetail.userDescription}</textarea>
                                <h5>Phản hồi của nhân viên: </h5><textarea cols="50" rows="5" style="border-radius: 5px" readonly>${serviceTrackingDetail.employeeDescription}</textarea>
                            </div>
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

<%@include file="include/header-footer/footer.jsp" %>

