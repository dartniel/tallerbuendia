package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.DetalleCarro;

@Local
public interface DetalleCarroRepository {

	public List<DetalleCarro> mostrarMarca();
	public List<DetalleCarro> mostrarModelo(DetalleCarro detalleCarro);

}
