package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pertencia_automovil database table.
 * 
 */
@Entity
@Table(name="pertencia_automovil")
@NamedQuery(name="PertenciaAutomovil.findAll", query="SELECT p FROM PertenciaAutomovil p")
public class PertenciaAutomovil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERTENCIA_AUTOMOVIL")
	private int idPertenciaAutomovil;

	//bi-directional many-to-one association to Automovil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_AUTOMOVIL")
	private Automovil automovil;

	//bi-directional many-to-one association to Pertenencia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERTENENCIA")
	private Pertenencia pertenencia;

	public PertenciaAutomovil() {
	}

	public int getIdPertenciaAutomovil() {
		return this.idPertenciaAutomovil;
	}

	public void setIdPertenciaAutomovil(int idPertenciaAutomovil) {
		this.idPertenciaAutomovil = idPertenciaAutomovil;
	}

	public Automovil getAutomovil() {
		return this.automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Pertenencia getPertenencia() {
		return this.pertenencia;
	}

	public void setPertenencia(Pertenencia pertenencia) {
		this.pertenencia = pertenencia;
	}

}