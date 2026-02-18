package com.tuempresa.gestionra.model;

import javax.persistence.*;
@Entity
@Table(name = "asignaturas") // Enlazamos con tu tabla original en la BD
public class Materia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Integer id;
    
    private String nombre;
    private String codigo;

    // Constructor vacío exigido por JPA
    public Materia() {
    }

    public Materia(Integer id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
}