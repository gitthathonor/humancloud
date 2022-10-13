<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card position-relative">
                <div class="card-body d-flex">
                	<div>
                		<a href="/recruit/detail/${recruit.recruitId}">공고 제목</a>
                	</div>
                	<div>
                	<button type="button" class="btn btn-primary">Primary</button>
                	<button type="button" class="btn btn-outline-primary btn-fw">Primary</button>
                	</div>
                </div>
              </div>
            </div>
          </div>
<%@ include file="layout/footer.jsp" %>