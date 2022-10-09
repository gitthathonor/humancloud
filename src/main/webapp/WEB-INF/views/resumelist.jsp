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
<h1>This is Resume List Page</h1>
<ul>
<c:forEach var="resume" items="${resumes}">
<li>${resume.resumeTitle}</li>
</c:forEach>
</ul>
<div>
    <c:forEach var="category" items="${categories}">
        <button onclick='btnCategory("${category.categoryName}")'>${category.categoryName}</button>
    </c:forEach>
</div>
<select id="orderList" onchange="orderDo(this.value)">
    <option value="recent">최신순</option>
    <option value="education">학력순</option>
    <option value="career">경력순</option>
    <option value="recommend">추천순</option>
</select>
<div id="listContent">
    여기가 내용 들어갈 칸
</div>
</body>
<script>
    // $('#orderList').change(() => {
    //     let listOption = $("#orderList option:selected").val();
    //     console.log(listOption);
    //     if(listOption)
    // });

    function orderDo(listOption){
        console.log(listOption)
        $.ajax({
            type: "GET",
            url: "/resume/list?order="+listOption,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
        }).done((res) => {
            $("#listContent").empty();
            $("#listContent").append(makeList(res.data));
        }).fail(function(error){
            console.log(error);
            alert("실패");
        });
    }

    function btnCategory(title){
        let data = {
            categoryName : title,
        };

        $.ajax("/resume", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            $("#listContent").empty();
            $("#listContent").append(makeList(res.data));
        }).fail(function(error){
            console.log(error);
            alert("실패");
        });
    }

    function makeList(x){
        let item = `<div>`;
        for(let list of x){
            item += `<p>`+list.resumeTitle+`</p>`;
            item += `<p>`+list.resumeCreatedAt+`</p>`;
            item += `</div>`;
        }
        return item;
    }
</script>
</html>