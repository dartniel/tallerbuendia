package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Automovil;
import sv.com.taller.entities.Cliente;


@Local
public interface AutomovilRepository {
	
	public void agregarAutomovil(Automovil automovil, Cliente cliente);
	public List<Automovil> mostrarAutomovilCliente();
	public void modificarAutomovil(Automovil automovil);
	public Automovil llenarAutomovil(int id);
}
