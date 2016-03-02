(function() {

    'use strict';

    angular
        .module('app')
        .directive('pageHeader', PageHeader);

    function PageHeader() {
        return {
            restrict: 'E',
            scope: {
                value: "@"
            },
            template: '<h1>{{value}}</h1>'
        };
    }

})();
