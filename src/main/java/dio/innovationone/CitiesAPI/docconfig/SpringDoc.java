package dio.innovationone.CitiesAPI.docconfig;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDoc {
    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("REST API Cities para Consulta de Países / Estados e Cidades brasileiras").version("5.0.0")
                        .description("Digital Innovation: Expert class - Sistema para Consulta / Calculo de distância entre cidades do Brasil")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc for Documentation - springdoc-openapi")
                        .url("https://springdoc.org/#Introduction"));
    }
}
