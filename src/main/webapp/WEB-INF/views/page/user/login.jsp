<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>
<div class="content-wrapper d-flex align-items-center auth px-0">
    <div class="row w-100 mx-0">
        <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left py-5 px-4 px-sm-5">
                <div class="brand-logo">
                    로고이미지
                </div>
                <h4>login form</h4>
                <h6 class="font-weight-light">Sign in to continue.</h6>
                <form class="pt-3">
                    <div class="form-group">
                        <input type="text" class="form-control form-control-lg" id="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control form-control-lg" id="password"
                               placeholder="Password">
                    </div>
                    <div class="mt-3">
                        <a onclick="login()" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn"
                           href="#">SIGN IN</a>
                    </div>
                    <div class="my-2 d-flex justify-content-between align-items-center">
                        <div class="form-check">
                            <label class="form-check-label text-muted">
                                <input type="checkbox" class="form-check-input">
                                Keep me signed in
                            </label>
                        </div>
                        <a href="#" class="auth-link text-black">Forgot password?</a>
                    </div>

                    <div class="text-center mt-4 font-weight-light">
                        Don't have an account? <a href="/join" class="text-primary">Create</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function login() {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            // remember: $("#remember").prop("checked") // t or f
        };

        $.ajax("/login", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        }).done((res) => {
            if (res.data != null) {
                location.href = "/";
            } else {
                alert("로그인 실패");
            }
        });
    }
</script>
<%@ include file="../../layout/footer.jsp" %>