package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detalle_carro database table.
 * 
 */
@Entity
@Table(name="detalle_carro")
@NamedQuery(name="DetalleCarro.findAll", query="SELECT d FROM DetalleCarro d")
public class DetalleCarro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DETALLE_CARRO")
	private int idDetalleCarro;

	private String anio;

	@Column(name="MARCAR_NOMBRE")
	private String marcarNombre;

	private String modelo;

	//bi-directional many-to-one association to Automovil
	@OneToMany(mappedBy="detalleCarro")
	private List<Automovil> automovils;

	public DetalleCarro() {
	}

	public int getIdDetalleCarro() {
		return this.idDetalleCarro;
	}

	public void setIdDetalleCarro(int idDetalleCarro) {
		this.idDetalleCarro = idDetalleCarro;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMarcarNombre() {
		return this.marcarNombre;
	}

	public void setMarcarNombre(String marcarNombre) {
		this.marcarNombre = marcarNombre;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Automovil> getAutomovils() {
		return this.automovils;
	}

	public void setAutomovils(List<Automovil> automovils) {
		this.automovils = automovils;
	}

	public Automovil addAutomovil(Automovil automovil) {
		getAutomovils().add(automovil);
		automovil.setDetalleCarro(this);

		return automovil;
	}

	public Automovil removeAutomovil(Automovil automovil) {
		getAutomovils().remove(automovil);
		automovil.setDetalleCarro(null);

		return automovil;
	}

}