(function () {
    'use strict';

    /* App Module */

    angular.module('helloWorld', ['motech-dashboard', 'helloWorld.controllers', 'helloWorld.directives', 'helloWorld.services', 'ngCookies'])
        .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.
                when('/helloWorld', {templateUrl: '../channel-module/resources/partials/say-hello.html', controller: 'HelloWorldController'});
    }]);
}());
