package com.gestionarticle.article.repository;

import com.gestionarticle.article.model.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Long> {

    void deleteDepotById(Long id);

    Optional<Depot> findDepotById(Long id);

}
