package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.ProveedorMarca;
import sv.com.taller.repositories.ProveedorRepository;

@Stateless
public class ProveedorService implements ProveedorRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProveedorMarca> mostrar() {
		List<ProveedorMarca> proveedores = null;
		Query query = entity.createQuery("FROM ProveedorMarca p");
		proveedores = query.getResultList();
		return proveedores;
	}

}
