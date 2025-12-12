package com.talento.crud.service;

import com.talento.crud.model.Articulo;
import com.talento.crud.repository.ArticuloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServicempl implements ArticuloService{
    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public Articulo actualizarArticulo(Long id, Articulo articulo) {
        // Primero verificamos si existe
        Optional<Articulo> existe = articuloRepository.findById(id);

        if (existe.isPresent()) {
            Articulo actualizado = existe.get();

            // Copiamos los datos nuevos
            actualizado.setNombre(articulo.getNombre());
            actualizado.setPrecio(articulo.getPrecio());
            actualizado.setStock(articulo.getStock());

            return articuloRepository.save(actualizado);
        }

        return null; // Si no existe, podrías lanzar una excepción
    }

    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}
