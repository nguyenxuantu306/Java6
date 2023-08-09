app.controller('thongke-order-ctrl', function($scope, $http) {
	$scope.form = {};
	$scope.itemsThongKeOrder = [];

	
	$scope.form = {};
	$scope.sort = function(keyname) {
		$scope.sortKey = keyname;
		$scope.reverse = !$scope.reverse;
	}
	
	$scope.initialize = function() {
		$http.get('/rest/orderdetails/thongke').then(response => {
			$scope.itemsThongKeOrder = response.data;
			console.log($scope.itemsThongKeOrder);
			
		}).catch(err => {
			
			console.log(err);
		})
		
		
		
		
	}
	
	
	
		
	
	
	
	$scope.pager = {
		page: 0,
		size: 3,
		get itemsThongKeOrder() {
			var start = this.page * this.size;
			return $scope.itemsThongKeOrder.slice(start, start + this.size);
		},
		
		get count() {
			return Math.ceil(1.0 * $scope.itemsThongKeOrder.length
				/ this.size);
		},
		first() {
			this.page = 0;

		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		},
		
		
	}
	$scope.initialize();

})