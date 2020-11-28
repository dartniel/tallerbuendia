package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Solicitud;
import sv.com.taller.entities.Empleado;
import sv.com.taller.entities.Proveedor;
import sv.com.taller.repositories.SolicitudRepository;

@Named
@ViewScoped
public class SolicitudController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Solicitud solicitud;
	
	private List<Solicitud> mostrarSolicitud;


	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	@PostConstruct
	public void init() {
		this.solicitud = new Solicitud();
		this.solicitud.setProveedor(new Proveedor());
		this.solicitud.setEmpleado(new Empleado());
	
	}

	@EJB
	private SolicitudRepository solicitudRepository;



	public void agregarSolicitud() {
	solicitudRepository.agregar(solicitud);
	this.solicitud.setFecha(null);
	this.solicitud.setDescripcion("");
	this.solicitud.setCantidad(0);
	}
	public List<Solicitud> getMostrarSolicitud() {
		this.mostrarSolicitud= solicitudRepository.mostrar();
		return mostrarSolicitud;
	}



}
