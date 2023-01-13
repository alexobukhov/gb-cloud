package ru.gb.products;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.products.grpc.ProductServiceGrpcImpl;

@SpringBootApplication
public class ProductsServiceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ProductsServiceApplication.class, args);
        Server server = ServerBuilder
                .forPort(8081)
                .addService(new ProductServiceGrpcImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
