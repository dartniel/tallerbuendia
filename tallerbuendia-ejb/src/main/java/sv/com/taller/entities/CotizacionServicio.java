package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cotizacion_servicio database table.
 * 
 */
@Entity
@Table(name="cotizacion_servicio")
@NamedQuery(name="CotizacionServicio.findAll", query="SELECT c FROM CotizacionServicio c")
public class CotizacionServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCotizacion_servicio;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Cotizacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCotizacion")
	private Cotizacion cotizacion;

	//bi-directional many-to-one association to Repuesto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRepuesto")
	private Repuesto repuesto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	//bi-directional many-to-one association to InformacionReparacion
	@OneToMany(mappedBy="cotizacionServicio")
	private List<InformacionReparacion> informacionReparacions;

	public CotizacionServicio() {
	}

	public int getIdCotizacion_servicio() {
		return this.idCotizacion_servicio;
	}

	public void setIdCotizacion_servicio(int idCotizacion_servicio) {
		this.idCotizacion_servicio = idCotizacion_servicio;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cotizacion getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
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

	public List<InformacionReparacion> getInformacionReparacions() {
		return this.informacionReparacions;
	}

	public void setInformacionReparacions(List<InformacionReparacion> informacionReparacions) {
		this.informacionReparacions = informacionReparacions;
	}

	public InformacionReparacion addInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().add(informacionReparacion);
		informacionReparacion.setCotizacionServicio(this);

		return informacionReparacion;
	}

	public InformacionReparacion removeInformacionReparacion(InformacionReparacion informacionReparacion) {
		getInformacionReparacions().remove(informacionReparacion);
		informacionReparacion.setCotizacionServicio(null);

		return informacionReparacion;
	}

}