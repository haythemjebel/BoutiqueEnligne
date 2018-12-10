<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="Model.LignePanier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Model.Panier"%>
<%@page import="Model.LignePanier"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
	<title>Panier</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">E-Boutique</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index">Home</a></li>
				<li><a href='login.jsp'>login</a></li>
				<li><a href='signup.jsp'>signup</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="panier.jsp"> Mon Panier </a></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class="container">

		<div class="row" style="margin-top: 80px;">
			<div class="col-md-3">
				<div class="list-group">
					<a href="#" class="list-group-item active"> Tous les Produits </a>
					<c:forEach var="i" items="${categories}">
						<a href="index?value=${i.id}" class="list-group-item">${i.description}</a>
						<!-- id bech yeb3atheha les servlet (id) nesamiha kima ne7eb  -->
					</c:forEach>
				</div>
			</div>


			<div class="col-md-9">
				<div class="panel panel-info">
					<div class="panel-heading">Mon panier</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>D&eacute;signation de vos articles</th>
									<th>Prix UT</th>
									<th>Quantit&eacute;</th>
									<th>Total</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									Panier panier = (Panier) session.getAttribute("panier");
								%>
								<%
									for (LignePanier lp : panier.getLignesPanier()) {
								%>
								<tr>
									<th scope="row"><%=lp.getProduit().getId()%></th>
									<!-- sion out.println(lp.getProduit.getid) -->
									<td><img src="images/<%=lp.getProduit().getId()%>.jpg"
										width="10%"> <%=lp.getProduit().getDescription()%></td>
									<td><%=lp.getProduit().getPrix()%>Dt</td>
									<td><%=lp.getQuantite()%></td>
									<td><%=lp.getProduit().getPrix() * lp.getProduit().getQuantite()%></td>
									<td><a class="btn btn-danger " href="DeletePanier?id=<% out.print(lp.getProduit().getId());%>">Suppimer </a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>


	</div>


</body>
</html>
