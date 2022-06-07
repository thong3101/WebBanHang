<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url value="/templates/assets" var="url"></c:url>

<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.1
Version: 3.6
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->



<!-- BEGIN CONTAINER -->
	<br>
	<br>
	<br>
	<br>
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">
							 Widget settings form goes here
						</div>
						<div class="modal-footer">
							<button type="button" class="btn blue">Save changes</button>
							<button type="button" class="btn default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			
			<!-- BEGIN PAGE HEADER-->			
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="index.html">Home</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">Pages</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">Profile</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row margin-top-20">
				<div class="col-md-12">
					<!-- BEGIN PROFILE SIDEBAR -->
					<div class="profile-sidebar">
						<!-- PORTLET MAIN -->
						<div class="portlet light profile-sidebar-portlet">
							<!-- SIDEBAR USERPIC -->
							<div class="profile-userpic">
								<%-- <img src="${url}/admin/pages/media/profile/profile_user.jpg" class="img-responsive" alt=""> --%>
								<%-- <c:url value="/image?fname=${product.imageLink}" var="imgUrl"></c:url>
												<td><img height="150" width="200" src="${imgUrl}" /></td> --%>
							</div>
							<!-- END SIDEBAR USERPIC -->
							<!-- SIDEBAR USER TITLE -->
							<div class="profile-usertitle">
								<div class="profile-usertitle-name">
									 ${acc.fullName }
								</div>
							</div>
							<!-- END SIDEBAR USER TITLE -->
						</div>
						<!-- END PORTLET MAIN -->
					</div>
					<!-- END BEGIN PROFILE SIDEBAR -->
					<!-- BEGIN PROFILE CONTENT -->
					<div class="profile-content">
						<div class="row">
							<div class="col-md-12">
								<div class="portlet light">
									<div class="portlet-title tabbable-line">
										<div class="caption caption-md">
											<i class="icon-globe theme-font hide"></i>
											<span class="caption-subject font-blue-madison bold uppercase">Profile Account</span>
										</div>
										<ul class="nav nav-tabs">
											<li class="active">
												<a href="#tab_1_1" data-toggle="tab">Personal Info</a>
											</li>
										</ul>
									</div>
									<div class="portlet-body">
										<div class="tab-content">
											<!-- PERSONAL INFO TAB -->
											<div class="tab-pane active" id="tab_1_1">
											<c:url value="/seller/acount" var="edit"></c:url>
												<form role="form" action="${edit}" method="post" enctype="multipart/form-data">
												
												<input name="id" value="${acc.uid}" hidden="">
													<div class="form-group">
														<label class="control-label">Tên</label>
														<input name="name" value ="${acc.fullName }" type="text" placeholder="" class="form-control"/>
													</div>
													
													<div class="form-group">
														<label class="control-label">Số điện thoại</label>
														<input name="phone" value="${acc.phone }" type="text" placeholder="" class="form-control"/>
													</div>
													<div class="form-group">
														<label class="control-label">Địa chỉ</label>
														<input name="address" value="${acc.address }" type="text" placeholder="" class="form-control"/>
													</div>
													<div class="form-group">
														<label class="control-label">Email</label>
														<input name="email" value="${acc.email }" type="text" placeholder="" class="form-control"/>
													</div>
													
													<div class="form-group">
														<c:url value="/image?fname=${acc.anh}" var="imgUrl"></c:url>
														<img class="img-responsive" width="100px" src="${imgUrl}"
															alt=""> <label>Ảnh đại diện</label> <input
															type="file" name="anh" value="${acc.anh}" />
													</div>
													
													<div class="margiv-top-10">
														<%-- <a href="<c:url value='/edit?id=${acc.uid}'/>" class="btn green-haze">
														Lưu </a> --%>
														<button type="submit" class="btn btn-default">Lưu</button>
														<a href="#" class="btn default">
														Cancel </a>
													</div>
												</form>
											</div>
											<!-- END PERSONAL INFO TAB -->
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- END PROFILE CONTENT -->
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
<!-- END CONTAINER -->
