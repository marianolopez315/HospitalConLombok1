package entidades;

import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@ToString(of = {"numero", "tipo"})
public class Sala implements Serializable {

    @NonNull
    private final String numero;

    @NonNull
    private final String tipo;

    @NonNull
    private final Departamento departamento;

    private final List<Cita> citas = new ArrayList<>();

    public Sala(String numero, String tipo, Departamento departamento) {
        this.numero = validarString(numero, "El número de sala no puede ser nulo ni vacío");
        this.tipo = validarString(tipo, "El tipo de sala no puede ser nulo ni vacío");
        this.departamento = Objects.requireNonNull(departamento, "El departamento no puede ser nulo");
    }

    public void addCita(Cita cita) {
        citas.add(cita);
    }

    // Getter personalizado que devuelve copia inmutable
    public List<Cita> getCitas() {
        return Collections.unmodifiableList(new ArrayList<>(citas));
    }

    // Método personalizado para toString específico del negocio
    public String toBusinessString() {
        return "Sala{numero='" + numero +
                "', tipo='" + tipo +
                "', departamento=" + departamento.getNombre() + "}";
    }

    private String validarString(String valor, String mensajeError) {
        Objects.requireNonNull(valor, mensajeError);
        if (valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }
}
