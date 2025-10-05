package com.bootlabs.demo.service;

import com.bootlabs.demo.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductService.class);


    private static final String PRODUCTS_ID = "/products/{id}";
    private static final String PRODUCTS = "/products";
    private final RestClient restClient;

    public ProductService(RestClient restClient) {
        this.restClient = restClient;
    }

    /** GET all products */
    public List<Product> getAllProducts() {
        return restClient.get()
                .uri(PRODUCTS)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    /** GET a single product by id */
    public Product getProductById(Long id) {
        return restClient.get()
                .uri(PRODUCTS_ID, id)
                .retrieve()
                .body(Product.class);
    }

    /** CREATE a new product */
    public Product createProduct(Product newProduct) {
        return restClient.post()
                .uri(PRODUCTS)
                .body(newProduct)
                .retrieve()
                .body(Product.class);
    }

    /** UPDATE (PUT) an existing product */
    public Product updateProduct(Long id, Product updatedProduct) {
        return restClient.put()
                .uri(PRODUCTS_ID, id)
                .body(updatedProduct)
                .retrieve()
                .body(Product.class);
    }

    /** DELETE a product */
    public void deleteProduct(Long id) {
        restClient.delete()
                .uri(PRODUCTS_ID, id)
                .retrieve()
                // some APIs return deleted object or status; FakeStoreAPI returns data of deleted item
                .body(Void.class);
    }
}
