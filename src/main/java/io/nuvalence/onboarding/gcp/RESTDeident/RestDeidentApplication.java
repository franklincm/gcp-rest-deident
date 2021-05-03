package io.nuvalence.onboarding.gcp.RESTDeident;

import io.nuvalence.onboarding.gcp.RESTDeident.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class RestDeidentApplication {

    public static void main(String[] args) {
	SpringApplication.run(RestDeidentApplication.class, args);
    }

}
