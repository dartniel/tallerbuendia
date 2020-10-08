package sv.com.taller.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the automovil database table.
 * 
 */
@Entity
@NamedQuery(name="Automovil.findAll", query="SELECT a FROM Automovil a")
public class Automovil implements Serializable {
	private static final long serialVersionUID = 1L;
	public Automovil() {}
	public Automovil(Automovil automovil) {}
	public Automovil(String chasis, String color, String observacion, String placa, Cliente cliente, DetalleCarro detalleCarro) {
		this.chasis = chasis;
		this.color = color;
		this.observacion = observacion;
		this.placa = placa;
		this.detalleCarro = detalleCarro;
		
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AUTOMOVIL")
	private int idAutomovil;

	private String chasis;

	private String color;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	private String observacion;

	private String placa;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to DetalleCarro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DETALLE_CARRO")
	private DetalleCarro detalleCarro;

	//bi-directional many-to-one association to PertenciaAutomovil
	@OneToMany(mappedBy="automovil")
	private List<PertenciaAutomovil> pertenciaAutomovils;

	//bi-directional many-to-one association to Reparacion
	@OneToMany(mappedBy="automovil")
	private List<Reparacion> reparacions;



	public int getIdAutomovil() {
		return this.idAutomovil;
	}

	public void setIdAutomovil(int idAutomovil) {
		this.idAutomovil = idAutomovil;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DetalleCarro getDetalleCarro() {
		return this.detalleCarro;
	}

	public void setDetalleCarro(DetalleCarro detalleCarro) {
		this.detalleCarro = detalleCarro;
	}

	public List<PertenciaAutomovil> getPertenciaAutomovils() {
		return this.pertenciaAutomovils;
	}

	public void setPertenciaAutomovils(List<PertenciaAutomovil> pertenciaAutomovils) {
		this.pertenciaAutomovils = pertenciaAutomovils;
	}

	public PertenciaAutomovil addPertenciaAutomovil(PertenciaAutomovil pertenciaAutomovil) {
		getPertenciaAutomovils().add(pertenciaAutomovil);
		pertenciaAutomovil.setAutomovil(this);

		return pertenciaAutomovil;
	}

	public PertenciaAutomovil removePertenciaAutomovil(PertenciaAutomovil pertenciaAutomovil) {
		getPertenciaAutomovils().remove(pertenciaAutomovil);
		pertenciaAutomovil.setAutomovil(null);

		return pertenciaAutomovil;
	}

	public List<Reparacion> getReparacions() {
		return this.reparacions;
	}

	public void setReparacions(List<Reparacion> reparacions) {
		this.reparacions = reparacions;
	}

	public Reparacion addReparacion(Reparacion reparacion) {
		getReparacions().add(reparacion);
		reparacion.setAutomovil(this);

		return reparacion;
	}

	public Reparacion removeReparacion(Reparacion reparacion) {
		getReparacions().remove(reparacion);
		reparacion.setAutomovil(null);

		return reparacion;
	}
	@Override
	public String toString() {
		return "Automovil [idAutomovil=" + idAutomovil + ", chasis=" + chasis + ", color=" + color + ", fechaRegistro="
				+ fechaRegistro + ", observacion=" + observacion + ", placa=" + placa + ", cliente=" + cliente
				+ ", detalleCarro=" + detalleCarro + ", pertenciaAutomovils=" + pertenciaAutomovils + ", reparacions="
				+ reparacions + "]";
	}

}