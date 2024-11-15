package com.luciaguga.libros.service;

import com.luciaguga.libros.dto.AutorDTO;
import com.luciaguga.libros.model.Libro;
import com.luciaguga.libros.repository.ILibroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService implements ILibroService{
    @Autowired
    private ILibroRepository libroRepo;
    
    @Override
    public List<Libro> getLibros() {
        return libroRepo.findAll();
    }

    @Override
    public void saveLibro(Long isbn, String titulo, int anioPublicacion, String breveDescripcion, List<AutorDTO> listaDto) {
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnioPublicacion(anioPublicacion);
        libro.setBreveDescripcion(breveDescripcion);
        List<String> listaAutores = new ArrayList<>();
        List<String> listaNacionalidades = new ArrayList<>();
        for(AutorDTO autorDto : listaDto){
            for(Long isbnA : autorDto.getIsbnsLibrosEscritos()){
                if(isbnA.equals(isbn)){
                    listaAutores.add(autorDto.getNombre());
                    listaNacionalidades.add(autorDto.getNacionalidad());
                }
                    
            }
        }
        libro.setNombresAutores(listaAutores);
        libro.setNacionalidades(listaNacionalidades);
        libroRepo.save(libro);
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepo.deleteById(id);
    }

    @Override
    public Libro findLibro(Long isbn) {
       return libroRepo.findById(isbn).orElse(null);
    }

    @Override
    public void editLibro(Long id, Libro l) {
        Libro libro = this.findLibro(id);
        libro.setIsbn(l.getIsbn());
        libro.setTitulo(l.getTitulo());
        libro.setAnioPublicacion(l.getAnioPublicacion());
        libro.setBreveDescripcion(l.getBreveDescripcion());
        //libro.setListaAutores(l.getListaAutores());
        libroRepo.save(libro);
    }


    
}
