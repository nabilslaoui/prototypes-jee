'use strict';

function EmployeListController($http, $scope, $location, EmployeAnnotated) {
    $scope.employes = EmployeAnnotated.query();
    $scope.gotoEmployeNewPage = function () {
        $location.path("/employe/new")
    };
    $scope.deleteEmploye = function (id) {
    	var res = $http.delete('/SPRING-MVC-ANGULAR-JS/rest/employe/delete/' + id );
		res.success(function(data, status, headers, config) {
			$location.path('/SPRING-MVC-ANGULAR-JS/rest/employe/list');
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});
    };
    $scope.addEmploye = function (employe) {
		 var dataObj = {
					nom : employe.nom,
					prenom : employe.prenom
			};	
		var res = $http.post('/SPRING-MVC-ANGULAR-JS/rest/employe/add', dataObj);
		res.success(function(data, status, headers, config) {
			$location.path('/SPRING-MVC-ANGULAR-JS/rest/employe/list');
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});
	 };
	 $scope.gotoEmployeListPage = function () {
         $location.path('/employe/list');
	 };
}

function EmployeNewController($http, $scope, $location) {
	 $scope.gotoEmployeListPage = function () {
         $location.path('/employe/list');
	 };
	 $scope.addEmploye = function (employe) {
		 var dataObj = {
					nom : employe.nom,
					prenom : employe.prenom
			};	
		var res = $http.post('/SPRING-MVC-ANGULAR-JS/rest/employe/add', dataObj);
		res.success(function(data, status, headers, config) {
			$location.path('/employe/list');
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});
	 };
}