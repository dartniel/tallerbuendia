package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.repositories.CotizacionDao;

@Stateless
public class CotizacionImp implements CotizacionDao {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void cotizar(DetalleChequeo detalles) {
		float precioUnitario = calcularPrecio(detalles.getCantidad(),
				detalles.getServicioRepuesto().getRepuesto().getPrecioVenta(),
				detalles.getServicioRepuesto().getServicio().getPrecio());

		DetalleChequeo cotizacion = new DetalleChequeo(detalles.getCantidad(), precioUnitario, detalles.getChequeo(),
				detalles.getServicioRepuesto());

		try {
			entity.getTransaction().begin();
			entity.persist(cotizacion);
			entity.getTransaction().commit();
			System.out.println("Guardado");
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}

	@Override
	public void modificar(DetalleChequeo detalles) {
		float precioUnitario = calcularPrecio(detalles.getCantidad(),
				detalles.getServicioRepuesto().getRepuesto().getPrecioVenta(),
				detalles.getServicioRepuesto().getServicio().getPrecio());

		detalles.setPrecioUnitario(precioUnitario);

		try {
			entity.getTransaction().begin();
			entity.merge(detalles);
			entity.getTransaction().commit();
			System.out.println("Modificado");
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}

	public float calcularPrecio(int cantidad, float precioRepuesto, float precioServicio) {
		float total = (precioRepuesto * cantidad) + precioServicio;
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleChequeo> buscar(DetalleChequeo cotizacion) {
		List<DetalleChequeo> obtenerCotizacion = null;
		Query query = entity.createQuery("FROM DetalleChequeo as d WHERE d.chequeo = :chequeo");
		query.setParameter("chequeo", cotizacion.getChequeo());
		obtenerCotizacion = query.getResultList();
		return obtenerCotizacion;
	}

	@Override
	public void eliminar(int id) {
		try {
			entity.getTransaction().begin();
			entity.remove(id);
			entity.getTransaction().commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}

	@Override
	public void eliminarTodo(Chequeo chequeo) {
		try {
			entity.getTransaction().begin();
			entity.remove(chequeo);
			entity.getTransaction().commit();
			System.out.println("Se Elimino todo");
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}
}
