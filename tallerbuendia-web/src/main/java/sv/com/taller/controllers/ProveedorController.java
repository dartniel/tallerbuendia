package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.MarcaProveedor;
import sv.com.taller.entities.Proveedor;
import sv.com.taller.repositories.ProveedorRepository;

@Named
@ViewScoped
public class ProveedorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Proveedor> mostrarProveedores;
	
	private List<MarcaProveedor> mostrarMarcaProveedor;

	private Proveedor proveedor;
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	@PostConstruct
	public void init() {
		proveedor = new Proveedor();
	}
	
	@EJB
	private ProveedorRepository proveedorRepository;
	

	public List<Proveedor> getMostrarProveedores() {
		this.mostrarProveedores = proveedorRepository.mostrarProveedor();
		return mostrarProveedores;
	}
	
	public void mostrarMarca() {
		mostrarMarcaProveedor = proveedorRepository.mostrarMarcaProveedor(proveedor);
	}
	
	
	public List<MarcaProveedor> getMostrarMarcaProveedor() {
		return mostrarMarcaProveedor;
	}

}
