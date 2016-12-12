<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recherche</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="header">

		<a id="Accueil" href="AccueilVue.jsp"> <strong>Cine
				Grande Arche </strong></a>

		<form id="identification" action="GestionArticle" method="POST">
			<label for="email">Adresse email</label> <input type="text"
				value="${param.email}" name="email" /> <span class="erreur">${erreurs['email']}</span>
			<label for="motdepasse">Mot de passe</label> <input type="password"
				value="${param.motdepasse}" name="motdepasse" /> <span
				class="erreur">${erreurs['motdepasse']}</span> <input type="submit"
				value="Connexion" name="action" />


		</form>




		<a id="Panier" href="PanierVue.jsp"> Panier (${compteurPanier})</a>

	</div>

	<form id="rechercheArticle" action="GestionRecherche" method="POST">

		<label for="rechercher"></label> <input type="text"
			value="${Rechercher}" name="rechercher" /> <span class="rechercher"></span>
		<input type="submit" value="Rechercher" name="action" /> <span
			class="erreur"> ${erreursR['rechercher']} </span> <br>

	</form>


	<table>

		<tr>

		</tr>
		<c:forEach items="${mesArticles}" var="article">
			<tr>
				<td><img src="<c:url value='Images/${article.getImage()}'/>"
					width="178" height="298" /></td>


				<td>${article.nom}</td>
				<td><c:if
						test="${article.getClass().getSimpleName() == 'Livre' }"> ${article.auteur}  </c:if>
				<td>${article.prixHT}&euro;</td>

				<td><c:if test="${not empty article.getMateriel()}"> Stock: ${article.getMateriel().stock} </c:if>
					<form action="GestionArticle" method="post">

						<input type="hidden" name="Reference" value="${article.ref}" /> <input
							type="submit" value="Ajouter" name="action" />
					</form>
				<td><span class="erreurs0">${erreurs0[article.ref]}</span></td>
			</tr>



		</c:forEach>

	</table>



</body>
</html>
