<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Gestion des clients - <c:out value="${ requestScope.update == 'update' ? 'Edition' : 'Ajout' }"/></title>
<link rel="stylesheet" type="text/css" href="<c:url value="../staticfiles/bootstrap/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="../staticfiles/font-awesome/css/font-awesome.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="../staticfiles/styles.css"/>"/>
</head>
<body>
	
	<c:set var="add" value="active" scope="request" />
	<c:import url="../inc/nav.jsp"/>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 align="center">Veuillez saisir les informations du client</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						<c:out value="${ requestScope.update == 'update' ? 'Edition' : 'Ajout' }"/> d'un nouveau client
					</div>
					<div class="panel panel-body">
						<form action="<c:url value="${ requestScope.update == 'update' ? '/client/update' : '/client/add' }"/>" method="POST">
								<c:if test="${ errors.vide != null }">
									<p class="error"><c:out value="${ errors.vide }"/></p>
								</c:if>
								
								<div class="form-group">
									<label>Nom</label>
										<c:if test="${ errors.nom != null }">
											<p class="error"><c:out value="${ errors.nom }"/></p>
										</c:if>
									<input type="text" required value="<c:out value="${ client.nom }"/>"  name="nom" class="form-control"/>
								</div>
								
								<div class="form-group">
										<c:if test="${ errors.prenom != null }">
											<p class="error"><c:out value="${ errors.prenom }"/></p>
										</c:if>
									<label>Prénom</label>
									<input type="text" required name="prenom" value="<c:out value="${ client.prenom }"/>" class="form-control"/>
								</div>
								
								<div class="form-group">
										<c:if test="${ errors.email != null }">
											<p class="error"><c:out value="${ errors.email }"/></p>
										</c:if>
									<label>Adresse email</label>
									<input type="text" required name="email" value="<c:out value="${ client.email }"/>" class="form-control"/>
								</div>
								
								<div class="form-group">
										<c:if test="${ errors.adresse != null }">
											<p class="error"><c:out value="${ errors.adresse }"/></p>
										</c:if>
									<label>Adresse</label>
									<input type="text" required name="adresse" value="<c:out value="${ client.adresse }"/>" class="form-control"/>
								</div>
								
								<div class="form-group">
										<c:if test="${ errors.telephone != null }">
											<p class="error"><c:out value="${ errors.telephone }"/></p>
										</c:if>
									<label>Telephone</label>
									<input type="text" required name="telephone" value="<c:out value="${ client.telephone }"/>" class="form-control"/>
								</div>
								<input type="hidden" name="c" value="${ client.id }" />
								<div class="form-group">
									<input type="submit" value="<c:out value="${ requestScope.update == 'update' ? 'Editer' : 'Ajouter' }"/>" class="btn btn-success" />
									<input type="reset" value="Réinitialiser" class="btn btn-warning" />
								</div>
						</form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	<c:import url="../inc/footer.jsp"/>
</body>
</html>