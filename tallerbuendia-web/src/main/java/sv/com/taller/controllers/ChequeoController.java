package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.Cliente;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.repositories.ChequeoRepository;
import sv.com.taller.repositories.DetalleChequeoRepository;

@Named("Chequeo")
@RequestScoped
public class ChequeoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Chequeo chequeo;
	private List<Chequeo> mostrarChequeo;
	private List<Chequeo> mostrar;
	private List<DetalleChequeo> mostrarDetalleChequeo;
	
	public Chequeo getChequeo() {
		return chequeo;
	}

	public void setChequeo(Chequeo chequeo) {
		this.chequeo = chequeo;
	}

	@PostConstruct
	public void init() {
		this.chequeo = new Chequeo();
		this.chequeo.setCliente(new Cliente());
	}
	
	@EJB
	private ChequeoRepository chequeoRepository;
	
	@EJB
	private DetalleChequeoRepository detalleChequeoRepository;
	
	public String agregarChequeo() {
		chequeoRepository.agregarChequeo(chequeo);
		return "cotizacion";
	}
	
	public List<Chequeo> getMostrarChequeo() {
		this.mostrarChequeo = chequeoRepository.mostrar();
		return mostrarChequeo;
	}

	public List<DetalleChequeo> getMostrarDetalleChequeo(Chequeo accionChequeo) {
		this.mostrarDetalleChequeo = detalleChequeoRepository.mostrar(accionChequeo);
		return mostrarDetalleChequeo;
	}
	
	public void cambioExistencia(DetalleChequeo detalleChequeo) {
		detalleChequeo.setEstado(0);
		detalleChequeoRepository.actualizarExistencia(detalleChequeo);
	}
	
	public void eliminarTarjeta() {
		chequeoRepository.modificar(chequeo);
	}

	public List<Chequeo> getMostrar() {
		this.mostrar = chequeoRepository.mostrarChequeo();
		return mostrar;
	}
}
