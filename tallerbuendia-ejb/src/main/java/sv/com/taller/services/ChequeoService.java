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
	
	@Override
	public void agregarChequeo(Chequeo chequeo) {
		try {
			entity.getTransaction().begin();
			Chequeo nuevoChequeo = new Chequeo(chequeo.getDiagnostico());
			entity.persist(nuevoChequeo);
			entity.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Chequeo> mostrar() {
		List<Chequeo> chequeos = null;
		Query query = entity.createQuery("FROM Chequeo as c WHERE c.estado = 1");
		chequeos = query.getResultList();
		return chequeos;
	}

	@Override
	public Chequeo buscar(String diagnostico) {
		Chequeo resultado = null;
		Query query = entity.createQuery("FROM Chequeo as c WHERE c.diagnostico = :diagnostico");
		query.setParameter("diagnostico", diagnostico);
		resultado = (Chequeo) query.getSingleResult();
		return resultado;
	}

	@Override
	public void modificar(Chequeo chequeo) {
		chequeo.setEstado(0);
		try {
			entity.getTransaction().begin();
			entity.merge(chequeo);
			entity.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}


}
