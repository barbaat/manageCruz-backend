package org.springframework.samples.manageCruz.entity;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

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

    @Column(name = "vendedor")
    private String vendedor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User cliente;
    
    @OneToMany(mappedBy = "albaran")
    @JsonIgnoreProperties({ "producto", "albaran" })
    private List<DetalleAlbaran> detalles;    

    @Column(name = "total")
    private double total;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "sign")
    @Length(max = 100000)
    private String firma;

    @Column(name = "prep_y_conf")
    private boolean preparadoYConfirmado;

    @Column(name = "tipo_instalacion")
    private String tipoInstalacion;

    public double getTotal() {
        double total = 0;
        if (detalles == null) return total;
        for (DetalleAlbaran detalle : detalles) {
            total += detalle.getImporte();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return "Albaran{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", vendedor='" + vendedor + '\'' +
                ", total=" + getTotal() +
                ", formaPago='" + formaPago + '\'' +
                ", firma='" + firma + '\'' +
                ", preparadoYConfirmado=" + preparadoYConfirmado +
                ", tipoInstalacion='" + tipoInstalacion + '\'' +
                '}';
    }
}
