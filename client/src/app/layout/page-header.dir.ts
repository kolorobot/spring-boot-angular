namespace app.layout {

    class PageHeader implements ng.IDirective {

        static instance():ng.IDirective {
            return new PageHeader();
        }

        restrict = 'E';
        scope = {
            value: "@"
        };
        template = '<h1>{{value}}</h1>';

    }

    angular
        .module('app.layout')
        .directive('pageHeader', PageHeader.instance);
}



