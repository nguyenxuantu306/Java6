const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function($scope, $http) {
   
   // QUẢN LÝ GIỎ HÀNG
   
   $scope.cart = {
	   items:[],
	   
	   // thêm sp vào giỏ hàng
	   add(id){
		   alert(id);
		  /* var item = this.items.find(item => item.id == id);
		   if(item){
			   item.qty++;
			   this.saveToLocalStorage();
		   }
		   else{
			   $http.get(`/rest/products/${id}`).then(resp =>{
				   resp.data.qty = 1;
				   this.items.push(resp.data);
				   this.saveToLocalStorage();
				  
				   
			   })
		   }*/
	   },
	   
	   // Xóa sp khỏi giỏ hàng
	   remove(id){
		 var index = this.items.findIndex(item => item.id ==id);
		 this.items.splice(index,1);
		 this.saveToLocalStorage();  
	   },
	   
	   // Xóa sạch các mặt hàng trong giỏ
	   clear(){
		   this.items = []
		   this.saveToLocalStorage();
	   },
	   
	  
	   
	   // Tính tổng số lượng các mặt hàng trong giỏ
	   get count(){
		 return this.items
		 	.map(item => item.qty)
		 	.reduce((total,qty)=> total += qty,0);
	   },
	   
	   // tổng thành tiền các mặt hàng trong giỏ
	   get amount(){
		 return this.items
		 	.map(item => item.qty * item.price)
		 	.reduce((total,qty)=> total += qty,0);
	   },
	   
	   // Lưu giỏ hàng vào trong Local storage
	   saveToLocalStorage(){
		 var json = JSON.stringify(angular.copy(this.items));
		 localStorage.setItem("cart",json);  
	   },
	   
	   // Đọc giỏ hàng từ local storage
	   loadFromLocalStorage(){
		   var json = localStorage.getItem("cart");
		   this.items = json ? JSON.parse(json):[];
	   }
   }
   
   $scope.cart.loadFromLocalStorage();
   
   
   $scope.order = {
	   createDate: new Date(),
	   address:"",
	   account:{username:$("#username").text()},
	   get orderDetails(){
		   return $scope.cart.items.map(item =>{
			   return{
				   product:{id:item.id},
				   price:item.price,
				   quantity:item.qty
			   }
		   });
	   },
	   purchase(){
		   var order = angular.copy(this);
		   // Thực hiện đặt hàng
		   $http.post("/rest/orders",order).then(resp =>{
			   alert("Đặt hàng thành công!");
			   $scope.cart.clear();
			   location.href = "/order/detail/" + resp.data.id;
		   }).catch(error =>{
			   alert("Đặt hàng lỗi!");
			   console.log(error)
		   })
	   }
   }
});
/*-------------------------------------Đóng mở modal mini-cart------------------------------------*/

  // Function to display the mini cart modal
  function displayMiniCart() {
    var miniCart = document.querySelector(".mini_cart");
    miniCart.style.display = "block";
  }

  // Function to close the mini cart modal
  function closeMiniCart() {
    var miniCart = document.querySelector(".mini_cart");
    miniCart.style.display = "none";
  }

  // Display the mini cart modal when the shopping cart link is clicked
  document.querySelector(".shopping_cart a").addEventListener("click", function(event) {
    event.preventDefault(); // Prevent the link from navigating to the cart page
    displayMiniCart();
  });

  // Close the modal when the document is clicked outside the modal
  window.onclick = function(event) {
    var miniCart = document.querySelector(".mini_cart");
    if (event.target === miniCart) {
      closeMiniCart();
    }
  }



