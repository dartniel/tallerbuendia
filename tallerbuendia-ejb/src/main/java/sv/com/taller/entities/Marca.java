package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MARCA")
	private int idMarca;

	private String nombre;

	//bi-directional many-to-one association to MarcaProveedor
	@OneToMany(mappedBy="marca")
	private List<MarcaProveedor> marcaProveedors;

	public Marca() {
	}

	public int getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MarcaProveedor> getMarcaProveedors() {
		return this.marcaProveedors;
	}

	public void setMarcaProveedors(List<MarcaProveedor> marcaProveedors) {
		this.marcaProveedors = marcaProveedors;
	}

	public MarcaProveedor addMarcaProveedor(MarcaProveedor marcaProveedor) {
		getMarcaProveedors().add(marcaProveedor);
		marcaProveedor.setMarca(this);

		return marcaProveedor;
	}

	public MarcaProveedor removeMarcaProveedor(MarcaProveedor marcaProveedor) {
		getMarcaProveedors().remove(marcaProveedor);
		marcaProveedor.setMarca(null);

		return marcaProveedor;
	}

}