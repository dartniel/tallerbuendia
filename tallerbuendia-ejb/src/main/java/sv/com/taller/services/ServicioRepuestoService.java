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
	public void agregarDetalleChequeo(List<String> checkServicioRepuesto) {
		List<ServicioRepuesto> mostrarRepuesto = null;
		DetalleChequeo serv = null;
		for(String servicioRepuesto : checkServicioRepuesto) {
			
			Query query = entity.createQuery("FROM ServicioRepuesto as sr WHERE sr.repuesto.idRepuesto = :idRepuesto");
			query.setParameter("idRepuesto", servicioRepuesto);
			mostrarRepuesto = query.getResultList();
			
			for(ServicioRepuesto sr : mostrarRepuesto) {
				serv = new DetalleChequeo(sr);
			}
			
			System.out.println(serv);
		}
		
		
		
	}


}
