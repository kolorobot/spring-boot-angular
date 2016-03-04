package pl.codeleak.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* robots.txt */
        registry.addResourceHandler("/robots.txt")
                .addResourceLocations("classpath:/static/robots.txt");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}

@Configuration
@Profile(Profiles.DEV)
class DevelopmentResourcesConfig extends WebMvcConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentResourcesConfig.class);

    @Value("${appHome:}")
    private String appHome;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (this.appHome.isEmpty()) {
            LOG.warn("Development profile is active, but no appPath property is set!");
        } else {
            LOG.info("\n\nDevelopment mode. Activating resources from '{}'\n\n", appHome);
            registry.addResourceHandler("/**")
                    .addResourceLocations("file:///" + this.appHome + "/client/build/")
                    .setCachePeriod(0);
        }
    }
}