package com.talento.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talento.crud.model.Articulo;;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
