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
	@Column(name="ID_CHEQUEO")
	private int idChequeo;

	private String adicionales;

	private String diagnostico;

	//bi-directional many-to-one association to Cotizacion
	@OneToMany(mappedBy="chequeo")
	private List<Cotizacion> cotizacions;

	//bi-directional many-to-one association to ServicioRepuesto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SERVICIO_REPUESTO")
	private ServicioRepuesto servicioRepuesto;

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

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public List<Cotizacion> getCotizacions() {
		return this.cotizacions;
	}

	public void setCotizacions(List<Cotizacion> cotizacions) {
		this.cotizacions = cotizacions;
	}

	public Cotizacion addCotizacion(Cotizacion cotizacion) {
		getCotizacions().add(cotizacion);
		cotizacion.setChequeo(this);

		return cotizacion;
	}

	public Cotizacion removeCotizacion(Cotizacion cotizacion) {
		getCotizacions().remove(cotizacion);
		cotizacion.setChequeo(null);

		return cotizacion;
	}

	public ServicioRepuesto getServicioRepuesto() {
		return this.servicioRepuesto;
	}

	public void setServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		this.servicioRepuesto = servicioRepuesto;
	}

}