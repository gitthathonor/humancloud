<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>
        
<div class="col-5 card">
    <div class="card-body">
        <h4 class="card-title">구직자 정보</h4>
            <form class="form-horizontal">
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
                    <div class="form-group">
                    <div><label for="exampleInputFile">파일 업로드</label></div>
                        <input type="file" id="exampleInputFile">
                    </div><%-- form-group--%>
                    <div style="border-bottom: 1px solid #aaa"></div>
                    <div style="margin: 20px 0 0 0;"></div>
                    <h4 class="card-title">학력 정보</h4>                      
                    <div class="btn-group m-4" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-primary">고졸</button>
                        <button type="button" class="btn btn-primary">대졸</button>
                    </div><%-- btn-group m-4 --%>
                    <div style="border-bottom: 1px solid #aaa"></div>
                    <div style="margin: 20px 0 0 0;"></div>
                    <h4 class="card-title">경력 사항</h4>
                    <div style="margin: 20px;">
                        <select class="col-5 form-control">
                            <option>경력선택</option>
                            <option>신입</option>
                            <option>1년미만</option>
                            <option>1년이상 ~ 3년미만</option>
                            <option>3년이상 ~ 5년미만</option>
                            <option>6년이상</option>
                        </select>
                    </div><%-- margin 적용 div --%>
                    <div style="border-bottom: 1px solid #aaa"></div>
                    <div style="margin: 20px 0 0 0;"></div>
                    <h4 class="card-title">직무</h4>
                    <div>                        
                        <label class="checkbox-inline">
                            <input type="checkbox" id="inlineCheckbox1" value="option1"> 웹 개발자
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="inlineCheckbox2" value="option2"> 프론트 개발자
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="inlineCheckbox3" value="option3"> 백 개발자
                        </label>
                    </div>
                </div><%-- form-group --%>
                <div>
                    <div class="btn-group m-4" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-primary">작성완료</button>
                    </div><%-- btn-group m-4 --%>
                </div>
            </form><%-- form-horizontal --%>
        </div><%-- form-group --%>
    </div><%-- card-body --%>
</div><%-- card --%>
<%@ include file="../../layout/footer.jsp" %>
