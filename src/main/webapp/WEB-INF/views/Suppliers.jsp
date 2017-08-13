<%@ include file="adminheader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
<script>
var suplist=${Suplierlist}
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) 
{
       $scope.supplier=suplist;
   
}
);
</script></head>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:choose>
<c:when test="${ClickedUpdateSuplier == true }">
<form:form class="jumbotron" action="updatesuplier" method="post" commandName="s" style="background-color:orangered;">
		<div class="row" style="padding-bottom: 5px; margin-left:6px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Sid">ID: </form:label>
					<form:input path="Sid" class="form-control disabledfield" readonly="true" placeholder="Enter supplier ID" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Sname">Name: </form:label>
					<form:input path="Sname" class="form-control disabledfield" placeholder="Enter Supplier name" required="required"></form:input>	
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Scontact">contact: </form:label>
					<form:input path="Scontact" class="form-control disabledfield"  placeholder="Enter Supplier contact" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Saddress">address: </form:label>
					<form:input path="Saddress" class="form-control disabledfield"  placeholder="Enter Supplier address" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Update Supplier"/>
			</div>	
		</div>
	</form:form></c:when>
	<c:otherwise>
<form:form class="jumbotron" action="addsuplier" method="POST" commandName="s" style="background-color:orangered;">
<div class="row" style="padding-bottom: 5px; margin-left:6px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Sid">ID: </form:label>
					<form:input path="Sid" class="form-control disabledfield" readonly="true" placeholder="Enter supplier ID" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Sname">Name: </form:label>
					<form:input path="Sname" class="form-control disabledfield" placeholder="Enter Supplier name" required="required"></form:input>	
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Scontact">contact: </form:label>
					<form:input path="Scontact" class="form-control disabledfield"  placeholder="Enter Supplier contact" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="Saddress">address: </form:label>
					<form:input path="Saddress" class="form-control disabledfield"  placeholder="Enter Supplier address" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Add Supplier"/>
			</div>	
		</div>
		</form:form>
</c:otherwise>
</c:choose>
		<div ng-app="myApp" ng-controller="myCtrl">
	
			<h4 align="center">Category</h4>
			<div id="custom-search-input">
				<div class="input-group col-md-12">
					<input type="text" class="search-query form-control" placeholder="Search" ng-model="seachproduct" /></span>				
				</div>
			</div>

			<div class="table-responsive">
				<table id="mytable" class="table table-bordred table-striped table-hover">
				<tr>
					<th>Supplier Id</th>
					<th>Supplier Name</th>
					<th>Supplier contact</th>
					<th>Category address</th>
					<th>Edit\Delete</th>
				  			
				</tr>
			<tr class="success"	ng-repeat="sup in supplier|filter:seachproduct">
						<td>{{sup.Sid}}</td>
						<td>{{sup.Sname}}</td>
						<td>{{sup.Scontact}}</td>
					    <td>{{sup.Saddress}}</td>
						 <td align="center">
						 <a href="fetchbyid?id={{sup.Sid}}"><button type="button" class="btn btn-sucess btn-sm">
						 <span class="glyphicon glyphicon-edit"></span>
						 </button></a>
						 
						 <a href="delsuplier?id={{sup.Sid}}"> <button type="button" class="btn btn-danger btn-sm">
						 <span class="glyphicon glyphicon-trash"></span>
						 </button></a>
                              
                            </td>
                           
                            
					</tr>
				</table>
			</div>
	
	</div>

		

		





