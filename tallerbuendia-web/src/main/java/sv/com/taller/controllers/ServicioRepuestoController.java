package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.Servicio;
import sv.com.taller.entities.ServicioRepuesto;
import sv.com.taller.repositories.ServicioRepuestoRepository;

@Named("ServicioRepuesto")
@ViewScoped
public class ServicioRepuestoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Servicio> servicio;

	private List<ServicioRepuesto> repuesto;

	private DetalleChequeo detalleChequeo;

	private String nombreServicio;
	
	private List<ServicioRepuesto> servicioRepuesto = new ArrayList<ServicioRepuesto>();

	private List<String> checkServicioRepuesto = new ArrayList<String>();

	public List<ServicioRepuesto> getServicioRepuesto() {
		return servicioRepuesto;
	}

	public void setServicioRepuesto(List<ServicioRepuesto> servicioRepuesto) {
		this.servicioRepuesto = servicioRepuesto;
	}

	public List<String> getCheckServicioRepuesto() {
		return checkServicioRepuesto;
	}

	public void setCheckServicioRepuesto(List<String> checkServicioRepuesto) {
		this.checkServicioRepuesto = checkServicioRepuesto;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public List<ServicioRepuesto> getRepuesto() {
		return repuesto;
	}

	public DetalleChequeo getDetalleChequeo() {
		return detalleChequeo;
	}

	public void setDetalleChequeo(DetalleChequeo detalleChequeo) {
		this.detalleChequeo = detalleChequeo;
	}

	@PostConstruct
	public void init() {
		this.detalleChequeo = new DetalleChequeo();
		this.detalleChequeo.setChequeo(new Chequeo());
		this.detalleChequeo.setServicioRepuesto(new ServicioRepuesto());
	}

	@EJB
	private ServicioRepuestoRepository servicioRepuestoRepository;

	public List<Servicio> getServicio() {
		servicio = servicioRepuestoRepository.mostrarServcio();
		return servicio;
	}

	public void mostrarRepuesto() {
		repuesto = servicioRepuestoRepository.mostrarRepuesto(nombreServicio);
	}
	
	public void agregarServicioRepuesto() {
		servicioRepuestoRepository.agregarDetalleChequeo(checkServicioRepuesto);
	}

}
