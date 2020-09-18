package sv.com.taller.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import sv.com.taller.entities.Proveedor;
import sv.com.taller.repositories.ProveedorRepository;

@Named
@ViewScoped
public class ProveedorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Proveedor> mostrarProveedores;

	private List<SelectItem> selectOneProveedor;
	
	private Proveedor proveedor;
	
	@PostConstruct
	public void init() {
		this.proveedor = new Proveedor();
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@EJB
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor> getMostrarProveedores() {
		this.mostrarProveedores = proveedorRepository.mostrar();
		return mostrarProveedores;
	}

	public List<SelectItem> getSelectOneProveedor() {
		this.selectOneProveedor = new ArrayList<SelectItem>();
		List<Proveedor> proveedores = proveedorRepository.mostrar();
		
		for(Proveedor p : proveedores) {
			SelectItem proveedorItem = new SelectItem(p.getIdProveedor(), p.getNombre());
			this.selectOneProveedor.add(proveedorItem);
		}
		return selectOneProveedor;
	}
	
	
}
