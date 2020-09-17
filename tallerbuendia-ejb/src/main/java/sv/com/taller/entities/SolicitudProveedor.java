package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the solicitud_proveedor database table.
 * 
 */
@Entity
@Table(name="solicitud_proveedor")
@NamedQuery(name="SolicitudProveedor.findAll", query="SELECT s FROM SolicitudProveedor s")
public class SolicitudProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Empleado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Repuesto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRepuesto")
	private Repuesto repuesto;

	//bi-directional many-to-one association to Solicitud
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idSolicitud")
	private Solicitud solicitud;

	public SolicitudProveedor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Repuesto getRepuesto() {
		return this.repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

}