# Spring Boot Angular

This is a basic Spring Boot AngularJS 1.x application utilizing:

* Thymeleaf
* Webjars (AngularJS / Bootstrap)
* Wro4j Gradle plugin
* No external dependencies (npm, gulp etc.)

It is well suited as a seed for rather smaller projects.

## Development notes

* `src/main/resources/app` folder contains the AngularJS application as well as Thymeleaf templates 
* Thymeleaf template that can be used for static prototyping
* In runtime, statically referenced Javascript and CSS files will be replaced with wro4j optimized ones
* In development mode, static resources will be refreshed instantly (incl. Thymeleaf templates)
* No external dependencies

## Frontend resources live reload

When running the application in development profile (`-Dspring.profiles.active=dev`), static resources will be instantly
reloaded. This is done by setting `spring.thymeleaf.prefix` and `spring.resources.static-locations` to a valid
location. Modify `application-dev.properties` and set the value of `project.root` to a valid path. E.g.:

`c:/projects/spring-boot-angular`

Now, run the application with `dev` profile enabled, modify some static resources and refresh the browser. You should see changes immediately.

Note: Check the logs if it does not work. `ThymeleafAutoConfiguration` will report a problem when `spring.thymeleaf.prefix` is an invalid directory. 

## Frontend development with no Backend running

In this scenario you may have a dedicated team member working only on the Frontend code. 

This scenario utilizes Thymeleaf's static prototyping capabilities.

### WebStorm or IntelliJ

- Import the project into WebStorm or IntelliJ 
- Navigate to `src/main/resources/app` and run the `index.th.html`. The browser will open. The application will be displayed.

Any changes done in the app is instantly available.

### Brackets

If you happen to use Brackets (http://brackets.io/) you may also develop the code.

- Open Brackets
- Navigate to `File > Open Folder` and select `<your-project>/src/main/resources/app`
- From the file tree open `index.th.html`
- Select `File > Live Preview` to run the application