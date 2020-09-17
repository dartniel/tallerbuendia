package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the repuesto database table.
 * 
 */
@Entity
@NamedQuery(name="Repuesto.findAll", query="SELECT r FROM Repuesto r")
public class Repuesto implements Serializable {
	private static final long serialVersionUID = 1L;
public Repuesto() {}
	
	public Repuesto(Repuesto repuesto) {}
	
	public Repuesto(int idRepuesto, int cantidad, double costo, Date fecha_adquisicion, String marca, String nombre,
			double precio_venta) {
		this.idRepuesto = idRepuesto;
		this.cantidad = cantidad;
		this.costo = costo;
		this.fecha_adquisicion = fecha_adquisicion;
		this.marca = marca;
		this.nombre = nombre;
		this.precio_venta = precio_venta;
	}
	public Repuesto(int cantidad) {
		this.cantidad = cantidad;
	}

	@Id
	private int idRepuesto;

	private int cantidad;

	private double costo;

	private int disponible;

	@Temporal(TemporalType.DATE)
	private Date fecha_adquisicion;

	private String marca;

	private String nombre;

	private double precio_venta;

	//bi-directional many-to-one association to CotizacionServicio
	@OneToMany(mappedBy="repuesto")
	private List<CotizacionServicio> cotizacionServicios;

	//bi-directional many-to-one association to SolicitudProveedor
	@OneToMany(mappedBy="repuesto")
	private List<SolicitudProveedor> solicitudProveedors;
	public int getIdRepuesto() {
		return idRepuesto;
	}

	public void setIdRepuesto(int idRepuesto) {
		this.idRepuesto = idRepuesto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public Date getFecha_adquisicion() {
		return fecha_adquisicion;
	}

	public void setFecha_adquisicion(Date fecha_adquisicion) {
		this.fecha_adquisicion = fecha_adquisicion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public List<CotizacionServicio> getCotizacionServicios() {
		return cotizacionServicios;
	}

	public void setCotizacionServicios(List<CotizacionServicio> cotizacionServicios) {
		this.cotizacionServicios = cotizacionServicios;
	}

	public List<SolicitudProveedor> getSolicitudProveedors() {
		return solicitudProveedors;
	}

	public void setSolicitudProveedors(List<SolicitudProveedor> solicitudProveedors) {
		this.solicitudProveedors = solicitudProveedors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Repuesto [idRepuesto=" + idRepuesto + ", cantidad=" + cantidad + ", costo=" + costo + ", disponible="
				+ disponible + ", fecha_adquisicion=" + fecha_adquisicion + ", marca=" + marca + ", nombre=" + nombre
				+ ", precio_venta=" + precio_venta + "]";
	}

}