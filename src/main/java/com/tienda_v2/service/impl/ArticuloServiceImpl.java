package com.tienda_v2.service.impl;

import com.tienda_v2.dao.ArticuloDao;
import com.tienda_v2.domain.Articulo;
import com.tienda_v2.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    @Autowired
    private ArticuloDao articuloDao;
    
    @Override
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>)articuloDao.findAll();
        
        // sino esta activo se remueve de la lista
        if (activos) { lista.removeIf(e -> !e.isActivo());}
        return lista;
    }
    
    @Override
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }
    
    @Override
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
    
    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdCategoria()).orElse(null);
    }
}
