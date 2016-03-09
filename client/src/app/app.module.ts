namespace app {
    angular
        .module('app', [
            'ui.router',
            'app.layout',
            'app.about',
            'app.home',
            'app.todo'
        ])
        .config(['$stateProvider', '$urlRouterProvider', routesConfig]);

    function routesConfig($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/home');

        $stateProvider
            .state('index', {
                url: '/home',
                templateUrl: './app/home/home.tpl.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm'
            })
            .state('todo', {
                url: '/todo',
                templateUrl: './app/todo/todo.tpl.html',
                controller: 'TodoCtrl',
                controllerAs: 'vm'
            })
            .state('about', {
                url: '/about',
                templateUrl: './app/about/about.tpl.html',
                controller: 'AboutCtrl',
                controllerAs: 'vm'
            });
    }
}