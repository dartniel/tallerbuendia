package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Repuesto;
import sv.com.taller.repositories.RepuestoRepository;

@Named
@ViewScoped
public class RepuestoController implements Serializable{

	private static final long serialVersionUID = 1L;

	private Repuesto repuesto;
	
	private Repuesto accionRepuesto;
	
	private int restarCantidad;
	

	public int getRestarCantidad() {
		return restarCantidad;
	}

	public void setRestarCantidad(int restarCantidad) {
		this.restarCantidad = restarCantidad;
	}

	public Repuesto getAccionRepuesto() {
		return accionRepuesto;
	}

	public void setAccionRepuesto(Repuesto accionRepuesto) {
		this.accionRepuesto = accionRepuesto;
	}

	private List<Repuesto> mostrarRepuesto;

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}
	
	@PostConstruct
	public void init() {
		this.repuesto = new Repuesto();
		this.accionRepuesto = new Repuesto();
	}

	@EJB
	private RepuestoRepository repuestoRepository;
	
	public void agregarRepuesto() {
		repuestoRepository.agregar(repuesto);
		this.repuesto.setIdRepuesto(0);
		this.repuesto.setNombre("");
		this.repuesto.setMarca("");
		this.repuesto.setCantidad(0);
		this.repuesto.setCosto(0.0);
		this.repuesto.setPrecio_venta(0.0);
		this.repuesto.setFecha_adquisicion(null);
		this.repuesto.setDisponible(0);
	}
	
	public void modificarRepuesto() {
		repuestoRepository.modificar(accionRepuesto);
	}
	
	public void eliminarRepuesto() {
		repuestoRepository.eliminar(accionRepuesto);
	}

	public List<Repuesto> getMostrarRepuesto() {
		this.mostrarRepuesto = repuestoRepository.mostrar();
		return mostrarRepuesto;
	}
	public void restaDeCantidad() {
		repuestoRepository.restarCantidad(accionRepuesto, restarCantidad);
	}
	
	
}
