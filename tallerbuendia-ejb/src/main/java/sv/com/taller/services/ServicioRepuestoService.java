package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.ServicioRepuesto;
import sv.com.taller.repositories.ServicioRepuestoRepository;

@Stateless
public class ServicioRepuestoService implements ServicioRepuestoRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicioRepuesto> mostrar() {
		List<ServicioRepuesto> servicioRepuesto = null;
		Query query = entity.createQuery("FROM ServicioRepuesto as s");
		servicioRepuesto = query.getResultList();
		return servicioRepuesto;
	}

	@Override
	public ServicioRepuesto buscar(DetalleChequeo servicioRepuesto) {
		ServicioRepuesto obtenerServicioRepuesto = null;
		Query query = entity.createQuery("FROM ServicioRepuesto as s WHERE s.idServicioRepuesto = :id");
		query.setParameter("id", servicioRepuesto.getServicioRepuesto().getIdServicioRepuesto());
		obtenerServicioRepuesto = (ServicioRepuesto) query.getSingleResult();
		return obtenerServicioRepuesto;
	}

}
