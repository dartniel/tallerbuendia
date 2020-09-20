package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.DetalleChequeo;

@Local
public interface DetalleChequeoRepository {

	public List<DetalleChequeo> mostrar();
}
