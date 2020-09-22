package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the marca_proveedor database table.
 * 
 */
@Entity
@Table(name="marca_proveedor")
@NamedQuery(name="MarcaProveedor.findAll", query="SELECT m FROM MarcaProveedor m")
public class MarcaProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MARCA_PROVEEDOR")
	private int idMarcaProveedor;

	//bi-directional many-to-one association to Marca
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_MARCA")
	private Marca marca;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROVEEDOR")
	private Proveedor proveedor;

	public MarcaProveedor() {
	}

	public int getIdMarcaProveedor() {
		return this.idMarcaProveedor;
	}

	public void setIdMarcaProveedor(int idMarcaProveedor) {
		this.idMarcaProveedor = idMarcaProveedor;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}