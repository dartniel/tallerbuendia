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

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to DetalleChequeo
	@OneToMany(mappedBy="chequeo")
	private List<DetalleChequeo> detalleChequeos;

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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleChequeo> getDetalleChequeos() {
		return this.detalleChequeos;
	}

	public void setDetalleChequeos(List<DetalleChequeo> detalleChequeos) {
		this.detalleChequeos = detalleChequeos;
	}

	public DetalleChequeo addDetalleChequeo(DetalleChequeo detalleChequeo) {
		getDetalleChequeos().add(detalleChequeo);
		detalleChequeo.setChequeo(this);

		return detalleChequeo;
	}

	public DetalleChequeo removeDetalleChequeo(DetalleChequeo detalleChequeo) {
		getDetalleChequeos().remove(detalleChequeo);
		detalleChequeo.setChequeo(null);

		return detalleChequeo;
	}

}