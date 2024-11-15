package com.luciaguga.libros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    private String nombre;
    private String nacionalidad;
    private Long[] isbnsLibrosEscritos;
}