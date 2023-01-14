package ru.gb.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfig {

    @Value("${spring.cloud.gateway.routes[0].uri}")
    private String productsUri;

    @Value("${spring.cloud.gateway.routes[1].uri}")
    private String cartUri;

    @Value("${spring.cloud.gateway.routes[2].uri}")
    private String newsUri;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("products",
                        route -> route.path("/products/**")
                                .and()
                                .method(HttpMethod.GET, HttpMethod.POST, HttpMethod.DELETE)
                                .filters(f -> f.stripPrefix(1))
                                .uri(productsUri))
                .route("cart",
                        route -> route.path("/cart/**")
                                .and()
                                .method(HttpMethod.GET, HttpMethod.POST, HttpMethod.DELETE)
                                .filters(f -> f.stripPrefix(1))
                                .uri(cartUri))
                .route("news",
                        route -> route.path("/news/**")
                                .and()
                                .method(HttpMethod.GET, HttpMethod.POST)
                                .filters(f -> f.stripPrefix(1))
                                .uri(newsUri))
                .build();
    }
}
