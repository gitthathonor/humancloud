<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../../layout/header.jsp" %>
        <%@ include file="subscribeModal.jsp" %>

            <div class="row">
                <%@ include file="profile.jsp" %>
                    <div class="col-md-9 grid-margin stretch-card">
                        <div class="card ">
                            <div class="card-body my-5">
                                <h4 class="m-3 text-primary">지원 현황</h4>
                                <div class="row rounded m-2 p-5 text-center  border">
                                    <div class="col border-right">
                                        <div class="display-2">0</div>
                                        <div>지원 완료</div>
                                    </div>
                                    <div class="col border-right">
                                        <div class="display-2">${resume.readCount}</div>
                                        <div>이력서 열람</div>
                                    </div>
                                    <div class="col border-right">
                                        <div class="display-2">0</div>
                                        <div>최종합격</div>
                                    </div>
                                    <div class="col">
                                        <div class="display-2">0</div>
                                        <div>불합격</div>
                                    </div>
                                </div>
                                <c:if
                                    test="${!empty sessionScope.principal.userId || empty sessionScope.companyPrincipal.companyId}">
                                    <div class="my-5">
                                        <h4 class="m-3 text-primary">이력서</h4>
                                        <div class="row d-flex justify-content-center">
                                            <c:choose>
                                                <c:when test="${empty resume.resume}">
                                                    <div class="m-3 p-3 col-2 border rounded"
                                                        onchange='viewResume("${r.resumeId}")'>
                                                        <a href="/resume/saveForm/${sessionScope.principal.userId}">
                                                            <h1 style="text-align:center; " class="text-primary">+</h1>
                                                        </a>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach var="r" items="${resume.resume}">
                                                        <div class="m-3 p-3 col-2 border rounded"
                                                            onchange='viewResume("${r.resumeId}")'>
                                                            <a href="/resume/detail/${r.resumeId}/${r.resumeUserId}">
                                                                <h3 class="m-1 text-primary text-center">${r.resumeTitle}</h3>
                                                            </a>
                                                            <div class="text-center">${r.resumeReadCount}</div>
                                                            <div class="text-center">${r.resumeCreatedAt}</div>
                                                        </div>
                                                    </c:forEach>
                                                    <div class="m-3 p-3 col-2 border rounded"
                                                        onchange='viewResume("${r.resumeId}")'>
                                                        <a href="/resume/saveForm/${sessionScope.principal.userId}">
                                                            <h1 style="text-align:center;" class="text-primary">+</h1>
                                                        </a>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </c:if>

                                <c:if
                                    test="${!empty sessionScope.companyPrincipal.companyId || empty sessionScope.principal.userId}">
                                    <div class="my-5">
                                        <h4 class="m-3 text-primary">채용공고</h4>
                                        <div class="row d-flex justify-content-center">
                                            <a href="/recruit/save"><button class="btn btn-primary">채용공고 작성</button></a>
                                        </div>
                                    </div>
                                </c:if>

                                <div class="my-5">
                                    <h4 class="m-3 text-primary">추천</h4>
                                    <div class="row d-flex justify-content-center">
                                        <div class="m-3 p-3 col-2 border">기업</div>
                                        <div class="m-3 p-3 col-2 border">기업</div>
                                        <div class="m-3 p-3 col-2 border">기업</div>
                                        <div class="m-3 p-3 col-2 border">기업</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <script>
                        function viewResume(id) {
                            $.ajax({
                                type: "GET",
                                // url: 여기다가 이력서 상세보기 연결 (매개변수 id 있음),
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                            }).done((res) => {
                                location.href = "#";
                            }).fail(function (error) {
                                console.log(error);
                                alert("오류");
                            });
                        }

                    </script>

                    <%@ include file="../../layout/footer.jsp" %>