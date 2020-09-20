package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.repositories.ChequeoRepository;

@Named("Chequeo")
@ViewScoped
public class ChequeoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Chequeo> mostrarChequeo;

	
	@EJB
	private ChequeoRepository chequeoRepository;
	
	public List<Chequeo> getMostrarChequeo() {
		this.mostrarChequeo = chequeoRepository.mostrar();
		return mostrarChequeo;
	}
	
	
}
