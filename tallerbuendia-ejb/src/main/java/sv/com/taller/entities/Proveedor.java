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
	@Column(name="ID_PROVEEDOR")
	private int idProveedor;

	private String direccion;

	private String nombre;

	private String telefono;

	@Column(name="TIPO_REPUESTO")
	private String tipoRepuesto;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="proveedor")
	private List<Solicitud> solicituds;

	//bi-directional many-to-one association to ProveedorMarca
	@OneToMany(mappedBy="proveedor")
	private List<ProveedorMarca> proveedorMarcas;

	public Proveedor() {
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoRepuesto() {
		return this.tipoRepuesto;
	}

	public void setTipoRepuesto(String tipoRepuesto) {
		this.tipoRepuesto = tipoRepuesto;
	}

	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public Solicitud addSolicitud(Solicitud solicitud) {
		getSolicituds().add(solicitud);
		solicitud.setProveedor(this);

		return solicitud;
	}

	public Solicitud removeSolicitud(Solicitud solicitud) {
		getSolicituds().remove(solicitud);
		solicitud.setProveedor(null);

		return solicitud;
	}

	public List<ProveedorMarca> getProveedorMarcas() {
		return this.proveedorMarcas;
	}

	public void setProveedorMarcas(List<ProveedorMarca> proveedorMarcas) {
		this.proveedorMarcas = proveedorMarcas;
	}

	public ProveedorMarca addProveedorMarca(ProveedorMarca proveedorMarca) {
		getProveedorMarcas().add(proveedorMarca);
		proveedorMarca.setProveedor(this);

		return proveedorMarca;
	}

	public ProveedorMarca removeProveedorMarca(ProveedorMarca proveedorMarca) {
		getProveedorMarcas().remove(proveedorMarca);
		proveedorMarca.setProveedor(null);

		return proveedorMarca;
	}

}