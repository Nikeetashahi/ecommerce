<%@ include file="header.jsp"%>


<script type="text/javascript">
var prudt=${prodlist}
var app=angular.modal('myapp',[]);
app.controller('mycontroller',function($scope)
{
	$scope.product=prudt;
	});

</script>

<div ng-app="myapp" ng-controller="mycontroller" class="container" style="margin-top:10px;">
  <div class="row">
    <div ng-repeat="p in prudt" class="col-sm-3">
     <div class="panel panel-primary">
       <div class="panel heading text-centr">{{p.pdname}}</div>
        <div class="panel-body">
          <a href="#"><img ng-src="./res/image/{{p.pdid}].jpg" class="img-responsive" width="200px" height="200px"/></a>
         </div>
        <div class="panel-footer text-center fa fa-inr">{{p.price}}</div>
      </div>
    </div>
</div>
</div>
<%@ include file="footer.jsp"%>