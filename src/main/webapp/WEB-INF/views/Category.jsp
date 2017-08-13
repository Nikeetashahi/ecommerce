<%@ include file="adminheader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script>
var Categorylist=${Catlist}
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) 
{
       $scope.category=Categorylist;
   
}
);
</script>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:choose>
<c:when test="${ClickedUpdateProduct == true }">
<form:form class="jumbotron" action="updateCategory" method="POST" commandName="c" style="background-color:orangered;">
		<div class="row" style="padding-bottom: 5px; margin-left:6px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="cid">ID: </form:label>
					<form:input path="cid" class="form-control disabledfield" readonly="true" placeholder="Enter category ID" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="cname">Name: </form:label>
					<form:input path="cname" class="form-control disabledfield" placeholder="Enter category name" required="required"></form:input>	
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="cdescription">description: </form:label>
					<form:input path="cdescription" class="form-control disabledfield"  placeholder="Enter category description" required="required"></form:input>
				</div>
			</div>
			</div>

					<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Update category" />
			</div>	
		</div>
	</form:form></c:when>
	<c:otherwise>
<form:form class="jumbotron" action="addCategory" method="POST" commandName="c" style="background-color:orangered;">
        <div class="row" style="padding-bottom: 5px; margin-left:6px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="cid">ID: </form:label>
					<form:input path="cid" class="form-control disabledfield" readonly="true" placeholder="Enter category ID" required="required"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="cname">Name: </form:label>
					<form:input path="cname" class="form-control disabledfield" placeholder="Enter category name" required="required"></form:input>	
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px; margin-left:3px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<form:label path="cdescription">description: </form:label>
					<form:input path="cdescription" class="form-control disabledfield"  placeholder="Enter category description" required="required"></form:input>
				</div>
			</div>
			</div>
				
			<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Add category" />
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
					<th>Category Id</th>
					<th>Category Name</th>
					<th>Category Description</th>
					 <th>Enable/Disable</th>	
					<th>Edit\Delete</th>
				  <th>Category Status</th>			
					</tr>
			<tr class="success"	ng-repeat="cat in category|filter:seachproduct">
						<td>{{cat.cid}}</td>
						<td>{{cat.cname}}</td>
						<td>{{cat.cdescription}}</td>
					    <td>{{cat.cstatus}}</td>
						 <td align="center">
						 <a href="fetchCategory?id={{cat.cid}}"><button type="button" class="btn btn-sucess btn-sm">
						 <span class="glyphicon glyphicon-edit"></span>
						 </button></a>
						 
						 <a href="deleteCategory?id={{cat.cid}}"> <button type="button" class="btn btn-danger btn-sm">
						 <span class="glyphicon glyphicon-trash"></span>
						 </button></a>
                              
                            </td>
                            <td align="center">
						 <a href="enablecategory?cid={{cat.cid}}"><button type="button" class="btn btn-sucess btn-sm">
						 <span class="glyphicon glyphicon-eye-open"></span>
						 </button></a>
						 
						 <a href="daiablecategory?cid={{cat.cid}}"> <button type="button" class="btn btn-danger btn-sm">
						 <span class="glyphicon glyphicon-eye-close"></span>
						 </button></a>
                              
                            </td>
                            
                            
					</tr>
				</table>
			</div>
	
	</div>

		

