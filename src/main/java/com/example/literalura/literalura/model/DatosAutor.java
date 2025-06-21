package com.example.literalura.literalura.model;



import com.fasterxml.jackson.annotation.JsonAlias;


public record DatosAutor(
        @JsonAlias("name") String autor,
        @JsonAlias("birth_year") Long nacimiento,
        @JsonAlias("death_year") Long fallecimiento
        ) {


}
