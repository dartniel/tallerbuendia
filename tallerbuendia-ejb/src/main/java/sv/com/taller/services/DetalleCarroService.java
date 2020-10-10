package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.DetalleCarro;
import sv.com.taller.repositories.DetalleCarroRepository;

@Stateless
public class DetalleCarroService implements DetalleCarroRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleCarro> mostrarMarca() {
		List<DetalleCarro> marcasCarro = null;
		Query query = entity.createQuery("FROM DetalleCarro d GROUP BY d.marcarNombre HAVING COUNT(*)>1");
		marcasCarro = query.getResultList();
		return marcasCarro;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleCarro> mostrarModelo(DetalleCarro detalleCarro) {
		List<DetalleCarro> modelos = null;
		Query query = entity.createQuery("FROM DetalleCarro d WHERE d.marcarNombre = :marcarNombre");
		query.setParameter("marcarNombre", detalleCarro.getMarcarNombre());
		modelos = query.getResultList();
		System.out.println(modelos);
		return modelos;
	}

}
