namespace app.todo {

    export class TodoCtrl {

        todos:ITodo[] = null;

        /*@ngInject*/
        constructor(private todoService:TodoService) {
            todoService.getAll().then(response => {
                this.todos = response.data;
            });
        }
    }

    angular.module('app.todo')
        .controller('TodoCtrl', TodoCtrl);
}

