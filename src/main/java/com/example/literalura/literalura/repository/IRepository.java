package com.example.literalura.literalura.repository;

import com.example.literalura.literalura.model.Lenguaje;
import com.example.literalura.literalura.model.Libro;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepository extends JpaRepository<Libro,Long> {
   List<Libro> findByAutor_AutorIgnoreCase(String nombre);
   List<Libro> findByLenguaje(Lenguaje lenguaje);
   List<Libro> findByAutorNacimientoGreaterThanEqualAndAutorFallecimientoLessThanEqual(Long nacimiento, Long fallecimiento);
}
