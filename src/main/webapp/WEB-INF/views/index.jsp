<%@include file="header.jsp"%>
<script>
var prodlist = ${plist}
var app = angular.module('myapp', []);
app.controller('mycontroller', function($scope) {
	$scope.product = prodlist;

});
</script>


<div class="container" style="margin-top:-15px;">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
		<li data-target="#myCarousel" data-slide-to="4"></li>

	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner">
		<div class="item active" id="a">
			<img src="./res/image/img.jpg" alt="Chania" style="max-height:800px">
			<div class="carousel-caption text">
				<b>Summer Collection</b>
			</div>
		</div>
		<div class="item">
			<img src="./res/image/img2.jpg" alt="Chicago">
			<div class="carousel-caption text" id="pict">
				<b>Fashion Forever!!</b>
				<p style="font-size:30px;"><b>UPTO 50% off</b></p>
			</div>
		</div>

		<div class="item">
			<img src="./res/image/img3.jpg" alt="New York">
			<div class="carousel-caption text" id="pi">
				<p><b>Buy 1 get 1 Free!!</b></p>
			</div>
		</div>
		<div class="item">
			<img src="./res/image/img4.jpg" alt="New York">
			<div class="carousel-caption text" id="pics">
				<b>Festive Collection</b>
				<p style="font-size:30px;"><b>Discount upto30%!</b></p>
			</div>
		</div>
		<div class="item">
			<img src="./res/image/images6.jpg" alt="New York">
			<div class="carousel-caption text" id="pic">
				<p><b>Get Flat 30% Discount!!</b></p>
			</div>
		</div>
	</div>

	<!-- Left and right controls -->
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span> <span
		class="sr-only">Next</span>
	</a>
</div>
</div>
<div class="container-fluid" ng-app="myapp" ng-controller="mycontroller" style="margin-top:5px;">
  <div class=row>
     <div ng-repeat="p in product | limitTo : 3"  class="col-sm-3">
        <div class="panel panel-primary">
          <div class="panel-heading text-center">{{p.pdname}}</div>
            <div class="panel-body"><a href="#"><img ng-src="./res/image/{{p.pdid}}.jpg" class="img-responsive" width="200px" height="200px"/></a></div>
              <div class="panel-footer text-center fa fa-inr">{{p.price}}</div>
            </div>
          </div>
        </div>
     </div>




<%@include file="footer.jsp"%>
