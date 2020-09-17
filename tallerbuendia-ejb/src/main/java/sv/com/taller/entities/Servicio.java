package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio;

	private String nombre_servicio;

	//bi-directional many-to-one association to CotizacionServicio
	@OneToMany(mappedBy="servicio")
	private List<CotizacionServicio> cotizacionServicios;

	public Servicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre_servicio() {
		return this.nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public List<CotizacionServicio> getCotizacionServicios() {
		return this.cotizacionServicios;
	}

	public void setCotizacionServicios(List<CotizacionServicio> cotizacionServicios) {
		this.cotizacionServicios = cotizacionServicios;
	}

	public CotizacionServicio addCotizacionServicio(CotizacionServicio cotizacionServicio) {
		getCotizacionServicios().add(cotizacionServicio);
		cotizacionServicio.setServicio(this);

		return cotizacionServicio;
	}

	public CotizacionServicio removeCotizacionServicio(CotizacionServicio cotizacionServicio) {
		getCotizacionServicios().remove(cotizacionServicio);
		cotizacionServicio.setServicio(null);

		return cotizacionServicio;
	}

}