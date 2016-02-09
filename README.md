# Spring Boot Angular

This is a basic Spring Boot AngularJS 1.x application utilizing:

* Thymeleaf
* Webjars (AngularJS / Bootstrap)
* Wro4j

## Development notes

* `resources/app` folder contains the AngularJS application. 
`index.html` is a Thymeleaf template that can be used for static prototyping
* In runtime, statically referenced Javascript and CSS files will be replaced with wro4j optimized ones.
* `resources/wro.xml` contains wro4j configuration. See Wro4jProperties for details how the library is configured.

