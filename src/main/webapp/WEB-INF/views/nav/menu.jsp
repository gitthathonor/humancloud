<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
      <li class="nav-item">
        <a class="nav-link" href="#">
          <i class="icon-head menu-icon"></i>
          <span class="menu-title">채용</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
          <i class="icon-columns menu-icon"></i>
          <span class="menu-title">기업</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/resume">
          <i class="icon-paper menu-icon"></i>
          <span class="menu-title">이력서</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
          <i class="icon-contract menu-icon"></i>
          <span class="menu-title">커뮤니티</span>
        </a>
      </li>
      <li class="nav-item">
          <c:choose>
          <c:when test="${empty sessionScope.principal}">
            <a class="nav-link" href="/login">
          </c:when>
          <c:otherwise>
            <a class="nav-link" href="/mypage?id=${sessionScope.principal}">
          </c:otherwise>
          </c:choose>
          <i class="icon-grid-2 menu-icon"></i>
          <span class="menu-title">마이페이지</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-toggle="collapse" href="#error" aria-expanded="false" aria-controls="error">
          <i class="icon-ban menu-icon"></i>
          <span class="menu-title">Error pages</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="error">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item"> <a class="nav-link" href="pages/samples/error-404.html"> 404 </a></li>
            <li class="nav-item"> <a class="nav-link" href="pages/samples/error-500.html"> 500 </a></li>
          </ul>
        </div>
      </li>
    </ul>
  </nav>