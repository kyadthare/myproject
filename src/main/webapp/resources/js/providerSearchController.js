(function() {
  var providerApp = angular.module("providerApp");

  var providerSearchController = function($scope, $http, $location, $anchorScroll) {

	$scope.dropDownData = loadSearchData;
	
	$scope.providerSearch = function(searchData){
		alert("inside search");
		if ($scope.searchData) {
			$scope.invalidData = false;
			$http.post('searchProvider', searchData).then(function(response) {
				if(response.data){
					$scope.getSearchData = response.data;
					$scope.emptyResult = false;
					scrollTo('SearchResult');
				}else{
					$scope.emptyResult = true;
				}
			});
		}else{
			$scope.invalidData = true;
		}
	}
	
	{
    	$http.get('loadProviderType').then(loadProviderTypes, onError);
        $http.get('loadRatings').then(loadQRating, onError);
        $http.get('loadCity').then(loadCity, onError);
        $http.get('loadCounty').then(loadCounty, onError);
    }

    var onError = function() {
      $scope.errorCount = errorCount++;
      $scope.errorReason = "Failed to load some of the search data";
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
	  
    $scope.scrollTo = function(position){
    	scrollTo(position);
    }
    
    function scrollTo(position){
    	if(position=="SearchResult"){
    		$location.hash('SearchResult');
    	}else{
    		$location.hash('header');
    	}
        $anchorScroll();
    }
    
    $scope.resetData = function() {
      $scope.searchData = null;
      $scope.getSearchData = null;
      $scope.invalidData = false;
      $scope.emptyResult = false;
    };
    
    $scope.sortByFields = [{
    	name:"Provider Name",
    	value:"one"
    },{
    	name:"Provider Type",
    	value:"two"
    },{
    	name:"city",
    	value:"three"
    }];
    
    var loadSearchData = {
      providerName: "",
      providerType: [],
      county: [],
      city: [],
      qualityRating: []
    };
    
  };

  providerApp.controller("providerSearchController", providerSearchController);
}());