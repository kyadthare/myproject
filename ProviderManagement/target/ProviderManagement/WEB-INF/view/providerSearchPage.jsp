
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Provider Management</title>
</head>
<body>
	<div class="SpringApp-Body" ng-controller="providerSearchController">

		<div class="Spring-Search-Form" style="background-color: white;">
			{{message}} {{errorCount}}
			<form name="mdhsProviderSearch" id="SpringAppForm">
				<table id="Search-table" border="2px">
					<tbody>
						<tr>
							<td>Provider Name</td>
							<td><input type="text" ng-model="searchData.providerName"
								id="Provider Name" name="Provider Name" /></td>
						</tr>
						<tr>
							<td>Provider Type</td>
							<td><select  id="providerType" name="providerType"
								ng-model="searchData.providerType"
								ng-options="providerType.providerTypeDescription for providerType in dropDownData.providerType"></select>
							</td>
						</tr>
						<tr>
							<td>County</td>
							<td><select ng-model="searchData.addressCounty" id="addressCounty"
								name="addressCounty"
								ng-options="addressCounty.county for addressCounty in dropDownData.county"
								ng-change="getCity()">
							</select></td>
						</tr>
						<tr>
							<td>City</td>
							<td><select type="range" ng-model="searchData.addressCity"
								id="addressCity" name="addressCity"
								ng-options="addressCity.city for addressCity in dropDownData.city"></select>
							</td>
						</tr>
						<tr>
							<td>Quality Star rating</td>
							<td><select type="range" id="qualityRating" name="qualityRating"
							ng-model="searchData.qualityRating"
								ng-options="qualityRating.ratingId for qualityRating in dropDownData.qualityRating"></select>
							</td>
						</tr>
					</tbody>
				</table>
				<br />
				<button ng-click="providerSearch(searchData)" type="submit">Search</button>
				<button type="reset" ng-click="resetData()">Reset</button>
			</form>
		</div>
		<div class="Spring-Search-Result" style="background-color: white;">
			<table>
				<thead>
					<tr>
						<th id="Name">PROVIDER NAME</th>
						<th id="Phone">PROVIDER TYPE</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="provider in getSearchData">
						<td>{{provider.providerName}}</td>
						<td>{{provider.providerType.providerTypeDescription}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>