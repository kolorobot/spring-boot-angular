# Spring Boot Angular

## Frontend development with no Backend running

Note: npm, ts_node, gulp must be installed

- Navigate to `client` module directory

> cd client

- Install all dependencies (`node_modules`, `typings`)

> npm install

- Build the project (creates `build` directory)

> npm run build

- Run the server

> npm run server

If you are developing Frontend code without the server, that's the best option.

## Backend development

Note: Make sure `client/build` directory exists. This directory will be used to server static resources in development mode.

- Navigate to `server` module directory
 
> cd server

- Run the application in development mode

> gradlew clean bootRun -Dspring.profiles.active=dev -DappHome=<path/to/project>

- Navigate to `http://localhost:8080` 

Changes in the `client/build` directory will be available instantly. Simply refresh the browser.

## Resources reloading

Spring Boot application, in development mode, maps resources from `client/build` directory.
So every change in this directory is available in the Backend. If you wish to make changes
to the client code while running Spring Boot application, go to `client` module directory
and run `watch` to watch for changes made in the client code:

>  npm run watch

Now you can freely modify `client/src` files and see them instantly in the Spring Boot application.
