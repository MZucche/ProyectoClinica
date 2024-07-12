package model;

public class EstadoProgramarCita implements EstadoCita {
	CitaMedica cita;
	public EstadoProgramarCita(CitaMedica cita ) {
		this.cita = cita;
	}
	@Override
	public String programada() {
		// TODO Auto-generated method stub
		return "La cita medica ya fue programada.";

	}

	@Override
	public String finalizada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getFinalizada());;
		return "Se ha finalizado la cita medica.";
		
	}

	@Override
	public String cancelada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getCancelada());;
		return "Se ha cancelado la cita medica.";

	}

}
