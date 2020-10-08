package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Cliente;

@Local
public interface ClienteRepository {

	public void agregarCliente(Cliente cliente);
	
	public void modificar(Cliente cliente);
	
	public void eliminar(Cliente cliente);
	
	public List<Cliente> mostrar();
	
}
