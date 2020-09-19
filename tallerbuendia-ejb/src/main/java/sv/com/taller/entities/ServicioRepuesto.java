package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicio_repuesto database table.
 * 
 */
@Entity
@Table(name="servicio_repuesto")
@NamedQuery(name="ServicioRepuesto.findAll", query="SELECT s FROM ServicioRepuesto s")
public class ServicioRepuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SERVICIO_REPUESTO")
	private int idServicioRepuesto;

	//bi-directional many-to-one association to Chequeo
	@OneToMany(mappedBy="servicioRepuesto")
	private List<Chequeo> chequeos;

	//bi-directional many-to-one association to Repuesto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_REPUESTO")
	private Repuesto repuesto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SERVICIO")
	private Servicio servicio;

	public ServicioRepuesto() {
	}

	public int getIdServicioRepuesto() {
		return this.idServicioRepuesto;
	}

	public void setIdServicioRepuesto(int idServicioRepuesto) {
		this.idServicioRepuesto = idServicioRepuesto;
	}

	public List<Chequeo> getChequeos() {
		return this.chequeos;
	}

	public void setChequeos(List<Chequeo> chequeos) {
		this.chequeos = chequeos;
	}

	public Chequeo addChequeo(Chequeo chequeo) {
		getChequeos().add(chequeo);
		chequeo.setServicioRepuesto(this);

		return chequeo;
	}

	public Chequeo removeChequeo(Chequeo chequeo) {
		getChequeos().remove(chequeo);
		chequeo.setServicioRepuesto(null);

		return chequeo;
	}

	public Repuesto getRepuesto() {
		return this.repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}