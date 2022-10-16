<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>

<div class="col grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <p class="card-title mb-0 p-3"> 추천 매칭 리스트</p>
            <div class="table-responsive p-3">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>기업명/이력서제목</th>
                        <th>공고명/이력서분야?</th>
                        <th>Date</th>
                        <th>구직현황/이력서등록현황</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Search Engine Marketing</td>
                        <td class="font-weight-bold">백엔드엔지니어링</td>
                        <td>21 Sep 2018</td>
                        <td class="font-weight-medium">
                            <div class="badge badge-success">모집중</div>
                        </td>
                    </tr>
                    <tr>
                        <td>Search Engine Optimization</td>
                        <td class="font-weight-bold">주거인테리어웹디자이너</td>
                        <td>13 Jun 2018</td>
                        <td class="font-weight-medium">
                            <div class="badge badge-success">모집중</div>
                        </td>
                    </tr>
                    <tr>
                        <td>E-Mail Marketing</td>
                        <td class="font-weight-bold">펌웨어하드웨어개발자</td>
                        <td>01 Nov 2018</td>
                        <td class="font-weight-medium">
                            <div class="badge badge-danger">임박</div>
                        </td>
                    </tr>
                    <tr>
                        <td>Pay Per Click Advertising</td>
                        <td class="font-weight-bold">시스템앤지니어</td>
                        <td>30 Jun 2018</td>
                        <td class="font-weight-medium">
                            <div class="badge badge-warning">완료</div>
                        </td>
                    </tr>
                    <tr>
                        <td>운동하는 개발자입니다</td>
                        <td class="font-weight-bold">자바 개발자, IOS 개발자</td>
                        <td>30 Jun 2018</td>
                        <td class="font-weight-medium">
                            <div class="badge badge-warning">미등록</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<div class="d-flex justify-content-center my-5">
    <div class="w-75 d-flex justify-content-between">
        <div class="btn-group">
            <c:forEach var="category" items="${resumeData.category}">
                <button onclick='btnCategory("${category.categoryName}", ${sessionScope.principal})'
                        class="btn btn-primary">${category.categoryName}</button>
            </c:forEach>
        </div>
        <div class="dropdown">
            <select id="btnOrder" onchange="orderDo(this.value)" class="btn btn-outline-primary dropdown-toggle"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <option selected>정렬</option>
                <option value="recent">최신순</option>
                <option value="career">경력순</option>
                <option value="education">학력순</option>
                <option value="recommend">추천순</option>
            </select>
        </div>
    </div>
</div>

<div id="resumeCard" class="">
    <c:forEach var="resume" items="${resumeData.resume}">
        <div class="card px-4 m-3">
            <div class="card-body row">
                <div class="col-2" style="width:200px">
                    <img src="/img/${resume.resumePhoto}" class="img-thumbnail"/>
                </div>
                <div class="col-8 px-5">
                    <p class="mb-4">${resume.resumeUserId}</p>
                    <a href="resume/detail/${resume.resumeId}/${resume.resumeUserId}"><p
                            class="fs-30 mb-2 text-black">${resume.resumeTitle}</p></a>
                    <p class="fs-10 mb-2">${resume.resumeCreatedAt}</p>
                </div>
                <div class="col-2 d-flex flex-wrap align-content-center">
                    <a href="resume/detail/${resume.resumeId}/${resume.resumeUserId}">
                        <button type="button" class="btn btn-outline-primary">상세보기</button>
                    </a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script>
    function btnCategory(title) {
        let data = {
            categoryName: title,
        };

        $.ajax("/resume", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            $("#resumeCard").empty();
            $("#resumeCard").append(makeList(res.data));
        }).fail(function (error) {
            console.log(error);
            alert("에러");
        });
    }

    function orderDo(listOption, userId) {
        let data = {
            userId: userId,
        };
        $.ajax({
            type: "POST",
            url: "/resume/list?order=" + listOption,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            $("#resumeCard").empty();
            $("#resumeCard").append(makeList(res.data));
        }).fail(function (error) {
            console.log(error);
            alert("오류");
        });
    }

    function makeList(x) {
        let item = ``;
        for (let list of x) {
            item += `<div class="card px-4 m-3"><div class="card-body row"><div class="col-2" style="width:200px">
                    <img src="/img/`+list.resumePhoto+`" class="img-thumbnail"/></div>`;
            item += `<div class="col-8 px-5">`
            item += `<p class="mb-4">` + list.resumeUserId + `</p>`;
            item += `<p class="fs-30 mb-2">` + list.resumeTitle + `</p>`;
            item += `<p>` + list.resumeCreatedAt + `</p>`;
            item += `</div><div class="col-2 d-flex flex-wrap align-content-center">`;
            item += `<a href="resume/detail/` + list.resumeId + `">`;
            item += `<button type="button" class="btn btn-outline-primary">` + `상세보기` + `</button></a>`
            item += `</div></div></div>`
        }
        return item;
    }
</script>
<%@ include file="../../layout/footer.jsp" %>