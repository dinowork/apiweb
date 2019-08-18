appCliente.controller("clienteDetalheController", function($scope, $route, $http ){    		
	$scope.$route = $route;	
	$scope.params = $route.current.params;
	$scope.cliente = {};
	
	$http.get("/admin/clientes"+$scope.params.clienteId).then(function(response){
		$scope.cliente = response.data;
	}, function(response){		
		console.log(response.status);
		console.log(response.data);	
	});
	
}); 
