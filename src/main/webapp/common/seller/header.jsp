<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="${pageContext.request.contextPath}/seller/home"> <img src="${url}/admin/layout/img/logo.png"
				alt="logo" class="logo-default" />
			</a>
			<div class="menu-toggler sidebar-toggler hide">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler"
			data-toggle="collapse" data-target=".navbar-collapse"> </a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">


				<!-- BEGIN USER LOGIN DROPDOWN -->
				<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
				<li class="dropdown dropdown-user"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true"> 
					<%-- <img alt="" class="img-circle" src="${url}/admin/layout/img/avatar3_small.jpg"/> --%>
					<c:url value="/image?fname=${acc.anh}" var="imgUrl"></c:url>
						<li class="header__navbar-item header__navbar-user"><img height="30" width="30"
					src="${imgUrl}"
					alt="" class="img-circle">
						<span class="username username-hide-on-mobile">
							${acc.fullName} </span> <i class="fa fa-angle-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li><a
							href="${pageContext.request.contextPath}/seller/acount?userid=${acc.uid}">
								<i class="icon-user"></i> My Profile
						</a></li>

						<c:choose>
							<c:when test="${acc.isAdmin == 1}">
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/admin/home">Trang admin</a></li>
							</c:when>
						</c:choose>

						<li><a
							href="${pageContext.request.contextPath}/home">
								<i class="icon-calendar"></i> Đến trang mua hàng
						</a></li>
						
						<li><a
							href="${pageContext.request.contextPath}/seller/change-pass?userid=${acc.uid}">
								<i class="icon-calendar"></i> Đổi mật khẩu
						</a></li>
						
						<li><a href="${pageContext.request.contextPath}/logout">
								<i class="icon-key"></i> Đăng xuất
						</a></li>
					</ul></li>
				<!-- END USER LOGIN DROPDOWN -->


			</ul>
		</div>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END HEADER INNER -->
</div>
