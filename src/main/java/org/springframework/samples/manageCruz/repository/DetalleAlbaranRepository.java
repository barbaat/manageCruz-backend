package org.springframework.samples.manageCruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.manageCruz.entity.DetalleAlbaran;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleAlbaranRepository extends JpaRepository<DetalleAlbaran, Integer> {

}
