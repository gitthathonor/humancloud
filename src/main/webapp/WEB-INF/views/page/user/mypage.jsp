<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>
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
                        <div class="display-2">0</div>
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
                <div class="my-5">
                    <h4 class="m-3 text-primary">이력서</h4>
                    <div class="row bg-primary rounded m-2 p-5 text-center text-white"></div>
                </div>
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

<%@ include file="../../layout/footer.jsp" %>