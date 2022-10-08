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
    <button>자바</button>
    <button>파이썬</button>
    <button>장고</button>
    <button>스프링</button>
</div>
    <select name="">
        <option value="">최신순</option>
        <option value="">학력순</option>
        <option value="">경력순</option>
        <option value="">추천순</option>
    </select>
</body>
</html>