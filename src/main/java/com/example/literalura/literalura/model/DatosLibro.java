package com.example.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(
        @JsonAlias("title") String nombre,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("summaries") List<String> sinopsis,
        @JsonAlias("languages") List<String> lenguaje) {
}
