package pl.codeleak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Controller
    public static class Routes {
        /* index.html is served by Thymeleaf and classpath:/static/ is switched off. See application.properties */
        @RequestMapping("/")
        public String index() {
            return "index";
        }
    }

}
