<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Gestion des clients - Accueil</title>
<link rel="stylesheet" type="text/css" href="<c:url value="staticfiles/bootstrap/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="staticfiles/font-awesome/css/font-awesome.min.css"/>"/>
</head>
<body>
	<c:set var="home" value="active" scope="request" />
	<c:import url="inc/nav.jsp"/>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 jumbotron">
				<h1>Bienvenue sur votre application de gestion de client.</h1>
				<p>
					Cette petite application permet d'éffectuer des opérations de type
					CRUD (Create Read Update Delete) afin d'enregistrer, lister et / ou modifier
					des clients.
				</p>
				<p>
					<a href="<c:url value="/client/list"/>" title="Accéder à la liste des clients" class="btn btn-primary">
						<i class="fa fa-list"></i> Liste des clients
					</a>
					<a href="<c:url value="/client/add"/>" title="Ajouter un nouveau client" class="btn btn-success">
						<i class="fa fa-user-plus"></i> Ajouter un nouveau client
					</a>
				</p>
			</div>
		</div>
	</div>

	<c:import url="inc/footer.jsp"/>
</body>
</html>