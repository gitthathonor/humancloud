<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Index Page</title>
</head>
<body>
<h1>This is Resume List Page</h1>
<ul>
<c:forEach var="resume" items="${resumes}">
<li>${resume.resumeTitle}</li>
</c:forEach>
</ul>
<div>
    <button>�ڹ�</button>
    <button>���̽�</button>
    <button>���</button>
    <button>������</button>
</div>
    <select name="">
        <option value="">�ֽż�</option>
        <option value="">�з¼�</option>
        <option value="">��¼�</option>
        <option value="">��õ��</option>
    </select>
</body>
</html>