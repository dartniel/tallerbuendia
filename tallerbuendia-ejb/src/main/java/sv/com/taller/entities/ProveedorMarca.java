package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor_marca database table.
 * 
 */
@Entity
@Table(name="proveedor_marca")
@NamedQuery(name="ProveedorMarca.findAll", query="SELECT p FROM ProveedorMarca p")
public class ProveedorMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROVEEDOR_MARCA")
	private int idProveedorMarca;

	//bi-directional many-to-one association to MarcaCarro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_MARCA_CARRO")
	private MarcaCarro marcaCarro;

	//bi-directional many-to-one association to MarcaRepuesto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_MARCA_REPUESTO")
	private MarcaRepuesto marcaRepuesto;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROVEEDOR")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Repuesto
	@OneToMany(mappedBy="proveedorMarca")
	private List<Repuesto> repuestos;

	public ProveedorMarca() {
	}

	public int getIdProveedorMarca() {
		return this.idProveedorMarca;
	}

	public void setIdProveedorMarca(int idProveedorMarca) {
		this.idProveedorMarca = idProveedorMarca;
	}

	public MarcaCarro getMarcaCarro() {
		return this.marcaCarro;
	}

	public void setMarcaCarro(MarcaCarro marcaCarro) {
		this.marcaCarro = marcaCarro;
	}

	public MarcaRepuesto getMarcaRepuesto() {
		return this.marcaRepuesto;
	}

	public void setMarcaRepuesto(MarcaRepuesto marcaRepuesto) {
		this.marcaRepuesto = marcaRepuesto;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Repuesto> getRepuestos() {
		return this.repuestos;
	}

	public void setRepuestos(List<Repuesto> repuestos) {
		this.repuestos = repuestos;
	}

	public Repuesto addRepuesto(Repuesto repuesto) {
		getRepuestos().add(repuesto);
		repuesto.setProveedorMarca(this);

		return repuesto;
	}

	public Repuesto removeRepuesto(Repuesto repuesto) {
		getRepuestos().remove(repuesto);
		repuesto.setProveedorMarca(null);

		return repuesto;
	}

}