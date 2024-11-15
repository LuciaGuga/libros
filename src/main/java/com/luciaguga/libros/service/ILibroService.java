package com.luciaguga.libros.service;

import com.luciaguga.libros.dto.AutorDTO;
import com.luciaguga.libros.model.Libro;
import java.util.List;

public interface ILibroService {
    public List<Libro> getLibros();
    public void saveLibro(Long isbn, String titulo, int anioPublicacion, String breveDescripcion, List<AutorDTO> listaDto);
    public void deleteLibro(Long id);
    public Libro findLibro(Long id);
    public void editLibro(Long id, Libro l);
}
