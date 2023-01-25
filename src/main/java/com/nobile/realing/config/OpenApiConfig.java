package com.nobile.realing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
            .title("Realing´s API")
            .description("Realing is a ebook reader focuses on helping the user to learn vocabulary in new languages. If you tap on a word, it will translate it and storage it. If you tap two times it's going to translate the sentence, and tapping 3 times you'll see the paragraph's translation")
            .version("v1.0"));
    }
}