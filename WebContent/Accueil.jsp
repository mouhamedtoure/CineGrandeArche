<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>

<form action="" method="POST">

<label for="rechercher"></label> <input type="text" value="${Rechercher}"
name="rechercher" /> <span class="rechercher"></span>
<input type="submit" value="Rechercher" name="action" />
		
</form>


<img src="<c:url value='Articles/Letranger.jpeg'/>" width="178" height="298">

${livre1}
<br/>

<img src="<c:url value='Articles/Bovary.jpg' />" width="178" height="298" >

${livre2}
<br/>

<img src="<c:url value='Articles/Jurassicpark.jpg' />" width="178" height="298" >

${livre3}
<br/>

</body>
</html>