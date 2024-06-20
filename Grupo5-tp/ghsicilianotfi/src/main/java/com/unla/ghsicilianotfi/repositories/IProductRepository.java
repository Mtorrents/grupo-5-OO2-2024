package com.unla.ghsicilianotfi.repositories;

import com.unla.ghsicilianotfi.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Producto, Integer> {
}