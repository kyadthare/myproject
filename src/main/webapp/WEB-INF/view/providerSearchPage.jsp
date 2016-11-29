
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link data-require="bootstrap-css@3.3.6" data-semver="3.3.6" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" /> -->
<title>Provider Management</title>
</head>
<body>
	<div class="container" ng-controller="providerSearchController">

		<div style="/* background-color: white; */ color: black;">
			<form name="mdhsProviderSearch" id="SpringAppForm">
				<fieldset>
			        <legend>Provider Search</legend>
			        <br />
					<div class="form-group">
						<label for="ProviderName" class="col-sm-3 control-label">Provider Name</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" ng-model="searchData.name" id="Provider Name" name="Provider Name" />
						</div>
					</div>
					<div class="form-group">
						<label for="providerType" class="col-sm-3 control-label">Provider Type</label>
						<div class="col-sm-9">
							<select id="providerType" class="form-control" name="providerType" ng-model="searchData.providerType" ng-options="providerType.description for providerType in dropDownData.providerType"></select>
						</div>
					</div>
					<div class="form-group">
						<label for="county" class="col-sm-3 control-label">County</label>
						<div class="col-sm-9">
							<select ng-model="searchData.addressCounty" class="form-control" id="addressCounty" name="addressCounty" ng-options="addressCounty.county for addressCounty in dropDownData.county" ng-change="getCity()" ></select>
						</div>
					</div>
					<div class="form-group">
						<label for="city" class="col-sm-3 control-label">City</label>
						<div class="col-sm-9">
							<select type="range" class="form-control" ng-model="searchData.addressCity"
								id="addressCity" name="addressCity"
								ng-options="addressCity.city for addressCity in dropDownData.city"></select>
						</div>
					</div>
					<div class="form-group">
						<label for="QualityRating" class="col-sm-3 control-label">Quality Star Rating</label>
						<div class="col-sm-9">
							<select type="range" class="form-control" id="qualityRating" name="qualityRating"
							ng-model="searchData.qualityRating"
								ng-options="qualityRating.ratingId for qualityRating in dropDownData.qualityRating"></select>
						</div>
					</div>
			        <div class="form-group">        
						<div class="col-sm-offset-3 col-sm-9">
							<button class="btn btn-primary" ng-click="providerSearch(searchData)" type="submit">Search</button>
							<button class="btn btn-default" type="reset" ng-click="resetData()">Reset</button>
						</div>
					</div>
			      </fieldset>
			</form>
		</div>
		<div style="background-color: white;">
			<table class="table table-striped">
				<thead>
					<tr>
						<th id="Name">PROVIDER NAME</th>
						<th id="Phone">PROVIDER TYPE</th>
						<th>LICENSETYPE</th>
						<th>COUNTY</th>
						<th>CITY</th>
						<th>CAPACITY</th>
						<th>PHONE NUMBER</th>
						<th>RATING</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="provider in getSearchData">
						<td>{{provider.name}}</td>
						<td>{{provider.providerType.description}}</td>
						<td>{{provider.licenseType}}</td>
						<td>{{provider.address.county}}</td>
						<td>{{provider.address.city}}</td>
						<td>{{provider.capacity}}</td>
						<td>{{provider.phoneNumber}}</td>
						<td>{{provider.rating.description}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>