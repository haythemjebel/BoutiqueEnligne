<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<title>Acceuill</title>
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
					<a href="index" class="list-group-item active"> Tous les Produits </a>
					<c:forEach var="i" items="${categories}">
					<a href="index?value=${i.id}" class="list-group-item">${i.description}</a>
					<!-- id bech yeb3atheha les servlet (id) nesamiha kima ne7eb  -->
					</c:forEach>
				</div>
			</div>

			<div class="col-md-9">
				<c:forEach var="i" items="${produits}">
					<div class="col-md-4">
						<div class="thumbnail">
							<img src="images/${i.id}.jpg">
								<div class="caption">
									<h3>${i.description}</h3>
									<p>
										<a href="Panier?x=${i.id}" class="btn btn-primary">Ajouter Panier</a> <a
											href="#" class="btn btn-danger">${i.prix}</a>
									</p>
								</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

	</div>

</body>
</html>