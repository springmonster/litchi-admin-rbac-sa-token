package com.litchi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * <p>
 * Create by noah
 * Date 2024/1/6 21:45
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info()
                .title("Litchi-Admin接口文档")
                .version("v1.0")
                .description("此接口文档开发使用，生产环境需配置禁用")
                .contact(new Contact()
                        .url("https://www.gengby.com")
                        .name("Noah")
                        .email("gby_dev@163.com")));
    }
}
