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
import sv.com.taller.repositories.DetalleChequeoRepository;
import sv.com.taller.repositories.ServicioRepuestoRepository;

@Named("ServicioRepuesto")
@ViewScoped
public class ServicioRepuestoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Servicio> servicio;

	private List<ServicioRepuesto> repuesto;

	private DetalleChequeo detalleChequeo;

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

	@EJB
	private DetalleChequeoRepository detalleChequeoRepository;

	public List<Servicio> getServicio() {
		servicio = servicioRepuestoRepository.mostrarServcio();
		return servicio;
	}

	public void mostrarRepuesto() {
		repuesto = servicioRepuestoRepository
				.mostrarRepuesto(detalleChequeo.getServicioRepuesto().getServicio().getNombreServicio());
	}

}
