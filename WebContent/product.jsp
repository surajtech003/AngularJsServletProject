<html ng-app="products.controller">
<head>
<script type="text/javascript" src="js/angular.min.js"></script>
<script>
	var app = angular.module("products.controller", []);
	app.controller("products_controller", [
			'$scope',
			'$window',
			'$http',
			function($scope, $window, $http) {
				$scope.productList = function() {
					$window.alert("calling function  -->minprice:"
							+ $scope.minPrice + " -->MaxPrice:"
							+ $scope.maxPrice);
					$http({
						url : "/AngularProductAppn/getProducts",
						method : "get",
						params : {
							"minPrice" : $scope.minPrice,
							"maxPrice" : $scope.maxPrice
						}
					}).then(function(result) {
						$scope.jsonList = result.data;
						$window.alert("success:" + $scope.jsonList);
					}, function(result) {
						$window.alert("failure:" + result);
					});
				}

			} ]);
</script>
</head>
<body ng-controller="products_controller">
	MinPrice:
	<input type="text" ng-model="minPrice" />
	<br /> MaxPrice:
	<input type="text" ng-model="maxPrice" />
	<br />
	<button ng-click="productList()">Search</button>

	<br />
	<hr>
	<div>
		<table border="1">
			<tr>
				<th>PID</th>
				<th>PName</th>
				<th>Price</th>
			</tr>
			<tr ng-repeat="product in jsonList">
				<td>{{product.pid}}</td>
				<td>{{product.pname}}</td>
				<td>{{product.price}}</td>
			</tr>

		</table>
	</div>

</body>
</html>