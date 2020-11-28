package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitud.findAll", query="SELECT s FROM Solicitud s")
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;
	public Solicitud() {}
	
	public Solicitud(Date fecha, String descripcion, int cantidad, Proveedor proveedor, Empleado empleado) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.proveedor = proveedor;
		this.empleado = empleado;
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SOLICITUD")
	private int idSolicitud;

	private int cantidad;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Empleado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_EMPLEADO")
	private Empleado empleado;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROVEEDOR")
	private Proveedor proveedor;



	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

}