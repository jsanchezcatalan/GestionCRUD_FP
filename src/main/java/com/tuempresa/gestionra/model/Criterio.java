package com.tuempresa.gestionra.model;

import javax.persistence.*;
@Entity
@Table(name = "criterios_evaluacion") // Enlazamos con tu tabla original
public class Criterio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String descripcion;

    // Muchos Criterios pertenecen a 1 RA
    @ManyToOne
    @JoinColumn(name = "id_ra") // El nombre exacto de tu columna en MySQL
    private Ra ra;

    public Criterio() {
    }

    public Criterio(Integer id, String descripcion, Ra ra) {
        this.id = id;
        this.descripcion = descripcion;
        this.ra = ra;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Ra getRa() { return ra; }
    public void setRa(Ra ra) { this.ra = ra; }
}