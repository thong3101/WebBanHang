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
					<h3 class="mb-4 billing-heading">Billing Details</h3>
					<div class="row align-items-end">
						
						
						
						<div class="col-md-6">
							<div class="form-group">
								<label for="firstname">Firt Name</label> <span>${bill.orderName }</span>
							</div>
						</div>
						<div class="w-100"></div>
						<div class="w-100"></div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="streetaddress">Street Address</label> <span>${bill.orderAddress }</span>
							</div>
						</div>
						
						<div class="w-100"></div>
						
						
						<div class="w-100"></div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="phone">Phone</label> <span>${bill.orderPhone }</span>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="emailaddress">Email Address</label> <span>${bill.orderEmail }</span>
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
								<span>Subtotal:  </span> <span id="tienship">${Integer.valueOf(bill.cart.total) }</span>
							</p>
							
							<p class="d-flex">
								<span>Ship:  </span> <span id="tienship">${bill.shipprice }</span>
							</p>
							<hr>
							<p class="d-flex total-price">
								<span>Total:  </span> <span name="tongcong" id="tong">${bill.subtotal }</span>
							</p>
						</div>
					</div>
					<div class="col-md-6">
						<div class="cart-detail p-3 p-md-4">
							<h3 class="billing-heading mb-4">Payment Method</h3>
								<span name="tongcong" id="tong">${bill.payment }</span>
							
							</div>
							<!-- <p>
								<a href="bill" class="btn btn-primary py-3 px-4">Place an order</a>
							</p> -->
						</div>
					</div>
				
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
