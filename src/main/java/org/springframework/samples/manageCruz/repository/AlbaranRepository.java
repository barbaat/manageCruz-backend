package org.springframework.samples.manageCruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.manageCruz.entity.Albaran;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbaranRepository extends JpaRepository<Albaran, Integer> {

    @Query("SELECT a FROM Albaran a WHERE a.id = ?1")
    Albaran findById(int id);
}
