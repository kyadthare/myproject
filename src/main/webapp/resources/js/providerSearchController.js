(function() {
  var providerApp = angular.module("providerApp");

  //Provider Search Controller function which handles the https calls and search result display for the application
  var providerSearchController = function($scope, $http, $location, $anchorScroll, $timeout) {

    //function which fetches the search results from the database through HTTP method call 
    $scope.providerSearch = function(searchData) {
      if (searchData) {

        $scope.invalidData = false;
        $scope.emptyResult = false;

        $http.post('searchProvider', searchData).then(function(response) {
          if (response.data.length > 0) {
            $scope.getSearchData = response.data;
            $scope.emptyResult = false;
            $scope.sortBy = $scope.sortByFields[0];
            $scope.sortSign = false;
            $scope.displayResult = true;
            $scope.currentPage = 1;
            scrollTo('SearchResult');
          } else {
            $scope.emptyResult = true;
          }
        });

      } else {
        $scope.invalidData = true;
      }
    };

    //function which sorts the search result in asc or desc order
    $scope.changeSortSign = function() {
      $scope.currentPage = 1;
      $scope.sortSign = !($scope.sortSign);
    };

    //function which sorts the search result based on specified value
    $scope.sortBySearch = function(sortByField) {
      $scope.sortSign = false;
      $scope.currentPage = 1;
    };

    var loadProviderTypes = function(response) {
      $scope.providerType = response.data;
    };

    var loadCounty = function(response) {
      $scope.county = response.data;
    };

    var tempcity = [];

    var loadCity = function(response) {
      $scope.city = response.data;
      tempCity = response.data;
    };

    var loadQRating = function(response) {
      $scope.qualityRating = response.data;
    };

    var onError = function(response) {
      $scope.errorReason = "Failed to load some of the search data";
    };

    $scope.scrollTo = function(position) {
      scrollTo(position);
    };

    //function which scrolls to the specified section in the page
    function scrollTo(position) {
      var id = $location.hash();

      $timeout(function() {
        if (position == "SearchResult") {
          $location.hash('SearchResult');
        } else {
          $location.hash('header');
        }
        $anchorScroll();
        $location.hash(id);
      });

    }

    //function which resets the data in the form
    $scope.resetData = function() {
      $scope.searchData = null;
      $scope.getSearchData = null;
      $scope.invalidData = false;
      $scope.emptyResult = false;
      $scope.displayResult = false;
    };

    //block which fetches the search form display data from the database
    {
      $http.get('loadProviderType').then(loadProviderTypes, onError);
      $http.get('loadRatings').then(loadQRating, onError);
      $http.get('loadCity').then(loadCity, onError);
      $http.get('loadCounty').then(loadCounty, onError);
    }

    //variable which gives the list of option to the sort feature
    $scope.sortByFields = [{
      name: "Provider Name",
      value: "name"
    }, {
      name: "Provider Type",
      value: "providerType.description"
    }, {
      name: "City",
      value: "address.city"
    }, {
      name: "County",
      value: "address.county"
    }, {
      name: "Quality Star Rating",
      value: "rating.ratingId"
    }];

    //function which loads the city value based on the county
    $scope.getCity = function(county) {
      if (county !== null) {

        $http.post('loadCity', county).then(function(response) {
          $scope.city = response.data;
        });

      } else {
        $scope.city = tempCity;
      }
    };

  };

  //binding of the application to the controller
  providerApp.controller("providerSearchController", providerSearchController);
}());