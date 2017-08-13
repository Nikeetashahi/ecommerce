<%@ include file="header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

<script type="text/javascript">
var pro=${prodlist}
var app=angular.module('myapp',[]);
app.controller('mycontroller',function($scope){
	$scope.pro=pro;
	});

</script>

<div  ng-controller="mycontroller" class="container" style="margin-top:2px;">
  <div class="row">
    <div ng-repeat="p in pro" class="col-sm-3">
     <div class="panel panel-primary">
       <div class="panel heading text-centr">{{p.pdname}}</div>
        <div class="panel-body">
          <a href="#"><img ng-src="./res/image/{{p.pdid}}.jpg" class="img-responsive" width="200px" height="200px"/></a>
         </div>
        <div class="panel-footer text-center fa fa-inr">{{p.price}}</div>
      </div>
    </div>
</div>
</div>
<%@ include file="footer.jsp"%>