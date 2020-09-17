package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idProveedor;

	private String apellido;

	private String direccion;

	private String marca_repuesto;

	private String nombre;

	private String telefono_contacto;

	private String tipo_repuesto;

	//bi-directional many-to-one association to SolicitudProveedor
	@OneToMany(mappedBy="proveedor")
	private List<SolicitudProveedor> solicitudProveedors;

	public Proveedor() {
	}

	public String getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
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

	public String getMarca_repuesto() {
		return this.marca_repuesto;
	}

	public void setMarca_repuesto(String marca_repuesto) {
		this.marca_repuesto = marca_repuesto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono_contacto() {
		return this.telefono_contacto;
	}

	public void setTelefono_contacto(String telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}

	public String getTipo_repuesto() {
		return this.tipo_repuesto;
	}

	public void setTipo_repuesto(String tipo_repuesto) {
		this.tipo_repuesto = tipo_repuesto;
	}

	public List<SolicitudProveedor> getSolicitudProveedors() {
		return this.solicitudProveedors;
	}

	public void setSolicitudProveedors(List<SolicitudProveedor> solicitudProveedors) {
		this.solicitudProveedors = solicitudProveedors;
	}

	public SolicitudProveedor addSolicitudProveedor(SolicitudProveedor solicitudProveedor) {
		getSolicitudProveedors().add(solicitudProveedor);
		solicitudProveedor.setProveedor(this);

		return solicitudProveedor;
	}

	public SolicitudProveedor removeSolicitudProveedor(SolicitudProveedor solicitudProveedor) {
		getSolicitudProveedors().remove(solicitudProveedor);
		solicitudProveedor.setProveedor(null);

		return solicitudProveedor;
	}

}