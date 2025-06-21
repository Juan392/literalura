package com.example.literalura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autor_id;
    private String autor;
    private Long nacimiento;
    private Long fallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> libros;

    public Autor() {
    }


    public Autor(DatosAutor datosAutor) {
        this.autor = datosAutor.autor();
        this.fallecimiento = datosAutor.fallecimiento();
        this.nacimiento = datosAutor.nacimiento();
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Long fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public Long getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Long nacimiento) {
        this.nacimiento = nacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return this.autor +
                "\n\t\tNacimiento: " + nacimiento +
                "\n\t\tFallecimiento: " + fallecimiento;
    }
}

