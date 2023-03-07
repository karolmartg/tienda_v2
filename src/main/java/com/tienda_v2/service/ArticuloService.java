package com.tienda_v2.service;

import com.tienda_v2.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
}
