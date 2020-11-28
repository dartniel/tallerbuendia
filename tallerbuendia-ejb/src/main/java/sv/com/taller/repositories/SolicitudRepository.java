package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Solicitud;

@Local
public interface SolicitudRepository {

	public void agregar(Solicitud solicitud);
	public List<Solicitud> mostrar();
	
}