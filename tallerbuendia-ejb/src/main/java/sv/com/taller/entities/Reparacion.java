package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reparacion database table.
 * 
 */
@Entity
@NamedQuery(name="Reparacion.findAll", query="SELECT r FROM Reparacion r")
public class Reparacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_REPARACION")
	private int idReparacion;

	@Column(name="DETALLE_REPACION")
	private String detalleRepacion;

	private int estado;

	//bi-directional many-to-one association to Automovil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_AUTOMOVIL")
	private Automovil automovil;

	//bi-directional many-to-one association to Empleado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_EMPLEADO")
	private Empleado empleado;

	public Reparacion() {
	}

	public int getIdReparacion() {
		return this.idReparacion;
	}

	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public String getDetalleRepacion() {
		return this.detalleRepacion;
	}

	public void setDetalleRepacion(String detalleRepacion) {
		this.detalleRepacion = detalleRepacion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Automovil getAutomovil() {
		return this.automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}