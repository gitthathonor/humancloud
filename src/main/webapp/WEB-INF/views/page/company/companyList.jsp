<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-12 grid-margin stretch-card">
		<div class="card position-relative">
			<div class="card-body">
				<div id="detailedReports" class="carousel slide detailed-report-carousel position-static pt-2" data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<div class="row">
								<div class="col-md-12 col-xl-3 d-flex flex-column justify-content-start">
									<div class="ml-xl-4 mt-3">
										<p class="card-title">card title</p>
										<h1 class="text-primary">기업명</h1>
										<h3 class="font-weight-500 mb-xl-4 text-primary">North America</h3>
										<p class="mb-2 mb-xl-0">The total number of sessions within the date range. It is the period time a user is actively engaged with your website, page or app, etc</p>
									</div>
								</div>
								<div class="col-md-12 col-xl-9">
									<div class="row">
										<div class="col-md-6 border-right">
											<div class="table-responsive mb-3 mb-md-0 mt-3">
												<table class="table table-borderless report-table">
													<tr>
														<td class="text-muted">여기에</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-primary" role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">713</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">분야나</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-warning" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">583</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">분류별로</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-danger" role="progressbar" style="width: 95%" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">924</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">선호도</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-info" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">664</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">나와도</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-primary" role="progressbar" style="width: 40%" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">560</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">좋을듯</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-danger" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">793</h5>
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div class="col-md-6 mt-3">
											<h3>여기다 아마 사진 넣을 듯</h3>
											<!-- <canvas id="north-america-chart"></canvas>
                        <div id="north-america-legend"></div> -->
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<div class="row">
								<div class="col-md-12 col-xl-3 d-flex flex-column justify-content-start">
									<div class="ml-xl-4 mt-3">
										<p class="card-title">Detailed Reports</p>
										<h1 class="text-primary">기업명2</h1>
										<h3 class="font-weight-500 mb-xl-4 text-primary">North America</h3>
										<p class="mb-2 mb-xl-0">The total number of sessions within the date range. It is the period time a user is actively engaged with your website, page or app, etc</p>
									</div>
								</div>
								<div class="col-md-12 col-xl-9">
									<div class="row">
										<div class="col-md-6 border-right">
											<div class="table-responsive mb-3 mb-md-0 mt-3">
												<table class="table table-borderless report-table">
													<tr>
														<td class="text-muted">Illinois</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-primary" role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">713</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">Washington</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-warning" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">583</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">Mississippi</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-danger" role="progressbar" style="width: 95%" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">924</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">California</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-info" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">664</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">Maryland</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-primary" role="progressbar" style="width: 40%" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">560</h5>
														</td>
													</tr>
													<tr>
														<td class="text-muted">Alaska</td>
														<td class="w-100 px-0">
															<div class="progress progress-md mx-4">
																<div class="progress-bar bg-danger" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</td>
														<td>
															<h5 class="font-weight-bold mb-0">793</h5>
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div class="col-md-6 mt-3">
											<h1>사진</h1>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#detailedReports" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#detailedReports" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 grid-margin stretch-card">
		<div class="card position-relative">
			<div class="card-body">
				<div class="d-flex flex-column justify-content-center m-5">
					<c:forEach var="company" items="${companyList}">
						<div class="w-75 stretch-card transparent">
							<div class="card px-4">
								<div class="card-body row d-flex align-items-center" style="border: solid 1px;">
									<div>
										<img src="/img/${company.companyLogo}" style="width: 120px; height: 44px;" />
									</div>
									<div class="col-8 px-5">
										<p class="fs-30 mb-1">
											<a href="/company/${company.companyId}">${company.companyName}</a>
										</p>
										<p>현재 채용중</p>
									</div>
									<div class="col-2 d-flex flex-wrap align-content-center">
										<button type="submit" class="btn btn-outline-primary">
											<span style="font-size: 12px">상세보기</span>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div style="margin: 0 0 20px 0"></div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../../layout/footer.jsp"%>