app.controller('ShopMeCtrl', function($scope, $http, $timeout) {
	$scope.message = "ShopMe.com Welcomes you";
	$scope.selectedProduct = {};
	$scope.emailUser = "";
	$scope.quantityDDP = loadQtyDDP();
	$scope.selectedQuantity = 0;
	$scope.httpResponseMessage = "";
	$scope.noticeMeNeeded = false;
	$scope.orderDetails = {
			productId : "",
			qty : $scope.selectedQuantity,
			email: $scope.emailUser,
			name: "",
			address: ""
	};
	
	$scope.noticeMe = function(prodId) {
		$scope.orderDetails.productId = prodId;
		$scope.orderDetails.qty = $scope.selectedQuantity,
		$scope.orderDetails.email = $scope.emailUser;
		$http.post('product/buy/reminder.html', $scope.orderDetails).then(function(response) {
			alert("You request has been registerd");
		}, function(response) {
			alert("Failed to add reminder");
		});
	};
	
	$scope.finalize =  function(data) {
		$scope.message = data.Message;
	};
	$scope.finalizeOrder = function () {
		alert("Test success");
		debugger;
		$scope.orderDetails;
		$http.post('product/buy/finalize.html', $scope.orderDetails).then(function(response) {
			finalize(response.data);
		}, function(response) {
			console.info(response);
			finalize(response.data);
		});
	};
	
	$scope.createOrder = function (productId) {
		debugger;
		if ($scope.selectedQuantity == 0 || $scope.selectedQuantity == '') {
			return;
		}
		if ($scope.emailUser == '') {
			return;
		}
		var order = {
				productId : productId,
				qty: $scope.selectedQuantity,
				email:$scope.emailUser
		};
		
		$http.post('product/buy/createorder.html', order).then(function(response) {
			productBuyProcess(response);
		}, function(response) {
			console.info(response);
			productBuyProcess(response);
		});
	};
	
	var productBuyProcess = function (response) {
		$scope.httpResponseMessage = response.data.Message;
		if ( response.data.Available == 'true') {
			$scope.noticeMeNeeded = false;
			$timeout(function() {
				localStorage.setItem('selectedQuantity', $scope.selectedQuantity);
				localStorage.setItem('emailUser', $scope.emailUser );
	           window.location = "finalize.html";
	        }, 1500); // delay 1.5 sec
		} else {
			$scope.noticeMeNeeded = true;
		}
		
	};	
	function chunk(arr, size) {
		var newArr = [];
		for ( var i = 0; i < arr.length; i += size) {
			newArr.push(arr.slice(i, i + size));
		}
		return newArr;
	};
	$scope.loadProduct = function () {
		$scope.selectedProduct = angular.fromJson(localStorage.getItem('selectedProduct'));
	};
	$scope.loadProductOnBuy = function () {
		debugger;
		$scope.selectedProduct = angular.fromJson(localStorage.getItem('selectedProduct'));
		$scope.orderDetails.qty = localStorage.getItem('selectedQuantity');
		$scope.orderDetails.email = localStorage.getItem('emailUser');
		$scope.orderDetails.productId = $scope.selectedProduct.id;
	};
	
	$scope.setProductToLocal = function (parentIndex, childIndex) {
		localStorage.setItem('selectedProduct', angular.toJson($scope.productsFull[parentIndex][childIndex]));
		console.log($scope.productsFull[parentIndex][childIndex]);
		window.location = "product.html";
	};
	
	var populateData = function(data) {
		$scope.productsFull = chunk(data, 3);
	};
	
	$scope.loadAllProducts = function() {
		$http.get('product/show/all.html').then(function(response) {
			populateData(response.data);
		}, function(response) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			console.info(response);
			populateData(response.data);
		});
	};

	function loadQtyDDP () {		
		var newArr = [];
		for ( var i = 0; i < 100; i++) {
			newArr[i] = i;
		}
		return newArr;
	};
});