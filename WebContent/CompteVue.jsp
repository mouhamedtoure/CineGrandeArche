<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="header">

		<a id="accueil" href="AccueilVue.jsp"> <strong>Cine
				Grande Arche </strong></a>

		<form id="identification" action="GestionCompte" method="POST">
			<input type="submit" value="Deconnexion" name="action" /> Bienvenue ${monCompte.getPrenom()}!


		</form>




		<a id="panier" href="PanierVue.jsp"> Panier (${compteurPanier})</a>

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
							<input type="hidden" name="Reference" value="${article.ref}" /> <input
							type="submit" value="Details" name="action" />
							
					</form>
				<td><span class="erreurs0">${erreurs0[article.ref]}</span></td>
			</tr>



		</c:forEach>

	</table>






</body>
</html>