<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col grid-margin stretch-card">
	<div class="card">
		<div class="card-body">
			<p class="card-title mb-0 p-3">추천 기업 리스트</p>
			<div class="table-responsive p-3">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>로고</th>
							<th>기업명</th>
							<th>email</th>
							<th>주소</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="company" items="${companyList}">
							<tr>
								<td><img src="/img/${company.companyLogo}" style="width: 184px; height: 56px; border-radius: 0" class="img-thumbnail"></td>
								<td class="font-weight-bold"><a href="/company/detail/${company.companyId}">${company.companyName}</a></td>
								<td>${company.companyEmail}</td>
								<td class="font-weight-medium">${company.companyAddress}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<a href="/company/saveForm">기업등록</a>


<div class="d-flex justify-content-center m-5">

	<div class="w-75 d-flex justify-content-between">
		<div class="btn-group">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
			<button type="button" class="btn btn-primary">Sony</button>
			<button type="button" class="btn btn-primary">Sony</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<div class="dropdown">
			<button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuSizeButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuSizeButton2">
				<h6 class="dropdown-header">Settings</h6>
				<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Separated link</a>
			</div>
		</div>
	</div>
</div>


<div class="d-flex justify-content-center m-5">
	<div class="w-75 stretch-card transparent">
		<div class="card px-4">
			<div class="card-body row">
				<div class="bg-danger col-2" style="width: 200px">사진</div>
				<div class="col-8 px-5">
					<p class="mb-4">backend, java, web</p>
					<p class="fs-30 mb-2">title</p>
					<p>2000.1.1</p>
				</div>
				<div class="col-2 d-flex flex-wrap align-content-center">
					<button type="submit" class="btn btn-outline-danger">지원하기</button>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>