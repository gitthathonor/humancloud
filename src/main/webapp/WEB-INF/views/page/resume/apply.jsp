<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>






<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    지원하기
</button>
<input hidden id="recruitId" value="1">

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">이력서를 선택해주세요</h5>
                <button type="button" class=" btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:forEach var="resume" items="${resume}">
                <div class="form-check">
                    <div>
                        <label class="form-check-label">
                        <input type="radio" class="form-check-input"  name="applyByResumeId" value="${resume.resumeId}">
                        <i class="input-helper"></i></label>
                        <div class="m-5 p-5 col-5 border" >
                            <h3>${resume.resumeTitle}</h3>
                            <p>${resume.resumeReadCount}</p>
                            <p>${resume.resumeCreatedAt}</p>
                        </div>
                    </div>    
                </div>   
                </c:forEach>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button id="btnSave" type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<script>

      $("#btnSave").click(() => {
                save();
        });
    
    $("#btnDelete").click(() => {
                delete();
        });

	function save(){
  
        let resumeId = "";

        $('input[type=radio][name=applyByResumeId]').each(function() {
            if($(this).is(":checked") == true){
                resumeId =$(this).val();
            }
        });
         
		let data ={
            applyResumeId : resumeId,
            applyRecruitId : $("#recruitId").val()
		}
        console.log(data);
		$.ajax("/apply/save",{
		 type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            if (res.code == 1) {
                alert("이력서를 지원하셨습니다.");
                location.href = "/";
            }
        });

    }

    function delete(){
        let data ={
            applyResumeId : $("#ResumeId").val(),
            applyRecruitId : $("#recruitId").val()
		}

        $.ajax("/subscribe/" + userId + "/" + companyId, {
            type: "DELETE",
            dataType: "json"
        }).done((res) => {
            if (res.code == 1) {
                alert("구독삭제완료");
                location.reload();
            } else {
                alert("오류");
            }
        });

    }

</script>
 

<%@ include file="../../layout/footer.jsp" %>
