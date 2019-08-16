appCliente.controller("clienteController", function($scope, $http){  
	
	$scope.clientes=[];
	
	// bind com o form
	$scope.cliente={};
	
	carregarClientes = function () {
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/clientes'
		}).then(function successCallback(response) {
			$scope.clientes = response.data;			
		}, function errorCallback(response) {
			console.log(response.status);
			console.log(response.data);				
		});	
	}

	$scope.salvarCliente = function () {
		$http({
			method: 'POST',
			url: 'http://localhost:8080/clientes',
			data: $scope.cliente
		}).then(function successCallback(response) {
			carregarClientes();
			$scope.alterarCliente();
		}, function errorCallback(response) {
			console.log(response.status);
			console.log(response.data);		 
		});	
	}

	$scope.excluirCliente = function (cli) {
		$http({
			method: 'DELETE',
			url: 'http://localhost:8080/clientes/'+cli.id,			
		}).then(function successCallback(response) {
			pos = $scope.clientes.indexOf(cli);
			$scope.clientes.splice(pos , 1);									
		}, function errorCallback(response) {
			console.log(response.status);
			console.log(response.data);		 
		});	
	}
	
	$scope.alterarCliente = function (cli) {
		$scope.cliente = angular.copy(cli);			
	}
	
	$scope.cancelarCliente = function () {
		$scope.cliente = {};
	}
	
	carregarClientes();
	

}); 
