package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.Empleado;
import sv.com.taller.repositories.EmpleadoRepository;

@Stateless
public class EmpleadoService implements EmpleadoRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> mostrarEmpleado() {
		List<Empleado> empleados = null;
		Query query = entity.createQuery("FROM Empleado e");
		empleados = query.getResultList();
		return empleados;
	}



}
