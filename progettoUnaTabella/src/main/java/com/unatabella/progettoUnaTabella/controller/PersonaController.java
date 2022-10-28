package com.unatabella.progettoUnaTabella.controller;

import com.unatabella.progettoUnaTabella.dto.PageDTO;
import com.unatabella.progettoUnaTabella.dto.PersonaDTO;
import com.unatabella.progettoUnaTabella.entity.Persona;
import com.unatabella.progettoUnaTabella.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    public final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaDTO> create(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO dtoResponse = personaService.create(personaDTO);
        return new ResponseEntity<PersonaDTO>(dtoResponse, HttpStatus.CREATED);
    }


    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaDTO> update(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO dtoResponse = personaService.update(personaDTO);
        return new ResponseEntity<PersonaDTO>(dtoResponse, HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<PersonaDTO> delete(@PathVariable(value = "id") Long userId) {
        personaService.delete(userId);
        return new ResponseEntity<PersonaDTO>(HttpStatus.NO_CONTENT);
    }



    @GetMapping(value = "/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaDTO> find(@PathVariable(value = "id") Long userId) {
        PersonaDTO dtoResponse = personaService.find(userId);
        return new ResponseEntity<PersonaDTO>(dtoResponse, HttpStatus.OK);
    }

    //altri controller

    //correggere
    @GetMapping(value= "/find_name/{nome}/{cognome}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaDTO> findByName(@PathVariable(value = "nome") String nome,
                                                @PathVariable(value = "cognome") String cognome){
        PersonaDTO dtoResponse = personaService.findNomeCognome(nome,cognome);
        return new ResponseEntity<PersonaDTO>(dtoResponse,HttpStatus.OK);
    }

    @GetMapping(value= "/find_cognome/{cognome}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageDTO> findPage(@PathVariable(value = "cognome") String cognome){
        PageDTO dtoResponse = personaService.findByCognome(cognome);
        return new ResponseEntity<PageDTO>(dtoResponse,HttpStatus.OK);
    }
}
