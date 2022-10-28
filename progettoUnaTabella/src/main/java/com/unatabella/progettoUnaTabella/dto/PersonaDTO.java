package com.unatabella.progettoUnaTabella.dto;

import java.util.Date;

public class PersonaDTO {
    private Long id;
    private String nome;
    private String cognome;
    private Date data;

    public PersonaDTO() {
    }

    public PersonaDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


}
