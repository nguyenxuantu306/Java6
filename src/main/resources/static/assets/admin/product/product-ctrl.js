app.controller("product-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.cates = [];
	$scope.form = {};
	$scope.field = [];
	$scope.error = ['err'];
	
	$scope.initialize = function(){
		// Load products
		$http.get("/rest/products").then(resp =>{
			$scope.items = resp.data;
			$scope.items.forEach(item =>{
				item.publication_date = new Date(item.publication_date)
			})
		});
		
		// Load categories
		$http.get("/rest/categories").then(resp =>{
			$scope.cates = resp.data;
			
		});
		
		/*// Load Athor
		$http.get("/rest/categories").then(resp =>{
			$scope.cates = resp.data;
			
		});*/
		
	}
	
	$scope.sort = function(keyname) {
		$scope.sortKey = keyname;
		$scope.reverse = !$scope.reverse;
	}
	
	// Khởi đầu
	$scope.initialize();
	
	// Xóa form
	$scope.reset = function(){
		$scope.error = ['err'];
		$scope.form = {
			publication_date:new Date(),
			image:'cloud-upload.jpg',
			available:true,
		};
		$('#id').attr('readonly', false);
		$('#btn-create').removeAttr('disabled');
		$('#btn-update').attr('disabled', 'disabled');
		$('#btn-delete').attr('disabled', 'disabled');
	}
	
	// Hiện thị lên form
	$scope.edit = function(item){
		$scope.form = angular.copy(item);	
		$('#btn-create').attr('disabled', 'disabled');
		$('#btn-delete').removeAttr('disabled');
		$('#btn-update').removeAttr('disabled');			
		$('html,body').animate({
			scrollTop: $(".info").offset().top
		},
			'slow');	
	}
	
	// Thêm sản phẩm mới
	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/products`, item).then(resp => {
			resp.data.publication_date = new Date(resp.data.publication_date)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm sản phẩm thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới sản phẩm");
			console.log("Error", error);
		});
	}

	
	// cặp nhật sản phẩm
	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/products/${item.id}`,item).then(resp =>{
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;				
			alert("Cập nhật sản phẩm thành công!");
		})
		.catch(error =>{
			alert("Lỗi cập nhật sản phẩm");
			console.log("Error",error);
		});
	}
	
	// Xóa sản phẩm 
	$scope.delete = function(item){
		$http.delete(`/rest/products/${item.id}`).then(resp =>{
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index,1);
			$scope.reset();				
			alert("Xóa sản phẩm thành công!");
		})
		.catch(error =>{
			alert("Lỗi Xóa sản phẩm");
			console.log("Error",error);
		});
	}
	
	// Upload hình
	$scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file',files[0]);
		$http.post('/rest/upload/images',data,{
			transformRequest:angular.identity,
			headers:{'Content-Type':undefined}
		}).then(resp =>{
			$scope.form.image = resp.data.name;
		}).catch(error =>{
			alert("Lỗi upload hình ảnh");
			console.log("Error",error);
		})
	}
	
	$scope.$watch('searchText', function(term) {
		$scope.filtered = filterFilter($scope.items, term);
		$scope.size = $scope.filtered.length;
		$scope.noOfPages = Math.ceil($scope.filtered.length / $scope.entryLimit);
	}, true);
	
	$scope.pager = {
		page:0,
		size:10,
		get items(){
			var start = this.page*this.size;
			 return $scope.items.slice(start,start + this.size);
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first(){
			this.page = 0;
		},
		prev(){
			this.page--;
			if(this.page < 0){
				this.last();
			}
		},
		next(){
			this.page++;
			if(this.page > this.count){
				this.first();
			}
		},
		last(){
			this.page = this.count-1;
		}		
	}
	
	$(function() {
		$("#example1").DataTable({
			"ajax": {
				"url": "/rest/products",
				"dataSrc": ""
			},
			"columns": [
				{ "data": "id" },
				{ "data": "name" },
				{ "data": "price" },
				{ "data": "publication_date" },
				{ "data": "image" },
				{ "data": "author" },
				{ "data": "genres" },
				{ "data": "available" },
				{
					/*"data": null,
					"render": function(data, type, row) {
						return '<button class="btn btn-success" ng-click="edit(' + row.id + ')">Xem chi tiết</button>';
					}*/
				}, 

				// Add more column configurations as needed
			],
			"responsive": true, "lengthChange": false, "autoWidth": false,
		}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
	});

	// Trong AngularJS controller hoặc service
	$scope.exportExcel = function() {
		$http.get('/print-to-excelsp', { responseType: 'arraybuffer' })
			.then(function(response) {
				var blob = new Blob([response.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
				var link = document.createElement('a');
				link.href = window.URL.createObjectURL(blob);
				link.download = 'example.xlsx';
				link.click();
			})
			.catch(function(error) {
				console.error('Error exporting Excel:', error);
			});
	};

	$scope.exportPdf = function() {
		$http.get('/print-to-pdfsp', { responseType: 'arraybuffer' })
			.then(function(response) {
				var blob = new Blob([response.data], { type: 'application/pdf' });
				var objectUrl = URL.createObjectURL(blob);
				var a = document.createElement('a');
				a.href = objectUrl;
				a.download = 'exportAccount.pdf';
				a.click();
				URL.revokeObjectURL(objectUrl);
			})
			.catch(function(error) {
				console.error('Error exporting PDF:', error);
			});
	};
	
});

	
