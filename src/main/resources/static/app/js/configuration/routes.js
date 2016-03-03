(function() {

    'use strict';

    angular
        .module('app')
        .config(['$stateProvider', '$urlRouterProvider', routesConfig]);

    function routesConfig($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/home');

        $stateProvider
            .state('index', {
                url: '/home',
                templateUrl: 'tpl/home.tpl.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm'
            })
            .state('todo', {
                url: '/todo',
                templateUrl: 'tpl/todo.tpl.html',
                controller: 'TodoCtrl',
                controllerAs: 'vm'
            })
            .state('about', {
                url: '/about',
                templateUrl: 'tpl/about.tpl.html',
                controller: 'AboutCtrl',
                controllerAs: 'vm'
            });
    }
})();
