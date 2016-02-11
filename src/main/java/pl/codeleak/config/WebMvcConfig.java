package pl.codeleak.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/app/**")
                .addResourceLocations("classpath:/app/");
    }

    /* Make sure that the application is bootstrapped via Thymeleaf view */
    @Controller
    public static class Routes {

        @RequestMapping(value = {"/"})
        public String start() {
            return "redirect:/app/index.html";
        }

        @RequestMapping(value = {"/app/index.html"})
        public String index() {
            return "index";
        }
    }
}
