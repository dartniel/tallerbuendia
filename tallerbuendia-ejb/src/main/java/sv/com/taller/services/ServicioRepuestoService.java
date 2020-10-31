package sv.com.taller.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.entities.Servicio;
import sv.com.taller.entities.ServicioRepuesto;
import sv.com.taller.repositories.ServicioRepuestoRepository;

@Stateless
public class ServicioRepuestoService implements ServicioRepuestoRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> mostrarServcio() {
		List<Servicio> mostrarServicio = null;
		Query query = entity.createQuery("FROM Servicio sr");
		mostrarServicio = query.getResultList();
		return mostrarServicio;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicioRepuesto> mostrarRepuesto(String nombreServicio) {
		List<ServicioRepuesto> mostrarRepuesto = null;
		Query query = entity.createQuery("FROM ServicioRepuesto as sr WHERE sr.servicio.nombreServicio = :nombreServicio");
		query.setParameter("nombreServicio", nombreServicio);
		mostrarRepuesto = query.getResultList();
		return mostrarRepuesto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicioRepuesto> buscarServicioRepuesto(DetalleChequeo idServicioRepuesto) {
		List<ServicioRepuesto> mostrarRepuesto = null;
		Query query = entity.createQuery("FROM ServicioRepuesto as sr WHERE sr.idServicioRepuesto = :idServicioRepuesto");
		query.setParameter("idServicioRepuesto", idServicioRepuesto.getServicioRepuesto().getIdServicioRepuesto());
		mostrarRepuesto = query.getResultList();
		return mostrarRepuesto;
	}
	
	@Override
	public DetalleChequeo agregarDetalleChequeo(String idRepuesto, int cantidad, String nombreServicio) {
		List<ServicioRepuesto> servicioRepuesto = null;
		DetalleChequeo detalles = null;
		return detalles;
	}


}
