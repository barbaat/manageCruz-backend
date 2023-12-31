package org.springframework.samples.manageCruz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "detalle_albaran")
public class DetalleAlbaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "albaran_id")
    private Albaran albaran;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "unidades")
    private int unidades;

    public String getNombreProducto() {
        return producto.getNombre();
    }

    public double getPrecio() {
        return producto.getPrecio();
    }

    public double getImporte() {
        return getPrecio() * unidades;
    }

    @Override
    public String toString() {
        return "DetalleAlbaran{" +
                "id=" + id +
                ", albaran=" + albaran +
                ", producto=" + producto +
                ", unidades=" + unidades +
                ", precio=" + getPrecio() +
                ", importe=" + getImporte() +
                ", nombreProducto='" + getNombreProducto() +
                '}';
    }
}
