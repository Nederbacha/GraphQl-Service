package org.ndr.graphqlservice.web;

import org.ndr.graphqlservice.entities.Category;
import org.ndr.graphqlservice.repository.CategoryRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryGraphQlController {

    private CategoryRepository categoryRepository ;

    private CategoryGraphQlController(CategoryRepository categoryRepository){
         this.categoryRepository=categoryRepository ;
    }

    @QueryMapping
public List<Category> getAllCategories(){
        return  categoryRepository.findAll() ;
}


@QueryMapping
public Category findByIdCategory(@Argument Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("this category %s is not found",id)));
}


}
