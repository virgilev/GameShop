<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="beans.Game"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>


<!-- Bootstrap core CSS -->
<link href="bootstrap_projet/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap_projet/css/shop-homepage.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap_projet/css/shop-inscription.css" rel="stylesheet">

<style>
@media ( max-width : 576px) {
	nav>.container {
		width: 100%;
	}
}

form {
	padding: 40px;
}

* {
	box-sizing: border-box;
}

html, body {
	width: 100%;
	height: 100%;
	margin: 0;
	background-color: #ffffff;
	font-family: 'Roboto', sans-serif;
}

.shopping-cart {
	width: 550px;
	height: auto;
	margin: 80px auto;
	background: #FFFFFF;
	box-shadow: 1px 2px 3px 0px rgba(0, 0, 0, 0.10);
	border-radius: 30px;
	display: flex;
	flex-direction: column;
}

.title {
	height: 60px;
	border-bottom: 1px solid #E1E8EE;
	padding: 20px 30px;
	color: #5E6977;
	font-size: 18px;
	font-weight: 400;
}

.item {
	padding: 20px 30px;
	height: 120px;
	display: flex;
}

.price {
 	 
}

.item:nth-child(3) {
	border-top: 1px solid #E1E8EE;
	border-bottom: 1px solid #E1E8EE;
}

.buttons {
	position: relative;
	padding-top: 30px;
	margin-right: 60px;
}

.delete-btn, .like-btn {
	display: inline-block;
	Cursor: pointer;
}

.delete-btn {
	width: 18px;
	height: 17px;
	background: url("delete-icn.svg") no-repeat center;
}

.like-btn {
	position: absolute;
	top: 9px;
	left: 15px;
	background: url('twitter-heart.png');
	width: 60px;
	height: 60px;
	background-size: 2900%;
	background-repeat: no-repeat;
}

.is-active {
	animation-name: animate;
	animation-duration: .8s;
	animation-iteration-count: 1;
	animation-timing-function: steps(28);
	animation-fill-mode: forwards;
}

@
keyframes animate { 0% {
	background-position: left;
}

50%
{
background-position
:
 
right
;
 
}
100%
{
background-position
:
 
right
;
 
}
}
.image {
	margin-right: 50px;
}

Let’s add some basic style to  product name and description .
.description {
	padding-top: 10px;
	margin-right: 60px;
	width: 115px;
}

.description span {
	display: block;
	font-size: 14px;
	color: #43484D;
	font-weight: 400;
}

.description span:first-child {
	margin-bottom: 5px;
}

.description span:last-child {
	font-weight: 300;
	margin-top: 8px;
	color: #86939E;
}

.quantity {
	padding-top: 20px;
	margin-right: 60px;
}

.quantity input {
	-webkit-appearance: none;
	border: none;
	text-align: center;
	width: 32px;
	font-size: 16px;
	color: #43484D;
	font-weight: 300;
}

button[class*=btn] {
	width: 30px;
	height: 30px;
	background-color: #E1E8EE;
	border-radius: 6px;
	border: none;
	cursor: pointer;
}

.minus-btn img {
	margin-bottom: 3px;
}

.plus-btn img {
	margin-top: 2px;
}

button:focus, input:focus {
	outline: 0;
}

.total-price {
	width: 83px;
	padding-top: 27px;
	text-align: right;
	font-size: 16px;
	color: #43484D;
	font-weight: 300;
	
}

.test {

	margin: auto;	
}

.logo {
	margin-bottom: 305px;	
}


@media ( max-width : 800px) {
	.shopping-cart {
		width: 100%;
		height: auto;
		overflow: hidden;
	}
	.item {
		height: auto;
		flex-wrap: wrap;
		justify-content: center;
	}
	.image img {
		width: 50%;
	}
	.image, .quantity, .description {
		width: 100%;
		text-align: center;
		margin-left: 50px;
	}
	.image, .quantity, .description {
		width: 100%;
		text-align: center;
		margin: 6px 0;
	}
	
	.quantity, .description {
		width: 100%;
		text-align: center;
		
	}
	.buttons {
		margin-right: 20px;
	}
}
</style>

