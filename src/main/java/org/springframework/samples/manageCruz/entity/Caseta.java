
package org.springframework.samples.manageCruz.entity;

import javax.persistence.*;

import org.springframework.samples.manageCruz.entity.types.Calle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "caseta")
public class Caseta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "calle")
    @Enumerated(EnumType.STRING)
    private Calle calle;

    @Column(name = "numero")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    @JsonIgnoreProperties({"casetas", "casetasComercial"})
    private User propietario;
    
    @ManyToOne
    @JoinColumn(name = "comercial_id")
    @JsonIgnoreProperties({"casetas", "casetasComercial"})
    private User comercial;
    

    @Override
    public String toString() {
        return "Caseta{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
