package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pertenencia database table.
 * 
 */
@Entity
@NamedQuery(name="Pertenencia.findAll", query="SELECT p FROM Pertenencia p")
public class Pertenencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERTENENCIA")
	private int idPertenencia;

	private int cantidad;

	private String descripcion;

	private String observacion;

	//bi-directional many-to-one association to PertenciaAutomovil
	@OneToMany(mappedBy="pertenencia")
	private List<PertenciaAutomovil> pertenciaAutomovils;

	public Pertenencia() {
	}

	public int getIdPertenencia() {
		return this.idPertenencia;
	}

	public void setIdPertenencia(int idPertenencia) {
		this.idPertenencia = idPertenencia;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<PertenciaAutomovil> getPertenciaAutomovils() {
		return this.pertenciaAutomovils;
	}

	public void setPertenciaAutomovils(List<PertenciaAutomovil> pertenciaAutomovils) {
		this.pertenciaAutomovils = pertenciaAutomovils;
	}

	public PertenciaAutomovil addPertenciaAutomovil(PertenciaAutomovil pertenciaAutomovil) {
		getPertenciaAutomovils().add(pertenciaAutomovil);
		pertenciaAutomovil.setPertenencia(this);

		return pertenciaAutomovil;
	}

	public PertenciaAutomovil removePertenciaAutomovil(PertenciaAutomovil pertenciaAutomovil) {
		getPertenciaAutomovils().remove(pertenciaAutomovil);
		pertenciaAutomovil.setPertenencia(null);

		return pertenciaAutomovil;
	}

}