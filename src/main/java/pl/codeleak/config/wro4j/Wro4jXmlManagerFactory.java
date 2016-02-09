package pl.codeleak.config.wro4j;

import org.springframework.core.io.ClassPathResource;
import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;
import ro.isdc.wro.model.factory.WroModelFactory;
import ro.isdc.wro.model.factory.XmlModelFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Wro4jXmlManagerFactory extends ConfigurableWroManagerFactory {

    private final Properties properties;

    private final String resourceName;


    public Wro4jXmlManagerFactory(Properties properties, String resourceName) {
        this.properties = properties;
        this.resourceName = resourceName;
    }

    @Override
    protected Properties newConfigProperties() {
        return properties;
    }

    @Override
    protected WroModelFactory newModelFactory() {
        return new XmlModelFactory() {
            @Override
            protected InputStream getModelResourceAsStream() throws IOException {
                return new ClassPathResource(resourceName).getInputStream();
            }
        };
    }
}