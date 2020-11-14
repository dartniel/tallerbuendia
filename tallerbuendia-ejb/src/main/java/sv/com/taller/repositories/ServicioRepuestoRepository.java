package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.ServicioRepuesto;

@Local
public interface ServicioRepuestoRepository {
	
	public List<ServicioRepuesto> mostrar();
	public ServicioRepuesto buscar(DetalleChequeo servicioRepuesto);
}
