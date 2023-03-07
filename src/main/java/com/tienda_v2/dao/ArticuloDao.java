package com.tienda_v2.dao;

import com.tienda_v2.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
}
