<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demogk.entities.Thuoc" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/9/2024
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Thuốc</title>
</head>
<body>
<%
    List<Thuoc> danhSachThuoc = (List<Thuoc>) session.getAttribute("danhSachThuoc");
%>
<h2>Danh sách thuốc</h2>
<% for (Thuoc thuoc : danhSachThuoc) { %>
<div><%= thuoc %>
</div>
<% } %>
</body>
</html>
