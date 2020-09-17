package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servicio_reparacion database table.
 * 
 */
@Entity
@Table(name="servicio_reparacion")
@NamedQuery(name="ServicioReparacion.findAll", query="SELECT s FROM ServicioReparacion s")
public class ServicioReparacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio_reparacion;

	//bi-directional many-to-one association to Reparacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idReparacion")
	private Reparacion reparacion;

	public ServicioReparacion() {
	}

	public int getIdServicio_reparacion() {
		return this.idServicio_reparacion;
	}

	public void setIdServicio_reparacion(int idServicio_reparacion) {
		this.idServicio_reparacion = idServicio_reparacion;
	}

	public Reparacion getReparacion() {
		return this.reparacion;
	}

	public void setReparacion(Reparacion reparacion) {
		this.reparacion = reparacion;
	}

}