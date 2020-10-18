package sv.com.taller.controllers;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sv.com.taller.entities.Cliente;
import sv.com.taller.entities.DetalleCarro;
import sv.com.taller.repositories.ClienteRepository;
import sv.com.taller.entities.Automovil;
import sv.com.taller.repositories.AutomovilRepository;


@Named
@SessionScoped
public class ClienteController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Cliente cliente;

	private Automovil automovil;
	
	private Cliente accionCliente;
	
	private List<Cliente> mostrarCliente;
	
	private List<Automovil> mostrarAutomovil;
	
	private boolean enable = true;
	private String typeButton = "hidden";


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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getTypeButton() {
		return typeButton;
	}

	public void setTypeButton(String typeButton) {
		this.typeButton = typeButton;
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
		this.setEnable(true);
		this.setTypeButton("hidden");
	}

	public void eliminarCliente() {
		clienteRepository.eliminar(accionCliente);
	}

	public List<Cliente> getMostrarCliente() {
		this.mostrarCliente = clienteRepository.mostrar();
		return mostrarCliente;
	}
	
	public List<Automovil> getMostrarAutomovil() {
		mostrarAutomovil = automovilRepository.mostrarAutomovil(this.accionCliente.getIdCliente());
		return mostrarAutomovil;
	}
	
	public String loadCliente() {
		return "editClienteAutomovil";
	}

	public void enableEdit (){
		if(this.enable == true) {
			this.setEnable(false);
			this.setTypeButton("submit");
		}else {
			this.setEnable(true);
			this.setTypeButton("hidden");
		}
	}
}
