package com.talento.crud.controller;

import com.talento.crud.model.Articulo;
import com.talento.crud.service.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/articulos") // URL base de la API
public class ArticuloController {
@Autowired
    private ArticuloService articuloService;

    // ------------------ LISTAR ------------------
    @GetMapping
    public List<Articulo> listarArticulos() {
        return articuloService.listarArticulos();
    }

    // ------------------ OBTENER POR ID ------------------
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerArticulo(@PathVariable Long id) {
        return articuloService.obtenerArticuloPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ------------------ CREAR ------------------
    @PostMapping
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    // ------------------ ACTUALIZAR ------------------
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizarArticulo(
            @PathVariable Long id,
            @RequestBody Articulo articulo) {
        return ResponseEntity.ok(articuloService.actualizarArticulo(id, articulo));
    }

    // ------------------ ELIMINAR ------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }
}
