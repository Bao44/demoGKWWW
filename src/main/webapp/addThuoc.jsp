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
</head>
<body>
<h3>Them thuoc</h3>
<div>
    <h1>Thong tin Thuoc moi</h1>
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
        <button type="submit">Them thuoc</button>
    </form>
</div>
</body>
</html>
