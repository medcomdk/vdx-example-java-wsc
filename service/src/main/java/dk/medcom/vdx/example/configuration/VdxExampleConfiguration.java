package dk.medcom.vdx.example.configuration;

import dk.medcom.vdx.example.service.ExampleService;
import dk.medcom.vdx.example.service.ExampleServiceImpl;
import dk.medcom.vdx.example.videoapiclient.VideoApiClient;
import dk.medcom.vdx.example.videoapiclient.VideoApiClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class VdxExampleConfiguration {
    private final Logger logger = LoggerFactory.getLogger(VdxExampleConfiguration.class);

    @Bean
    public ExampleService exampleService(VideoApiClient videoApiClient) {
        return new ExampleServiceImpl(videoApiClient);
    }

    @Bean
    public VideoApiClient videoApiClient(@Value("${service.url}")String serviceUrl, RestTemplate restTemplate) {
        logger.info("Configuration Video API client with base url {}.", serviceUrl);
        return new VideoApiClientImpl(serviceUrl, restTemplate);
    }

    @Bean
    public RestTemplate restTemplate() throws Exception {
        return new RestTemplate();
    }
}
