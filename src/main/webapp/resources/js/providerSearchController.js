(function() {
  var providerApp = angular.module("providerApp");

  var providerSearchController = function($scope, $http, $location, $anchorScroll, $timeout) {

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
					$scope.sortOrder = 'name';
					$scope.sortSign = true;
					$scope.displayResult = true;
					scrollTo('SearchResult');
				}else{
					$scope.emptyResult = true;
				}
			});
		}else{
			$scope.invalidData = true;
		}
	}
	
	$scope.changeSortSign = function(){
		$scope.sortSign = !($scope.sortSign);
	}
	
	$scope.sortBySearch = function(sortBy){
		$scope.sortSign = true;
	}
	
	var loadProviderTypes = function(response) {
		$scope.providerType = response.data;
	};
	
	var loadCounty = function(response) {
		$scope.county = response.data;
	};
	
	var loadCity = function(response) {
		$scope.city = response.data;
	};
		
	var loadQRating = function(response) {
		$scope.qualityRating = response.data;
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
    	var id = $location.hash();
    	$timeout(function(){
    		if(position=="SearchResult"){
        		$location.hash('SearchResult');
        	}else{
        		$location.hash('header');
        	}
        	
            $anchorScroll();
            $location.hash(id);
    	});
    }
    
    $scope.resetData = function() {
      $scope.searchData = null;
      $scope.getSearchData = null;
      $scope.invalidData = false;
      $scope.emptyResult = false;
      $scope.displayResult = false;
    };
    
    {
    	$http.get('loadProviderType').then(loadProviderTypes, onError);
        $http.get('loadRatings').then(loadQRating, onError);
        $http.get('loadCity').then(loadCity, onError);
        $http.get('loadCounty').then(loadCounty, onError);
    }
    
    
    $scope.sortByFields = [{
    	name:"Provider Name",
    	value:"name"
    },{
    	name:"Provider Type",
    	value:"providerType.description"
    },{
    	name:"City",
    	value:"address.city"
    },{
    	name:"County",
    	value:"address.county"
    },{
    	name:"Quality Star Rating",
    	value:"rating.ratingId"
    }];
    
        
  };

  providerApp.controller("providerSearchController", providerSearchController);
}());