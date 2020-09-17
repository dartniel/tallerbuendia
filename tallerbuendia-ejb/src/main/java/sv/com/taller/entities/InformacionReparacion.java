package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the informacion_reparacion database table.
 * 
 */
@Entity
@Table(name="informacion_reparacion")
@NamedQuery(name="InformacionReparacion.findAll", query="SELECT i FROM InformacionReparacion i")
public class InformacionReparacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Automovil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idAutomovil")
	private Automovil automovil;

	//bi-directional many-to-one association to Chequeo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChequeo")
	private Chequeo chequeo;

	//bi-directional many-to-one association to CotizacionServicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCotizacion_servicio")
	private CotizacionServicio cotizacionServicio;

	//bi-directional many-to-one association to Empleado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Reparacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idReparacion")
	private Reparacion reparacion;

	public InformacionReparacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Automovil getAutomovil() {
		return this.automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Chequeo getChequeo() {
		return this.chequeo;
	}

	public void setChequeo(Chequeo chequeo) {
		this.chequeo = chequeo;
	}

	public CotizacionServicio getCotizacionServicio() {
		return this.cotizacionServicio;
	}

	public void setCotizacionServicio(CotizacionServicio cotizacionServicio) {
		this.cotizacionServicio = cotizacionServicio;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Reparacion getReparacion() {
		return this.reparacion;
	}

	public void setReparacion(Reparacion reparacion) {
		this.reparacion = reparacion;
	}

}