package org.scaler.product.Controllers;

import org.scaler.product.Model.Category;
import org.scaler.product.Services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
private CategoryService categoryService;
private CategoryController(CategoryService categoryServic){
    this.categoryService = categoryService;
}
@GetMapping("/products/categories")
public List<Category> getAllCategories(){
return categoryService.getAllCategories();
    }

}
