<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../../layout/header.jsp" %>

        <div class="d-flex justify-content-center my-5">
            <div class="w-75 d-flex justify-content-between">
                <div class="btn-group">
                    <c:forEach var="category" items="${recruits.category}">
                        <button onclick='btnCategory("${category.categoryName}")'
                            class="btn btn-primary">${category.categoryName}</button>
                    </c:forEach>
                </div>
                <div class="dropdown">
                    <select id="btnOrder" onchange="orderDo(this.value)" class="form-select dropdown-toggle"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <option selected>정렬</option>
                        <option value="recent">최신순</option>
                        <option value="career">경력순</option>
                        <option value="education">학력순</option>
                    </select>
                </div>
            </div>
        </div>

        <div id="recruitCard" class="">
            <c:forEach var="recruit" items="${recruits.recruit}">
                <div class="card px-4 m-3">
                    <div class="card-body row">
                        <!-- <div class="col-2" style="width:200px">
                    <img class="img-thumbnail" src="/img/${recruit.companyLogo}" alt="people">
                </div> -->
                        <div class="col-8 px-5">
                            <p class="mb-4">${recruit.recruitLocation}</p>
                            <p class="fs-30 mb-2"><a
                                    href="/recruit/detail/${recruit.recruitId}">${recruit.recruitTitle}</a></p>
                            <p class="fs-10 mb-2">${recruit.recruitCreatedAt}</p>
                        </div>
                        <div class="col-2 d-flex flex-wrap align-content-center">
                            <a href="/recruit/detail/${recruit.recruitId}">
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

                $.ajax("/recruit/category", {
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(data),
                    headers: {
                        "Content-Type": "application/json"
                    }
                }).done((res) => {
                    $("#recruitCard").empty();
                    $("#recruitCard").append(makeList(res.data));
                }).fail(function (error) {
                    console.log(error);
                    alert("오류");
                });
            }

            function orderDo(listOption) {
                $.ajax({
                    type: "GET",
                    url: "/recruit/order?order=" + listOption,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                }).done((res) => {
                    console.log(res.data);
                    $("#recruitCard").empty();
                    $("#recruitCard").append(makeList(res.data));
                }).fail(function (error) {
                    console.log(error);
                    alert("오류");
                });
            }

            function makeList(x) {
                let item = `<div class="card px-4">`;
                for (let list of x) {
                    item += `<div class="card-body row border"><div class="bg-danger col-2" style="width:200px">` + list.recruitCompanyId + `</div>`;
                    item += `<div class="col-8 px-5">`
                    item += `<p class="mb-4">` + list.recruitCreatedAt + `</p>`;
                    item += `<p class="fs-30 mb-2">` + list.recruitTitle + `</p>`;
                    item += `<p>` + list.recruitLocation + `</p>`;
                    item += `</div><div class="col-2 d-flex flex-wrap align-content-center">`;
                    item += `<a href="/recruit/detail/" + list.recruitId + `>`;
                    item += `<button type="button" class="btn btn-outline-primary">` + `상세보기` + `</button></a>`
                    item += `</div></div></div>`
                }
                return item;
            }
        </script>
        <%@ include file="../../layout/footer.jsp" %>