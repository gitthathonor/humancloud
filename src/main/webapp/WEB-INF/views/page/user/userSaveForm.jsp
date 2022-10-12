<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>

<div class="col-md-6 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">user register form</h4>
            <p class="card-description">
                Basic form layout
            </p>
            <div class="btn-group m-4" role="group" aria-label="Basic example">
                <button type="button" class="btn btn-primary">일반</button>

                <button type="button" class="btn btn-default"><a class="text-black" href="/company/saveForm">기업</a></button>

            </div>

            <form class="forms-sample">
                <label for="username">Username</label>
                <div class="form-group row">
                    <div class="col-9"><input type="text" class="form-control" id="username" placeholder="Username"></div>
                    <div class="col-3"><button onclick="checkUsername()" class="btn btn-light" type="button">중복확인</button></div>
                </div>

                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" id="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone number</label>
                    <input type="tel" class="form-control" id="phoneNumber" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="password2">Confirm Password</label>
                    <input type="password" class="form-control" id="password2" placeholder="Password">
                </div>

                <button id="join" type="submit" class="btn btn-primary mr-2">Submit</button>
                <button class="btn btn-light">Cancel</button>
            </form>
        </div>
    </div>
</div>

<script>
    let isUsernameSameCheck = false;
    let checkPassword = false;

    $("#join").click(()=>{
        checkSamePassword();
        if(isUsernameSameCheck==true && checkPassword==true){
            insert();
        } else{
            alert("아이디체크");
        }
    });

    function checkSamePassword(){
        let password = $("#password").val();
        let password2 = $("#password2").val();

        if(password!=password2){
            alert("비밀번호 노일치");
        } else {
            checkPassword=true;
        }
    }

    function checkUsername() {
        let username = $("#username").val();

        if(username===""){
            alert("아이디를 입력하시오");
            return;
        }

        $.ajax("/user/usernameSameCheck?username="+username, {
            type: "GET",
            dataType: "json",
        }).done((res) => {
            if (res.code == 1) { // 통신 성공
                if (res.data == true) {
                    alert("사용 가능");
                    isUsernameSameCheck = true;
                } else {
                    alert("아이디 중복");
                    isUsernameSameCheck = false;
                }
            }
        });
    }

    function insert(){
        let data = {
            username: $("#username").val(),
            name: $("#name").val(),
            email : $("#email").val(),
            phoneNumber : $("#phoneNumber").val(),
            password : $("#password").val()
        };

        $.ajax("/user/join", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            if (res.code == 1) {
                alert("회원가입 완료");
                location.href = "/login";
            }
        });
    }
</script>

<%@ include file="../../layout/footer.jsp" %>