<script>
$('.like-btn').on('click', function() {
	   $(this).toggleClass('is-active');
	});
	
$('.minus-btn').on('click', function(e) {
    e.preventDefault();
    var $this = $(this);
    var $input = $this.closest('div').find('input');
    var value = parseInt($input.val());
 
    if (value &gt, 1) {
        value = value - 1;
    } else {
        value = 0;
    }
 
  $input.val(value);
 
});
 
$('.plus-btn').on('click', function(e) {
    e.preventDefault();
    var $this = $(this);
    var $input = $this.closest('div').find('input');
    var value = parseInt($input.val());
 
    if (value &lt, 100) {
        value = value + 1;
    } else {
        value =100;
    }
 
    $input.val(value);
});
</script>


</head>

<body>
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-toggleable-md navbar-inverse bg-inverse">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarExample"
		aria-controls="navbarExample" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="container">
		<a class="navbar-brand" href="#">Vente en ligne de jeux vidéos</a>
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="homeservlet">Accueil</a></li>
				<li class="nav-item"><a class="nav-link" href="inscription">Inscription</a>
				</li>
				<c:if test="${empty sessionScope.sessionClient}">
					<li class="nav-item active"><a class="nav-link"
						href="connexion">Connexion<span class="sr-only">(current)</span></a>
					</li>
				</c:if>
				<c:if test="${!empty sessionScope.sessionClient}">
					<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a>
					</li>
				</c:if>
				<c:url value="cartservlet" var="URLview">
					<c:param name="flag" value="view" />
				</c:url>
				<c:if test="${!empty sessionScope.sessionClient}">
					<li class="nav-item"><a class="nav-link" href="${URLview}"><img
							class="card-img-top img-fluid"
							src="./pictures/panier-icone-7888-32.png" alt=""></a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">
			<div class="logo">

				<img class="card-img-top img-fluid"
					src="./pictures/logoEPVgames.png" alt="">

			</div>
			</div>
			<!-- /.col-lg-3 -->

			
			<div class="col-lg-9">
			<div class="test">
				<div class="shopping-cart">
					<!-- Title -->
					<div class="title">Panier</div>


					<c:set var="client" value="${sessionScope.sessionClient}"
						scope="page" />
					<c:set var="cart" value="${client.getCart()}" scope="page" />
					<c:set var="nbgames" value="${cart.getGames().size()}" scope="page" />
					<c:set var="total" value="0" scope="page" />
					<c:if test="${!empty cart.getGames()}">
						<c:forEach var="i" begin="0" end="${nbgames-1}">


							<c:url value="cartservlet" var="URLdel">
								<c:param name="flag" value="del" />
								<c:param name="title"
									value="${cart.getGames().get(i).getTitle()}" />
								<c:param name="console"
									value="${cart.getGames().get(i).getConsole()}" />
							</c:url>
			
							<div class="item">
								<div class="buttons">
									<a class="nav-link" href="${URLdel}"><img
										class="card-img-top img-fluid"
										src="./pictures/del.png" alt=""></a>
								</div>

								<div class="image">
									<img
										src="./pictures/${cart.getGames().get(i).getTitle()}_64x64.jpg"
										alt="" />
								</div>

								<div class="description">
									<span>${cart.getGames().get(i).getTitle()} </span> <span>Console
										: ${cart.getGames().get(i).getConsole()} </span>
								</div>
								<div class="price">
									<div class="total-price" align="right">${cart.getGames().get(i).getPrice()}
										&euro;</div>
								</div>
							</div>
							<c:set var="total"
								value="${total + cart.getGames().get(i).getPrice()}"
								scope="page" />

						</c:forEach>
					</c:if>


				</div>
				<div align="right">
					<h4>Total : ${total} &euro;</h4>
				</div>
			</div>
			</div>


			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->


	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-inverse">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2017</p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="bootstrap_projet/vendor/jquery/jquery.min.js"></script>
	<script src="bootstrap_projet/vendor/tether/tether.min.js"></script>
	<script src="bootstrap_projet/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

