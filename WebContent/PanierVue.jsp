<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Votre Panier</title>
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


		<form id="rechercheArticle" action="" method="POST">

			<label for="rechercher"></label> <input type="text"
				value="${Rechercher}" name="rechercher" /> <span class="rechercher"></span>
			<input type="submit" value="Rechercher" name="action" />

		</form>

	</div>





	Voici votre panier! Vous disposez de ${monPanier.getNbArticles()}
	article(s)

	<table>

		<tr>
			<th>Titre</th>
			<th>Choix quantité</th>
			<th>Quantité</th>
			<th>Prix</th>


			<td>Prix total: ${PrixTOT}&euro;</td>

		</tr>



		<c:forEach items="${monPanier.getListeAchat()}" var="listePanier">
			<tr>
				<td>${listePanier.article.nom}
					<form action="GestionPanier" method="post">
						<input type="hidden" name="ModifierArticle"
							value="${listePanier.article.ref}">

					</form>
				</td>

				<td><c:if test="${not empty listePanier.article.getMateriel()}">
						<form action="GestionPanier" method=post>
							<input type="hidden" name="Reference"
								value="${listePanier.article.ref}" /> <input type="number"
								name="quantity" value="${listePanier.quantite}" step="1"
								min="${listePanier.quantite}"
								max="${listePanier.article.getMateriel().stock}"> <input
								type="submit" value="Modifier" name="action">
						</form>

					</c:if></td>


				<td>${listePanier.quantite}</td>
				<td>${listePanier.article.prixHT}&euro;</td>
				<td>


					<form id="supprimerArticle" action="" method="POST">
						<input type="hidden" name="Reference"
							value="${listePanier.article.ref}" /> <input type="submit"
							value="Supprimer" name="action" />

					</form>

				</td>
			</tr>

		</c:forEach>

	</table>



</body>
</html>

<!-- 


	 -->