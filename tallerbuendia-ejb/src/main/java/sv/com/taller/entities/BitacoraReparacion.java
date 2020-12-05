package sv.com.taller.entities;

import java.util.Date;

public class BitacoraReparacion {
	
	private String mecanico;
	private Date fecha;
	private String descripcion;
	
	public String getMecanico() {
		return mecanico;
	}
	
	public void setMecanico(String mecanico) {
		this.mecanico = mecanico;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
