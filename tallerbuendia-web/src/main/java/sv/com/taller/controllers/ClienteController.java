package sv.com.taller.controllers;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Cliente;
import sv.com.taller.entities.DetalleCarro;
import sv.com.taller.repositories.ClienteRepository;
import sv.com.taller.entities.Automovil;
import sv.com.taller.repositories.AutomovilRepository;


@Named
@ViewScoped
public class ClienteController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Cliente cliente;

	private Automovil automovil;
	
	private Cliente accionCliente;


	public Cliente getAccionCliente() {
		return accionCliente;
	}

	public void setAccionCliente(Cliente accionCliente) {
		this.accionCliente = accionCliente;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	private List<Cliente> mostrarCliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		this.automovil = new Automovil();
		this.automovil.setCliente(new Cliente());
		this.automovil.setDetalleCarro(new DetalleCarro());
	}

	@EJB
	private ClienteRepository clienteRepository;
	@EJB
	private AutomovilRepository automovilRepository;

	public void agregarCliente() {
		clienteRepository.agregarCliente(cliente);
		automovilRepository.agregarAutomovil(automovil, cliente);
		this.cliente.setIdCliente("");
		this.cliente.setApellido("");
		this.cliente.setAseguradora("");
		this.cliente.setDui("");
		this.cliente.setFechaNacimiento(null);
		this.cliente.setLugarTrabajo("");
		this.cliente.setTelefonoTrabajo("");
		this.cliente.setNit("");
		this.cliente.setNombre("");
		this.cliente.setTelefono("");
		this.automovil.setChasis("");
		this.automovil.setColor("");
		this.automovil.setPlaca("");
		this.automovil.setObservacion("");
		this.automovil.setDetalleCarro(null);
		
	
	}

	public void modificarCliente() {
		clienteRepository.modificar(accionCliente);
	}

	public void eliminarCliente() {
		clienteRepository.eliminar(accionCliente);
	}

	public List<Cliente> getMostrarCliente() {
		this.mostrarCliente = clienteRepository.mostrar();
		return mostrarCliente;
	}

}
