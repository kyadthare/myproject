(function() {
  var providerApp = angular.module("providerApp");

  var providerSearchController = function($scope, $http, $location, $anchorScroll) {

	/*$scope.dropDownData.providerType = $http.get('loadProviderType').then(returnResponse, onError);
	$scope.dropDownData.qualityRating = $http.get('loadRatings').then(returnResponse, onError);
	$scope.dropDownData.city = $http.get('loadCity').then(returnResponse, onError);
	$scope.dropDownData.county = $http.get('loadCounty').then(returnResponse, onError);*/
	
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
	
	var loadProviderTypes = function(response) {
		$scope.dropdowndata.providerType = response.data;
	};
	
	var loadCounty = function(response) {
		$scope.dropdowndata.county = response.data;
	};
	
	var loadCity = function(response) {
		$scope.dropdowndata.city = response.data;
	};
		
	var loadQRating = function(response) {
		$scope.dropdowndata.qualityRating = response.data;
	};

    var onError = function(response) {
      $scope.errorCount = errorCount++;
      $scope.errorReason = "Failed to load some of the search data";
    };

    var returnResponse = function(response) {
    	return{
    		"data" : response.data
    	}
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
    
    {
    	$http.get('loadProviderType').then(loadProviderTypes, onError);
        $http.get('loadRatings').then(loadQRating, onError);
        $http.get('loadCity').then(loadCity, onError);
        $http.get('loadCounty').then(loadCounty, onError);
    }
    
    
    $scope.sortByFields = [{
    	name:"Provider Name",
    	value:"one"
    },{
    	name:"Provider Type",
    	value:"two"
    },{
    	name:"city",
    	value:"three"
    },{
    	name:"county",
    	value:"three"
    },{
    	name:"qualityRating",
    	value:"three"
    }];
    
        
  };

  providerApp.controller("providerSearchController", providerSearchController);
}());