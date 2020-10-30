package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.Cliente;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.Servicio;
import sv.com.taller.entities.ServicioRepuesto;
import sv.com.taller.repositories.ChequeoRepository;
import sv.com.taller.repositories.DetalleChequeoRepository;
import sv.com.taller.repositories.ServicioRepuestoRepository;

@Named("Cotizacion")
@SessionScoped
public class CotizacionController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Servicio> servicio;

	private List<ServicioRepuesto> repuesto;

	private DetalleChequeo detalleChequeo;
	
	private String nombreServicio;
	
	private Chequeo chequeo;
	
	private Chequeo accionChequeo;

	public List<ServicioRepuesto> getRepuesto() {
		return repuesto;
	}

	public DetalleChequeo getDetalleChequeo() {
		return detalleChequeo;
	}

	public void setDetalleChequeo(DetalleChequeo detalleChequeo) {
		this.detalleChequeo = detalleChequeo;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public Chequeo getChequeo() {
		return chequeo;
	}

	public void setChequeo(Chequeo chequeo) {
		this.chequeo = chequeo;
	}

	public Chequeo getAccionChequeo() {
		return accionChequeo;
	}

	public void setAccionChequeo(Chequeo accionChequeo) {
		this.accionChequeo = accionChequeo;
	}

	@PostConstruct
	public void init() {
		this.detalleChequeo = new DetalleChequeo();
		this.detalleChequeo.setChequeo(new Chequeo());
		this.detalleChequeo.setServicioRepuesto(new ServicioRepuesto());
		this.chequeo = new Chequeo();
		this.chequeo.setCliente(new Cliente());
		this.accionChequeo = new Chequeo();
		this.accionChequeo.setCliente(new Cliente());
	}
	
	@EJB
	private ServicioRepuestoRepository servicioRepuestoRepository;

	@EJB
	private DetalleChequeoRepository detalleChequeoRepository;
	
	@EJB
	private ChequeoRepository chequeoRepository;

	public List<Servicio> getServicio() {
		servicio = servicioRepuestoRepository.mostrarServcio();
		return servicio;
	}

	public void mostrarRepuesto() {
		repuesto = servicioRepuestoRepository.mostrarRepuesto(nombreServicio);
	}

	public void agregar() {
		this.accionChequeo.setDiagnostico(this.chequeo.getDiagnostico());
		System.out.println(accionChequeo.getDiagnostico());
		detalleChequeoRepository.cotizacion(detalleChequeo,accionChequeo.getDiagnostico());
	}
	
	public String agregarChequeo() {
		chequeoRepository.agregarChequeo(chequeo);
		return "cotizacion";
	}
}
