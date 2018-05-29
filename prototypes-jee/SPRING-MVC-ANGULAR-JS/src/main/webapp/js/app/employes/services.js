'use strict';

angular.module('employeService', ['ngResource']).
factory('EmployeAnnotated', function ($resource) {
    return $resource('rest/employe', {}, {
        '/': {method:'GET'}
    });
});