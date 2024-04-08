package org.scaler.product.Services;

import org.scaler.product.Dto.FakeStoreProductDto;
import org.scaler.product.Model.Category;
import org.scaler.product.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService  implements ProductService {
    RestTemplate restTemplate = new RestTemplate();

    private Product ConvertToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if (fakeStoreProductDto == null) {
            return null;

        }
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageURL(fakeStoreProductDto.getImageURL());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products"
                , FakeStoreProductDto[].class);

        if (fakeStoreProductDtos != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                Product product = ConvertToProduct(fakeStoreProductDto);
                products.add(product);
            }
            return products;
        }
        return null;
    }

    @Override
    public Product getSingleProduct(long id) {
        String url = "https://fakestoreapi.com/products" + id;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(url, FakeStoreProductDto.class);
        return ConvertToProduct(fakeStoreProductDto);
//        return null;
    }





}
