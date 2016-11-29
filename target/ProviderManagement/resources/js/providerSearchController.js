(function() {
  var mdhsApp = angular.module("providerApp");

  var MDHSSearchController = function($scope, $http) {
    $scope.providerName = "example";
    $scope.message = "Hello Plunker!";

    $scope.providerSearch = function(searchData) {
      if ($scope.searchData) {
    	  $http.post('searchProvider', searchData).then(function(response) {
    	      $scope.getSearchData = response.data;
    	    });
      } 
    };
    
    $scope.resetData = function() {
      $scope.searchData = null;
      $scope.getSearchData = null;
    };
    
    var loadSearchData = {
      providerName: "",
      providerType: [],
      county: [],
      city: [],
      qualityRating: []
    };

    var errorCount = 0;
    var onError = function() {
      loadSearchData.providerType = [{
        "providerId": 1,
        "value": "test1"
      }, {
        "providerId": 2,
        "value": "test2"
      }];
      loadSearchData.county = [{
        "countyId": 1,
        "value": "test1"
      }, {
        "countyId": 2,
        "value": "test2"
      }];
      loadSearchData.city = [{
        "cityId": 1,
        "value": "test1"
      }, {
        "cityId": 2,
        "value": "test2"
      }];
      loadSearchData.qRating = [{
        "qRatingId": 1,
        "value": "test1"
      }, {
        "qRatingId": 2,
        "value": "test2"
      }];
    };

    var onError1 = function() {
      $scope.errorCount = errorCount++;
    };

    var loadProviderTypes = function(response) {
      loadSearchData.providerType = response.data;
    };

    var loadCounty = function(response) {
      loadSearchData.county = response.data;
    };

    var loadCity = function(response) {
      loadSearchData.city = response.data;
    };

    var loadQRating = function(response) {
      loadSearchData.qualityRating = response.data;
    };

    {
      $http.get('loadProviderType').then(loadProviderTypes, onError);
      $http.get('loadRatings').then(loadQRating, onError1);
      $http.get('loadCity').then(loadCity, onError1);
      $http.get('loadCounty').then(loadCounty, onError1);
    }
    

    $scope.dropDownData = loadSearchData;

  };

  mdhsApp.controller("providerSearchController", MDHSSearchController);
}());