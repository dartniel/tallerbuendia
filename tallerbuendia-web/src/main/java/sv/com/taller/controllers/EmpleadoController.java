package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Empleado;
import sv.com.taller.repositories.EmpleadoRepository;

@Named
@ViewScoped
public class EmpleadoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Empleado> mostrarEmpleados;
	
	private Empleado empleado;


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@PostConstruct
	public void init() {
		empleado = new Empleado();
	}
	
	@EJB
	private EmpleadoRepository empleadoRepository;
	

	public List<Empleado> getMostrarEmpleados() {
		this.mostrarEmpleados = empleadoRepository.mostrarEmpleado();
		return mostrarEmpleados;
	}

}