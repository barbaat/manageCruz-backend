package org.springframework.samples.manageCruz.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "albaran")
public class Albaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private Date fecha = new Date();

    @Column(name = "no_cliente")
    private String numeroCliente;

    @Column(name = "vendedor")
    private String vendedor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User cliente;
    
    @OneToMany(mappedBy = "albaran")
    @JsonIgnoreProperties({ "producto", "albaran" })
    private List<DetalleAlbaran> detalles;    

    @Column(name = "total_bruto")
    private double totalBruto;

    @Column(name = "porcentaje_descuento")
    private int porcentajeDescuento;

    @Column(name = "importe_descuento")
    private double importeDescuento;

    @Column(name = "base_imponible")
    private double baseImponible;

    @Column(name = "porcentaje_iva")
    private int porcentajeIVA;

    @Column(name = "importe_iva")
    private double importeIVA;

    @Column(name = "porcentaje_rec")
    private int porcentajeRec;

    @Column(name = "importe_rec")
    private double importeRec;

    @Column(name = "total")
    private double total;

    @Column(name = "forma_pago")
    private String formaPago;

    @Override
    public String toString() {
        return "Albaran{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", numeroCliente='" + numeroCliente + '\'' +
                ", vendedor='" + vendedor + '\'' +
                ", totalBruto=" + totalBruto +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", importeDescuento=" + importeDescuento +
                ", baseImponible=" + baseImponible +
                ", porcentajeIVA=" + porcentajeIVA +
                ", importeIVA=" + importeIVA +
                ", porcentajeRec=" + porcentajeRec +
                ", importeRec=" + importeRec +
                ", total=" + total +
                ", formaPago='" + formaPago + '\'' +
                '}';
    }
}
