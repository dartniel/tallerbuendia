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

	//bi-directional many-to-one association to DetalleChequeo
	@OneToMany(mappedBy="servicioRepuesto")
	private List<DetalleChequeo> detalleChequeos;

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

	public List<DetalleChequeo> getDetalleChequeos() {
		return this.detalleChequeos;
	}

	public void setDetalleChequeos(List<DetalleChequeo> detalleChequeos) {
		this.detalleChequeos = detalleChequeos;
	}

	public DetalleChequeo addDetalleChequeo(DetalleChequeo detalleChequeo) {
		getDetalleChequeos().add(detalleChequeo);
		detalleChequeo.setServicioRepuesto(this);

		return detalleChequeo;
	}

	public DetalleChequeo removeDetalleChequeo(DetalleChequeo detalleChequeo) {
		getDetalleChequeos().remove(detalleChequeo);
		detalleChequeo.setServicioRepuesto(null);

		return detalleChequeo;
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

	@Override
	public String toString() {
		return "ServicioRepuesto [idServicioRepuesto=" + idServicioRepuesto + ", detalleChequeos=" + detalleChequeos
				+ ", repuesto=" + repuesto + ", servicio=" + servicio + "]";
	}

}