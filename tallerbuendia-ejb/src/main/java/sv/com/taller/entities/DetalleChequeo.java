package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_chequeo database table.
 * 
 */
@Entity
@Table(name="detalle_chequeo")
@NamedQuery(name="DetalleChequeo.findAll", query="SELECT d FROM DetalleChequeo d")
public class DetalleChequeo implements Serializable {
	private static final long serialVersionUID = 1L;

	public DetalleChequeo() {}
	
	public DetalleChequeo(DetalleChequeo detalleChequeo) {}
	
	public DetalleChequeo(ServicioRepuesto servicioRepuesto) {
		this.servicioRepuesto = servicioRepuesto;
	}
	
	public DetalleChequeo(int cantidad, float precioUnitario, Chequeo chequeo, ServicioRepuesto servicioRepuesto) {
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.chequeo = chequeo;
		this.servicioRepuesto = servicioRepuesto;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DETALLE_CHEQUEO")
	private int idDetalleChequeo;

	private int cantidad;

	private int estado = 1;

	@Column(name="PRECIO_UNITARIO")
	private float precioUnitario;

	//bi-directional many-to-one association to Chequeo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CHEQUEO")
	private Chequeo chequeo;

	//bi-directional many-to-one association to ServicioRepuesto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SERVICIO_REPUESTO")
	private ServicioRepuesto servicioRepuesto;

	public int getIdDetalleChequeo() {
		return this.idDetalleChequeo;
	}

	public void setIdDetalleChequeo(int idDetalleChequeo) {
		this.idDetalleChequeo = idDetalleChequeo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public float getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Chequeo getChequeo() {
		return this.chequeo;
	}

	public void setChequeo(Chequeo chequeo) {
		this.chequeo = chequeo;
	}

	public ServicioRepuesto getServicioRepuesto() {
		return this.servicioRepuesto;
	}

	public void setServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		this.servicioRepuesto = servicioRepuesto;
	}

	@Override
	public String toString() {
		return "DetalleChequeo [idDetalleChequeo=" + idDetalleChequeo + ", cantidad=" + cantidad + ", estado=" + estado
				+ ", precioUnitario=" + precioUnitario + ", chequeo=" + chequeo + ", servicioRepuesto="
				+ servicioRepuesto + "]";
	}

}