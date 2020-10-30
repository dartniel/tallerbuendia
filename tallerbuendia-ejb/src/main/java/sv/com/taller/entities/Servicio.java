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
	@Column(name="ID_SERVICIO")
	private int idServicio;

	@Column(name="NOMBRE_SERVICIO")
	private String nombreServicio;

	private float precio;

	//bi-directional many-to-one association to ServicioRepuesto
	@OneToMany(mappedBy="servicio")
	private List<ServicioRepuesto> servicioRepuestos;

	public Servicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return this.nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<ServicioRepuesto> getServicioRepuestos() {
		return this.servicioRepuestos;
	}

	public void setServicioRepuestos(List<ServicioRepuesto> servicioRepuestos) {
		this.servicioRepuestos = servicioRepuestos;
	}

	public ServicioRepuesto addServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		getServicioRepuestos().add(servicioRepuesto);
		servicioRepuesto.setServicio(this);

		return servicioRepuesto;
	}

	public ServicioRepuesto removeServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		getServicioRepuestos().remove(servicioRepuesto);
		servicioRepuesto.setServicio(null);

		return servicioRepuesto;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", precio=" + precio + "]";
	}

}