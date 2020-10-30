package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Chequeo;

@Local
public interface ChequeoRepository {

	public void agregarChequeo(Chequeo chequeo);
	
	public List<Chequeo> mostrar();
}
