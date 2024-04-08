package org.scaler.product.Services;

import org.scaler.product.Dto.FakeStoreProductDto;
import org.scaler.product.Model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service

public class FakeStoreCategoryService implements  CategoryService {
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Category> getAllCategories() {

        String[] fakeStoreCategories = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );
        if(fakeStoreCategories!=null){
            List<Category> categories =new ArrayList<>();
            for(String cat : fakeStoreCategories){
Category category = new Category();
category.setName(cat);
categories.add(category);
            }
            return categories;
        }



        return null;
    }
}
