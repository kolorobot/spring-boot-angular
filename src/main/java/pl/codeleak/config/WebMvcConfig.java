package pl.codeleak.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/app/**")
                .addResourceLocations("classpath:/app/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /* Make sure Thymeleaf views are not accessible directly as static resources */
        registry.addRedirectViewController("/", "/app/index.html");
        registry.addViewController("/app/index.html").setViewName("index");
        registry.addViewController("/app/error.html").setViewName("error");
    }
}
