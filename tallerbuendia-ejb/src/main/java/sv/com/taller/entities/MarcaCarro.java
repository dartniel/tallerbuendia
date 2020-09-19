package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca_carro database table.
 * 
 */
@Entity
@Table(name="marca_carro")
@NamedQuery(name="MarcaCarro.findAll", query="SELECT m FROM MarcaCarro m")
public class MarcaCarro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MARCA_CARRO")
	private int idMarcaCarro;

	private String anio;

	@Column(name="MARCAR_NOMBRE")
	private String marcarNombre;

	private String modelo;

	//bi-directional many-to-one association to ProveedorMarca
	@OneToMany(mappedBy="marcaCarro")
	private List<ProveedorMarca> proveedorMarcas;

	public MarcaCarro() {
	}

	public int getIdMarcaCarro() {
		return this.idMarcaCarro;
	}

	public void setIdMarcaCarro(int idMarcaCarro) {
		this.idMarcaCarro = idMarcaCarro;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMarcarNombre() {
		return this.marcarNombre;
	}

	public void setMarcarNombre(String marcarNombre) {
		this.marcarNombre = marcarNombre;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<ProveedorMarca> getProveedorMarcas() {
		return this.proveedorMarcas;
	}

	public void setProveedorMarcas(List<ProveedorMarca> proveedorMarcas) {
		this.proveedorMarcas = proveedorMarcas;
	}

	public ProveedorMarca addProveedorMarca(ProveedorMarca proveedorMarca) {
		getProveedorMarcas().add(proveedorMarca);
		proveedorMarca.setMarcaCarro(this);

		return proveedorMarca;
	}

	public ProveedorMarca removeProveedorMarca(ProveedorMarca proveedorMarca) {
		getProveedorMarcas().remove(proveedorMarca);
		proveedorMarca.setMarcaCarro(null);

		return proveedorMarca;
	}

}