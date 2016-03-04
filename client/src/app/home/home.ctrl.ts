namespace app.home {

    export class HomeCtrl {
        message:string = 'Hello!';
    }

    angular
        .module('app.home')
        .controller('HomeCtrl', HomeCtrl);
}