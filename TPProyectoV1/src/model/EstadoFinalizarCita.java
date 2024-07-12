package model;

public class EstadoFinalizarCita implements EstadoCita {
	private CitaMedica cita;

	public EstadoFinalizarCita(CitaMedica citaMedica) {
		// TODO Auto-generated constructor stub
		this.cita = citaMedica;
	}

	@Override
	public String programada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getFinalizada());
		return "Se ha finalizado la cita medica.";

	}

	@Override
	public String finalizada() {
		// TODO Auto-generated method stub
		return "La cita medica ya ha sido finalizada.";

	}

	@Override
	public String cancelada() {
		// TODO Auto-generated method stub
		return "La cita medica ya ha sido finalizada.";
	}

}
