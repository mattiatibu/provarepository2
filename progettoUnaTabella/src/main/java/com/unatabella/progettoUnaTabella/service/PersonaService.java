package com.unatabella.progettoUnaTabella.service;

import com.unatabella.progettoUnaTabella.dto.PageDTO;
import com.unatabella.progettoUnaTabella.dto.PersonaDTO;
import com.unatabella.progettoUnaTabella.entity.Persona;
import com.unatabella.progettoUnaTabella.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class PersonaService {

    private final PersonaRepo personaRepo;

    @Autowired
    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    @Transactional
    public PersonaDTO create(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setId(personaDTO.getId());
        persona.setNome(personaDTO.getNome());
        persona.setCognome(personaDTO.getCognome());
        persona.setData(personaDTO.getData());
        personaRepo.save(persona);
        return personaDTO;
    }

    @Transactional
    public PersonaDTO update(PersonaDTO personaDTO) {
        Optional<Persona> cOpt= personaRepo.findById(personaDTO.getId());
        if(!cOpt.isEmpty()) {
            Persona p = cOpt.get();//tiro fuori l'oggetto managed se non e' vuoto
            p.setNome(personaDTO.getNome());
            p.setCognome(personaDTO.getCognome());
            p.setData(personaDTO.getData());
        }
        return personaDTO;
    }

    @Transactional
    public void delete(Long id) {
        Optional<Persona> cOpt = personaRepo.findById(id);
        if(!cOpt.isEmpty())
            personaRepo.delete(cOpt.get());
    }


    public PersonaDTO find(Long id) {
        Optional<Persona> cOpt = personaRepo.findById(id);
        if(!cOpt.isEmpty()) {
            PersonaDTO dto = new PersonaDTO();
            Persona p = cOpt.get();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setCognome(p.getCognome());
            dto.setData(p.getData());
            return dto;
        }
        return new PersonaDTO();
    }

    public PersonaDTO findNomeCognome(String name,String surname){
        Optional<Persona> opt= personaRepo.getPersonaNomeCognome(name,surname);
        if(opt.isEmpty()){
            PersonaDTO dto = new PersonaDTO();
            Persona p = opt.get();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setCognome(p.getCognome());
            dto.setData(p.getData());
            System.out.println("Ho Trovato questa persona: "+p.toString());
            return dto;
        }
        return new PersonaDTO();
    }

    public PageDTO findByCognome(String cognome){
        Page<Persona> page=personaRepo.getPersonaByCognome(cognome, PageRequest.of(0,5));
        if(page.hasContent()){
            PageDTO dto= new PageDTO();
            dto.setNumElementi(page.getTotalElements());
            dto.setNumPagine(page.getTotalPages());
            dto.setPage(page);
            return dto;
        }
        return new PageDTO();
    }
}
