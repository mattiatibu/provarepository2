package com.unatabella.progettoUnaTabella.dto;

import com.unatabella.progettoUnaTabella.entity.Persona;
import org.springframework.data.domain.Page;

public class PageDTO {
    private int numPagine;
    private Long numElementi;
    Page<Persona> page;

    public Integer getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int totalPages) {
        numPagine=totalPages;
    }

    public Long getNumElementi() {
        return numElementi;
    }

    public void setNumElementi(Long numElementi) {
        this.numElementi = numElementi;
    }

    public Page<Persona> getPage() {
        return page;
    }

    public void setPage(Page<Persona> page) {
        this.page = page;
    }
}
