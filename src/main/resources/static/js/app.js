// criacao do modulo principal da aplicacao
var appCliente = angular.module("appCliente",["ngRoute"]);

appCliente.config(function($routeProvider, $locationProvider, $httpProvider){	
	$routeProvider
	.when("/clientes",{templateUrl:"view/cliente.html",controller:"clienteController"})
	.when("/clientes/:clienteId",{templateUrl:"view/cliente-detalhe.html",controller:"clienteDetalheController"})
	.when("/cidades" ,{templateUrl:"view/cidade.html" ,controller:"cidadeController"})
	.when("/estados" ,{templateUrl:"view/estado.html" ,controller:"estadoController"})
	.when("/login" ,{templateUrl:"view/login.html" ,controller:"loginController"})
	.otherwise({redirectTo:"/" });
	$locationProvider.html5Mode(true);
});



appCliente.config(function($routeProvider, $locationProvider, $httpProvider){	
	$httpProvider.interceptors.push("tokenInterceptor");
});