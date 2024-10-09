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
    <a href="action?action=danhSachLoaiThuoc">Danh sách các loại thuốc</a> |
    <a href="addThuoc.jsp"> Thêm mới thuốc </a>
</div>

<%
    List<Thuoc> danhSachThuoc = (List<Thuoc>) session.getAttribute("danhSachThuoc");
%>
<div class="container-dashboard">
    <h1>Danh sách thuốc</h1>
    <table>
        <thead>
        <tr>
            <th>Mã thuốc</th>
            <th>Tên thuốc</th>
            <th>Nam san xuat</th>
            <th>Gia</th>
            <th>Mã loại</th>
        </tr>
        </thead>
        <tbody>
        <% for (Thuoc thuoc : danhSachThuoc) { %>
        <tr>

            <td><%=thuoc.getMaThuoc()%>
            </td>
            <td><%=thuoc.getTenThuoc()%>
            </td>
            <td><%=thuoc.getNamsx()%>
            </td>
            <td><%=thuoc.getDonGia()%>
            </td>
            <td><%=thuoc.getLoaiThuoc().getMaLoai()%>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>



