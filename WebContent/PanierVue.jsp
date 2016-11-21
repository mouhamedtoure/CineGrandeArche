<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Votre Panier</title>
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

	</div>





	Voici votre panier! Vous disposez de ${monPanier.getNbArticles()}
	articles

	<table>

		<tr>
			<th>Titre</th>
			<th>Quantité</th>
			<th>PrixHT</th>
			<th>Prix</th>
			<th>Prix Total</th>

			<td>${monPanier.getPrixTotal()}&euro;<br />
			</td>

		</tr>



		<c:forEach items="${monPanier.getListeAchat()}" var="listePanier">
			<tr>
				<td>${listePanier.article.nom}
					<form action="PanierVue.jsp" method="post">
						<input type="hidden" name="ModifierArticle"
							value="${listePanier.article.ref}">

					</form>
				</td>

				<td>${listePanier.quantite}
				
				<input type="number" step="1" value="${listePanier.quantite}" min="0" max="64" /> </td>

				<td>${listePanier.article.prixHT}&euro;</td>

				<td>${listePanier.article.prixHT*listePanier.quantite}&euro;</td>

			</tr>

		</c:forEach>

	</table>



</body>
</html>