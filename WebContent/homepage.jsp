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

<!-- Temporary navbar container fix -->
<style>
.navbar-toggler {
	z-index: 1;
}

@media ( max-width : 576px) {
	nav>.container {
		width: 100%;
	}
}
/* Temporary fix for img-fluid sizing within the carousel */
.carousel-item.active, .carousel-item-next, .carousel-item-prev {
	display: block;
}
</style>
<style type="text/css">
.morecontent span {
	display: none;
}

.morelink {
	display: block;
}

.card-footer /* Lorsque la souris passe sur un des liens */    
{
        color: #ffffff; /* On passe le texte en blanc... */
        background: #009933; /* ... fond vert clair */
}



.card-footer:hover /* Lorsque la souris passe sur un des liens */    
{
        color: #ffffff; /* On passe le texte en blanc... */
        background: #003300; /* ... fond vert foncé */
}

a.cache { 
  color: #ffffff; 
  text-decoration: none; 
  
} 

</style>

<script type='text/javascript' src="http://code.jquery.com/jquery.js"></script>
<script type='text/javascript'>
$(document).ready(function() {
    // Configure/customize these variables.
    var showChar = 30;  // How many characters are shown by default
    var ellipsestext = "...";
    var moretext = "Lire la suite >";
    var lesstext = "Montrer moins";
    

    $('.more').each(function() {
        var content = $(this).html();
 
        if(content.length > showChar) {
 
            var c = content.substr(0, showChar);
            var h = content.substr(showChar, content.length - showChar);
 
            var html = c + '<span class="moreellipses">' + ellipsestext+ '&nbsp;</span><span class="morecontent"><span>' + h + '</span>&nbsp;&nbsp;<a href="" class="morelink">' + moretext + '</a></span>';
 
            $(this).html(html);
        }
 
    });
 
    $(".morelink").click(function(){
        if($(this).hasClass("less")) {
            $(this).removeClass("less");
            $(this).html(moretext);
        } else {
            $(this).addClass("less");
            $(this).html(lesstext);
        }
        $(this).parent().prev().toggle();
        $(this).prev().toggle();
        return false;
    });
});
</script>

</head>

<body>
	<% List<Game> listeGames = (List<Game>)request.getAttribute("listGame"); 
		for (Game g : listeGames){
		 System.out.println(g.getTitle()); 
	 }
     	 int nb_games = listeGames.size();     %>
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
		<a class="navbar-brand" href="#">Vente en ligne de jeux
			vid&eacute;os</a>
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="homeservlet">Accueil<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="inscription">Inscription</a>
				</li>
				<c:if test="${empty sessionScope.sessionClient}">
					<li class="nav-item"><a class="nav-link" href="connexion">Connexion</a>
					</li>
				</c:if>
				<c:if test="${!empty sessionScope.sessionClient}">
					<li class="nav-item"><a class="nav-link" href="deconnexion">D&eacute;connexion</a>
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
				<img class="card-img-top img-fluid"
					src="./pictures/logoEPVgames.png" alt="">
				<c:if test="${!empty sessionScope.sessionClient}">
                    Bonjour ${sessionScope.sessionClient.firstName} ${sessionScope.sessionClient.lastName} !
                </c:if>
				<div class="list-group">
					<a href="#" class="list-group-item">Jeux d'actions</a> <a href="#"
						class="list-group-item">Jeux de sport</a> <a href="#"
						class="list-group-item">Jeux d'aventures</a>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid"
								src="./pictures/${requestScope.listGame.get(0).getTitle()}_900x350.jpg"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid"
								src="./pictures/${requestScope.listGame.get(1).getTitle()}_900x350.jpg"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid"
								src="./pictures/${requestScope.listGame.get(2).getTitle()}_900x350.jpg"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<c:set var="count" value="0" scope="page" />


					<%   		for (int i = 0; i< listeGames.size(); ++i) { %>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top img-fluid"
								src="./pictures/${requestScope.listGame.get(count).getTitle()}.jpg"
								alt=""></a>
							<div class="card-block">

								<c:url value="cartservlet" var="URLadd">
									<c:param name="flag" value="add" />
									<c:param name="title"
										value="${requestScope.listGame.get(count).getTitle()}" />
									<c:param name="console"
										value="${requestScope.listGame.get(count).getConsole()}" />
								</c:url>

								<h4 class="card-title">
									
										${requestScope.listGame.get(count).getTitle()}>
								</h4>

								<h5>${requestScope.listGame.get(count).getPrice()}&euro;</h5>
								<h6>Console : ${requestScope.listGame.get(count).getConsole()}</h6>
								
								<span class="more">

												${requestScope.listGame.get(count).getDescription()} </span>

							
										</div>
							<div class="card-footer">
								<h5 class= "add-cart"><a href="${URLadd}" class = "cache"> Ajouter au panier </a></h5>
							</div>
						</div>
					</div>
					<c:set var="count" value="${count + 1}" scope="page" />
					<% }%>
				</div>

				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

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