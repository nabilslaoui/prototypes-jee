'use strict';

angular.module('employeApp', ['employeService']).
config(['$routeProvider', function ($routeProvider) {
$routeProvider.
    when('/employe/list', {templateUrl:'views/employes/employes-list.html', controller:EmployeListController}).
    when('/employe/new', {templateUrl:'views/employes/employe-new.html', controller:EmployeNewController}).
    otherwise({redirectTo:'/employe/list'});
}]);
