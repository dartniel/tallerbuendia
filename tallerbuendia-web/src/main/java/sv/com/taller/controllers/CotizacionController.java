package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.ServicioRepuesto;
import sv.com.taller.repositories.ChequeoRepository;
import sv.com.taller.repositories.CotizacionDao;
import sv.com.taller.repositories.ServicioRepuestoRepository;

@Named("Cotizacion")
@RequestScoped
public class CotizacionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DetalleChequeo detalles;
	private DetalleChequeo accionDetalles;
	private String diagnostico;
	private List<DetalleChequeo> mostrarDetalles;
	private Double totalFinal;

	public DetalleChequeo getDetalles() {
		return detalles;
	}

	public void setDetalles(DetalleChequeo detalles) {
		this.detalles = detalles;
	}

	public DetalleChequeo getAccionDetalles() {
		return accionDetalles;
	}

	public void setAccionDetalles(DetalleChequeo accionDetalles) {
		this.accionDetalles = accionDetalles;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public List<DetalleChequeo> getMostrarDetalles() {
		return mostrarDetalles;
	}

	public Double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(Double totalFinal) {
		this.totalFinal = totalFinal;
	}

	@PostConstruct
	public void init() {
		this.detalles = new DetalleChequeo();
		this.detalles.setChequeo(new Chequeo());
		this.detalles.setServicioRepuesto(new ServicioRepuesto());
		
	}
	
	@EJB
	private ServicioRepuestoRepository servicioRepuestoRepository;
	
	@EJB
	private CotizacionDao cotizacionDao;
	
	@EJB
	private ChequeoRepository chequeoRepository;
	
	public void agregar() {
		ServicioRepuesto obtenerServRep = null;
		Chequeo obtenerChequeo = null;
		// Obtenemos todo el registro de servicioRepuesto que seleccionamos en el modal
		obtenerServRep = servicioRepuestoRepository.buscar(detalles);
		// Obtenemos todo el registro del chequeo buscandolo por medio del diagnostico
		obtenerChequeo = chequeoRepository.buscar(diagnostico);
		// Seteamos los paramentros de detalles
		detalles.setServicioRepuesto(obtenerServRep);
		detalles.setChequeo(obtenerChequeo);
		// Guardamos
		cotizacionDao.cotizar(detalles);
		// Mostramos los detalles de la cotizacion que se hizo
		mostrarDetalles = cotizacionDao.buscar(detalles);
		Double sumandoPrecios = cotizacionDao.totalCotizacion(diagnostico);
		this.setTotalFinal(sumandoPrecios);
		this.detalles.setServicioRepuesto(new ServicioRepuesto());
		this.detalles.setCantidad(0);
	}
	
	
	// Se elimina cotizacion completa
	public String cancelarCotizacion() {
		cotizacionDao.cancelarCotizacion(diagnostico);
		return "chequeo?faces-redirect=true";
	}
}
