package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servico_repuesto database table.
 * 
 */
@Entity
@Table(name="servico_repuesto")
@NamedQuery(name="ServicoRepuesto.findAll", query="SELECT s FROM ServicoRepuesto s")
public class ServicoRepuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SERVICO_REPUESTO")
	private int idServicoRepuesto;

	//bi-directional many-to-one association to Chequeo
	@OneToMany(mappedBy="servicoRepuesto")
	private List<Chequeo> chequeos;

	//bi-directional many-to-one association to Repuesto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_REPUESTO")
	private Repuesto repuesto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SERVICIO")
	private Servicio servicio;

	public ServicoRepuesto() {
	}

	public int getIdServicoRepuesto() {
		return this.idServicoRepuesto;
	}

	public void setIdServicoRepuesto(int idServicoRepuesto) {
		this.idServicoRepuesto = idServicoRepuesto;
	}

	public List<Chequeo> getChequeos() {
		return this.chequeos;
	}

	public void setChequeos(List<Chequeo> chequeos) {
		this.chequeos = chequeos;
	}

	public Chequeo addChequeo(Chequeo chequeo) {
		getChequeos().add(chequeo);
		chequeo.setServicoRepuesto(this);

		return chequeo;
	}

	public Chequeo removeChequeo(Chequeo chequeo) {
		getChequeos().remove(chequeo);
		chequeo.setServicoRepuesto(null);

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