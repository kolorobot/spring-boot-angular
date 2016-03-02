(function () {

    'use strict';

    angular
        .module('app')
        .factory('TodoService', ['$state', '$http', '$window', TodoService]);

    function TodoService($state, $http, $window) {

        return {
            addTodoItem: addTodoItem
        };

        function addTodoItem() {
            var data = {};
            return $http.post(getBaseUrl() + '/todo', data);
        }

        function getBaseUrl() {
            var url = $window.location.protocol + '//' + $window.location.host;
            var pathParts = window.location.pathname.split("/");
            if (pathParts.length > 2) {
                var subContext = pathParts[1];
                if (subContext !== 'app') {
                    url += "/" + subContext;
                }
            }
            return url;
        }
    }
})();
