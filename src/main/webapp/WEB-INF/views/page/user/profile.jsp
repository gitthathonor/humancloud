<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class=" col-md-3 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <div class="py-5 px-3 border-bottom">
                <div><img class="w-100" src="/img/${resume.resume[0].resumePhoto}"></div>
                <div class="text-center p-3">${user.email}</div>
                <div class="text-center px-3">${user.phoneNumber}</div>
                <div class="text-center py-4 my-3 btn-primary rounded">#백엔드 #자바</div>
            </div>
            <div class="p-3 border-bottom d-flex justify-content-around">
                <div class="">
                    <div class="my-2">관심있음</div>
                    <div class="my-2">열람</div>
                    <div class="my-2">받은 제안</div>

                </div>
                <div class="">
                    <div class=" font-weight-bold my-2">0</div>
                    <div class=" font-weight-bold my-2">0</div>
                    <div class=" font-weight-bold my-2">0</div>

                </div>
            </div>
            <div class="py-3 px-3 text-center d-flex justify-content-around">
                <div class="btn btn-inverse-dark btn-fw"><a class="text-black" href="/update/${sessionScope.principal}">회원정보수정</a></div>
                <div class="btn btn-inverse-dark btn-fw" onclick='deleteUser("${sessionScope.principal}")'>계정탈퇴</div>
            </div>
        </div>
    </div>
</div>

<script>
function deleteUser(id) {
	$.ajax("/user/" + id, { 
		type: "DELETE",
		dataType: "json"
	}).done((res) => {
		if (res.code == 1) {
			alert("회원탈퇴완료");
			location.href = "/";
		} else {
			alert("회원탈퇴실패");
		}
	});
}
</script>