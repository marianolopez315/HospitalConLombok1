package entidades;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //@RequiredArgsConstructor, Lombok genera automáticamente el constructor que recibe todos los campos final.

public enum TipoSangre {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_POSITIVI("O+"),
    O_NEGATIVO("O-");

    private final String descripcion;

}
