package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cotizacion database table.
 * 
 */
@Entity
@NamedQuery(name="Cotizacion.findAll", query="SELECT c FROM Cotizacion c")
public class Cotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCotizacion;

	@Temporal(TemporalType.DATE)
	private Date fecha_entrega;

	private double total;

	//bi-directional many-to-one association to CotizacionServicio
	@OneToMany(mappedBy="cotizacion")
	private List<CotizacionServicio> cotizacionServicios;

	public Cotizacion() {
	}

	public int getIdCotizacion() {
		return this.idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public Date getFecha_entrega() {
		return this.fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<CotizacionServicio> getCotizacionServicios() {
		return this.cotizacionServicios;
	}

	public void setCotizacionServicios(List<CotizacionServicio> cotizacionServicios) {
		this.cotizacionServicios = cotizacionServicios;
	}

	public CotizacionServicio addCotizacionServicio(CotizacionServicio cotizacionServicio) {
		getCotizacionServicios().add(cotizacionServicio);
		cotizacionServicio.setCotizacion(this);

		return cotizacionServicio;
	}

	public CotizacionServicio removeCotizacionServicio(CotizacionServicio cotizacionServicio) {
		getCotizacionServicios().remove(cotizacionServicio);
		cotizacionServicio.setCotizacion(null);

		return cotizacionServicio;
	}

}