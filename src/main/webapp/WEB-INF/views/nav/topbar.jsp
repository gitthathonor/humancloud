<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
    <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
      <a class="navbar-brand brand-logo mr-5" href="/"><img src="images/logo.svg" class="mr-2"
          alt="logo" /></a>
      <a class="navbar-brand brand-logo-mini" href="/"><img src="images/logo-mini.svg" alt="logo" /></a>
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


      <ul class="navbar-nav navbar-nav-right">
        <li class="nav-item dropdown">
          <c:choose>
          <c:when test="${empty principal}">
            <div style="margin: 0 10px;">
              <button type="button" class="btn btn-primary"><a class="text-white" href="/login">로그인</a> </button>
              <button type="button" class="btn btn-outline-primary"><a class="text-primary" href="/join">회원가입</a></button>
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
            <a href="/mypage?id=${sessionScope.principal}" class="dropdown-item">
              <i class="ti-settings text-primary"></i>
              MyPage
            </a>
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