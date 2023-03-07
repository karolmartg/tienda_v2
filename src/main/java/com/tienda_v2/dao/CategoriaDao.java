package com.tienda_v2.dao;

import com.tienda_v2.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Long> {
    
}
