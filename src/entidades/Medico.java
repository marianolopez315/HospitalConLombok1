package entidades;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@ToString(of = {"nombre", "apellido", "especialidad", "matricula"})
public class Medico extends Persona implements Serializable {

    @NonNull
    private final Matricula matricula;

    @NonNull
    private final EspecialidadMedica especialidad;

    @Setter
    private Departamento departamento;

    private final List<Cita> citas = new ArrayList<>();

    public Medico(String nombre, String apellido, String dni,
                  LocalDate fechaNacimiento, TipoSangre tipoSangre,
                  String numeroMatricula, EspecialidadMedica especialidad) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        this.matricula = new Matricula(numeroMatricula);
        this.especialidad = Objects.requireNonNull(especialidad,
                "La especialidad no puede ser nula");
    }

    // Setter personalizado (aunque en este caso es simple, lo mantengo por consistencia)
    public void setDepartamento(Departamento departamento) {
        if (this.departamento != departamento) {
            this.departamento = departamento;
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
        return "Medico{nombre='" + nombre +
                "', apellido='" + apellido +
                "', especialidad=" + especialidad.getDescripcion() +
                ", matricula=" + matricula.getNumero() + "}";
    }
}