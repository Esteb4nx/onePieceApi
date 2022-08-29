package com.example.opapi.controller;

import com.example.opapi.model.Personaje;
import com.example.opapi.respository.PersonajeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {

    @Autowired
    private PersonajeRespository personajeRespository;

    @GetMapping
    public ResponseEntity<List<Personaje>> getAll(){
        return new ResponseEntity<>(personajeRespository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Personaje> getById(@PathVariable Long id){
        if(!personajeRespository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(personajeRespository.findById(id).get(),HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Personaje> newPersonaje(@RequestBody Personaje personajeNuevo){
        personajeNuevo.setId(0L);
        personajeRespository.save(personajeNuevo);
        return new ResponseEntity<>(personajeNuevo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if(personajeRespository.existsById(id)){
            personajeRespository.deleteById(id);
            return new ResponseEntity<>("Se ha borrado el personaje: "+id,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
