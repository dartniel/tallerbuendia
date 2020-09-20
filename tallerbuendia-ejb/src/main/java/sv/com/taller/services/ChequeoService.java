package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.Chequeo;
import sv.com.taller.repositories.ChequeoRepository;

@Stateless
public class ChequeoService implements ChequeoRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Chequeo> mostrar() {
		List<Chequeo> chequeos = null;
		Query query = entity.createQuery("FROM Chequeo c");
		chequeos = query.getResultList();
		return chequeos;
	}

}
