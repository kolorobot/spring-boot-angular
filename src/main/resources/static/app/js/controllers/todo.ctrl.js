(function () {

    'use strict';

    var app = angular
        .module('app')
        .controller('TodoCtrl', ['TodoService', TodoCtrl]);

    function TodoCtrl(TodoService) {
        var vm = this;

        vm.todos = {};
        TodoService.getAll().then(function (response) {
            vm.todos = response.data;
        });
    }
})();

