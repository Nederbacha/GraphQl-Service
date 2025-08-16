package org.ndr.graphqlservice.repository;

import org.ndr.graphqlservice.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LignCommandeRepository extends JpaRepository<LigneCommande,Long> {

}
