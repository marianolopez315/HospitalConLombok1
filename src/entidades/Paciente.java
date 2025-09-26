package entidades;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@ToString(of = {"nombre", "apellido", "dni", "telefono", "tipoSangre"})
public class Paciente extends Persona implements Serializable {

    @NonNull
    private final HistoriaClinica historiaClinica;

    @NonNull
    private final String telefono;

    @NonNull
    private final String direccion;

    @Setter
    private Hospital hospital;

    private final List<Cita> citas = new ArrayList<>();

    public Paciente(String nombre, String apellido, String dni,
                    LocalDate fechaNacimiento, TipoSangre tipoSangre,
                    String telefono, String direccion) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        this.telefono = validarString(telefono, "El teléfono no puede ser nulo ni vacío");
        this.direccion = validarString(direccion, "La dirección no puede ser nula ni vacía");
        this.historiaClinica = new HistoriaClinica(this);
    }

    // Setter personalizado con lógica bidireccional
    public void setHospital(Hospital hospital) {
        if (this.hospital != hospital) {
            if (this.hospital != null) {
                this.hospital.getInternalPacientes().remove(this);
            }
            this.hospital = hospital;
            if (hospital != null) {
                hospital.getInternalPacientes().add(this);
            }
        }
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
        return "Paciente{nombre='" + nombre +
                "', apellido='" + apellido +
                "', dni='" + dni +
                "', telefono='" + telefono +
                "', tipoSangre=" + tipoSangre.getDescripcion() + "}";
    }

    private String validarString(String valor, String mensajeError) {
        Objects.requireNonNull(valor, mensajeError);
        if (valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }
}
