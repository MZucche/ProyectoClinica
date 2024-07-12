package model;
import java.time.LocalDateTime;

public class CitaMedica {

	private Paciente paciente;
	private Medico medico;
	private Procedimiento Procedimiento;
	private String diagnostico;
	private Tratamiento tratamiento;
	private LocalDateTime fechaYHora;
	private EstadoCita estadoCita;
	private final EstadoCita programada;
	private final EstadoCita finalizada;
	private final EstadoCita cancelada;
	private Especialidad motivo;
	
	
	public CitaMedica(Paciente paciente, Medico medico, Procedimiento procedimiento, LocalDateTime fechaYHora,
			Especialidad motivo) {
		this.paciente = paciente;
		this.medico = medico;
		this.Procedimiento = procedimiento;
		this.fechaYHora = fechaYHora;
		this.motivo = motivo;
		this.programada = new EstadoProgramarCita(this);
		this.finalizada = new EstadoFinalizarCita(this);
		this.cancelada = new EstadoCancelarcita(this);
		this.estadoCita = programada;
	}
	public void setEstadoCita(EstadoCita estadoCita) {
		this.estadoCita = estadoCita;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public Procedimiento getProcedimiento() {
		return Procedimiento;
	}
	
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Tratamiento getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public EstadoCita getEstadoCita() {
		return estadoCita;
	}
	
	public String programarCita() {
		return estadoCita.programada();
	} 
	
	public String finalizarCita() {
		return estadoCita.finalizada();
	}
	
	public String cancelarCita() {
		return estadoCita.cancelada();
	}
	
	public Especialidad getMotivo() {
		return motivo;
	}
	public void setMotivo(Especialidad motivo) {
		this.motivo = motivo;
	}
	public EstadoCita getFinalizada() {
		return finalizada;
	}
	public EstadoCita getCancelada() {
		return cancelada;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		Procedimiento = procedimiento;
	}
	@Override
	public String toString() {
		return "CitaMedica [paciente=" + paciente + ", medico=" + medico + ", Procedimiento=" + Procedimiento
				+ ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", fechaYHora=" + fechaYHora
				+ ", motivo=" + motivo + "]";
	}
	
	
}
