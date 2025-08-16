package org.ndr.graphqlservice.web;


import org.ndr.graphqlservice.entities.LigneCommande;
import org.ndr.graphqlservice.repository.LignCommandeRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LignCommandeGraphQlController {

    private LignCommandeRepository lignCommandeRepository ;

    private LignCommandeGraphQlController(LignCommandeRepository lignCommandeRepository){
        this.lignCommandeRepository=lignCommandeRepository ;
    }


    @QueryMapping
    public List<LigneCommande>  getAllLigneCommande(){
        return lignCommandeRepository.findAll() ;
    }


    @QueryMapping
    public LigneCommande findByIdLignCommande(@Argument Long id){
        return  lignCommandeRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("this ligne commande %s is not existed",id)));
    }

}
