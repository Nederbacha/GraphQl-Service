package org.ndr.graphqlservice.web;



import org.ndr.graphqlservice.dto.ProductRequestDTO;
import org.ndr.graphqlservice.entities.Category;
import org.ndr.graphqlservice.entities.Product;
import org.ndr.graphqlservice.repository.CategoryRepository;
import org.ndr.graphqlservice.repository.ProducctRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
@Controller
public class ProductGraphQlController {

    private ProducctRepository producctRepository ;
     private ModelMapper modelMapper ;
     private CategoryRepository categoryRepository;


    public ProductGraphQlController(ProducctRepository repository,
                                    ModelMapper modelMapper,
                                    CategoryRepository categoryRepository){
        this.producctRepository=repository ;
        this.modelMapper=modelMapper;
        this.categoryRepository=categoryRepository;
    }


    @QueryMapping
    public List<Product>  findAllProduct(){
        return  producctRepository.findAll();
    }


    @QueryMapping
    public Product findByIdProduct(@Argument String id){
        return producctRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("this product %s not found",id)));
    }


    @MutationMapping
    public Product saveProduct(@Argument ProductRequestDTO product ){
//Product product=modelMapper.map(productRequestDTO, Product.class);
 //return producctRepository.save(product);
        Category category=categoryRepository.findById(product.id_category()).orElse(null);
        Product productToSave=new Product();
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return producctRepository.save(productToSave);
        // Mapper le DTO vers l'entité Product
     /*   Product product = modelMapper.map(productDTO, Product.class);

        // Générer un UUID pour l'ID
        product.setId(UUID.randomUUID().toString());

        // Charger la catégorie depuis la BDD
        Category category = categoryRepository.findById(productDTO.id_category()).orElse(null);

        product.setCategory(category);

        return producctRepository.save(product);*/

    }


    @MutationMapping
    public Product updateProduct(@Argument String id, @Argument ProductRequestDTO product){
        Category category=categoryRepository.findById(product.id_category()).orElse(null);
        Product productToSave=new Product();
        productToSave.setId(id);
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return producctRepository.save(productToSave);
    }

}
