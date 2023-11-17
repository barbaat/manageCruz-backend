package org.springframework.samples.manageCruz.entity;

import org.springframework.samples.manageCruz.entity.types.RolUser;

import java.util.List;

import org.springframework.samples.manageCruz.entity.types.City;
import org.springframework.samples.manageCruz.entity.types.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String username;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private RolUser rolUser;
    private City city;
    private String telephone;
    private Gender gender;
    private String avatar;
    private String cityString;
    private String dni;
    private List<Caseta> casetas;
    private List<Caseta> casetasComercial;
}
