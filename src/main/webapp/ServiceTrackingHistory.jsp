<%@include file="include/header-footer/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<style>
    #pagination {
        margin-top: 10px;
    }

    .paging-button {
        display: inline-block;
        padding: 5px 10px;
        border: 1px solid #ccc;
        background-color: #f7f7f7;
        cursor: pointer;
        text-decoration: none;
    }

    .paging-button.active {
        background-color: #ccc;
    }

</style>
<body>
<div class="container-fluid mb-3">
    <div class="container">
        <div class="col-md-12 col-sm-9 col-xx-6 col-xs-12 gach_line">
            <div class="border-start border-5 border-success ps-5 mb-5 mt-5" style="max-width: 600px;">
                <h6 class="text-success text-uppercase">Lịch sử đơn hàng</h6>
                <h1 class="display-5 text-uppercase mb-0">Các đơn hàng bạn đã đặt</h1>
            </div>
            <div id="tab1" class="content_tab">
                <table width="100%" cellspacing="0" cellpadding="0" class="table-bordered text-center table-hover"
                       id="data-table">
                    <thead>
                    <td class="py-2">Mã đơn dịch vụ</td>
                    <td class="py-2">Ngày đặt dịch vụ</td>
                    <td class="py-2">Tiêu Đề</td>
                    <td class="py-2">Chi tiết dịch vụ</td>
                    <td class="py-2">Tình trạng</td>

                    </thead>
                    <tbody>
                    <c:forEach items="${serviceTrackingArrayList}" var="sta">
                        <tr>
                            <td width="15%"><a href="GetServiceTrackingDetail?serviceTrackingId=${sta.id}" style="text-decoration: none">${sta.id}</a></td>
                            <td width="20%">${sta.createDate}</td>

                            <td width="20%">
                                <p>${sta.title}</p>
                            </td>

                            <td>
                                <p>${sta.userDescription }</p>
                            </td>
                            <td width="15%">
                                    <%--                  ${i.status}--%>
                                <c:if test="${sta.status eq '0'.charAt(0)}">
                                    <h6 class="text-warning m-1 p-0">Từ chối</h6>
                                </c:if>
                                <c:if test="${sta.status eq '1'.charAt(0)}">
                                    <h6 class="text-warning m-1 p-0">Đang chờ</h6>
                                </c:if>
                                <c:if test="${sta.status eq '2'.charAt(0)}">
                                    <h6 class="text-primary m-1 p-0">Đồng ý</h6>
                                </c:if>
                                <c:if test="${sta.status eq '3'.charAt(0)}">
                                    <h6 class="text-danger m-1 p-0">Thất bại</h6>
                                </c:if>
                                <c:if test="${sta.status eq '4'.charAt(0)}">
                                    <h6 class="text-success m-1 p-0">Thành công</h6>
                                </c:if>
                            </td>

                        </tr>
                        ${orderedCart.getThanhTienStringAfterPurchaseDiscount(30000)}
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row mt-3">
                <ul class="pagination pagination-lg justify-content-end ">
                    <c:if test="${tag>1}">
                        <li class="page-item ">
                            <a class="page-link rounded-0 mr-3 shadow-sm  text-dark"
                               href="ServiceTrackingHistory?index=${tag-1}"
                               tabindex="-1"><i class="text-dark fas fa-chevron-left"></i></a>
                        </li>
                    </c:if>
                    <c:if test="${endPage >3}">
                        <c:set var="beginIndex" value="${tag - 1}"/>
                        <c:set var="endIndex" value="${tag +1}"/>
                        <c:if test="${beginIndex < 1}">
                            <c:set var="beginIndex" value="1"/>
                        </c:if>
                        <c:if test="${endIndex > endPage}">
                            <c:set var="endIndex" value="${endPage}"/>
                        </c:if>
                        <c:forEach begin="${beginIndex}" end="${endIndex}" var="i" step="1">
                            <li class="page-item">
                                <a class="page-link rounded-0 mr-3 shadow-sm  text-dark  ${tag == i?"active":""}"
                                   href="ServiceTrackingHistory?index=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${tag<endPage}">
                        <li class="page-item">
                            <a class="page-link rounded-0 shadow-sm  text-dark " href="ServiceTrackingHistory?index=${tag+1}"><i
                                    class="text-dark fas fa-chevron-right"></i></a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>


<%@include file="include/header-footer/footer.jsp" %>

