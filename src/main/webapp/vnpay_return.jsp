<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="com.vapeshop.vnpay.common.Config"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Đơn Hàng Đã Thanh Toán</title>
        <!-- Bootstrap core CSS -->
        <link href="assets/asset/bootstrap.min.css" rel="stylesheet"/>
        <link href="assets/asset/vn_pay.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <link href="assets/asset/jumbotron-narrow.css" rel="stylesheet">
        <script src="assets/asset/jquery-1.11.3.min.js"></script>
    </head>
    <body>
        <%
            //Begin process return from VNPAY
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);

        %>
        <!--Begin display -->
        <div class="container">
            <div class="header clearfix">
                <h3 class="text-muted text-center">Đơn Hàng Đã Thanh Toán</h3>
            </div>
            <div class="row">
                <div class="table-responsive col-md-8">
                    <div class="form-group form-payed">
                        <label >Mã giao dịch thanh toán:</label>
                        <label><%=request.getParameter("vnp_TxnRef")%></label>
                    </div>
                    <div class="form-group form-payed">
                        <label >Số tiền:</label>
                        <label><%=request.getParameter("vnp_Amount")%></label>
                    </div>
                    <div class="form-group form-payed">
                        <label >Mô tả giao dịch:</label>
                        <label><%=request.getParameter("vnp_OrderInfo")%></label>
                    </div>
                    <div class="form-group form-payed">
                        <label >Mã lỗi thanh toán:</label>
                        <label><%=request.getParameter("vnp_ResponseCode")%></label>
                    </div>
                    <div class="form-group form-payed">
                        <label >Mã giao dịch tại CTT VNPAY-QR:</label>
                        <label><%=request.getParameter("vnp_TransactionNo")%></label>
                    </div>
                    <div class="form-group form-payed">
                        <label >Mã ngân hàng thanh toán:</label>
                        <label><%=request.getParameter("vnp_BankCode")%></label>
                    </div>
                    <div class="form-group form-payed">
                        <label >Thời gian thanh toán:</label>
                        <label><%=request.getParameter("vnp_PayDate")%></label>
                    </div>
                    <div class="form-group form-payed">
                        <label >Tình trạng giao dịch:</label>
                        <label>
                            <% if (signValue.equals(vnp_SecureHash)) {
                                if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                                    out.print("Thành công");
                                } else {
                                    out.print("Không thành công");
                                }

                            } else {
                                out.print("invalid signature");
                            } %></label>
                    </div>
                    <div class="form-group" style="padding-left: 20px">
                        <label><a href="Home"><button class="text-center" type="button">Trang chủ</button></a></label>
                    </div>
                </div>
                <div class="col-md-4">
                    <img src="assets/img/Paymet-Result-Img.svg" class="img-fluid rounded-circle" style="width: 250px;">
                </div>
            </div>
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VapeShop Payment</p>
            </footer>
        </div>  
    </body>
</html>
