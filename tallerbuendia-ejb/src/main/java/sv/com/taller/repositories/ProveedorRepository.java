package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Proveedor;

@Local
public interface ProveedorRepository {

	public List<Proveedor> mostrar();
}
