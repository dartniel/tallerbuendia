package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.repositories.DetalleChequeoRepository;

@Stateless
public class DetalleChequeoService implements DetalleChequeoRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleChequeo> mostrar() {
		List<DetalleChequeo> detalleChequeo = null;
		Query query = entity.createQuery("FROM DetalleChequeo d");
		detalleChequeo = query.getResultList();
		return detalleChequeo;
	}

}
