<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Gestion des clients - Liste</title>
<link rel="stylesheet" type="text/css" href="<c:url value="../staticfiles/bootstrap/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="../staticfiles/font-awesome/css/font-awesome.min.css"/>"/>
</head>
<body>

	<c:set var="list" value="active" scope="request" />
	<c:import url="../inc/nav.jsp"/>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 align="center">Liste des clients</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-offset-2 col-lg-8">
			<c:if test="${ !empty clients }">
					<div class="panel panel-primary">
					  <!-- Default panel contents -->
					  <div class="panel-heading">Liste de tous les clients et leurs informations</div>
					
					  <!-- Table -->
					  <table class="table table-striped table-bordered">
					  	<tr>
					  		<th>Nom</th>
					  		<th>Prénom</th>
					  		<th>Email</th>
					  		<th>Adresse</th>
					  		<th>Telephone</th>
					  		<th>Opérations</th>
					  	</tr>
					  	<c:forEach items="${ clients }" var="client">
					  		<tr>
					  			<td><c:out value="${ client.nom }" /></td>
					  			<td><c:out value="${ client.prenom }" /></td>
					  			<td><c:out value="${ client.adresse }" /></td>
					  			<td><c:out value="${ client.email }" /></td>
					  			<td><c:out value="${ client.telephone }" /></td>
					  			<td>
					  				<a class="btn btn-warning" title="Editer" 
					  				   href="<c:url value="/client/update?c=${ client.id }"/>">
					  				   <i class="fa fa-edit"></i>
					  				</a>
					  				<a class="btn btn-danger" 
					  				   onclick="return confirm('Voulez vous vraiment supprimer ce client ?');" 
					  				   title="Supprimer" href="<c:url value="/client/delete?c=${ client.id }"/>">
					  				   <i class="fa fa-trash"></i>
					  				</a>
					  			</td>
					  		</tr>
					  	</c:forEach>
					  </table>
					</div>
					</c:if>
					<c:if test="${ empty clients }">
						<h2 align="center">Pas encore de clients !</h2>
					</c:if>
			</div>
		</div>
	</div>
	
	<c:import url="../inc/footer.jsp"/>
</body>
</html>