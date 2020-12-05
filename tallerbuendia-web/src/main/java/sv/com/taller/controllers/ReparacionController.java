package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Automovil;
import sv.com.taller.entities.BitacoraReparacion;

@Named("Reparacion")
@ViewScoped
public class ReparacionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BitacoraReparacion reparacion;
	private List<BitacoraReparacion> listBitacora;

	public BitacoraReparacion getReparacion() {
		return reparacion;
	}

	public void setReparacion(BitacoraReparacion reparacion) {
		this.reparacion = reparacion;
	}

	public List<BitacoraReparacion> getListBitacora() {
		return listBitacora;
	}

	@PostConstruct
	public void init() {
		reparacion = new BitacoraReparacion();
	}
	
	public void listar() {
		reparacion.setMecanico("Mario Campos");
		System.out.println(reparacion);
	}
}
