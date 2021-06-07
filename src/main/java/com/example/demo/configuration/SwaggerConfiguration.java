package com.example.demo.configuration;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.SwaggerConfiguration
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|12:06
 * @Version SwaggerConfiguration: 1.0
 */
@Configuration
public class SwaggerConfiguration {
    public OpenAPI studentOpenAPI()
    {
        return new OpenAPI().
        info(
            new Info()
                .title("Курсова")
                .version("1.0")
                .contact(
                    new Contact()
                    .email("")
                    .name("Городенский Станислав")
                    .url("")
                )
    );
    }
}
