app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/product",{
		templateUrl:"/assets/admin/product/index.html",
		controller:"product-ctrl"
	})
	.when("/genres",{
		templateUrl:"/assets/admin/genres/index.html",
		controller:"genres-ctrl"
	})
	
	.when("/account",{
		templateUrl:"/assets/admin/account/index.html",
		controller:"account-ctrl"
	})
	.when("/order",{
		templateUrl:"/assets/admin/order/index.html",
		controller:"order-ctrl"	
	}).when('/thongke_sp', {
		templateUrl: "/assets/admin/thongke/_thongke_sp.html",
		controller: 'thongke-sp-ctrl'	
	}).when("/authorize",{
		templateUrl:"/assets/admin/authority/index.html",
		controller:"authority-ctrl"
	})	
	.when("/unauthorized",{
		templateUrl:"/assets/admin/authority/404.html",
		controller:"authority-ctrl"
	})	
	.when("/main",{
		templateUrl:"/assets/admin/result/main.html",
		controller:"thongke-ctrl"
	})	
	
	.otherwise({
		templateUrl:"/assets/admin/main.html",
	});
});