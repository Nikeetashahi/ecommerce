<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>kidz's club</title>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="res/css/style.css" type="text/css" rel="stylesheet"></link>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script type="text/javascript" src="./res/passwordmatch.js"></script>

</head>
<body ng-app="myapp" background="./res/image/bg5.jpg">
	<nav class="nav navbar-default custom1">
	<div class="container-fluid">
		<div class="navbar-header logo">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
			<a class="navbar-brand custom" href="#"><img
				src="./res/image/header.jpg" height="70px" width="150px"></img></a>
		</div>
		  <div class="collapse navbar-collapse" id="myNavbar">
		  <ul class="nav navbar-nav demo"
			style="margin-left: 20px; margin-top: 18px;">
			<li class="active"><a href="#">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">BOY'S <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="tshirt">T-Shirt</a></li>
					<li><a href="shirt">Shirt</a></li>
					<li><a href="jeans">Jeans</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">GIRL'S <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Frocks</a></li>
					<li><a href="#">Top,Tees & Shirt</a></li>
					<li><a href="#">Short & capris</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">BABY'S CARE <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Baby Product</a></li>
					<li><a href="#">Diapers</a></li>
					<li><a href="#">Baby's Cloth</a></li>
				</ul></li>
		</ul>
		
		<form class="navbar-form navbar-left">
			<div class="input-group" style="width: 150%">
				<input type="text" class="form-control"
					placeholder="Search For a Product" style="font-size: 15px;">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
			</div>
		</form>
		</div>
		<ul class="nav navbar-nav navbar-right">

			<li style="color: blue;"><a href="#" class="cart"><span
					class="glyphicon glyphicon-shopping-cart">Cart</span></a></li>
			<c:choose>
				
					<c:when test="${userloggedin==true}">
						<li><a href="perform_logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</c:when>
					<c:otherwise>
						<li><a data-toggle="modal" data-target="#myModal"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:otherwise>
			</c:choose>
		</ul>

	</div>
	</nav>

	<div class="container">
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: red;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h1 style="text-align: center; color: black;">Register</h1>
					</div>
					<div class="modal-body" id="container1">
						<form:form action="signup" commandName="user" method="POST">
							<div class="form-group">
								<form:label path="firstname">First Name: </form:label>
								<form:input path="firstname" class="form-control"
									placeholder="Enter First Name" required="required"></form:input>
							</div>
							<div class="form-group">
								<form:label path="lastname">Last Name:</form:label>
								<form:input path="lastname" class="form-control"
									placeholder="Enter Last Name" required="required"></form:input>
							</div>
							<div class="form-group">
								<form:label path="username">User Name:</form:label>
								<form:input path="username" class="form-control"
									placeholder="Enter User Name" required="required"></form:input>
							</div>
							<div class="form-group">
								<form:label path="email_id">E-mail:</form:label>
								<form:input path="email_id" class="form-control" type="email"
									placeholder="Enter Email ID" required="required"
									pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
									title="Enter valid mail ID"></form:input>
							</div>
							<div class="form-group">
								<form:label path="password">Password:</form:label>
								<form:password path="password" id="password"
									class="form-control" placeholder="Enter Password"
									required="required"
									title="The password must contain at least one number and one uppercase and lowercase letter and one special character like !,@,#,~,$,%,^,&,*,_ only, and at least 8 or more characters"></form:password>
							</div>
							<div class="form-group">
								<form:label path="confirmpassword">Confirm Password:</form:label>
								<form:password path="confirmpassword" id="confirmpassword"
									onkeyup="confPass(); return false;" class="form-control"
									placeholder="Re-enter Password" required="required"></form:password>
								<span id="confirmMessage" class="confirmMessage"></span>
							</div>
							<div class="form-group">
								<form:label path="contact_no">Contact Number:</form:label>
								<form:input path="contact_no" class="form-control"
									placeholder="Enter Contact Number" required="required"
									pattern="(^[1-8]\d{9}$)|(^[789]\d{9}$)"
									title="Please enter a valid contact number (including STD code for landlines) but excluding the zero at the start"></form:input>
							</div>
							<div class="form-group">
								<form:label path="address">Address:</form:label>
								<form:textarea path="address" rows="3" class="form-control"
									placeholder="Enter Address" required="required"></form:textarea>
							</div>
							<div class="form-group">
								<form:label path="city">City:</form:label>
								<form:input path="city" class="form-control"
									placeholder="Enter City" required="required"></form:input>
							</div>
							<div class="form-group">
								<form:label path="pincode">pin code:</form:label>
								<form:input path="pincode" class="form-control"
									placeholder="Enter Pincode" required="required"
									pattern="^[1-9][0-9]{5}$" title="Please enter a valid pincode"></form:input>
							</div>
							<div class="form-group">
								<form:label path="state">State:</form:label>
								<form:input path="state" class="form-control"
									placeholder="Enter State" required="required"></form:input>
							</div>

							<div class="form-group">
								<form:label path="acceptprivacy">Accept Privacy Policy</form:label>
								<form:checkbox path="acceptprivacy" value="accept"
									required="required" />
								<a data-target="#privacy" data-toggle="modal"
									data-dismiss="modal">Read Policy</a>
							</div>
							<input class="btn btn-primary btn-block" type="submit"
								value="Submit">
						</form:form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> Close
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>