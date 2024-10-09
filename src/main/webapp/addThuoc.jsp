<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/9/2024
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Thuoc</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>

<h1 class="header">
    21017351 - Truơng Quốc Bảo
</h1>
<br/>
<div class="nav">
    <a href="index.jsp"> Trang chủ </a> |
    <a href="action?action=danhSachLoaiThuoc">Danh sách các loại thuốc</a> |
    <a href="action?action=danhSachThuoc">Danh sách các thuốc</a>
</div>
<div class="form">
    <h1>Nhap thong tin Thuoc moi</h1>
    <form action="action?action=addThuoc" method="post">
        <label>Ma Thuoc</label>
        <input type="text" name="MATHUOC" placeholder="nhap ma thuoc"/><br>
        <label>Ten thuoc</label>
        <input type="text" name="TENTHUOC" placeholder="nhap ten thuoc"/><br>
        <label>Nam sx</label>
        <input type="text" name="NAMSX" placeholder="nhap nam sx"/><br>
        <label>Gia</label>
        <input type="text" name="GIA" placeholder="nhap gia"/><br>
        <label>Ma loai</label>
        <input type="text" name="MALOAI" placeholder="nhap ma loai"/><br>
        <button type="submit" class="addBtn"> Them thuốc </button>
    </form>
</div>
</body>
</html>
