package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.MarcaProveedor;
import sv.com.taller.entities.Proveedor;

@Local
public interface ProveedorRepository {

	public List<Proveedor> mostrarProveedor();

	public List<MarcaProveedor> mostrarMarcaProveedor(Proveedor proveedor);
	public Proveedor buscar(int id);
	public MarcaProveedor buscarMarca(int id);
}
