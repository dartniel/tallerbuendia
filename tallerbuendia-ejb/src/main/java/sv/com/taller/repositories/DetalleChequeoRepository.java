package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.DetalleChequeo;

@Local
public interface DetalleChequeoRepository {

	public List<DetalleChequeo> mostrar(Chequeo chequeo);
	
	public List<DetalleChequeo> mostrarCotizacion();
	
	public void actualizarExistencia(DetalleChequeo detalleChequeo);
	
	public void cotizacion(DetalleChequeo cotizacion, String diagnostico);
	
	public List<DetalleChequeo> detalleSerRepuesto(String diagnostico);
	
	public void eliminarCotizacion(DetalleChequeo cotizacion);
	
	public void cancelarCotizacion(String diagnostico);
	
}
