package org.ndr.graphqlservice.web;



import org.ndr.graphqlservice.entities.Product;
import org.ndr.graphqlservice.repository.ProducctRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Controller
public class ProductGraphQlController {

    private ProducctRepository producctRepository ;

    public ProductGraphQlController(ProducctRepository repository){
        this.producctRepository=repository ;
    }


    @QueryMapping
    public List<Product>  findAllProduct(){
        return  producctRepository.findAll();
    }


    @QueryMapping
    public Product findByIdProduct(@Argument String id){
        return producctRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("this produsct %s not found",id)));
    }



}
