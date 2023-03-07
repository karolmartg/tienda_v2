package com.tienda_v2.service.impl;

import com.tienda_v2.dao.CategoriaDao;
import com.tienda_v2.domain.Categoria;
import com.tienda_v2.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos){
        var lista = (List<Categoria>)categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo()); // sino esta activo lo remueve
        }
        return lista;
    }
    
    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }
    
    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
}
