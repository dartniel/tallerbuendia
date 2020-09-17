package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idEmpleado;

	private String apellido;

	private String direccion;

	private String nombre;

	private String password;

	private int telefono;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="empleado_rol"
		, joinColumns={
			@JoinColumn(name="idEmpleado")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idRol")
			}
		)
	private List<Rol> rols;

	//bi-directional many-to-one association to InformacionReparacion
	@OneToMany(mappedBy="empleado")
	private List<InformacionReparacion> informacionReparacions;

	//bi-directional many-to-one association to SolicitudProveedor
	@OneToMany(mappedBy="empleado")
	private List<SolicitudProveedor> solicitudProveedors;

	public Empleado() {
	}

	public String getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public List<InformacionReparacion> getInformacionReparacions() {
		return this.informacionReparacions;
	}

	public void setInformacionReparacions(List<InformacionReparacion> informacionReparacions) {
		this.informacionReparacions = informacionReparacions;
	}

	public InformacionReparacion addInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().add(informacionReparacion);
		informacionReparacion.setEmpleado(this);

		return informacionReparacion;
	}

	public InformacionReparacion removeInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().remove(informacionReparacion);
		informacionReparacion.setEmpleado(null);

		return informacionReparacion;
	}

	public List<SolicitudProveedor> getSolicitudProveedors() {
		return this.solicitudProveedors;
	}

	public void setSolicitudProveedors(List<SolicitudProveedor> solicitudProveedors) {
		this.solicitudProveedors = solicitudProveedors;
	}

	public SolicitudProveedor addSolicitudProveedor(SolicitudProveedor solicitudProveedor) {
		getSolicitudProveedors().add(solicitudProveedor);
		solicitudProveedor.setEmpleado(this);

		return solicitudProveedor;
	}

	public SolicitudProveedor removeSolicitudProveedor(SolicitudProveedor solicitudProveedor) {
		getSolicitudProveedors().remove(solicitudProveedor);
		solicitudProveedor.setEmpleado(null);

		return solicitudProveedor;
	}

}