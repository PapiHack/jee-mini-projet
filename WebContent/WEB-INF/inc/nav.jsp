<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<c:url value="/home"/>">Gestion des clients</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li class="<c:out value="${ requestScope.home }"/>"><a href="<c:url value="/home"/>">Accueil</a></li>
        <li class="<c:out value="${ requestScope.add }"/>"><a href="<c:url value="/client/add"/>"><c:out value="${ requestScope.update == 'update' ? 'Edition' : 'Ajout' }"/> d'un client <span class="sr-only">(current)</span></a></li>
        <li class="<c:out value="${ requestScope.list }"/>"><a href="<c:url value="/client/list"/>">Liste des clients</a></li>
      </ul> <ul class="nav navbar-nav navbar-right">
        <li class="<c:out value="${ requestScope.about }"/>"><a href="<c:url value="/about"/>">A Propos</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>