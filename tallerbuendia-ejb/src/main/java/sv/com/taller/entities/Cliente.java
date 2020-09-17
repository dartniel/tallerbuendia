package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idCliente;

	private String apellido;

	private String aseguradora;

	private String dui;

	@Temporal(TemporalType.DATE)
	private Date fecha_Nacimiento;

	private String lugar_trabajo;

	private String nit;

	private String nombre;

	private String telefono;

	private String telefono_trabajo;

	private String tipo_Seguro;

	//bi-directional many-to-many association to Automovil
	@ManyToMany(mappedBy="clientes")
	private List<Automovil> automovils;

	//bi-directional many-to-one association to AutomovilCliente
	@OneToMany(mappedBy="cliente")
	private List<AutomovilCliente> automovilClientes;

	public Cliente() {
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAseguradora() {
		return this.aseguradora;
	}

	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public Date getFecha_Nacimiento() {
		return this.fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(Date fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getLugar_trabajo() {
		return this.lugar_trabajo;
	}

	public void setLugar_trabajo(String lugar_trabajo) {
		this.lugar_trabajo = lugar_trabajo;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono_trabajo() {
		return this.telefono_trabajo;
	}

	public void setTelefono_trabajo(String telefono_trabajo) {
		this.telefono_trabajo = telefono_trabajo;
	}

	public String getTipo_Seguro() {
		return this.tipo_Seguro;
	}

	public void setTipo_Seguro(String tipo_Seguro) {
		this.tipo_Seguro = tipo_Seguro;
	}

	public List<Automovil> getAutomovils() {
		return this.automovils;
	}

	public void setAutomovils(List<Automovil> automovils) {
		this.automovils = automovils;
	}

	public List<AutomovilCliente> getAutomovilClientes() {
		return this.automovilClientes;
	}

	public void setAutomovilClientes(List<AutomovilCliente> automovilClientes) {
		this.automovilClientes = automovilClientes;
	}

	public AutomovilCliente addAutomovilCliente(AutomovilCliente automovilCliente) {
		getAutomovilClientes().add(automovilCliente);
		automovilCliente.setCliente(this);

		return automovilCliente;
	}

	public AutomovilCliente removeAutomovilCliente(AutomovilCliente automovilCliente) {
		getAutomovilClientes().remove(automovilCliente);
		automovilCliente.setCliente(null);

		return automovilCliente;
	}

}