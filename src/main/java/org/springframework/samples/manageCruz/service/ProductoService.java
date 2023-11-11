package org.springframework.samples.manageCruz.service;

import java.util.List;

import org.springframework.samples.manageCruz.entity.Producto;
import org.springframework.samples.manageCruz.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        super();
        this.productoRepository = productoRepository;
    }

    public Producto findById(int id) {
        return productoRepository.findById(id);
    }

    public List<Producto> findAll() {
        return productoRepository.findAllProd();
    }
    
}
