package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca_repuesto database table.
 * 
 */
@Entity
@Table(name="marca_repuesto")
@NamedQuery(name="MarcaRepuesto.findAll", query="SELECT m FROM MarcaRepuesto m")
public class MarcaRepuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MARCA_REPUESTO")
	private int idMarcaRepuesto;

	private String nombre;

	//bi-directional many-to-one association to ProveedorMarca
	@OneToMany(mappedBy="marcaRepuesto")
	private List<ProveedorMarca> proveedorMarcas;

	public MarcaRepuesto() {
	}

	public int getIdMarcaRepuesto() {
		return this.idMarcaRepuesto;
	}

	public void setIdMarcaRepuesto(int idMarcaRepuesto) {
		this.idMarcaRepuesto = idMarcaRepuesto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ProveedorMarca> getProveedorMarcas() {
		return this.proveedorMarcas;
	}

	public void setProveedorMarcas(List<ProveedorMarca> proveedorMarcas) {
		this.proveedorMarcas = proveedorMarcas;
	}

	public ProveedorMarca addProveedorMarca(ProveedorMarca proveedorMarca) {
		getProveedorMarcas().add(proveedorMarca);
		proveedorMarca.setMarcaRepuesto(this);

		return proveedorMarca;
	}

	public ProveedorMarca removeProveedorMarca(ProveedorMarca proveedorMarca) {
		getProveedorMarcas().remove(proveedorMarca);
		proveedorMarca.setMarcaRepuesto(null);

		return proveedorMarca;
	}

}