package com.richard.application.config.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private final OpenApiPropertiesConfig environment;

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("Products")
                        .description("API responsável por gerenciar as informações de produtos vindas do PIM(ProductResponse Information Management)")
                        .version(environment.getAppVersion()))
                .tags(List.of(new Tag().name("Products").description("Endpoints responsáveis por gerenciar as informações do produto"),
                                new Tag().name("Brands").description("Endpoints responsáveis por gerenciar as informações da marca"),
                                new Tag().name("Categories").description("Endpoints responsáveis por gerenciar as informações de categoria"),
                                new Tag().name("Subcategories").description("Endpoints responsáveis por gerenciar as informações de subcategoria"),
                                new Tag().name("Categories Multichannel").description("Endpoints responsáveis por gerenciar as informações de categoria multicanal"),
                                new Tag().name("Products Multichannel").description("Endpoints responsáveis por gerenciar as informações de produto multicanal"),
                                new Tag().name("PsychotropicList").description("Endpoints responsáveis por gerenciar as informações da lista de psicotrópicos"),
                                new Tag().name("Groups").description("Endpoints responsáveis por gerenciar as informações de grupo"),
                                new Tag().name("MasterCategories").description("Endpoints responsáveis por gerenciar as informações de categoria master"),
                                new Tag().name("Exhibition Categories").description("Endpoints responsáveis por gerenciar as informações de categoria exposição"),
                                new Tag().name("PharmaceuticalMolds").description("Endpoints responsáveis por gerenciar as informações de forma farmacêutica"),
                                new Tag().name("Dcb").description("Endpoints responsáveis por gerenciar as informações de DCB"),
                                new Tag().name("Subgroups").description("Endpoints responsáveis por gerenciar as informações de subgrupo"),
                                new Tag().name("ActiveIngredients").description("Endpoints responsáveis por gerenciar as informações de princípio ativo"),
                                new Tag().name("Cardgroups").description("Endpoints responsáveis por gerenciar as informações de grupo de ficha"),
                                new Tag().name("Sal").description("Endpoints responsáveis por gerenciar as informações do sal dos produtos"),
                                new Tag().name("Usage").description("Endpoints responsáveis por gerenciar as informações de uso dos produtos"),
                                new Tag().name("Recommendation").description("Endpoints responsáveis por gerenciar as informações de lista de indicação dos produtos"),
                                new Tag().name("Therapeutic Class").description("Endpoints responsáveis por gerenciar as informações de classe terapêutica"),
                                new Tag().name("Sizes").description("Endpoints responsáveis por gerenciar as informações do tamanho dos produtos"),
                                new Tag().name("PackageTypes").description("Endpoints responsáveis por gerenciar as informações do tipo dos pacote dos produtos"),
                                new Tag().name("StatusReasons").description("Endpoints responsáveis por gerenciar as informações dos motivos de inativação")
                        )
                );
    }

}
