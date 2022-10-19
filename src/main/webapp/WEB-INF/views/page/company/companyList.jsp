<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../../layout/header.jsp" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<!-- <div class="row">
	<c:forEach begin="1" end="4">
	<div class="col-md-3 grid-margin stretch-card recommend">
		<div class="card">
			<div class="card-people" style="padding: 0 0 0 0; margin: 0 0.1px 0 0.1px;">
				<img src="/images/company_best.jpg"
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
 -->

			<!-- 기업 리스트 출력(추천순,업력순)  -->
			<!-- <c:forEach var="company" items="${companyList}">
				<div class="row d-flex justify-content-center">
					<div class="col-md-9 grid-margin stretch-card" style="margin: 0 0 10px 0">
						<div class="card position-relative" style="border: 1px solid;">
							<div class="card-body d-flex justify-content-between align-items-center">
								<div id="recruit-content" class="d-flex justify-content-between align-items-center">
									<div>
										<div>
											<img src="/img/${company.companyLogo}" style="width: 110px; height: 50px;">
										</div>
									</div>
									<div>
										<h3>${company.companyName}</h3>
										<p>현재 채용중</p>
									</div>
								</div>
								<div class="d-flex justify-content-between align-items-center">
									<div>
										<i></i><span style="margin: 0 10px 0 0">조회수</span>
									</div>
									<div>
										<a href="/company/${company.companyId}"
											style="font-size: 16px; color: #1F1F1F;"><button type="button"
												class="btn btn-outline-primary btn-fw">상세보기</button></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach> -->

			<!-- 새로 짤 리스트 css -->
			<div class=" m-3">
				<div class="d-flex justify-content-between">
					<div class="btn-group">
						<c:forEach var="category" items="${recruits.category}">
							<button onclick='btnCategory("${category.categoryName}")'
								class="btn btn-primary">${category.categoryName}</button>
						</c:forEach>
					</div>
					<div class="dropdown">
						<select id="btnOrder" onchange="orderDo(this.value, ${sessionScope.principal.userId})"
							class="form-select dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							<option selected>정렬</option>
							<option value="recent">최신순</option>
							<option value="career">경력순</option>
							<option value="recommend">추천순</option>
						</select>
					</div>
				</div>
			</div>

			<div id="recruitCard" class="">
				<c:forEach var="company" items="${companyList}">
					<div class="card mb-3 mt-3">
						<div class="card-body row">
							<div class="col-10 px-5">
								<div>
									<img src="/img/${company.companyLogo}" style="width: 100px; height: px; "
										alt="${company.companyName}">
								</div>
								<!-- <p class="fs-30 mb-4 text-primary">${company.companyName}</p> -->
								<p class=""><span class=" text-primary">현재 채용중</span></p>
							</div>
							<div class="col-2 d-flex flex-wrap align-content-center">
								<a href="/company/${company.companyId}">
									<button type="button" class="btn btn-outline-primary">상세보기</button>
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>


			<%@ include file="../../layout/footer.jsp" %>