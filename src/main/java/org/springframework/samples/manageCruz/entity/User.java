package org.springframework.samples.manageCruz.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;
import org.springframework.samples.manageCruz.entity.types.City;
import org.springframework.samples.manageCruz.entity.types.RolUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.samples.manageCruz.entity.types.Gender;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true)
    @ColumnTransformer(read = "username", write = "LOWER(?)")
    private String username;

    @Column(name = "name")
    protected String name;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "rol_user")
    @Enumerated(EnumType.STRING)
    private RolUser rolUser;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "dni")
    private String dni;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "propietario")
    @JsonIgnoreProperties({"propietario", "comercial"})
    private List<Caseta> casetas;
    
    @OneToMany(mappedBy = "comercial")
    @JsonIgnoreProperties({"propietario", "comercial"})
    private List<Caseta> casetasComercial;
    

    public String getCityString() {
        return (city != null) ? city.getNombre() : "";
    }

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setUsername(username);
        userDTO.setName(name);
        userDTO.setLastName(lastName);
        userDTO.setPassword(password);
        userDTO.setEmail(email);
        userDTO.setRolUser(rolUser);
        userDTO.setCity(city);
        userDTO.setCityString(getCityString());
        userDTO.setTelephone(telephone);
        userDTO.setGender(gender);
        userDTO.setAvatar(avatar);
        userDTO.setDni(dni);
        userDTO.setCasetas(casetas);
        userDTO.setCasetasComercial(casetasComercial);
        return userDTO;
    }

}
