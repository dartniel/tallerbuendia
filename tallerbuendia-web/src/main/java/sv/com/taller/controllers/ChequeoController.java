package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.Cliente;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.repositories.ChequeoRepository;
import sv.com.taller.repositories.DetalleChequeoRepository;

@Named("Chequeo")
@ViewScoped
public class ChequeoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Chequeo> mostrarChequeo;
	
	private List<DetalleChequeo> mostrarDetalleChequeo;
	
	@EJB
	private ChequeoRepository chequeoRepository;
	
	@EJB
	private DetalleChequeoRepository detalleChequeoRepository;
	
	public List<Chequeo> getMostrarChequeo() {
		this.mostrarChequeo = chequeoRepository.mostrar();
		return mostrarChequeo;
	}

	public List<DetalleChequeo> getMostrarDetalleChequeo(Chequeo accionChequeo) {
		this.mostrarDetalleChequeo = detalleChequeoRepository.mostrar(accionChequeo);
		return mostrarDetalleChequeo;
	}
	
	public void cambioExistencia(DetalleChequeo detalleChequeo) {
		detalleChequeoRepository.actualizarExistencia(detalleChequeo);
	}
}
