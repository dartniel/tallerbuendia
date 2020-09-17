package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chequeo database table.
 * 
 */
@Entity
@NamedQuery(name="Chequeo.findAll", query="SELECT c FROM Chequeo c")
public class Chequeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idChequeo;

	private String adicionales;

	//bi-directional many-to-one association to InformacionReparacion
	@OneToMany(mappedBy="chequeo")
	private List<InformacionReparacion> informacionReparacions;

	public Chequeo() {
	}

	public int getIdChequeo() {
		return this.idChequeo;
	}

	public void setIdChequeo(int idChequeo) {
		this.idChequeo = idChequeo;
	}

	public String getAdicionales() {
		return this.adicionales;
	}

	public void setAdicionales(String adicionales) {
		this.adicionales = adicionales;
	}

	public List<InformacionReparacion> getInformacionReparacions() {
		return this.informacionReparacions;
	}

	public void setInformacionReparacions(List<InformacionReparacion> informacionReparacions) {
		this.informacionReparacions = informacionReparacions;
	}

	public InformacionReparacion addInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().add(informacionReparacion);
		informacionReparacion.setChequeo(this);

		return informacionReparacion;
	}

	public InformacionReparacion removeInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().remove(informacionReparacion);
		informacionReparacion.setChequeo(null);

		return informacionReparacion;
	}

}