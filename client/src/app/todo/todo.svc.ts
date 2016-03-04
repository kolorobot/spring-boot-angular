namespace app.todo {

    import IPromise = angular.IPromise;
    import IHttpService = angular.IHttpService;
    import IWindowService = angular.IWindowService;

    export interface ITodo {
        id: number;
        title: string;
        done: boolean;
    }

    export class Todo implements ITodo {
        constructor(public id:number,
                    public title:string,
                    public done:boolean) {

        }
    }

    export class TodoService {

        static $inject = ['$http', '$window'];
        constructor(private $http:IHttpService, private $window:IWindowService) {

        }

        public getAll():any {
            return this.$http.get(this.getBaseUrl() + '/todo');
        }

        public getTodo(id) {
            return this.$http.get(this.getBaseUrl() + '/todo/' + id);
        }

        public addTodo(todo) {
            return this.$http.put(this.getBaseUrl() + '/todo', todo);
        }

        public updateTodo(id, todo) {
            return this.$http.get(this.getBaseUrl() + '/todo/' + id, todo);
        }

        public getBaseUrl():any {
            var url = this.$window.location.protocol + '//' + this.$window.location.host;
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

    angular
        .module('app.todo')
        .service('TodoService', TodoService);
}