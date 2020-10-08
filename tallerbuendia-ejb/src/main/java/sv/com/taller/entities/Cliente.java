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
	
	public Cliente() {}
	public Cliente(Cliente cliente) {}
	public Cliente(String idCliente, String apellido, String aseguradora,String tipoSeguro,String dui, Date fechaNacimiento, String lugarTrabajo, String telefonoTrabajo,
			String nit, String nombre, String telefono, String fechaRegistro) {
		this.idCliente = idCliente;
		this.apellido = apellido;
		this.aseguradora = aseguradora;
		this.tipoSeguro = tipoSeguro;
		this.dui = dui;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarTrabajo = lugarTrabajo;
		this.telefonoTrabajo = telefonoTrabajo;
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
		
	}

	@Id
	@Column(name="ID_CLIENTE")
	private String idCliente;

	private String apellido;

	private String aseguradora;

	private String dui;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	@Column(name="LUGAR_TRABAJO")
	private String lugarTrabajo;

	private String nit;

	private String nombre;

	private String telefono;

	@Column(name="TELEFONO_TRABAJO")
	private String telefonoTrabajo;

	@Column(name="TIPO_SEGURO")
	private String tipoSeguro;

	//bi-directional many-to-one association to Automovil
	@OneToMany(mappedBy="cliente")
	private List<Automovil> automovils;

	//bi-directional many-to-one association to Chequeo
	@OneToMany(mappedBy="cliente")
	private List<Chequeo> chequeos;

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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getLugarTrabajo() {
		return this.lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
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

	public String getTelefonoTrabajo() {
		return this.telefonoTrabajo;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	public String getTipoSeguro() {
		return this.tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public List<Automovil> getAutomovils() {
		return this.automovils;
	}

	public void setAutomovils(List<Automovil> automovils) {
		this.automovils = automovils;
	}

	public Automovil addAutomovil(Automovil automovil) {
		getAutomovils().add(automovil);
		automovil.setCliente(this);

		return automovil;
	}

	public Automovil removeAutomovil(Automovil automovil) {
		getAutomovils().remove(automovil);
		automovil.setCliente(null);

		return automovil;
	}

	public List<Chequeo> getChequeos() {
		return this.chequeos;
	}

	public void setChequeos(List<Chequeo> chequeos) {
		this.chequeos = chequeos;
	}

	public Chequeo addChequeo(Chequeo chequeo) {
		getChequeos().add(chequeo);
		chequeo.setCliente(this);

		return chequeo;
	}

	public Chequeo removeChequeo(Chequeo chequeo) {
		getChequeos().remove(chequeo);
		chequeo.setCliente(null);

		return chequeo;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", aseguradora=" + aseguradora + ", dui="
				+ dui + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + ", lugarTrabajo="
				+ lugarTrabajo + ", nit=" + nit + ", nombre=" + nombre + ", telefono=" + telefono + ", telefonoTrabajo="
				+ telefonoTrabajo + ", tipoSeguro=" + tipoSeguro + ", automovils=" + automovils + ", chequeos="
				+ chequeos + "]";
	}

}