package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the automovil database table.
 * 
 */
@Entity
@NamedQuery(name="Automovil.findAll", query="SELECT a FROM Automovil a")
public class Automovil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAutomovil;

	private String chasis;

	private String color;

	private String estado_recibido;

	private String marca;

	private String modelo;

	private String observacion;

	private String placa;

	//bi-directional many-to-many association to Cliente
	@ManyToMany
	@JoinTable(
		name="automovil_cliente"
		, joinColumns={
			@JoinColumn(name="idAutomovil")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idCliente")
			}
		)
	private List<Cliente> clientes;

	//bi-directional many-to-one association to AutomovilCliente
	@OneToMany(mappedBy="automovil")
	private List<AutomovilCliente> automovilClientes;

	//bi-directional many-to-one association to InformacionReparacion
	@OneToMany(mappedBy="automovil")
	private List<InformacionReparacion> informacionReparacions;

	public Automovil() {
	}

	public int getIdAutomovil() {
		return this.idAutomovil;
	}

	public void setIdAutomovil(int idAutomovil) {
		this.idAutomovil = idAutomovil;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEstado_recibido() {
		return this.estado_recibido;
	}

	public void setEstado_recibido(String estado_recibido) {
		this.estado_recibido = estado_recibido;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<AutomovilCliente> getAutomovilClientes() {
		return this.automovilClientes;
	}

	public void setAutomovilClientes(List<AutomovilCliente> automovilClientes) {
		this.automovilClientes = automovilClientes;
	}

	public AutomovilCliente addAutomovilCliente(AutomovilCliente automovilCliente) {
		getAutomovilClientes().add(automovilCliente);
		automovilCliente.setAutomovil(this);

		return automovilCliente;
	}

	public AutomovilCliente removeAutomovilCliente(AutomovilCliente automovilCliente) {
		getAutomovilClientes().remove(automovilCliente);
		automovilCliente.setAutomovil(null);

		return automovilCliente;
	}

	public List<InformacionReparacion> getInformacionReparacions() {
		return this.informacionReparacions;
	}

	public void setInformacionReparacions(List<InformacionReparacion> informacionReparacions) {
		this.informacionReparacions = informacionReparacions;
	}

	public InformacionReparacion addInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().add(informacionReparacion);
		informacionReparacion.setAutomovil(this);

		return informacionReparacion;
	}

	public InformacionReparacion removeInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().remove(informacionReparacion);
		informacionReparacion.setAutomovil(null);

		return informacionReparacion;
	}

}