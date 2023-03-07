package com.tienda_v2.service.impl;

import com.tienda_v2.dao.ClienteDao;
import com.tienda_v2.domain.Cliente;
import com.tienda_v2.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
        
    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }
}
