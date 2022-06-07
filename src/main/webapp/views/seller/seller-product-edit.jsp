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


<!-- BEGIN CONTAINER -->
	<br>
	<br>
	<br>
	<br>
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">Widget settings form goes here</div>
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

			<!-- BEGIN PAGE CONTENT-->
			<div class="container">

				<!-- /. NAV SIDE  -->
				<div id="page-wrapper">
					<div id="page-inner">
						<div class="row">
							<div class="col-md-12">
								<h2>Chỉnh sửa danh mục</h2>
								<h5>Nơi bạn có thể chỉnh sửa thông tin danh mục</h5>
							</div>
						</div>
						<!-- /. ROW  -->
						<hr />
						<div class="row">
							<div class="col-md-12">
								<!-- Form Elements -->
								<div class="panel panel-default">
									<div class="panel-heading">Chỉnh sửa sản phẩm</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-md-8">
												<h3>Sản phẩm:</h3>
												<c:url value="/seller/product/edit" var="edit"></c:url>
												<form role="form" action="${edit}" method="post"
													enctype="multipart/form-data">
													<input name="id" value="${product.pid}" hidden="">
													<div class="form-group">
														<label>Tên:</label> <input type="text"
															class="form-control" value="${product.pname }"
															name="name" />
													</div>

													<div class="form-group">
														<label class="col-md-2 control-label">Mô tả</label>
														<div class="col-md-10">
															<textarea name="description" type="text"
																class="form-control">${product.pdescription }</textarea>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-2 control-label">Danh mục </label> <select
															name="category">
															<c:forEach items="${listCategory}" var="o">
																<option value="${o.cid}"
																	${product.cid == o.cid? "selected":"" }>${o.cname}</option>
															</c:forEach>
														</select>
													</div>


													<%-- <input type="radio" id="postageyes" name="postage"
														value="Yes" /> Chèn link ảnh <br /> <input type="radio"
														id="postageno" name="postage" value="No" /> Tải ảnh <br />

													<c:set var="string1" value="${product.imageLink}" />
													<c:set var="string2" value="${fn:substring(string1, 0, 4)}" />
													<c:choose>
														<c:when test="${string2 =='product'}">
															<c:url value="/image?fname=${product.imageLink}"
																var="imgUrl"></c:url>
														</c:when>
														<c:otherwise>
															<c:url value="${product.imageLink}" var="imgUrl"></c:url>
														</c:otherwise>
													</c:choose>
													<img class="img-responsive" width="100px" src="${imgUrl}"
														alt=""> <br />
													
													<div class="form-group" id="anh" hidden="hidden">
														<label>Ảnh đại diện</label> <input id="inputicon"
															type="file" name="imageLink" value="${product.imageLink}" />
													</div> --%>


													<div class="form-group">
														<c:url value="/image?fname=${product.imageLink}"
															var="imgUrl"></c:url>
														<img class="img-responsive" width="100px" src="${imgUrl}"
															alt=""> <label>Ảnh đại diện</label> <input
															type="file" name="imageLink" value="${product.imageLink}" />
													</div>


													<div class="form-group">
														<label class="col-md-2 control-label">Hàng Còn </label>
														<div class="col-md-10">
															<input type="text" class="form-control"
																value="${product.hangcon}" name="hangcon" placeholder="">
														</div>
													</div>


													<div class="form-group">
														<label class="col-md-2 control-label">Discount </label>
														<div class="col-md-10">
															<input type="text" class="form-control"
																value="${product.discount}" name="discount"
																placeholder="">
														</div>
													</div>



													<div class="form-group">
														<label class="col-md-2 control-label">Giá </label>
														<div class="col-md-10">
															<input type="text" class="form-control"
																value="${product.price}" name="price" placeholder="">
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-md-2 control-label">Trạng thái </label>
														<div class="col-md-10">
															<input type="text" class="form-control"
																value="${product.status}" 
																name="status" placeholder="">
														</div>
													</div>

													<button type="submit" class="btn btn-default">Edit</button>
													<button type="reset" class="btn btn-primary">Reset</button>
												</form>
												<br />

											</div>
										</div>
									</div>
								</div>
								<!-- End Form Elements -->
							</div>
						</div>
						<!-- /. ROW  -->
						<div class="row">
							<div class="col-md-12"></div>
						</div>
						<!-- /. ROW  -->
					</div>
					<!-- /. PAGE INNER  -->
				</div>
				<!-- /. PAGE WRAPPER  -->
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->

<!-- END CONTAINER -->

