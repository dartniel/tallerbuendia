package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Repuesto
	@OneToMany(mappedBy="marcaProveedor")
	private List<Repuesto> repuestos;

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

	public List<Repuesto> getRepuestos() {
		return this.repuestos;
	}

	public void setRepuestos(List<Repuesto> repuestos) {
		this.repuestos = repuestos;
	}

	public Repuesto addRepuesto(Repuesto repuesto) {
		getRepuestos().add(repuesto);
		repuesto.setMarcaProveedor(this);

		return repuesto;
	}

	public Repuesto removeRepuesto(Repuesto repuesto) {
		getRepuestos().remove(repuesto);
		repuesto.setMarcaProveedor(null);

		return repuesto;
	}

	@Override
	public String toString() {
		return "MarcaProveedor [idMarcaProveedor=" + idMarcaProveedor + ", marca=" + marca + ", proveedor=" + proveedor
				+ "]";
	}

}