package com.gestionarticle.article.controller;

import com.gestionarticle.article.model.Depot;
import com.gestionarticle.article.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DepotController {


    /**
     * Injection de dépendance / Partern IO Container
     */
    @Autowired
    private DepotService depotService;


    /**
     *
     * Méthodes CRUD
     */
    @GetMapping("/depot/all")
    public ResponseEntity<List<Depot>> getAllArticle()
    {
        List<Depot> depots = depotService.getDepots();
        return new ResponseEntity<>(depots, HttpStatus.OK);
    }

    @GetMapping("/depot/find/{id}")
    public ResponseEntity<Depot> getDepotById(@PathVariable("id") Long id)
    {
        Depot depot = depotService.getDepot(id);
        return new ResponseEntity<>(depot, HttpStatus.OK);
    }

    @PostMapping("/depot/add")
    public ResponseEntity<Depot> addDepot(@RequestBody Depot depot)
    {
        Depot depotAdded = depotService.saveDepot(depot);
        return new ResponseEntity<>(depotAdded, HttpStatus.CREATED);
    }

    @PutMapping("/depot/update")
    public ResponseEntity<Depot> updateDepot(@RequestBody Depot depot)
    {
        Depot updateDepot = depotService.updateDepot(depot);
        return new ResponseEntity<>(updateDepot, HttpStatus.OK);
    }

    @DeleteMapping("/depot/delete/{id}")
    public ResponseEntity<?> deleteDepot(@PathVariable("id") Long id)
    {
        depotService.deleteDepot(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
