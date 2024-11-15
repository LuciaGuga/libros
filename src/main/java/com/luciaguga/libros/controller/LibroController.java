package com.luciaguga.libros.controller;

import com.luciaguga.libros.dto.AutorDTO;
import com.luciaguga.libros.model.Libro;
import com.luciaguga.libros.repository.AutorAPIClient;
import com.luciaguga.libros.service.ILibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private ILibroService libroService;
    
    
    @Autowired
    private AutorAPIClient autorCliente;
    
    @GetMapping("/autores/traerDTO")
    public List<AutorDTO> traerTodosAutoresDTO(){
        return autorCliente.getAutoresDto();
    }
    
    @GetMapping("/traer")
    public List<Libro> traerLibros(){
        return libroService.getLibros();
    }
    
    @PostMapping("/crear")
    public String guardarLibro(@RequestParam Long isbn,
                                @RequestParam String titulo,
                                @RequestParam int anioPublicacion,
                                @RequestParam String breveDescripcion){
        libroService.saveLibro(isbn, titulo, anioPublicacion,breveDescripcion,traerTodosAutoresDTO());
        return "Libro guardado correctamente";
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String borrarLibro(@PathVariable Long id){
        libroService.deleteLibro(id);
        return "Libro elimnado correctamente";
    }
    
    @GetMapping("/traer/{id}")
    public Libro traerLibroPorIsbn(@PathVariable Long id){
        return libroService.findLibro(id);
    }
    
    @PutMapping("/editar/{isbn}")
    public Libro editarLibro(Long isbn, Libro l){
        libroService.editLibro(isbn, l);
        return libroService.findLibro(isbn);
    }
}
