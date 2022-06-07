<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url value="/templates/assets" var="url"></c:url>

<!--Import jQuery before export.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>


<!--Data Table-->
<script type="text/javascript"
	src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>

<!--Export table buttons-->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js"></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js"></script>

<!--Export table button CSS-->

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">

<!DOCTYPE html>

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

		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">
			Products <small>product listing</small>
		</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">eCommerce</a> <i class="fa fa-angle-right"></i>
				</li>
				<li><a href="#">Products</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- Begin: life time stats -->
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i>Products
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-container">
							<table id="tbl"
								class="table table-striped table-bordered table-condensed"
								style="width: 100%">
								<thead>
									<tr role="row" class="heading">
										<th width="10%">ID</th>
										<th width="15%">Tên sản phẩm</th>
										<th width="15%">Ảnh</th>
										<th width="15%">Danh mục</th>
										<th width="10%">Giá</th>
										<th width="15%">Mô tả</th>
										<th width="10%">Số lượng</th>
										<th width="15%">Discount</th>
										<th width="10%">Đã bán</th>
										<th width="10%">Trạng thái</th>
										<th width="10%">Hành động</th>
								</thead>
								<tbody>
									<c:forEach items="${productlist}" var="product" varStatus="STT">
										<tr class="odd gradeX">
											<td>${STT.index+1 }</td>
											<td>${product.pname }</td>


											<%-- <c:set var="string1" value="${product.imageLink}" />
												<c:set var="string2" value="${fn:substring(string1, 0, 4)}" />
												<c:choose>
													<c:when test="${string2 =='product'}">
														<c:url value="/image?fname=${product.imageLink}" var="imgUrl"></c:url>
														<c:url value="${product.imageLink}" var="imgUrl"></c:url>
													</c:when>
													<c:otherwise>
														<c:url value="${product.imageLink}" var="imgUrl"></c:url>
													</c:otherwise>
												</c:choose>
												<td><img height="150" width="200" src="${imgUrl}" /></td> --%>

											<c:url value="/image?fname=${product.imageLink}" var="imgUrl"></c:url>
											<td><img height="150" width="200" src="${imgUrl}" /></td>

											<%-- <td><img height="150" width="200"
													src="${product.imageLink}" /></td> --%>
											<td>${product.cid }</td>
											<td>${product.price } đồng</td>
											<td>${product.pdescription }</td>
											<td>${product.hangcon }</td>
											<td>${product.discount } %</td>
											<td>${product.daban }</td>
											<%-- <td>${product.status }</td> --%>

											<%-- <c:if test="${product.status == 0}">
												<td>Sản phẩm không thể đặt</td>
											</c:if>

											<td>Có thể đặt</td> --%>
											
											<c:choose>
												<c:when test="${product.status == 0}">
													<td>Sản phẩm không thể đặt</td>
												</c:when>
												<c:otherwise>
													<td>Có thể đặt</td>
												</c:otherwise>
											</c:choose>

											<%-- <c:url value="/image?fname=${product.imageLink }"
													var="imgUrl"></c:url>
												<td><img height="150" width="200" src="${imgUrl}" /></td> --%>

											<td><a
												href="<c:url value='/seller/product/edit?id=${product.pid }'/>"
												class="center">Sửa</a> | <a
												href="<c:url value='/seller/product/delete?id=${product.pid}'/>"
												class="center">Xóa</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- End: life time stats -->
			</div>
		</div>
		<!-- END PAGE CONTENT-->
	</div>
</div>
<!-- END CONTENT -->


<script>
	$('#tbl').DataTable({
		dom : 'Bfrtip',
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
	});
</script>




