package org.scaler.product.Controllers;

import org.scaler.product.Model.Product;
import org.scaler.product.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(long id) {
        return productService.getSingleProduct(id);
    }

}

