package pl.codeleak.config.wro4j;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("wro4j")
public class Wro4jProperties {

    private boolean disableCache;

    private boolean debug = false;

    private int cacheUpdatePeriod = 0;

    private int resourceWatcherUpdatePeriod = 5;

    private String urlPattern = "/assets/*";

    private String uriLocators = "servletContext,classpath,uri";

    private String preProcessors = "cssUrlRewriting,cssImport,semicolonAppender,lessCss";

    private String postProcessors = "cssVariables,cssMinJawr,jsMin";

    private String wro4jResourceName = "wro.xml";

    private String hashStrategy = "MD5";

    private String namingStrategy = "hashEncoder-CRC32";

    private boolean cacheGzippedContent = true;

    private boolean parallelProcessing = false;

    public boolean isDisableCache() {
        return disableCache;
    }

    public void setDisableCache(boolean disableCache) {
        this.disableCache = disableCache;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public int getCacheUpdatePeriod() {
        return cacheUpdatePeriod;
    }

    public void setCacheUpdatePeriod(int cacheUpdatePeriod) {
        this.cacheUpdatePeriod = cacheUpdatePeriod;
    }

    public int getResourceWatcherUpdatePeriod() {
        return resourceWatcherUpdatePeriod;
    }

    public void setResourceWatcherUpdatePeriod(int resourceWatcherUpdatePeriod) {
        this.resourceWatcherUpdatePeriod = resourceWatcherUpdatePeriod;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getUriLocators() {
        return uriLocators;
    }

    public void setUriLocators(String uriLocators) {
        this.uriLocators = uriLocators;
    }

    public String getPreProcessors() {
        return preProcessors;
    }

    public void setPreProcessors(String preProcessors) {
        this.preProcessors = preProcessors;
    }

    public String getPostProcessors() {
        return postProcessors;
    }

    public void setPostProcessors(String postProcessors) {
        this.postProcessors = postProcessors;
    }

    public String getWro4jResourceName() {
        return wro4jResourceName;
    }

    public void setWro4jResourceName(String wro4jResourceName) {
        this.wro4jResourceName = wro4jResourceName;
    }

    public String getHashStrategy() {
        return hashStrategy;
    }

    public void setHashStrategy(String hashStrategy) {
        this.hashStrategy = hashStrategy;
    }

    public String getNamingStrategy() {
        return namingStrategy;
    }

    public void setNamingStrategy(String namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    public boolean isCacheGzippedContent() {
        return cacheGzippedContent;
    }

    public void setCacheGzippedContent(boolean cacheGzippedContent) {
        this.cacheGzippedContent = cacheGzippedContent;
    }

    public boolean isParallelProcessing() {
        return parallelProcessing;
    }

    public void setParallelProcessing(boolean parallelProcessing) {
        this.parallelProcessing = parallelProcessing;
    }
}
