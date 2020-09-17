package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reparacion database table.
 * 
 */
@Entity
@NamedQuery(name="Reparacion.findAll", query="SELECT r FROM Reparacion r")
public class Reparacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReparacion;

	private String detalle_reparacion;

	@Temporal(TemporalType.DATE)
	private Date fecha_reparacion;

	//bi-directional many-to-one association to InformacionReparacion
	@OneToMany(mappedBy="reparacion")
	private List<InformacionReparacion> informacionReparacions;

	//bi-directional many-to-one association to ServicioReparacion
	@OneToMany(mappedBy="reparacion")
	private List<ServicioReparacion> servicioReparacions;

	public Reparacion() {
	}

	public int getIdReparacion() {
		return this.idReparacion;
	}

	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public String getDetalle_reparacion() {
		return this.detalle_reparacion;
	}

	public void setDetalle_reparacion(String detalle_reparacion) {
		this.detalle_reparacion = detalle_reparacion;
	}

	public Date getFecha_reparacion() {
		return this.fecha_reparacion;
	}

	public void setFecha_reparacion(Date fecha_reparacion) {
		this.fecha_reparacion = fecha_reparacion;
	}

	public List<InformacionReparacion> getInformacionReparacions() {
		return this.informacionReparacions;
	}

	public void setInformacionReparacions(List<InformacionReparacion> informacionReparacions) {
		this.informacionReparacions = informacionReparacions;
	}

	public InformacionReparacion addInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().add(informacionReparacion);
		informacionReparacion.setReparacion(this);

		return informacionReparacion;
	}

	public InformacionReparacion removeInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().remove(informacionReparacion);
		informacionReparacion.setReparacion(null);

		return informacionReparacion;
	}

	public List<ServicioReparacion> getServicioReparacions() {
		return this.servicioReparacions;
	}

	public void setServicioReparacions(List<ServicioReparacion> servicioReparacions) {
		this.servicioReparacions = servicioReparacions;
	}

	public ServicioReparacion addServicioReparacion(ServicioReparacion servicioReparacion) {
		getServicioReparacions().add(servicioReparacion);
		servicioReparacion.setReparacion(this);

		return servicioReparacion;
	}

	public ServicioReparacion removeServicioReparacion(ServicioReparacion servicioReparacion) {
		getServicioReparacions().remove(servicioReparacion);
		servicioReparacion.setReparacion(null);

		return servicioReparacion;
	}

}