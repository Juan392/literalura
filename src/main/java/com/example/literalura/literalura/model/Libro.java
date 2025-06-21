package com.example.literalura.literalura.model;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import static com.example.literalura.literalura.service.GeminiAi.traduccion;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libro_id;
    @Column(unique = true)
    private String nombre;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @Column(length = 1000)
    private String sinopsis;
    private Lenguaje lenguaje;

    public Libro() {
    }

    public Libro(DatosLibro datosLibro) {
        this.nombre = datosLibro.nombre();
        if (!datosLibro.autor().isEmpty()){
            var autorconer = datosLibro.autor().get(0);
            this.autor = new Autor(autorconer);
        }

        if(!datosLibro.sinopsis().isEmpty()){
            this.sinopsis = traduccion(datosLibro.sinopsis().get(0));
        }
        this.lenguaje = Lenguaje.fromString(datosLibro.lenguaje().get(0));
    }

    public Long getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Long libro_id) {
        this.libro_id = libro_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public String toString() {
        return
                "\nTitulo: " + this.nombre +
                "\nAutor: " + this.autor +
                "\nLenguaje: "+ this.lenguaje +
                "\nSinopsis: "+ this.sinopsis;
    }
}
