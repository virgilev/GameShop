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
    @media (max-width: 576px) {
        nav > .container {
            width: 100%;
        }
    }
    
     	form {
    		padding: 40px;
    }
    </style>


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
				<li class="nav-item"><a class="nav-link"
					href="homeservlet">Accueil</a></li>
				<li class="nav-item"><a class="nav-link" href="inscription">Inscription</a>
				</li>
				<c:if test="${empty sessionScope.sessionClient}">
					<li class="nav-item active"><a class="nav-link" href="connexion">Connexion<span class="sr-only">(current)</span></a>
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

				<img class="card-img-top img-fluid" src="./pictures/logoEPVgames.png" alt="">

			</div>
		<!-- /.col-lg-3 -->


			<div class="col-lg-13">

				<form method="post" action="connexion">
					<fieldset>
					<legend style="font-weight: 500;"> Connexion :</legend>

                <c:if test="${!empty sessionScope.sessionClient}">  
				Bonjour ${sessionScope.sessionClient.firstName}, vous êtes déjà connecté et pouvez vous consulter les jeux. <br>
                </c:if>
                <c:if test="${empty sessionScope.sessionClient}">  
				<p>Vous pouvez vous connecter à votre espace client via ce formulaire.</p>
                
                
						<label class="control-label col-lg-13" for="nom">Adresse email :</label> 
						<div class="col-lg-13">
						<input type="email"
							id="email" name="email" value="<c:out value="${client.email}"/>"
							size="20" maxlength="60" /> <span class="erreur">${connexion.erreurs['email']}</span>
						<br />
						</div>
						<label class="control-label col-lg-13" for="motdepasse">Mot de passe : </label> 
						<div class="col-lg-13">
						<input
							type="password" name="password" id="password1" value="" size="20"
							maxlength="20" /> <span class="erreur">${connexion.erreurs['password']}</span>
						<br/> 
						</div>
						<div class="col-lg-13">
						<br/> 
						</div>
						<div class="col-lg-13">
						
						<input type="submit" value="Connexion" class="sansLabel" />
						<br />

						<p class="${empty connexion.erreurs ? 'succes' : 'erreur'}">${connexion.resultat}</p>
                                
                
						</p>
						</c:if>
						</div>
					</fieldset>
				</form>

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