<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>
.form-group {
margin-top: 40px;
}

.margin-item {
margin-top: 25px;
}

.margin-left {
margin-left: 35px;
}

.content {
height: auto;
background-color: #fff;
top: 50px;
}
#top{
margin-top: 10px;
}
.btn-warning {
background-color: orange;
color: white;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">E-Boutique</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="index">Home</a></li>
				<li><a href='login.jsp'>login</a></li>
				<li class="active"><a href='signup.jsp'>signup</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="panier.jsp"> Mon Panier </a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container" id="top">	
<form method="post" action="Signup">
<div class="form-group">email:<br><input class="form-control" type="text" name="email" placeholder="email"><br></div>
<div class="form-group">name<br><input class="form-control" type="text" name="name" placeholder="name"><br></div>
<div class="form-group">lastname<br><input class="form-control" type="text" name="surname" placeholder="lastname"><br></div>
<div class="form-group">username<br><input class="form-control" type="text" name="username" placeholder="username"><br></div>
<div class="form-group">password<br><input class="form-control" type="password" name="pass1" placeholder="password"><br></div>
<div class="form-group">confirm password<br><input class="form-control" type="password" name="pass2" placeholder="confirm password"><br></div>
<div class="form-group"><input class="btn btn-primary" type="submit" value="signup"></div>
</form>
<% Messages message = (Messages)request.getAttribute("message"); 
if(message !=null){
if(message.getId()==1)
{
%>
<span style="color:red"><%=message.getMessage()%></span>
<%} if(message.getId()==2){ %>
<span style="color:green"><%=message.getMessage() %></span>
<%}} %>
</div>
</body>
</html>