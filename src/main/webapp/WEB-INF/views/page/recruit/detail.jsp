<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../../layout/header.jsp" %>


        <!-- 기업사진 명 등-->
        <div class="row" style="height: 300;">
            <div class="col-md-4">
                <div class="card tale-bg">
                    <div class="card-people">
                        <img src="/img/${Recruit.company.companyLogo}" alt="people">
                    </div>
                </div>
            </div>


            <div class="col-md-8  transparent">
                <div>

                    <p class="card-title"></p>${Recruit.company.companyName}</p>
                    <h2 class="text-primary">${Recruit.recruitTitle}</h2>

                </div>

                <div>
                    <div class="mt-5">
                        <p><span>#${Category.categoryName}</span></p>
                        <p><span>근무지 : ${Recruit.recruitLocation}</span></p>
                    </div>
                </div>
            </div>
        </div>
        <hr />

        <div class="row">
            <div class="col-md-4 col-xl-4  stretch-card pricing-card">
                <div class="card border border-primary">
                    <h3 class="mt-3 ml-2">지원 자격</h3>
                    <hr class="border-primary" />

                    <p class="m-3 plan-cost text-primary">경력 :${Recruit.recruitCareer} </p>
                    <p class="m-3 plan-cost text-primary">연봉 :${Recruit.recruitSalary} </p>
                </div>
            </div>

            <div class="col-md-8 col-xl-8  stretch-card pricing-card">
                <div class="card border border-success">
                    <h3 class="mt-3 ml-2">회사 소개</h3>
                    <hr class="border-success" />

                    <p class="m-3 plan-cost text-success">회사 소개 내용 존농=ㅇㄴㄹ녀롬ㄴ뎌ㅑ로ㅑㅕㄴㅁㅈㄷ뢔ㅔㅁ 곳곳곳곳곳ㄱ속속솏곳곳곳곳</p>

                </div>
            </div>
        </div>
        <hr />
        <div class="row">
            <div class="d-flex">
                <div class="mr-2">
                    <button type="button" class="btn btn-primary btn-icon-text">
                        <i class="ti-file btn-icon-prepend"></i>
                        즉시지원하기
                    </button>
                </div>
                <div>
                    <button type="button" class="btn btn-outline-info btn-icon-text">
                        <i class="ti-upload btn-icon-prepend"></i>
                        공유하기기기
                    </button>
                </div>
            </div>

            <!-- 버튼 눌러 졌을 때
            <button type="button" class="btn btn-info btn-rounded btn-social-icon">
                <i class="ti-star"></i>
            </button>

            버튼 안눌러 졌을 때
            <button type="button" class="btn btn-outline-secondary btn-rounded btn-social-icon">
                <i class="ti-star text-primary"></i>
            </button> -->
        </div>
        <hr />

        <div class="row">
            <div class="card" style="width: 100%;">
                <div class="card-body">
                    <div class="d-flex justify-content">
                        <p class="card-title"></p>
                        <a href="#" class="text-info">Vist Company</a>
                    </div>
                    <p class="font-weight-500">회사내용
                        ㄹ더랴ㅐ덜ㄴ댜ㅐ런대ㅑ[러매[ㅑ허ㅗㅁㄷ개ㅑ호ㅜㅁㅇㄱ라;ㅓㅜㅁ대ㅓ먛ㅁㄴㄱ;ㅐ흐ㅓㅜㅁㄵ꺠ㅑㅎㅇㅁㄹ"ㅒㅠㅜㄴㄷ개ㅑㅓㅎㅍㄴㄱ'ㅐㅑ헌ㅁ"해ㅓㄴ'ㅇ먜ㅓㄴ'애ㅑ햐ㅐㄴ'</p>

                </div>

            </div>
            <div class="mr-2">
                <button style="font-style: white;" type="button" class="btn btn-success btn-icon-text"
                    onclick="goUpdate()">
                    <i class="ti-file btn-icon-prepend"></i>
                    수정하기
                </button>
            </div>
        </div>

        <hr />
        <div class="row">
            <div class="card" style="width: 100%;">
                <div class="card-body">
                    <p class="card-title">이 기업의 다른 공고</p>

                    <div class="dataTables_wrapper ">

                        <table class="display expandable-table dataTable no-footer" style="width: 100%;">
                            <thead>
                                <tr role="row">
                                    <!-- sorting_desc / sorting_asc 으로 해가지고 Ajax 로 ORDER BY 하는거 하면 리스트 정렬 가능-->
                                    <!-- 이름순, 추천순, 작성일자 순 -->
                                    <th class="select-checkbox sorting_desc" rowspan="1" colspan="1">
                                        No
                                        <!-- recruitId -->
                                    </th>
                                    <th class="select-checkbox sorting_asc" rowspan="1" colspan="2">
                                        공고
                                        <!-- recruitId -->
                                    </th>
                                    <th class="select-checkbox sorting_desc" rowspan="1" colspan="1">
                                        회사 이름
                                        <!-- recruitId -->
                                    </th>
                                    <th class="select-checkbox sorting_desc" rowspan="1" colspan="1">
                                        연봉
                                        <!-- recruitId -->
                                    </th>
                                    <th class="select-checkbox sorting_desc" rowspan="1" colspan="1">
                                        공고 시작 일자
                                        <!-- recruitId -->
                                    </th>

                                </tr>
                            </thead>
                            <tbody>
                                <!-- class = odd / even -->
                                <tr role="row">
                                    <td rowspan="1" colspan="1">번호</td>
                                    <td rowspan="1" colspan="2">그린컴퓨터아카데미 노예 모집 awfawfawfawfaw공고</td>
                                    <td rowspan="1" colspan="1">Green Academe</td>
                                    <td rowspan="1" colspan="1">$8888</td>
                                    <td rowspan="1" colspan="1">25/04/2020</td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>

        <%@ include file="../../layout/footer.jsp" %>