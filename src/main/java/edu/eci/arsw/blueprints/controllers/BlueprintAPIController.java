/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/v1/blueprint")
public class BlueprintAPIController {

    @Autowired
    private BlueprintsServices bps;

    @RequestMapping(method = RequestMethod.GET )
    public ResponseEntity<?> bluePrints(){
        try{
            return new ResponseEntity<>(bps.getAllBlueprints(),HttpStatus.ACCEPTED);

        }catch (Exception e){
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>("Error bluprint no encontrado",HttpStatus.NOT_FOUND);
        }
    }


}

