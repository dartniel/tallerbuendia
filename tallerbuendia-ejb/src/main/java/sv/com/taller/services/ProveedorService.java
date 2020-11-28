package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.MarcaProveedor;
import sv.com.taller.entities.Proveedor;
import sv.com.taller.repositories.ProveedorRepository;

@Stateless
public class ProveedorService implements ProveedorRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> mostrarProveedor() {
		List<Proveedor> proveedores = null;
		Query query = entity.createQuery("FROM Proveedor p");
		proveedores = query.getResultList();
		return proveedores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MarcaProveedor> mostrarMarcaProveedor(Proveedor proveedor) {
		List<MarcaProveedor> marcas = null;
		Query query = entity.createQuery("From MarcaProveedor m WHERE m.proveedor = :proveedor");
		query.setParameter("proveedor", 	proveedor);
		marcas = query.getResultList();
		return marcas;
	}

	@Override
	public Proveedor buscar(int id) {
		Proveedor obtenerProveedor = null;
		Query query = entity.createQuery("FROM Proveedor as p WHERE p.idProveedor = :idProveedor");
		query.setParameter("idProveedor", id);
		obtenerProveedor = (Proveedor) query.getSingleResult();
		return obtenerProveedor;
	}

	@Override
	public MarcaProveedor buscarMarca(int id) {
		MarcaProveedor obtenerMarca = null;
		Query query = entity.createQuery("FROM MarcaProveedor as m WHERE m.idMarcaProveedor = :idMarcaProveedor");
		query.setParameter("idMarcaProveedor", id);
		obtenerMarca = (MarcaProveedor) query.getSingleResult();
		return obtenerMarca;
	}

}
