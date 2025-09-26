package entidades;

import lombok.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@ToString
public class Matricula implements Serializable {

    @NonNull
    private final String numero;

    public Matricula(String numero) {
        this.numero = validarMatricula(numero);
    }

    private String validarMatricula(String numero) {
        Objects.requireNonNull(numero, "El número de matrícula no puede ser nulo");
        if (!numero.matches("MP-\\d{4,6}")) {
            throw new IllegalArgumentException("Formato de matrícula inválido. Debe ser como MP-12345");
        }
        return numero;
    }
}
