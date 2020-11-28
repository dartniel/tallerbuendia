package sv.com.taller.repositories;

import java.util.List;

import javax.ejb.Local;

import sv.com.taller.entities.Empleado;

@Local
public interface EmpleadoRepository {

	public List<Empleado> mostrarEmpleado();
	public Empleado buscar (String id);

}
