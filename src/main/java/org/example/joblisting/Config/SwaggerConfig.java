package org.example.joblisting.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI jobListingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Job Listing API")
                        .description("API for managing job listings (HR and Users)")
                        .version("1.0"));
    }
}
