<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../../layout/header.jsp" %>
   <form>
		<div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label"> 이름 : </label>
                        <div class="col-sm-10">
                            <input type="text" class="col-5 form-control" id="inputEmail3" placeholder="이름 입력란">
                        </div><%-- col-sm-10 --%>
                    </div><%-- col-sm-2 control-label --%>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label"> 이메일 : </label>
                        <div class="col-sm-10">
                            <input type="email" class="col-5 form-control" id="inputPassword3" placeholder="이메일 입력란">
                        </div><%-- col-sm-10 --%>
                    </div><%-- form-group--%>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label"> 전화번호 : </label>
                        <div class="col-sm-10">
                            <input type="tel" class="col-5 form-control" id="inputPassword3" placeholder="전화번호 입력란">
                        </div><%-- col-sm-10 --%>
                    </div><%-- form-group--%>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label"> 주소 : </label>
                        <div class="col-sm-10">
                            <input type="text" class="col-9 form-control" id="inputPassword3" placeholder="주소 입력란">
                        </div><%-- col-sm-10 --%>
                    </div><%-- form-group--%>                                                             

                        <div class="col-sm-10">
                            <input type="text" class="col-5 form-control" id="title" placeholder="이력서 이름 입력란" value="${resume.resumeTitle}">
                        </div><%-- col-sm-10 --%>
                    <div class="form-group">
                    <div><label for="file">파일 업로드</label></div>
                        <input type="file" id="file" onchange="setThumbnail(event)"/>
                    <div id="image_container">
                        <img id ="oldImg" src="/img/${resume.resumePhoto}">
                    </div>              
                    </div><%-- form-group--%>
                    <div style="border-bottom: 1px solid #aaa"></div>
                    <div style="margin: 20px 0 0 0;"></div>
                    <h4 class="card-title">학력 정보</h4>                      
                    <div class="btn-group m-4" role="group" aria-label="Basic example" id="education">
                        <input id = "education" name="education" type="radio" class="btn btn-primary" value="고졸" >고졸
                        <input id = "education" name="education" type="radio" class="btn btn-primary" value="대졸" >대졸
                    </div><%-- btn-group m-4 --%>
                    <div style="border-bottom: 1px solid #aaa"></div>
                    <div style="margin: 20px 0 0 0;"></div>
                    <h4 class="card-title">경력 사항</h4>
                    <div style="margin: 20px;">
                        <select id="resumeCareer" class="col-5 form-control">
                            <option>경력선택</option>
                            <option value="신입">신입</option>
                            <option value="1년미만">1년미만</option>
                            <option value="1년이상 ~ 3년미만">1년이상 ~ 3년미만</option>
                            <option value="3년이상 ~ 5년미만">3년이상 ~ 5년미만</option>
                            <option value="6년이상">6년이상</option>
                        </select>
                    </div><%-- margin 적용 div --%>
                    <div style="border-bottom: 1px solid #aaa"></div>
                    <div style="margin: 20px 0 0 0;"></div>
                    <h4 class="card-title">사용 블로그</h4>
                     <div class="col-sm-10">
                        <input type="text" class="col-5 form-control" id="blog" placeholder="깃허브 주소나 블로그주소를 입력해주세요"value="${resume.resumeLink}">
                    </div><%-- col-sm-10 --%>
                    <div style="border-bottom: 1px solid #aaa"></div>
                    <div style="margin: 20px 0 0 0;"></div>
                    <h4 class="card-title">직무</h4>
                    <div id="categorys">                        
                        <label class="checkbox-inline">
                            <input type="checkbox"  id="categoryName" name="categoryName" value="웹 개발자"> 웹 개발자
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="categoryName" name="categoryName"  value="프론트 개발자"> 프론트 개발자
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox"  id="categoryName" name="categoryName"  value="백 개발자"> 백 개발자
                        </label>
                    </div><%-- #categorys --%>
                </div><%-- form-group --%>
            <div>
                <div class="btn-group m-4" role="group" aria-label="Basic example">
                    <button type="button" class="btn btn-primary" id="btnSave">작성완료</button>
                </div><%-- btn-group m-4 --%>
            </div><%-- form-horizontal --%>
            <div >
            <input id="resumeId" type ="text" value='${resume.resumeId}'/>
            <c:forEach var="category" items="${category}">
                <input id = "asd" name="asd" type ="text" value='${category.categoryName}'/>
            </c:forEach> 
            </div> 
	</form>

<script>

    // 라디오 버튼 값 가져오기
    document.querySelector("#education input[value=${resume.resumeEducation}]").setAttribute('checked' , true);
   
    // 드롭박스 값 가져오기
    $("#resumeCareer").val('${resume.resumeCareer}');


    function setThumbnail(event) {
        let reader = new FileReader();

        reader.onload = function(event) {
            let img = document.createElement("img");
            let oldImg = $("#oldImg");
            oldImg.remove();
            img.setAttribute("src", event.target.result);
            document.querySelector("#image_container").appendChild(img);
        };
        reader.readAsDataURL(event.target.files[0]);
    }

	$("#btnSave").click(()=>{
		Save();
	});
	function Save(){
        let categoryName = new Array();
        let education = "";

        let resumeId = $("#resumeId").val();

        $('input[type=radio][name=education]').each(function() {
            if($(this).is(":checked") == true){
                education =$(this).val();
            }
        });
    	$("input:checkbox[name='categoryName']").each(function() {
    		if ($(this).is(":checked ") == true) {
    			categoryName.push($(this).val());
            }
    	});

         let formData = new FormData();
         
		let data ={
            resumeId : resumeId,
            resumeTitle : $("#title").val(),
            resumeEducation : education,
            resumeCareer : $("#resumeCareer option:selected").val(),
            resumeLink : $("#blog").val(),
            categoryList : categoryName
		}

        formData.append('file', $("#file")[0].files[0]);
		formData.append('updateDto', new Blob([ JSON.stringify(data) ], {type : "application/json"}));
		
		$.ajax("/resume/update/"+resumeId,{
			type : "PUT",
			data : formData,
			processData: false,    
       		contentType: false, 
			enctype : 'multipart/form-data'
		}).done((res) => {
			if (res.code == 1) {
				alert("이력서 수정 성공");
				}
			});
		}
        
</script>
<%@ include file="../../layout/footer.jsp" %>