package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Repuesto;

@Local
public interface RepuestoRepository {

	public void agregar(Repuesto repuesto);
	
	public void modificar(Repuesto repuesto);
	
	public void eliminar(Repuesto repuesto);
	
	public void restarCantidad(Repuesto repuesto, int cantidad);
	
	public List<Repuesto> mostrar();
	
	public List<Repuesto> buscar(String repuesto);
}
