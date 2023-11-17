package org.springframework.samples.manageCruz.entity.types;

public enum Calle {
    ANTONIO_BIENVENIDA("Calle Antonio Bienvenida"),
    PEPE_HILLO("Calle Pepe Hillo"),
    PEPE_LUIS_VAZQUEZ("Calle Pepe Luis Vázquez"),
    CHICUELO("Calle Chicuelo"),
    BOMBITA("Calle Bombita"),
    COSTILLARES("Calle Costillares"),
    ESPARTERO("Calle Espartero"),
    GITANILLO_DE_TRIANA("Calle Gitanillo de Triana"),
    JOSELITO_EL_GALLO("Calle Joselito el Gallo"),
    JUAN_BELMONTE("Calle Juan Belmonte"),
    PASCUAL_MARQUEZ("Calle Pascual Márquez"),
    CURRO_ROMERO("Calle Curro Romero"),
    SANCHEZ_MEJIAS("Calle Ignacio Sánchez Mejías"),
    GOMEZ_ORTEGA("Calle Rafael Gómez Ortega"),
    MANOLO_VAZQUEZ("Calle Manolo Vázquez1");

    private final String nombre;

    Calle(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
