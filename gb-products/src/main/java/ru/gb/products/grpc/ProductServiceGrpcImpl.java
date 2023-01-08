package ru.gb.products.grpc;

import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.products.model.Product;
import ru.gb.products.service.ProductService;

public class ProductServiceGrpcImpl extends ProductServiceImplBase {

    @Autowired
    ProductService productService;

    @Override
    public Product products(ProductRequest productRequest, StreamObserver<ProductResponse> responseStreamObserver) {
        Product product = productService.getProduct(productRequest.getId());
        ProductResponse productResponse = ProductResponse.newBuilder()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setCost(product.getCost())
                .setDate(product.getPuchaseDate())
                .build();

        productResponse.onNext(productResponse);
        productResponse.onCompleted();
    }
}
