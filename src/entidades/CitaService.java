package entidades;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

interface CitaService {
    Cita programarCita(Paciente var1, Medico var2, Sala var3, LocalDateTime var4, BigDecimal var5) throws CitaException;

    List<Cita> getCitasPorPaciente(Paciente var1);

    List<Cita> getCitasPorMedico(Medico var1);

    List<Cita> getCitasPorSala(Sala var1);

    void guardarCitas(String var1) throws IOException;

    void cargarCitas(String var1, Map<String, Paciente> var2, Map<String, Medico> var3, Map<String, Sala> var4) throws IOException, ClassNotFoundException, CitaException;
}
