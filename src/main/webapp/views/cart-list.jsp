<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<div style="margin-top: 40px;" class="container mb-4">
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr class="productCartListItem">
							<th scope="col">Ảnh</th>
							<th scope="col">Tên sản phẩm</th>


							<!-- <th scope="col">Tồn kho</th> -->
							<th scope="col" class="text-center">Số lượng</th>
							<th scope="col" class="text-right">Giá</th>
							<th scope="col" class="text-right">Discount</th>
							<th></th>
						</tr>
					</thead>
					<tbody>




						<c:forEach items="${sessionScope.cart}" var="map">

							<tr>
								<c:url value="/image?fname=${map.value.product.imageLink}"
									var="imgUrl"></c:url>

								<td><img class="img-responsive" width="60px" height="60px"
									src="${imgUrl}" /></td>

								<td>${map.value.product.pname }</td>
								<%-- <td>${map.value.product.stoke }</td> --%>
								<td>${map.value.quantity }</td>


								<td class="text-right shop-red"> ${map.value.product.price * map.value.quantity } đồng</</td>

								<td class="text-right shop-red">
									${map.value.product.discount} %</td>

								<td class="text-right"><a
									href="${pageContext.request.contextPath}/cart-remove?pId=${map.value.product.pid}"
									class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a>
								</td>
							</tr>
						</c:forEach>

						<%-- <tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Sub-Total</td>
							<td class="text-right"><h4>Subtotal:</h4> <c:set var="total"
									value="${0}" /> <c:forEach items="${sessionScope.cart}"
									var="map">
									<c:set var="total"
										value="${total + map.value.quantity * map.value.product.price}" />
								</c:forEach>
								<div class="total-result-in">
									<span>$ ${total }</span>

								</div></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Discount</td>
							<c:forEach items="${sessionScope.cart}" var="map">
							<td class="text-right shop-red">$ ${map.value.product.discount}</td>
							</c:forEach>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><strong>Total</strong></td>
							<c:forEach items="${sessionScope.cart}" var="map">
							<td class="text-right"><strong> $ ${Integer.valueOf(total - map.value.quantity*map.value.product.price*map.value.product.discount/100)} </strong></td>
							</c:forEach>
						</tr> --%>

					</tbody>
				</table>
			</div>
		</div>
		<div class="col mb-2">
			<div class="row">
				<div class="col-sm-12  col-md-6">
					<a href="${pageContext.request.contextPath }/home"
						class="btn btn-block btn-light">Continue Shopping</a>
				</div>
				<div class="col-sm-12 col-md-6 text-right">
					<a href="${pageContext.request.contextPath }/checkout"
						class="btn btn-block btn-light">Checkout</a>
				</div>
			</div>
		</div>
	</div>
</div>

