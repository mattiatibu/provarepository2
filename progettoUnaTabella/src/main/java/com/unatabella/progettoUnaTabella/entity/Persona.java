package com.unatabella.progettoUnaTabella.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tabella")
@SequenceGenerator(name = "persona_generator", sequenceName = "persona_sequence",
        initialValue = 5, allocationSize = 3)
public class Persona {
    private Long id;
    private String nome;
    private String cognome;
    private Date data;
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "persona_generator",strategy=GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "cognome")
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    @Column(name="data_nascita")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
