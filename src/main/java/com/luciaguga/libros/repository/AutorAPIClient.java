package com.luciaguga.libros.repository;

import com.luciaguga.libros.dto.AutorDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="autores", url="localhost:9001")
public interface AutorAPIClient {
    @GetMapping("/autores/traerDTO")
    public List<AutorDTO> getAutoresDto();
}
