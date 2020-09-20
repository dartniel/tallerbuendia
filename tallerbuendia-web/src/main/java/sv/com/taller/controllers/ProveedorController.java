package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Proveedor;
import sv.com.taller.repositories.ProveedorRepository;

@Named
@ViewScoped
public class ProveedorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Proveedor> mostrarProveedores;

	
	@EJB
	private ProveedorRepository proveedorRepository;
	

	public List<Proveedor> getMostrarProveedores() {
		this.mostrarProveedores = proveedorRepository.mostrarProveedor();
		return mostrarProveedores;
	}
}
