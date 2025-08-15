package org.ndr.graphqlservice.repository;

import org.ndr.graphqlservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProducctRepository extends JpaRepository<Product,String> {
}
