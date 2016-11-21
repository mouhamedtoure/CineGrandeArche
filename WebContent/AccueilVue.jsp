<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="header">


		<form id="identification" action="GestionArticle" method="POST">
			<label for="email">Adresse email</label> <input type="text"
				value="${param.email}" name="email" /> <span class="erreur">${erreurs['email']}</span>
			<label for="motdepasse">Mot de passe</label> <input type="password"
				value="${param.motdepasse}" name="motdepasse" /> <span
				class="erreur">${erreurs['motdepasse']}</span> <input type="submit"
				value="Connexion" name="action" />


		</form>


		<form id="rechercheArticle" action="" method="POST">

			<label for="rechercher"></label> <input type="text"
				value="${Rechercher}" name="rechercher" /> <span class="rechercher"></span>
			<input type="submit" value="Rechercher" name="action" />

		</form>

		<a id="Panier" href="PanierVue.jsp"> Panier (${compteurPanier})</a>

	</div>




	<ul>


		<c:forEach var="article" items="${mesArticles}">

			<img src="<c:url value='Images/${article.getImage()}'/>" width="178"
				height="298" />
				
			 ${article.nom}, <c:if
				test="${article.getClass().getSimpleName() == 'Livre' }"> ${article.auteur}  </c:if>  (${article.prixHT} &euro;) 
			<c:if test="${not empty article.getMateriel()}"> Stock: ${article.getMateriel().stock} </c:if>
			<form action="GestionArticle" method="post">
				<input type="hidden" name="Reference" value="${article.ref}" /> <input
					type="submit" value="Ajouter" name="action" /> <span
					class="erreurs0">${erreurs0[article.ref]}</span>

			</form>
			<br/>

		</c:forEach>



	</ul>


</body>
</html>