<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>


<div class="ProductDetailForm">
<div style="height: 60px; width: 100%; display: block;">
</div>

<div class="container">
    <div class="row">
        <!-- Image -->
        <div class="col-12 col-lg-6">
            <div class="card bg-light mb-3">
                <div class="card-body">
                    <a href="" data-toggle="modal" data-target="#productModal">
                        <%-- <img class="img-fluid" src="${productDetail.imageLink}" /> --%>
                        
                        <div class="form-group">
								<c:url value="/image?fname=${productDetail.imageLink}" var="imgUrl"></c:url>
								<img class="img-fluid" src="${imgUrl}" alt="">
							</div>
                        
                        <p class="text-center">Zoom</p>
                    </a>
                </div>
            </div>
        </div>

        <!-- Add to cart -->
        <div class="col-12 col-lg-6 add_to_cart_block">
            <div class="card bg-light mb-3">
                <div class="card-body">
                	<p>Danh mục: ${categoryName.cname} <br>Tên sản phẩm: ${productDetail.pname}</p>
                    <p class="price">Giá: ${productDetail.price} $</p>
                    <p class="price_discounted">Giá sau khi giảm: ${Integer.valueOf(productDetail.price - productDetail.price*productDetail.discount/100)} $</p>
                    <form method="get" action="cart.html">
                        <div class="form-group">
                            <label>Đã Bán : ${productDetail.daban}</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                        <i class="fa fa-minus"></i>
                                    </button>
                                </div>
                                <input type="text" class="form-control"  id="quantity" name="quantity" min="1" max="100" value="1">
                                <div class="input-group-append">
                                    <a type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <%-- <a href="<c:url value="'/member/cart-add?pId=${productDetail.pid}&quantity='+document.getElementById('quantity').value"></c:url>" class="btn btn-success btn-block">Add to cart</a> --%>
                        <a href='' onclick="this.href='/ShopNhacCu/cart-add?pId=${productDetail.pid}&quantity='+document.getElementById('quantity').value" class="btn btn-success btn-block">Add to cart</a>
                    </form>
                   
                </div>
            </div>
        </div>
    </div>

    <div class="row ProductDescription">
        <!-- Description -->
        <div class="col-12">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-align-justify"></i> Description</div>
                <div class="card-body">
                    <p class="card-text">
                       ${productDetail.pdescription}
                    </p>
                    <p class="card-text">
                      
                    </p>
                </div>
            </div>
        </div>

       
    </div>
</div>


<!-- Modal image -->
<div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="productModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="productModalLabel"> ${categoryName.cname} <br> ${productDetail.pname}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <%-- <img class="img-fluid" src="${productDetail.imageLink}" /> --%>
                <c:url value="/image?fname=${productDetail.imageLink}" var="imgUrl"></c:url>
								<img class="img-fluid" src="${imgUrl}" alt="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


</div>
<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
    //Plus & Minus for Quantity product
    $(document).ready(function(){
        var quantity = 1;

        $('.quantity-right-plus').click(function(e){
            e.preventDefault();
            var quantity = parseInt($('#quantity').val());
            $('#quantity').val(quantity + 1);
        });

        $('.quantity-left-minus').click(function(e){
            e.preventDefault();
            var quantity = parseInt($('#quantity').val());
            if(quantity > 1){
                $('#quantity').val(quantity - 1);
            }
        });

    });
</script>
