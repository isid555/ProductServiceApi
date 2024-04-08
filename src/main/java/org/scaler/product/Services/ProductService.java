package org.scaler.product.Services;

import org.scaler.product.Model.Product;

import java.util.List;

public interface ProductService {
List<Product> getAllProducts();
Product getSingleProduct(long id);
}
