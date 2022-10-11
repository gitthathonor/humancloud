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
    <option value="recent">�ֽż�</option>
    <option value="education">�з¼�</option>
    <option value="career">��¼�</option>
    <option value="recommend">��õ��</option>
</select>
<div id="listContent">
    ���Ⱑ ���� �� ĭ
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
            console.log(res.data);
            $("#listContent").empty();
            $("#listContent").append(makeList(res.data));
        }).fail(function(error){
            console.log(error);
            alert("����");
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
            alert("����");
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



<div class="card-body row">
                <div class="bg-danger col-2" style="width:200px">사진</div>
                <div class="col-8 px-5">
                    <p class="mb-4">backend, java, web</p>
                    <p class="fs-30 mb-2">title</p>
                    <p>2000.1.1</p>
                </div>
                <div class="col-2 d-flex flex-wrap align-content-center">
                    <button type="submit" class="btn btn-outline-danger">지원하기</button>
                </div>
            </div>