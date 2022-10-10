<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>
<div class="row">
    <%@ include file="profile.jsp" %>
    <div class="col-md-9 grid-margin stretch-card">
        <div class="card">
            <div class="card-body row m-4">
                <div class="forms-sample col-8">
                    <h4 class="card-title">user update form</h4>
                    <p class="card-description">마이페이지에 둘지 유저에 둘지 애매함</p>
                    <input type="hidden" id="userId" value="${user.userId}">
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" value="${user.name}">
                    </div>
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input type="email" class="form-control" id="email" value="${user.email}">
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Phone number</label>
                        <input type="tel" class="form-control" id="phoneNumber" value="${user.phoneNumber}">
                    </div>
                    <button onclick="update()" type="submit" class="btn btn-primary mr-2">Submit</button>
                    <button class="btn btn-light"><a href="/"> Cancel</a></button>
                </form>
<%--                <div class="col-3" style="margin-top:8%">--%>
<%--                    <h4>사진:이력서사진목록불러오기</h4>--%>
<%--                    <div class="" style="height:200px; background:red"></div>--%>
<%--                    <div class="w-100 btn btn-inverse-dark btn-fw">사진 수정하기</div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
</div>

<script>
    function update() {
        let data = {
            password: $("#password").val(),
            name : $("#name").val(),
            email: $("#email").val(),
            phoneNumber: $("#phoneNumber").val()
        };
        let id = $("#userId").val();
        $.ajax("/update/" + id, {
            type: "put",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        }).done((res) => {
            if (res.code == 1) {
                location.href = "/mypage?id="+id;
            } else {
                alert("업데이트 실패");
            }
        });
    }
</script>

<%@ include file="../../layout/footer.jsp" %>