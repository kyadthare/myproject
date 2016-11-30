var mdhsApp = angular.module("providerApp", ['ngRoute','angularUtils.directives.dirPagination','ui.bootstrap']);
mdhsApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "providers",
		Controller: "providerSearchController"
	})
});
