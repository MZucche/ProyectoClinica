package model;

public class Factura {
	private Double total;
	private boolean estadoDePago;
	private Double descuento; 
	
	public Factura() {
	}
	public void aplicarDescuento(Paciente paciente) {}
	
	public void actualizarEstado() {}
	
	public void calcularTotal() {}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public boolean isEstadoDePago() {
		return estadoDePago;
	}
	public void setEstadoDePago(boolean estadoDePago) {
		this.estadoDePago = estadoDePago;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	
	
}
