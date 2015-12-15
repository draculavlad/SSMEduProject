package jacob.su.edu.config;

import java.io.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Configuration
@EnableAsync
public class AppConfiguration {

    private final Logger logger = LoggerFactory.getLogger(AppConfiguration.class);



    @Value("classpath:jdbc.properties")
    private Resource configurationResource;

    @Bean(name="applicationConfiguration")
   	public Properties appConfig() throws IOException, ConfigurationException {
   		Properties properties = new Properties();
   		if(!configurationResource.exists()){
   			logger.error("Could not find root configuration file.");
   			throw new FileNotFoundException("Root configuration file.");
   		}

   		properties.load(configurationResource.getInputStream());
   		return properties;
   	}

    private Properties convertToProperties(PropertiesConfiguration cfg) {
        Properties properties = new Properties();
        Iterator<String> keyIter = cfg.getKeys();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            properties.put(key, cfg.getProperty(key));
        }
        return properties;
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }


    private InputStream openConfiguration(String location) throws IOException {
   		logger.info("Loading configuration from: {}", location);
   		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
   		Resource resource = resourceLoader.getResource(location);
   		if (!resource.exists()) {
   			throw new FileNotFoundException(location);
   		}

   		return resource.getInputStream();
   	}

}
