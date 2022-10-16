<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<c:forEach begin="1" end="4">
	<div class="col-md-3 grid-margin stretch-card recommend">
		<div class="card">
			<div class="card-people" style="padding: 0 0 0 0; margin: 0 0.1px 0 0.1px;">
				<img src="/img/home-gc381fbfc1_1280.jpg"
					style="border-bottom-left-radius: 0; border-bottom-right-radius: 0;">
			</div>
			<div class="row container d-flex justify-content-between">
				<h3>기업명</h3>
				<p>간단한 기업 소개</p>
				<p>
					<i></i><span>좋아요 수</span>
				</p>
			</div>
		</div>
	</div>
	</c:forEach>
</div>



<!-- 기업 리스트 출력(추천순,업력순, )  -->
<c:forEach var="company" items="${companyList}">
<div class="row d-flex justify-content-center">
	<div class="col-md-9 grid-margin stretch-card" style="margin: 0 0 10px 0">
		<div class="card position-relative" style="border: 1px solid;">
			<div class="card-body d-flex justify-content-between align-items-center">
				<div id="recruit-content" class="d-flex justify-content-between align-items-center">
					<div>
						<div>
							<img src="/img/${company.companyLogo}" style="width: 120px; height: 40px;">
						</div>
					</div>
					<div>
						<a href="/company/${company.companyId}" style="font-size: 16px; color: #1F1F1F;">${company.companyName}</a>
					</div>
				</div>
				<div class="d-flex justify-content-between align-items-center">
					<div>
						<i></i><span style="margin: 0 10px 0 0">조회수</span>
					</div>
					<div>
						<button type="button" class="btn btn-outline-primary btn-fw">상세보기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</c:forEach>


<%@ include file="../../layout/footer.jsp"%>