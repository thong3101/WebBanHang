<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- BEGIN SIDEBAR -->
		<br>
		<br>
		<br>
		<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
				<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
				<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
				<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu1" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
					<li class="heading">
						<h3>GENERAL</h3>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/admin/home">
						<i class="icon-home"></i>
						<span class="title">Dashboard</span>
						</a>
					</li>
					
					<li>
						
					
							<li>
								<a href="${pageContext.request.contextPath}/admin/user/list">
								<i class="icon-basket"></i>
								User</a>
							</li>
							
							<li>
								<a href="${pageContext.request.contextPath}/admin/category/list">
								<i class="icon-handbag"></i>
								Category</a>
							</li>
							
							<li>
								<a href="${pageContext.request.contextPath}/admin/cart">
								<i class="icon-pencil"></i>
								Quản lí các giỏ hàng</a>
							</li>
						
					</li>
					
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
		<!-- END SIDEBAR -->