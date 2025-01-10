package sn.edu.ugb.ipsl.git.HelloSpringBoot.config;

import io.swagger.v3.oas.annotations.extensions.Extension;
//import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import jakarta.validation.constraints.Null;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI getOpenAPI() {


        return new OpenAPI()
                .info(new Info()
                        .title("API IPSL")
                        .description("Example API description")
                        .version("1.0")
                        .contact(
                                new Contact().email("ndiaye.khady30@ugb.edu.sn")
                        )

                );
    }
}
