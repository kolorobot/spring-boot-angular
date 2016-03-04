namespace app.todo {

    export class TodoCtrl {

        todos:ITodo[] = null;

        static $inject = ['TodoService'];

        constructor(private todoService:TodoService) {
            todoService.getAll().then(response => {
                this.todos = response.data;
            }).catch(response => {
                this.todos = [
                    new Todo(1, "Get the milk", false)
                ];
            });
        }
    }

    angular.module('app.todo')
        .controller('TodoCtrl', TodoCtrl);
}

