//AngularJS Application module and url routing configuration

var providerApp = angular.module("providerApp", ['ngRoute', 'angularUtils.directives.dirPagination', 'ui.bootstrap']);

providerApp.config(function($routeProvider) {

  $routeProvider.when("/", {
    templateUrl: "providers",
    controller: "providerSearchController"
  });

});

providerApp.controller("indexController", function($scope, $location, $timeout, $anchorScroll) {

  //function which scrolls to the specified section in the page
  $scope.scrollTo = function() {
    var id = $location.hash();

    $timeout(function() {
      $location.hash('header');
      $anchorScroll();
      $location.hash(id);
    });

  };
});