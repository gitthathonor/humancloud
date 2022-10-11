<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

내용작성

<button type="button" onclick='subscribeCompany(${sessionScope.principal})'>구독하기</button>
<input id="companyId" type="hidden" value="1">


<script>
    function subscribeCompany(userId){
        let data = {
            subscribeUserId : userId,
            subscribeCompanyId: $("#companyId").val()
        };


        $.ajax("/subscribe", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            if (res.code == 1) {
                alert("구독완료");
                // 나중에는 여기 기업 상세보기로 변경
                location.href = "/";
            }
        });
    }
</script>

<%@ include file="../layout/footer.jsp" %>
