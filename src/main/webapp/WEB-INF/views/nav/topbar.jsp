<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a class="navbar-brand brand-logo mr-5" href="/"><img src="images/devridge.jpg" class="mr-2" alt="logo"
            style="width:80px; height: 60px;" /></a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">

        <!-------------검색창-------------->
        <ul class="navbar-nav mr-lg-2">
          <li class="nav-item nav-search d-none d-lg-block">
            <div class="input-group">
              <div class="input-group-prepend hover-cursor" id="navbar-search-icon">
                <span class="input-group-text" id="search">
                  <i class="icon-search"></i>
                </span>
              </div>
              <input type="text" class="form-control" id="navbar-search-input" placeholder="Search now"
                aria-label="search" aria-describedby="search">
            </div>
          </li>
        </ul>

        <div id="boxAlarm">
          뭐가 적어짐 여기?
        </div>


        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown">
            <c:choose>
              <c:when test="${empty sessionScope}">
                <div style="margin: 0 10px;">
                  <a class="text-white" href="/login"><button type="button" class="btn btn-primary">로그인 </button></a>
                  <a class="text-primary" href="/join"><button type="button"
                      class="btn btn-outline-primary">회원가입</button></a>
                </div>
              </c:when>
              <c:otherwise>
                <!---------로그인 후--------->
                <!-----------알림창------------>
                <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#"
                  data-toggle="dropdown">
                  <i class="icon-bell mx-0"></i>
                  <span class="count"></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
                  aria-labelledby="notificationDropdown">
                  <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-success">
                        <i class="ti-info-alt mx-0"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <h6 class="preview-subject font-weight-normal">Application Error</h6>
                      <p class="font-weight-light small-text mb-0 text-muted">
                        Just now
                      </p>
                    </div>
                  </a>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-warning">
                        <i class="ti-settings mx-0"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <h6 class="preview-subject font-weight-normal">Settings</h6>
                      <p class="font-weight-light small-text mb-0 text-muted">
                        Private message
                      </p>
                    </div>
                  </a>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-info">
                        <i class="ti-user mx-0"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <h6 class="preview-subject font-weight-normal">New user registration</h6>
                      <p class="font-weight-light small-text mb-0 text-muted">
                        2 days ago
                      </p>
                    </div>
                  </a>
                </div>
          </li>
          <!------------로그인후 아이콘------------>
          <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
              <img src="images/faces/face28.jpg" alt="profile" />
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
              <c:choose>
                <c:when test="${!empty principal.userId}">
                  <a href="/mypage?id=${sessionScope.principal.userId}" class="dropdown-item">
                    <i class="ti-settings text-primary"></i>
                    MyPage
                  </a>
                </c:when>
                <c:when test="${!empty companyPrincipal.companyId}">
                  <a href="/company/mypage?id=${sessionScope.companyPrincipal.companyId}" class="dropdown-item">
                    <i class="ti-settings text-primary"></i>
                    MyPage
                  </a>
                </c:when>
              </c:choose>
              <a href="/logout" class="dropdown-item">
                <i class="ti-power-off text-primary"></i>
                Logout
              </a>
            </div>
            </c:otherwise>
            </c:choose>
          </li>
        </ul>
      </div>

    </nav>



<c:choose>
  <c:when test="${!empty principal.userId}">
    <input class="checkUser" type="hidden" value="${sessionScope.principal.username}">
  </c:when>
  <c:when test="${!empty companyPrincipal.companyId}">
    <input class="checkUser" type="hidden" value="${sessionScope.companyPrincipal.companyName}">
  </c:when>
</c:choose>

<script src="/socket/webSocket.js"></script>
