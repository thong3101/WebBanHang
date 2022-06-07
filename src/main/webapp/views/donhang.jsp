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
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
					<!-- Begin: life time stats -->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i>Bill
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
											<th width="15%">Mã giỏ hàng</th>
											<th width="15%">Tên người đặt</th>
											<th width="15%">Địa chỉ</th>
											<th width="10%">Số điện thoại</th>
											<th width="15%">Email</th>
											<th width="15%">Tổng bill</th>
											<th width="10%">Phương thức thanh toán</th>
									</thead>
									<tbody>
										<c:forEach items="${listbill}" var="bill"
											varStatus="STT">
											<tr class="odd gradeX">
												<td>${STT.index+1 }</td>
												<td>${bill.cart.id }</td>
												<td>${bill.orderName }</td>
												<td>${bill.orderAddress }</td>
												<td>${bill.orderPhone }</td>
												<td>${bill.orderEmail }</td>
												<td>${bill.subtotal }</td>
												<td>${bill.payment }</td>
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
    dom: 'Bfrtip',
    buttons: [
        'copy', 'csv', 'excel', 'pdf', 'print'
    ]
});    </script>




