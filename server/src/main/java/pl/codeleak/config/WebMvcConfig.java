package pl.codeleak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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

//@Configuration
//@Profile(Profiles.DEV)
//class DevelopmentResourcesConfig extends WebMvcConfigurerAdapter {
//
//    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentResourcesConfig.class);
//
//    @Value("${project.root:}")
//    private String projectRoot;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (this.projectRoot.isEmpty()) {
//            LOG.warn("Development profile is active, but no project.root property is set!");
//        } else {
//            LOG.info("\n\nDevelopment mode. Activating resources from '{}'\n\n", projectRoot);
//            registry.addResourceHandler("/**")
//                    .addResourceLocations("file:///" + this.projectRoot + "/client/build/")
//                    .setCachePeriod(0);
//        }
//    }
//}