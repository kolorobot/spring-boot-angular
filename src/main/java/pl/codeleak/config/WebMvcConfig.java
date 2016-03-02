package pl.codeleak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.AppCacheManifestTransformer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /* Caching strategy */
        boolean prodMode = environment.acceptsProfiles(Profiles.PROD);
        Integer cachePeriod = prodMode ? null : 0;
        boolean useResourceCache = prodMode;

        VersionResourceResolver versionResourceResolver = new VersionResourceResolver();
        versionResourceResolver.addContentVersionStrategy("/**/*.js", "/**/*.css");
        AppCacheManifestTransformer transformer = new AppCacheManifestTransformer();

        /* robots.txt */
        registry.addResourceHandler("/robots.txt")
                .addResourceLocations("classpath:/static/robots.txt");

        /* All other resources */
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(cachePeriod)
                .resourceChain(useResourceCache)
                .addResolver(versionResourceResolver)
                .addTransformer(transformer);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /* Make sure Thymeleaf views are not accessible directly as static resources */
        registry.addRedirectViewController("/app/*.th.html", "/");
        /* Default mapping */
        registry.addRedirectViewController("/", "/app/index.html");
        /* Application entry */
        registry.addViewController("/app/index.html").setViewName("index");
    }
}
