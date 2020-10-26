package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.ServicioRepuesto;

@Named("Cotizacion")
@ViewScoped
public class CotizacionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ServicioRepuesto> servicioRepuesto = new ArrayList<ServicioRepuesto>();
	
	private List<Integer> checkServicioRepuesto = new ArrayList<Integer>();

	public List<ServicioRepuesto> getServicioRepuesto() {
		return servicioRepuesto;
	}

	public void setServicioRepuesto(List<ServicioRepuesto> servicioRepuesto) {
		this.servicioRepuesto = servicioRepuesto;
	}

	public List<Integer> getCheckServicioRepuesto() {
		return checkServicioRepuesto;
	}

	public void setCheckServicioRepuesto(List<Integer> checkServicioRepuesto) {
		this.checkServicioRepuesto = checkServicioRepuesto;
	}
	
	
}
