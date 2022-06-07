<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>




<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN PAGE HEAD -->
		<div class="page-head">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>
					Dashboard <small>statistics & reports</small>
				</h1>
			</div>
			<!-- END PAGE TITLE -->
			<!-- BEGIN PAGE TOOLBAR -->
			<div class="page-toolbar">
				<!-- BEGIN THEME PANEL -->
				<div class="btn-group btn-theme-panel">
					<a href="javascript:;" class="btn dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-settings"></i>
					</a>
					<div
						class="dropdown-menu theme-panel pull-right dropdown-custom hold-on-click">
						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-12">
								<h3>THEME</h3>
								<ul class="theme-colors">
									<li class="theme-color theme-color-default active"
										data-theme="default"><span class="theme-color-view"></span>
										<span class="theme-color-name">Dark Header</span></li>
									<li class="theme-color theme-color-light" data-theme="light">
										<span class="theme-color-view"></span> <span
										class="theme-color-name">Light Header</span>
									</li>
								</ul>
							</div>
							<div class="col-md-8 col-sm-8 col-xs-12 seperator">
								<h3>LAYOUT</h3>
								<ul class="theme-settings">
									<li>Theme Style <select
										class="layout-style-option form-control input-small input-sm">
											<option value="square" selected="selected">Square
												corners</option>
											<option value="rounded">Rounded corners</option>
									</select>
									</li>
									<li>Layout <select
										class="layout-option form-control input-small input-sm">
											<option value="fluid" selected="selected">Fluid</option>
											<option value="boxed">Boxed</option>
									</select>
									</li>
									<li>Header <select
										class="page-header-option form-control input-small input-sm">
											<option value="fixed" selected="selected">Fixed</option>
											<option value="default">Default</option>
									</select>
									</li>
									<li>Top Dropdowns <select
										class="page-header-top-dropdown-style-option form-control input-small input-sm">
											<option value="light">Light</option>
											<option value="dark" selected="selected">Dark</option>
									</select>
									</li>
									<li>Sidebar Mode <select
										class="sidebar-option form-control input-small input-sm">
											<option value="fixed">Fixed</option>
											<option value="default" selected="selected">Default</option>
									</select>
									</li>
									<li>Sidebar Menu <select
										class="sidebar-menu-option form-control input-small input-sm">
											<option value="accordion" selected="selected">Accordion</option>
											<option value="hover">Hover</option>
									</select>
									</li>
									<li>Sidebar Position <select
										class="sidebar-pos-option form-control input-small input-sm">
											<option value="left" selected="selected">Left</option>
											<option value="right">Right</option>
									</select>
									</li>
									<li>Footer <select
										class="page-footer-option form-control input-small input-sm">
											<option value="fixed">Fixed</option>
											<option value="default" selected="selected">Default</option>
									</select>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- END THEME PANEL -->
			</div>
			<!-- END PAGE TOOLBAR -->
		</div>
		<!-- END PAGE HEAD -->
		<!-- BEGIN PAGE BREADCRUMB -->
		<ul class="page-breadcrumb breadcrumb hide">
			<li><a href="#">Home</a><i class="fa fa-circle"></i></li>
			<li class="active">Dashboard</li>
		</ul>
		<!-- END PAGE BREADCRUMB -->
		<div class="row">
			<div class="col-md-12">
				<!-- Begin: life time stats -->
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i>Category
						</div>
					</div>

					<p class="text-danger">${mess}</p>
					<div class="portlet-body">
						<div class="table-container">
							<table id="tbl"
								class="table table-striped table-bordered table-condensed"
								style="width: 100%">
								<thead>
									<tr role="row" class="heading">
										<th width="10%">ID</th>
										<th width="15%">Tên Danh Mục</th>
										<th width="15%">Hành động</th>
								</thead>
								<tbody>
									<c:forEach items="${cate}" var="cate" varStatus="STT">
										<tr class="odd gradeX">
											<td>${STT.index+1 }</td>
											<td>${cate.cname }</td>


											<td><a
												href="<c:url value='/admin/category/edit?id=${cate.cid }'/>"
												class="center">Sửa</a> | <a
												href="<c:url value='/admin/category/delete?id=${cate.cid}'/>"
												class="center">Xóa</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<a href="<c:url value='/admin/category/add'/>" class="center">Thêm</a>
				</div>
				<!-- End: life time stats -->
			</div>
		</div>

		<!-- BEGIN PAGE CONTENT INNER -->

		<!-- END PAGE CONTENT INNER -->
	</div>
</div>
<!-- END CONTENT -->
