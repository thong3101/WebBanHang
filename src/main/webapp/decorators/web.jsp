<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url value="/templates/assets1/web" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    

    
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;1,400&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="${url}/assets/fonts/fontawesome-free-5.15.2-web/css/all.min.css">
    <link rel="stylesheet" href="${url}/assets/css/base.css">
    <link rel="stylesheet" href="${url}/assets/css/main.css">
    
    
    
    
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    
  

    
    <style type="text/css">
    
    a{
    text-decoration: none !important;
    font-size: 1.4rem !important;
    }
    
    .card-body{
    font-size: 2rem;
    }
    
    select#colors {
    height: 44px;
	}
	
	input#quantity{
	font-size: 1.6rem;
	padding-left: 20px; 
	
	}
	
	a.btn.btn-success.btn-block {
    margin-top: 40px;
    height: 40px;
    font-size: 2rem !important;
    background-color: #EC593C !important;

	}
	
	.ProductDetailForm{
		background-color: #F5F5F5;
	}
	
	.card-header.bg-primary.text-white.text-uppercase {
    background-color: #FAFAFA !important;
    font-size: 1.8rem;
    color: black !important;
	}
	
	
	.ProductDescription{
	margin: 20px;
	width: 100%;
	}
	
	a.quantity-right-plus.btn.btn-success.btn-number,button.quantity-left-minus.btn.btn-danger.btn-number {
    background-color: #F5F5F5;
    color: black;
	}
	
	tr {
    font-size: 1.8rem;
}
	.productCartListItem{

	
	}
	
	a.btn.btn-block.btn-light {
    background-color: #EC593C;
    height: 50px;
    color: white;
    text-align: center;
    font-size: 1.8rem !important;
    line-height: 42px;
	}
	
	a.btn.btn-block.btn-light:hover{
	background-color: #D41830;
	}
    
    </style>
    
    
    
    
    <title>Shoppeee</title>
</head>

<body>
    <div class="app">
    
    <!-- BEGIN HEADER -->
	<%@ include file="/common/web/header.jsp" %>
	<!-- END HEADER -->

      

		<dec:body />

        <!-- BEGIN FOOTER -->
		<%@ include file="/common/web/footer.jsp" %>
		<!-- END FOOTER -->

    </div>
    
    <!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
    
</body>

</html>