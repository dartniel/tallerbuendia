package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitud.findAll", query="SELECT s FROM Solicitud s")
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSolicitud;

	private int año;

	private String cantidad;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String marca;

	private String modelo;

	//bi-directional many-to-one association to SolicitudProveedor
	@OneToMany(mappedBy="solicitud")
	private List<SolicitudProveedor> solicitudProveedors;

	public Solicitud() {
	}

	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public int getAño() {
		return this.año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(String cantidad) {
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

	public List<SolicitudProveedor> getSolicitudProveedors() {
		return this.solicitudProveedors;
	}

	public void setSolicitudProveedors(List<SolicitudProveedor> solicitudProveedors) {
		this.solicitudProveedors = solicitudProveedors;
	}

	public SolicitudProveedor addSolicitudProveedor(SolicitudProveedor solicitudProveedor) {
		getSolicitudProveedors().add(solicitudProveedor);
		solicitudProveedor.setSolicitud(this);

		return solicitudProveedor;
	}

	public SolicitudProveedor removeSolicitudProveedor(SolicitudProveedor solicitudProveedor) {
		getSolicitudProveedors().remove(solicitudProveedor);
		solicitudProveedor.setSolicitud(null);

		return solicitudProveedor;
	}

}