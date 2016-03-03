(function () {

    'use strict';

    angular
        .module('app')
        .factory('TodoService', ['$http', '$window', TodoService]);

    function TodoService($http, $window) {

        return {
            getAll: getAll,
            getTodo: getTodo,
            addTodo: addTodo,
            updateTodo: updateTodo
        };

        function getAll() {
            return $http.get(getBaseUrl() + '/todo');
        }

        function getTodo(id) {
            return $http.get(getBaseUrl() + '/todo/' + id);
        }

        function addTodo(todo) {
            return $http.put(getBaseUrl() + '/todo', todo);
        }

        function updateTodo(id, todo) {
            return $http.get(getBaseUrl() + '/todo/' + id, todo);
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
