(function() {
  var providerApp = angular.module("providerApp");

  //Provider Search Controller function which handles the https calls and search result display for the application
  var providerSearchController = function($scope, $http, $location, $anchorScroll, $timeout) {

    var mapCenter = {
      center: new google.maps.LatLng(36.0078, -98.0929),
      zoom: 6,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    var map = new google.maps.Map(document.getElementById("googleMap"), mapCenter);

    var markers = [];

    //function which fetches the search results from the database through HTTP method call 
    $scope.providerSearch = function(searchData) {
      validateForm();
      $scope.displayResult = false;
      $scope.emptyResult = false;
      $scope.showMap = false;
      if (!($scope.invalidData || $scope.missingData)) {
    	  setTransWindowVisiblitily('visible');
        $http.post('searchProvider', $scope.searchData).then(function(response) {
          if (response.data.length > 0) {
            $scope.getSearchData = response.data;
            createMarker($scope.getSearchData);
            $scope.sortBy = $scope.sortByFields[0];
            $scope.sortSign = false;
            $scope.displayResult = true;
            $scope.currentPage = 1;
            scrollTo('searchResult');
          } else {
            $scope.emptyResult = true;
          }
          setTransWindowVisiblitily('hidden');
        });
      }
    };

    function setTransWindowVisiblitily(visibility){
    	document.getElementById('transWindow').style.visibility = visibility;
    }
    
    function createMarker(dataList) {
      deleteMarkers();
      for (var i = 0; i < dataList.length; i++) {
        addMarker(dataList[i]);
      }
    }

    function addMarker(data) {
      var marker = new google.maps.Marker({
        position: new google.maps.LatLng(data.address.latitude, data.address.longitude),
        title: data.name,
        map: map
      });

      var infowindow = new google.maps.InfoWindow({
        content: '<div class="fontHeading padSpace">' + data.name +
          '</div><div class="fontSmall"><strong>Type:</strong>' + data.providerType.description +
          '<br/><strong>County:</strong>' + data.address.county +
          '<br/><strong>City:</strong>' + data.address.city +
          '<br/><strong>Capacity:</strong>' + data.capacity +
          '<br/><strong>Phone#:</strong>' + data.phoneNumber + '</div>'
      });

      marker.addListener('click', function() {
        map.setCenter(marker.position);
        map.setZoom(9);
        infowindow.open(map, marker);
      });

      markers.push(marker);
    }

    // Removes the markers from the map, but keeps them in the array.
    function clearMarkers() {
      for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
      }
    }

    // Deletes all markers in the array by removing references to them.
    function deleteMarkers() {
      clearMarkers();
      markers = [];
    }

    //function to validate the form data
    function validateForm() {
      $scope.invalidData = true;
      $scope.missingData = false;
      $scope.showDistance = false;
      if ($scope.searchData) {
        var formValues = [];
        if ($scope.searchData.providerName) {
          formValues.push($scope.searchData.providerName);
        }
        if ($scope.searchData.providerType) {
          formValues.push($scope.searchData.providerType.description);
        }
        if ($scope.searchData.city) {
          formValues.push($scope.searchData.city);
        }
        if ($scope.searchData.geoRadius) {
          if (!($scope.searchData.city)) {
            $scope.missingData = true;
          }
          $scope.showDistance = true;
          formValues.push($scope.searchData.geoRadius.description);
        }
        if ($scope.searchData.county) {
          formValues.push($scope.searchData.county);
        }
        if ($scope.searchData.qualityRating) {
          formValues.push($scope.searchData.qualityRating.description);
        }
        for (var i = 0; i < formValues.length; i++) {
          if (formValues[i].length > 0) {
            $scope.invalidData = false;
          }
        }
      }
    }

    //function which shows or hides the map
    $scope.toggleShowMap = function() {
      $scope.showMap = !$scope.showMap;
      $timeout(function() {
        google.maps.event.trigger(map, 'resize');
      });
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

    $scope.geoRadius = [{
      radius: 10,
      description: "10 mile radius"
    }, {
      radius: 25,
      description: "25 mile radius"
    }, {
      radius: 50,
      description: "50 mile radius"
    }, {
      radius: 100,
      description: "100 mile radius"
    }];

    var loadQRating = function(response) {
      $scope.qualityRating = response.data;
    };

    var onError = function(response) {
      $scope.errorReason = "Failed to load some of the search data";
    };

    //function which scrolls to the specified section in the page
    function scrollTo(position) {
      var id = $location.hash();

      $timeout(function() {
        $location.hash('searchResult');
        $anchorScroll();
        $location.hash(id);
      });
    }

    //function which resets the data in the form
    $scope.resetData = function() {
      $scope.searchData = null;
      $scope.getSearchData = null;
      $scope.invalidData = false;
      $scope.city = tempCity;
      $scope.emptyResult = false;
      $scope.displayResult = false;
      $scope.missingData = false;
      $scope.showMap = false;
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
      name: "Distance",
      value: "address.distance"
    }, {
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