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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>

<h1 class="header">
    21017351 - Truơng Quốc Bảo
</h1>
<br/>
<div class="nav">
    <a href="index.jsp">Trang chủ</a> |
    <a href="action?action=danhSachThuoc">Danh sách các thuốc</a> |
    <a href="addThuoc.jsp"> Thêm mới thuốc </a>
</div>

<% List<LoaiThuoc> list = (List<LoaiThuoc>) session.getAttribute("danhSachLoaiThuoc"); %>
<div class="container-dashboard">
    <h1>Danh sách loại thuốc</h1>
    <table>
        <thead>
        <tr>
            <th>Mã loại thuốc</th>
            <th>Tên loại thuốc</th>
        </tr>
        </thead>
        <tbody>
        <% for (LoaiThuoc loaiThuoc : list) { %>
        <tr>

            <td><a href="action?action=danhSachThuocTheoLoai&MALOAI=<%= loaiThuoc.getMaLoai() %>">
                <%= loaiThuoc.getMaLoai() %>
            </a>
            </td>
            <td><%=loaiThuoc.getTenLoai()%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>

