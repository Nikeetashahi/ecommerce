<%@ include file="adminheader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
	var productlist = ${prodlist}
	var Categorylist = ${Catlist}
	var suplist = ${Suplierlist}
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope) {
		$scope.products = productlist;
		$scope.categories = Categorylist;
		$scope.supplier = suplist;

	});
</script>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div ng-app="myApp">
	<c:choose>
		<c:when test="${updateproductform == true }">
			<form:form class="jumbotron" action="updatep" method="POST"
				commandName="mp" enctype="multipart/form-data"
				style="background-color:orangered;" ng-controller="myCtrl">
				<div class="row" style="padding-bottom: 5px; margin-left: 6px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="pdid">ID: </form:label>
							<form:input path="pdid" class="form-control disabledfield"
								readonly="true" placeholder="Enter Product ID"
								required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="pdname">Name: </form:label>
							<form:input path="pdname" class="form-control disabledfield"
								placeholder="Enter Product name" required="required"></form:input>
						</div>

					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="price">price: </form:label>
							<form:input path="price" class="form-control disabledfield"
								placeholder="Enter Product price" required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="size">size: </form:label>
							<form:input path="size" class="form-control disabledfield"
								placeholder="Enter Product size" required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="pquantity">quantity: </form:label>
							<form:input path="pquantity" class="form-control disabledfield"
								placeholder="enter product quantity " required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="description">description: </form:label>
							<form:input path="description" class="form-control disabledfield"
								placeholder="Write about Product " required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="cid">cat_id: </form:label>
							<form:select path="cid" class="form-control">
								<option ng-repeat="category in categories"
									value="{{category.cid}}">{{category.cname}}
								<option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="Sid">sup_id: </form:label>
							<form:select path="Sid" class="form-control">
								<option ng-repeat="suplier in supplier" value="{{suplier.Sid}}">{{suplier.Sname}}</option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="product_image">image: </form:label>
							<form:input path="product_image" class="form-control" type="file"
								required="required"></form:input>
						</div>
					</div>
				</div>

				<div class="row" style="padding-bottom: 5px">
					<div class="col-sm-4 col-sm-offset-4">
						<input type="submit" class="btn btn-primary btn-block"
							value="Update Product" />
					</div>
				</div>
			</form:form>
		</c:when>
		<c:otherwise>
			<form:form class="jumbotron" action="addProduct" method="POST"
				commandName="mp" enctype="multipart/form-data"
				style="background-color:orangered;" ng-controller="myCtrl">
				<div class="row" style="padding-bottom: 5px; margin-left: 6px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="pdid">ID: </form:label>
							<form:input path="pdid" class="form-control disabledfield"
								readonly="true" placeholder="Enter Product ID"
								required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="pdname">Name: </form:label>
							<form:input path="pdname" class="form-control disabledfield"
								placeholder="Enter Product name" required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="price">price: </form:label>
							<form:input path="price" class="form-control disabledfield"
								placeholder="Enter Product ID" required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="size">size: </form:label>
							<form:input path="size" class="form-control disabledfield"
								placeholder="Enter Product size" required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="pquantity">Quantity: </form:label>
							<form:input path="pquantity" class="form-control disabledfield"
								placeholder="enter product quantity " required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="description">description: </form:label>
							<form:input path="description" class="form-control disabledfield"
								placeholder="Write about Product " required="required"></form:input>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="cid">cat_id: </form:label>
							<form:select path="cid" class="form-control">
								<option ng-repeat="category in categories"
									value="{{category.cid}}">{{category.cname}}</option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="Sid">sup_id: </form:label>
							<form:select path="Sid" class="form-control">
								<option ng-repeat="suplier in supplier" value="{{suplier.Sid}}">{{suplier.Sname}}</option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row" style="padding-bottom: 5px; margin-left: 3px;">
					<div class="col-md-4 col-md-offset-4">
						<div class="form-group">
							<form:label path="product_image">image: </form:label>
							<form:input path="product_image" class="form-control" type="file"
								required="required"></form:input>
						</div>
					</div>
				</div>

				<div class="row" style="padding-bottom: 5px">
					<div class="col-sm-4 col-sm-offset-4">
						<input type="submit" class="btn btn-primary btn-block"
							value="Add Product" />
					</div>
				</div>
			</form:form>
		</c:otherwise>
	</c:choose>


	<div ng-controller="myCtrl">
		<div class="col-md-12">
			<h4 align="center">Manage Products</h4>
			<div id="custom-search-input">
				<div class="input-group col-md-12">
					<input type="text" class="search-query form-control"
						placeholder="Search" ng-model="seachproduct" /></span>
				</div>
			</div>

			<div class="table-responsive">
				<table id="mytable"
					class="table table-bordred table-striped table-hover" >
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Product Description</th>
						<th>Product Price</th>
						<th>Product Size</th>
						<th>product quantity</th>
						<th>Category id</th>
						<th>Supplier id</th>
						<th>image</th>
						<th>Update/Delete</th>

					</tr>
					<tr class="success"
						ng-repeat="prod in products|filter:seachproduct">
						<td>{{prod.pdid}}</td>
						<td>{{prod.pdname}}</td>
						<td>{{prod.description}}</td>
						<td>{{prod.price}}</td>
						<td>{{prod.size}}</td>
						<td>{{prod.pquantity}}</td>
						<td>{{prod.cid}}</td>
						<td>{{prod.Sid}}</td>
						<td ng-controller="myCtrl"><img alt="{{prod.pdid}}" ng-src="C:/Users/NIKEETA SHAHI/workspace/nikita/ecommerce/src/main/webapp/res/image/{{prod.pdid}}.jpg"
							height="50px" width="50px" /></td>
						<td align="center"><a href="fetchProduct?id={{prod.pdid}}"><button
									type="button" class="btn btn-sucess btn-sm">
									<span class="glyphicon glyphicon-edit"></span>
								</button></a> <a href="deleteProduct?id={{prod.pdid}}">
								<button type="button" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
						</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
