package com.gestionarticle.article.service;

import com.gestionarticle.article.exception.HandlerException;
import com.gestionarticle.article.model.Depot;
import com.gestionarticle.article.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DepotService {


    /**
     * Injection de dépendance / Partern IO Container
     */
    @Autowired
    private DepotRepository depotRepository;


    /**
     *
     * Méthodes CRUD
     */
    public List<Depot> getDepots() {
        return depotRepository.findAll();
    }

    public Depot getDepot( Long id) {
        return depotRepository.findDepotById(id)
                .orElseThrow(()-> new HandlerException("Depot by id"+ id +"was not found."));
    }

    public Depot saveDepot(Depot depot) {
        return depotRepository.save(depot);
    }

    public Depot updateDepot(Depot depot) {
        Depot updateDepot = depotRepository.save(depot);
        return updateDepot;
    }

    public void deleteDepot(final Long id) {
        depotRepository.deleteById(id);
    }


}
