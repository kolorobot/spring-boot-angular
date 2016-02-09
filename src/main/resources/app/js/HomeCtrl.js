(function () {

    'use strict';

    var app = angular
        .module('app')
        .controller("HomeCtrl", HomeCtrl);

    function HomeCtrl() {
        this.greeting = {
            id: '1',
            content: 'Demo'
        };
    }
})();

