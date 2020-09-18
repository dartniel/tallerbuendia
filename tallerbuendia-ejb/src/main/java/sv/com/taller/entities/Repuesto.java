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
	
	public Repuesto(int cantidad, float costo, Date fechaAdquisicion, String marca, String nombre,
			float precioVenta, Proveedor proveedor) {
		this.cantidad = cantidad;
		this.costo = costo;
		this.fechaAdquisicion = fechaAdquisicion;
		this.marca = marca;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.proveedor = proveedor;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_REPUESTO")
	private int idRepuesto;

	private int cantidad;

	private float costo;

	private int disponible;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ADQUISICION")
	private Date fechaAdquisicion;

	private String marca;

	private String nombre;

	@Column(name="PRECIO_VENTA")
	private float precioVenta;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROVEEDOR")
	private Proveedor proveedor;

	
	@OneToMany(mappedBy="repuesto")
	private List<ServicoRepuesto> servicoRepuestos;

	public int getIdRepuesto() {
		return this.idRepuesto;
	}

	public void setIdRepuesto(int idRepuesto) {
		this.idRepuesto = idRepuesto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getCosto() {
		return this.costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public int getDisponible() {
		return this.disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public Date getFechaAdquisicion() {
		return this.fechaAdquisicion;
	}

	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<ServicoRepuesto> getServicoRepuestos() {
		return this.servicoRepuestos;
	}

	public void setServicoRepuestos(List<ServicoRepuesto> servicoRepuestos) {
		this.servicoRepuestos = servicoRepuestos;
	}

	public ServicoRepuesto addServicoRepuesto(ServicoRepuesto servicoRepuesto) {
		getServicoRepuestos().add(servicoRepuesto);
		servicoRepuesto.setRepuesto(this);

		return servicoRepuesto;
	}

	public ServicoRepuesto removeServicoRepuesto(ServicoRepuesto servicoRepuesto) {
		getServicoRepuestos().remove(servicoRepuesto);
		servicoRepuesto.setRepuesto(null);

		return servicoRepuesto;
	}

	@Override
	public String toString() {
		return "Repuesto [idRepuesto=" + idRepuesto + ", cantidad=" + cantidad + ", costo=" + costo + ", disponible="
				+ disponible + ", fechaAdquisicion=" + fechaAdquisicion + ", marca=" + marca + ", nombre=" + nombre
				+ ", precioVenta=" + precioVenta + ", proveedor=" + proveedor + ", servicoRepuestos=" + servicoRepuestos
				+ "]";
	}

}