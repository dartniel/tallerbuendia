package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.Repuesto;
import sv.com.taller.entities.ServicioRepuesto;
import sv.com.taller.repositories.DetalleChequeoRepository;

@Stateless
public class DetalleChequeoService implements DetalleChequeoRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleChequeo> mostrar(Chequeo chequeo) {
		List<DetalleChequeo> detalleChequeo = null;
		Query query = entity.createQuery("FROM DetalleChequeo d WHERE d.chequeo = :chequeo AND d.estado = 1");
		query.setParameter("chequeo", chequeo);
		detalleChequeo = query.getResultList();
		return detalleChequeo;
	}

	@Override
	public void actualizarExistencia(DetalleChequeo detalleChequeo) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Repuesto valorExistencia = null;

			Query query = entity.createQuery("FROM Repuesto r WHERE r.idRepuesto = :idRepuesto");
			query.setParameter("idRepuesto", detalleChequeo.getServicioRepuesto().getRepuesto().getIdRepuesto());
			valorExistencia = (Repuesto) query.getSingleResult();

			int nuevaExistencia = valorExistencia.getCantidad() - detalleChequeo.getCantidad();

			if (nuevaExistencia < 0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"El stock no tiene los suministros necesarios", null));
			} else {
				valorExistencia.setCantidad(nuevaExistencia);
				entity.getTransaction().begin();
				entity.merge(valorExistencia);
				entity.merge(detalleChequeo);
				entity.getTransaction().commit();
			}
		} catch (Exception e) {
			entity.close();
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleChequeo> mostrarCotizacion() {
		List<DetalleChequeo> detalleChequeo = null;
		Query query = entity.createQuery("FROM DetalleChequeo as d");
		detalleChequeo = query.getResultList();
		return detalleChequeo;
	}

	public void generarCotizacion(int idChequeo, DetalleChequeo detalles) {

		Query query = entity.createQuery("FROM Chequeo as c WHERE c.idChequeo = :idChequeo");
		query.setParameter("idChequeo", idChequeo).getSingleResult();
		Chequeo id = (Chequeo) query;

		try {
			detalles.getChequeo().setIdChequeo(id.getIdChequeo());

			entity.getTransaction().begin();
			/* DetalleChequeo cotizacion = new DetalleChequeo(detalles.getCantidad(), detalles.getPrecioUnitario(),
					detalles.getServicioRepuesto());*/
			entity.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}

	@Override
	public void cotizacion(DetalleChequeo cotizacion, String diagnostico) {
		System.out.println(cotizacion);

		ServicioRepuesto servRepuesto = servicioRepuesto(cotizacion.getServicioRepuesto().getIdServicioRepuesto());

		float totalServicioRepuesto = calcularServicioRepuesto(cotizacion.getCantidad(),
				servRepuesto.getServicio().getPrecio(), servRepuesto.getRepuesto().getPrecioVenta());

		System.out.println("ID SERVICIOREPUESTO = " + cotizacion.getServicioRepuesto().getIdServicioRepuesto());
		System.out.println("ID CHEQUEO = " + chequeo(diagnostico));
		System.out.println("CANTIDAD DE REPUESTOS = " + cotizacion.getCantidad());
		System.out.println("TOTAL POR SERVICIO Y REPUESTO = " + totalServicioRepuesto);

		try {
			entity.getTransaction().begin();
			/*DetalleChequeo detalles = new DetalleChequeo(cotizacion.getCantidad(), totalServicioRepuesto,
					cotizacion.getServicioRepuesto());*/
			// entity.persist(detalles);
			// System.out.println(detalles);
			System.out.println("GUARDADO");

			entity.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleChequeo> detalleSerRepuesto(String diagnostico) {
		List<DetalleChequeo> detalles = null;

		Query query = entity.createQuery("FROM DetalleChequeo as dc WHERE dc.chequeo = :chequeo");
		query.setParameter("chequeo", chequeo(diagnostico));
		detalles = query.getResultList();
		return detalles;
	}

	public float calcularServicioRepuesto(int cantidad, float precioServicio, float precioRepuesto) {
		float total = 0;
		total = (precioServicio + precioRepuesto) * cantidad;
		return total;
	}

	public Chequeo chequeo(String diagnostico) {
		Query query = entity.createQuery("FROM Chequeo as c WHERE c.diagnostico = :diagnostico");
		query.setParameter("diagnostico", diagnostico);
		Chequeo cheq = (Chequeo) query.getSingleResult();
		return cheq;
	}

	public ServicioRepuesto servicioRepuesto(int idServicioRepuesto) {
		Query query = entity
				.createQuery("FROM ServicioRepuesto as sr WHERE sr.idServicioRepuesto = :idServicioRepuesto");
		query.setParameter("idServicioRepuesto", idServicioRepuesto);
		ServicioRepuesto sr = (ServicioRepuesto) query.getSingleResult();
		return sr;
	}

	@Override
	public void eliminarCotizacion(DetalleChequeo cotizacion) {

		try {
			entity.getTransaction().begin();
			entity.remove(cotizacion);
			entity.getTransaction().commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}

	@Override
	public void cancelarCotizacion(String diagnostico) {

		Query query = entity.createQuery("FROM Chequeo as c WHERE c.diagnostico = :diagnostico");
		query.setParameter("diagnostico", diagnostico);
		Chequeo idChequeo = (Chequeo) query.getSingleResult();

		try {
			entity.getTransaction().begin();
			entity.remove(idChequeo);
			entity.getTransaction().commit();
			System.out.println("Cotizacion Cancelada");
		} catch (Exception e) {
			e.printStackTrace();
			entity.close();
		}
	}

	@Override
	public Double totalCotizacion(String diagnostico) {
		Query query = entity.createQuery(
				"SELECT sum(dc.precioUnitario) FROM DetalleChequeo as dc WHERE dc.chequeo.diagnostico = :chequeo");
		query.setParameter("chequeo", diagnostico);

		System.out.println(query.getSingleResult());
		Double total = (Double) query.getSingleResult();
		return total;
	}

}
