var mdhsApp = angular.module("providerApp", [ "ngRoute" ]);
mdhsApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "providers",
		Controller: "providerSearchController"
	})
});
