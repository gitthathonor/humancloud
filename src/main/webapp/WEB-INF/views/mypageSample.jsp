<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Index Page</title>
</head>
<body>
<h1>This is My Page</h1>
<div>
    <h1>������(���� ī��)</h1>
    <ul>
        <li>���� : ��� �� ����</li>
        <li>�̸��� : ${user.email}</li>
        <li>��ȭ��ȣ : ${user.phoneNumber}</li>
    </ul>
</div>
</body>
</html>