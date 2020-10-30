package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.Servicio;
import sv.com.taller.entities.ServicioRepuesto;

@Local
public interface ServicioRepuestoRepository {
	
	public DetalleChequeo agregarDetalleChequeo(String idRepuesto, int cantidad, String nombreServicio);
	
	public List<Servicio> mostrarServcio();
	
	public List<ServicioRepuesto> mostrarRepuesto(String nombreServicio);
}
