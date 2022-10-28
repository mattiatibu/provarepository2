package com.unatabella.progettoUnaTabella.repository;

import com.unatabella.progettoUnaTabella.entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;


public interface PersonaRepo extends JpaRepository<Persona,Long> {

    public Page<Persona> getPersonaByCognome(String cognome, Pageable pageable);

    @Query(value = "select p from Persona p where p.nome= :name and p.cognome= :cognome"
            /*countQuery = "select count(p) from Persona p where p.nome= :name and p.cognome"*/)
    public Optional<Persona> getPersonaNomeCognome(String name, String cognome);

    //@Query(value= "select p.id,p.nome from Persona p where p.id= :id")
    //public List<Tuple>











}
