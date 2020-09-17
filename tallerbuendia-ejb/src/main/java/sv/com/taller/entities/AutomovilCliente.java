package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the automovil_cliente database table.
 * 
 */
@Entity
@Table(name="automovil_cliente")
@NamedQuery(name="AutomovilCliente.findAll", query="SELECT a FROM AutomovilCliente a")
public class AutomovilCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Automovil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idAutomovil")
	private Automovil automovil;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	public AutomovilCliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Automovil getAutomovil() {
		return this.automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}