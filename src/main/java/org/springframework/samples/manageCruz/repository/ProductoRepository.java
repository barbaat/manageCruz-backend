package org.springframework.samples.manageCruz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.manageCruz.entity.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE p.id = ?1")
    Producto findById(int id);

    @Query("SELECT p FROM Producto p")
    List<Producto> findAllProd();
}
