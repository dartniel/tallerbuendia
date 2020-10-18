package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.DetalleCarro;
import sv.com.taller.repositories.DetalleCarroRepository;

@Named
@ViewScoped
public class DetalleCarroController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DetalleCarro> mostrarMarca;
	private List<DetalleCarro> mostrarModelo;
	private DetalleCarro detalleCarro;
	


	public DetalleCarro getDetalleCarro() {
		return detalleCarro;
	}


	public void setDetalleCarro(DetalleCarro detalleCarro) {
		this.detalleCarro = detalleCarro;
	}


	@PostConstruct
	public void init() {
		detalleCarro = new DetalleCarro();
	}
	
	@EJB
	private DetalleCarroRepository detalleCarroRepository;
	

	public List<DetalleCarro> getMostrarMarca() {
		this.mostrarMarca = detalleCarroRepository.mostrarMarca();
		return mostrarMarca;
	}
	public void mostrarModelo() {
		mostrarModelo = detalleCarroRepository.mostrarModelo(detalleCarro);
	}
	public List<DetalleCarro> getMostrarModelo() {
		return mostrarModelo;
	}
	
	

}
