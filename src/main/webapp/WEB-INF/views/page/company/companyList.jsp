<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layout/header.jsp" %>
<div class="col grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title mb-0 p-3"> 추천 매칭 리스트</p>
                  <div class="table-responsive p-3">
                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>기업명/이력서제목</th>
                          <th>공고명/이력서분야?</th>
                          <th>Date</th>
                          <th>구직현황/이력서등록현황</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>Search Engine Marketing</td>
                          <td class="font-weight-bold">백엔드엔지니어링</td>
                          <td>21 Sep 2018</td>
                          <td class="font-weight-medium">
                            <div class="badge badge-success">모집중</div>
                          </td>
                        </tr>
                        <tr>
                          <td>Search Engine Optimization</td>
                          <td class="font-weight-bold">주거인테리어웹디자이너</td>
                          <td>13 Jun 2018</td>
                          <td class="font-weight-medium">
                            <div class="badge badge-success">모집중</div>
                          </td>
                        </tr>
                        <tr>
                          <td>E-Mail Marketing</td>
                          <td class="font-weight-bold">펌웨어하드웨어개발자</td>
                          <td>01 Nov 2018</td>
                          <td class="font-weight-medium">
                            <div class="badge badge-danger">임박</div>
                          </td>
                        </tr>
                        <tr>
                          <td>Pay Per Click Advertising</td>
                          <td class="font-weight-bold">시스템앤지니어</td>
                          <td>30 Jun 2018</td>
                          <td class="font-weight-medium">
                            <div class="badge badge-warning">완료</div>
                          </td>
                        </tr>
                        <tr>
                          <td>운동하는 개발자입니다</td>
                          <td class="font-weight-bold">자바 개발자, IOS 개발자</td>
                          <td>30 Jun 2018</td>
                          <td class="font-weight-medium">
                            <div class="badge badge-warning">미등록</div>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>


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
                      <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuSizeButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown
                      </button>
                      <div class="dropdown-menu" aria-labelledby="dropdownMenuSizeButton2">
                        <h6 class="dropdown-header">Settings</h6>
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
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
                        <div class="bg-danger col-2" style="width:200px">사진</div>
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
<%@ include file="../../layout/footer.jsp" %>