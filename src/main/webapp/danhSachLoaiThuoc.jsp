<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demogk.entities.LoaiThuoc" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/9/2024
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách các loại thuốc</title>
</head>
<body>
<% List<LoaiThuoc> list = (List<LoaiThuoc>) session.getAttribute("danhSachLoaiThuoc"); %>
<h2>Danh sách loại thuôc</h2>
<% for (LoaiThuoc loaiThuoc : list) { %>
<div>
    <a href="action?action=danhSachThuocTheoLoai&MALOAI=<%= loaiThuoc.getMaLoai() %>">
        <%= loaiThuoc %>
    </a>
</div>
<% } %>
</body>
</html>
