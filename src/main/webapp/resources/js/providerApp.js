//AngularJS Application module and url routing configuration
var providerApp = angular.module("providerApp", ['ngRoute', 'angularUtils.directives.dirPagination', 'ui.bootstrap']);
providerApp.config(function($routeProvider) {
  $routeProvider.when("/", {
    templateUrl: "providers",
    Controller: "providerSearchController"
  })
});