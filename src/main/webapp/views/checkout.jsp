<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10 ftco-animate">
			<c:url value="checkout" var="add"></c:url>
			<form class="billing-form" action="${add}" method="post">
				<!-- <form action="#" class="billing-form"> -->
					<h3 class="mb-4 billing-heading">Xác nhận thông tin</h3>
					<div class="row align-items-end">
						
						
						
						<div class="col-md-6">
							<div class="form-group">
								<label for="firstname">Firt Name</label> <input type="text"
									class="form-control" placeholder="" value="${acc.fullName}" name="fname">
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="country">State / Country</label>
								<div class="select-wrap">
									<div class="icon">
										<span class="ion-ios-arrow-down"></span>
									</div>

									<select name="shipprice" onchange='showprice(this.value)'>
										<c:forEach items="${cityship}" var="o">
											<option value="${o.priceship}">${o.cityname}</option>
										</c:forEach>
									</select>

								</div>
							</div>

						</div>
						<div class="w-100"></div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="streetaddress">Street Address</label> <input
									type="text" class="form-control"
									placeholder="House number and street name" value="${acc.address }" name="address">
							</div>
						</div>
						
						<div class="w-100"></div>
						
						
						<div class="w-100"></div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="phone">Phone</label> <input type="text"
									class="form-control" placeholder="" value="${acc.phone }" name="phone">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="emailaddress">Email Address</label> <input
									type="text" class="form-control" placeholder="" value="${acc.email }" name="email">
							</div>
						</div>
						<div class="w-100"></div>
					</div>
				<!-- </form> -->
				
				<div class="row mt-5 pt-3 d-flex">
					<div class="col-md-6 d-flex">
						<div class="cart-detail cart-total p-3 p-md-4">
							<h3 class="billing-heading mb-4">Cart Total</h3>
							<p class="d-flex">
								<!-- <span>Subtotal</span> <span>$20.60</span> -->
								<span>Subtotal:</span>
							<c:set var="total" value="${0}" />
							<c:forEach items="${sessionScope.cart}" var="map">
								<c:set var="total"
									value="${Integer.valueOf(total + (map.value.quantity * map.value.product.price - map.value.quantity*map.value.product.price*map.value.product.discount/100))}" />
							</c:forEach>
							
								<span id="tongtien">${total}</span>
								<input type="text" name="tongtiensp" value ="${total}" hidden>

							</p>

	
							<p class="d-flex">
								<span>Delivery:  </span> <span id="tienship">0.00</span>
							</p>
							<hr>
							<p class="d-flex total-price">
								<span>Total:  </span> <span name="tongcong" id="tong">0.00</span>
							</p>
						</div>
					</div>
					<div class="col-md-6">
						<div class="cart-detail p-3 p-md-4">
							<h3 class="billing-heading mb-4">Payment Method</h3>
							
							<c:forEach items="${payment}" var="p">
								<div class="col-md-12">
									<div class="radio">
										<label><input type="radio" name="optradio"
											class="mr-2" value="${p.payment }">${p.payment }</label>
									</div>
								</div>				
							</c:forEach>
							</div>
							<!-- <p>
								<a href="bill" class="btn btn-primary py-3 px-4">Place an order</a>
							</p> -->
						</div>
					</div>
					<button type="submit" class="btn btn-primary py-3 px-4">Xác nhận</button>
				
				</form>
				<!-- END -->



				
				</div>
			</div>
			<!-- .col-md-8 -->
		</div>
	</div>
</section>



<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/scrollax.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<script src="js/main.js"></script>

<script>
	function showprice(str) {
		const t=document.getElementById('tienship');
		const subtong=document.getElementById('tongtien');
		t.innerHTML = str;
		t.value = str;
		const a=parseFloat(t.value);
		const b=parseFloat(subtong.innerHTML);
		document.getElementById('tong').innerHTML=a+b;
	}
</script>

