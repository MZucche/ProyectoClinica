package model;

public class EstadoCancelarcita implements EstadoCita {
	private CitaMedica cita;

	public EstadoCancelarcita(CitaMedica citaMedica) {
		// TODO Auto-generated constructor stub
		cita = citaMedica;
	}

	@Override
	public String programada() {
		// TODO Auto-generated method stub
		return "La cita medica ya esta cancelada";

	}

	@Override
	public String finalizada() {
		// TODO Auto-generated method stub
		return "La cita medica ya esta cancelada.";

	}

	@Override
	public String cancelada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getCancelada());
		return "Se ha cancelado la cita medica.";

	}

}
