package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.DetalleChequeo;

@Local
public interface CotizacionDao {

	public void cotizar(DetalleChequeo detalles);
	public void modificar(DetalleChequeo detalles);
	public void eliminar(int id);
	public void eliminarTodo(Chequeo chequeo);
	public List<DetalleChequeo> buscar(DetalleChequeo cotizacion);
}
