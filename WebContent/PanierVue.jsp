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

		<c:choose>
			<c:when test="${not empty monCompte}">
				<form id="identification" action="GestionCompte" method="POST">
					<input type="submit" value="Deconnexion" name="action" />
					Bienvenue ${monCompte.getPrenom()}!

				</form>
			</c:when>


			<c:otherwise>
				<form id="identification" action="GestionArticle" method="POST">
					<label for="email">Adresse email</label> <input type="text"
						value="${param.email}" name="email" /> <span class="erreur">${erreurs['email']}</span>
					<label for="motdepasse">Mot de passe</label> <input type="password"
						value="${param.motdepasse}" name="motdepasse" /> <span
						class="erreur">${erreurs['motdepasse']}</span> <input
						type="submit" value="Connexion" name="action" />

				</form>
			</c:otherwise>
		</c:choose>


	</div>

	<form id="rechercheArticle" action="GestionRecherche" method="POST">

		<label for="rechercher"></label> <input type="text"
			value="${Rechercher}" name="rechercher" /> <span class="rechercher"></span>
		<input type="submit" value="Rechercher" name="action" /> <span
			class="erreur"> ${erreursR['rechercher']} </span> <br>

	</form>

	<br /> Voici votre panier! Vous disposez de
	${monPanier.getNbArticles()} article(s) &nbsp;
	<form id="viderPanier" action="GestionPanier" method="POST">
		<input type="submit" value="Vider" name="action" />

	</form>


	<c:if test="${not empty monPanier}">
		<c:if test="${monPanier.getNbArticles()!=0}">

			<table>



				<tr>
					<th>Titre</th>
					<th>Choix quantité</th>
					<th>Quantité</th>
					<th>Prix à l'unité</th>
					<th>Suppression</th>


					<td>Prix total: ${monPanier.getPrixTotal()}&euro;</td>

				</tr>



				<c:forEach items="${monPanier.getListeAchat()}" var="lignePanier">
					<tr>
						<td>${lignePanier.article.nom}
							<form action="GestionPanier" method="post">
								<input type="hidden" name="ModifierArticle"
									value="${lignePanier.article.ref}">

							</form>
						</td>

						<td><c:if
								test="${not empty lignePanier.article.getMateriel()}">
								<form action="GestionPanier" method=post>
									<input type="hidden" name="Reference"
										value="${lignePanier.article.ref}" /> <input type="number"
										name="quantity" value="${lignePanier.quantite}" step="1"
										min="0" max="${lignePanier.article.getMateriel().stock}">
									<input type="submit" value="Modifier" name="action">
								</form>

							</c:if></td>


						<td>${lignePanier.quantite}</td>
						<td>${lignePanier.article.prixHT}&euro;</td>
						<td>


							<form id="supprimerArticle" action="GestionPanier" method="POST">
								<input type="hidden" name="Reference"
									value="${lignePanier.article.ref}" /> <input type="submit"
									value="Supprimer" name="action" />

							</form>

						</td>
					</tr>

				</c:forEach>

			</table>
		</c:if>
	</c:if>

</body>
</html>

<!-- 


	 -->