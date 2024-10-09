<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demogk.entities.Thuoc" %>
<%@ page import="vn.edu.iuh.fit.demogk.entities.LoaiThuoc" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/9/2024
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach thuoc theo loai</title>
</head>
<body>

<% List<Thuoc> danhSachThuocTheoLoai = (List<Thuoc>) session.getAttribute("danhSachThuocTheoLoai");
%>
<h2>Danh sách thuốc theo loai</h2>
<% for (Thuoc thuoc : danhSachThuocTheoLoai) { %>
<div><%= thuoc %>
</div>
<% } %>
</body>
</html>
