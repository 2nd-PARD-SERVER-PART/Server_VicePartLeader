package three.seminar.basic.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }
    public Info apiInfo(){
        return new Info()
                .title("텍스트") //제목
                .description("스프링 독을 이용한 SWagger UI 테스트")
                .version("1.0.0");

    }
}
