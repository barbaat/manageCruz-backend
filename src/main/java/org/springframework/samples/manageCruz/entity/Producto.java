
package org.springframework.samples.manageCruz.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "albaran", cascade = CascadeType.ALL)
    private List<DetalleAlbaran> detalles;

}
