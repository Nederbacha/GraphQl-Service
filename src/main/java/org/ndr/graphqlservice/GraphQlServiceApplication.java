package org.ndr.graphqlservice;

import org.modelmapper.ModelMapper;
import org.ndr.graphqlservice.entities.Category;
import org.ndr.graphqlservice.entities.Product;
import org.ndr.graphqlservice.repository.CategoryRepository;
import org.ndr.graphqlservice.repository.ProducctRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import java.util.UUID;

@SpringBootApplication
public class GraphQlServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(GraphQlServiceApplication.class, args);
        System.out.println("################################################################################");

        System.out.println("####################  ✅  SUCCESS    ✅ #######################################");

        System.out.println("################################################################################");
    }

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
                                        ProducctRepository producctRepository){
        return args -> {

            List.of("printer","smartphone").forEach(el->{
                Category category=Category.builder().name(el).build();
                categoryRepository.save(category);
            });

categoryRepository.findAll().forEach(category->{
    for (int i = 0; i < 10; i++) {


        Product product=Product.builder()
                .id(UUID.randomUUID().toString())
                .price(1000+Math.random()*5000)
                .name(category.getName()+i)
                .quantity(10+i)
                .category(category)
                .build();

        producctRepository.save(product);

    }


});



        };
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

















/*
    @Bean
     CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
                                        ProducctRepository producctRepository){

        return args -> {

            List.of("Smartphone","TV","Printer").forEach(commande->{


                Category  category=Category.builder().name(commande).build();

                categoryRepository.save(category);


            });

            categoryRepository.findAll().forEach(category -> {
                for(int i=0;i<10;i++){

                    Product  product= Product.builder()
                            .id(UUID.randomUUID().toString())
                            .price(1000+Math.random()*5000)
                            .category(category)
                            .quantity(10+ i)
                            .name(category.getName()+i)
                            .build();

                    producctRepository.save(product);

                }
           });

        };
    }*/


}



