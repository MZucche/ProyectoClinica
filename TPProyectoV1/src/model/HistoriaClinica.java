package model;

import java.util.ArrayList;

public class HistoriaClinica {
	private ArrayList<CitaMedica> historiaClinica;

	public HistoriaClinica() {
		ArrayList<CitaMedica> historiaClinica = new ArrayList<CitaMedica>();
	}

	public ArrayList<CitaMedica> getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(ArrayList<CitaMedica> historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

	@Override
	public String toString() {
		return "HistoriaClinica [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
