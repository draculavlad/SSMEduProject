package jacob.su.edu.config;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(
        ContentNegotiationConfigurer configurer) {
        configurer
            .defaultContentType(MediaType.APPLICATION_JSON)
            .favorPathExtension(false)
            .favorParameter(false);
    }

    @Override
    public void configureMessageConverters(
        List<HttpMessageConverter<?>> converters) {
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new BufferedImageHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(mappingJackson2HttpMessageConverter());
        converters.add(new FormHttpMessageConverter());
    }

    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
            new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,
            System.getProperties().containsKey("PrettyJSON"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        objectMapper.setDateFormat(simpleDateFormat);

        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2HttpMessageConverter;
    }

    @Bean
    public ServletFileUpload getServletFileUpload() {
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        return new ServletFileUpload(factory);
    }

}
