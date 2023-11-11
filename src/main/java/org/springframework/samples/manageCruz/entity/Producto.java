
package org.springframework.samples.manageCruz.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @Column(name = "precio")
    private double precio;

    @OneToMany(mappedBy = "albaran", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({ "producto", "albaran" })
    private List<DetalleAlbaran> detalles;

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", referencia='" + referencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", detalles=" + detalles +
                ", precio=" + precio +
                '}';
    }
}
