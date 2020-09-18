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

	//bi-directional many-to-one association to ServicoRepuesto
	@OneToMany(mappedBy="servicio")
	private List<ServicoRepuesto> servicoRepuestos;

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

	public List<ServicoRepuesto> getServicoRepuestos() {
		return this.servicoRepuestos;
	}

	public void setServicoRepuestos(List<ServicoRepuesto> servicoRepuestos) {
		this.servicoRepuestos = servicoRepuestos;
	}

	public ServicoRepuesto addServicoRepuesto(ServicoRepuesto servicoRepuesto) {
		getServicoRepuestos().add(servicoRepuesto);
		servicoRepuesto.setServicio(this);

		return servicoRepuesto;
	}

	public ServicoRepuesto removeServicoRepuesto(ServicoRepuesto servicoRepuesto) {
		getServicoRepuestos().remove(servicoRepuesto);
		servicoRepuesto.setServicio(null);

		return servicoRepuesto;
	}

}