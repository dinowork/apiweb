appCliente.controller("clienteController", function($scope, $http){  	
	
	$http.defaults.headers.common.Authorization ="Bearer "+localStorage.getItem("userToken");
	
	$scope.clientes=[];
	$scope.cliente={};
	$scope.estados=[];
	$scope.estado={};
	
	// listar cliente
	carregarClientes = function () {
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/admin/clientes'
		}).then(function successCallback(response) {
			$scope.clientes = response.data;			
		}, function errorCallback(response) {
			console.log(response.status);
			console.log(response.data);				
		});	
	}

	// salvar cliente
	$scope.salvarCliente = function () {		
		if($scope.frmCliente.$valid){
			$http({
				method: 'POST',
				url: 'http://localhost:8080/admin/clientes',
				data: $scope.cliente
			}).then(function successCallback(response) {
				carregarClientes();
				$scope.alterarCliente();
				$scope.frmCliente.$setPristine();
			}, function errorCallback(response) {
				console.log(response.status);
				console.log(response.data);		 
			});	
		}else{
			window.alert("Dados invalidos")
		}
	}

	// excluir cliente
	$scope.excluirCliente = function (cli) {
		$http({
			method: 'DELETE',
			url: 'http://localhost:8080/admin/clientes/'+cli.id,			
		}).then(function successCallback(response) {
			pos = $scope.clientes.indexOf(cli);
			$scope.clientes.splice(pos , 1);									
		}, function errorCallback(response) {
			console.log(response.status);
			console.log(response.data);		 
		});	
	}
	
	// altera cliente (jogar para objeto na tela)	
	$scope.alterarCliente = function (cli) {
		$scope.cliente = angular.copy(cli);			
	}
	
	// cancelar cliente (limpar dando um new no objeto da tela)
	$scope.cancelarCliente = function () {
		$scope.cliente = {};
	}
	
	// carregar estados para o combo da tela de clientes
	carregarEstados= function () {
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/estados'
		}).then(function successCallback(response) {
			$scope.estados = response.data;			
		}, function errorCallback(response) {
			console.log(response.status);
			console.log(response.data);				
		});	
	}

	carregarClientes();
	carregarEstados();
	
}); 
