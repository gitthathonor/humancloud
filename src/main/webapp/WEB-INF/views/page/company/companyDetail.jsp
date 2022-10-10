<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../layout/header.jsp"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
<div>
	<div class="row">
		<div class="col-sm-9">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<h3>기업 정보</h3>
							<div style="margin: 0 100px 0 0;"></div>
							<button>
								<i class="fa-regular fa-heart"></i>
								<span>관심기업등록</span>
							</button>
						</div>
						<div style="margin: 20px 0 0 0;"></div>
						<div style="border-bottom: 1px solid #aaa"></div>
						<div style="margin: 30px 0 0 0;"></div>
						<div class="row">
							<div class="col-xs-3 col-sm-3">
								<img src="/img/${company.companyLogo}" style="width: 184px; height: 56px;" class="img-thumbnail" />
							</div>
							<div class="col-xs-4 col-sm-6">
								<ul class="list-unstyled">
									<li style="font-size: 22px; font-weight: bold;">${company.companyName}</li>
									<div style="margin: 20px 0 0 0;"></div>
									<li style="font-size: 16px;"><i class="ti-mobile"></i> ${company.companyPhoneNumber}</li>
									<div style="margin: 10px 0 0 0;"></div>
									<li style="font-size: 16px;"><i class="ti-email"></i> ${company.companyEmail}</li>
									<div style="margin: 10px 0 0 0;"></div>
									<li style="font-size: 16px;"><i class="ti-desktop"></i> ${company.companyAddress}</li>
								</ul>
							</div>
							<%-- col-xs-4 col-sm-6 --%>
						</div>
						<%-- row --%>
					</div>
				</div>
			</div>



		</div>
		<%-- col-sm-9 --%>
	</div>
	<%-- row --%>
	<div style="margin: 20px 0 0 0;"></div>
	<div style="border-bottom: 1px solid #aaa"></div>
	<div style="margin: 30px 0 0 0;"></div>
	<div class="row text-center">
		<div class="col-md-4 col-xl-4  stretch-card pricing-card ">
			<div class="card border border-primary center-block ">
				<h3 class="mt-3 ml-2">학력사항</h3>
				<hr class="border-primary" />
				<p class="m-3 plan-cost text-primary">학력</p>
			</div>
			<%-- card border border-primary center-block --%>
		</div>
		<%-- col-md-4 col-xl-4  stretch-card pricing-card --%>
		<div class="col-md-4 col-xl-4  stretch-card pricing-card">
			<div class="card border border-success">
				<h3 class="mt-3 ml-2">경력사항</h3>
				<hr class="border-success" />
				<p class="m-3 plan-cost text-success">경력</p>
			</div>
			<%-- card border border-primary center-block --%>
		</div>
		<%-- col-md-4 col-xl-4  stretch-card pricing-card --%>
		<div class="col-md-4 col-xl-4  stretch-card pricing-card">
			<div class="card border border-primary">
				<h3 class="mt-3 ml-2">원하는직업</h3>
				<hr class="border-primary" />
				<p class="m-3 plan-cost text-primary">직업</p>
			</div>
			<%-- card border border-primary center-block --%>
		</div>
		<%-- col-md-4 col-xl-4  stretch-card pricing-card --%>
	</div>
	<%-- row text-center --%>
	<div style="margin: 30px 0 0 0;"></div>
	<div style="border-bottom: 1px solid #aaa"></div>
	<div style="margin: 30px 0 0 0;"></div>
	<div class="row">
		<div class="d-flex">
			<div class="mr-2">
				<a href="/company/updateForm/${company.companyId}"><button type="button" class="btn btn-outline-info btn-icon-text">
					<i class="ti-file btn-icon-prepend"></i> 기업 정보 수정하기
				</button></a>
			</div>
			<%-- mr-2 --%>
			<div class="mr-2">
				<button type="button" class="btn btn-outline-info btn-icon-text">
					<i class="ti-trash btn-icon-prepend"></i> 기업 정보 삭제하기
				</button>
			</div>
			<%-- mr-2 --%>
		</div>
		<%-- d-flex --%>
	</div>
	<%-- row --%>
</div>
<%-- row --%>





<%@ include file="../../layout/footer.jsp"%>