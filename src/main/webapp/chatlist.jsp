<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/16/2023
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="include/header-footer/header.jsp"%>
<c:forEach items="${chatList}" var="chat">
    <a href="#">${chat.sessionId} ${chat.customerUsername}</a>
</c:forEach>


<%@include file="include/header-footer/footer.jsp"%>

