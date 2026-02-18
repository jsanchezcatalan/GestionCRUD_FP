package com.tuempresa.gestionra.model;

import javax.persistence.*;
@Entity
@Table(name = "resultados_aprendizaje") // Enlazamos con tu tabla original
public class Ra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String descripcion;

    // Magia de JPA: Relación Muchos a Uno (Muchos RA pertenecen a 1 Materia)
    @ManyToOne
    @JoinColumn(name = "id_asignatura") // El nombre exacto de tu columna en MySQL
    private Materia materia; 

    public Ra() {
    }

    public Ra(Integer id, String descripcion, Materia materia) {
        this.id = id;
        this.descripcion = descripcion;
        this.materia = materia;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Materia getMateria() { return materia; }
    public void setMateria(Materia materia) { this.materia = materia; }
}