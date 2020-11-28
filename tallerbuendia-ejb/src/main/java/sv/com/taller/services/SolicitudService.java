package sv.com.taller.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.Repuesto;
import sv.com.taller.entities.Solicitud;
import sv.com.taller.repositories.SolicitudRepository;

@Stateless
public class SolicitudService implements SolicitudRepository{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void agregar(Solicitud solicitud) {
		
		try {
			entity.getTransaction().begin();
			Solicitud solicitud1 = new Solicitud(solicitud.getFecha(), solicitud.getDescripcion(), solicitud.getCantidad(), solicitud.getProveedor(), solicitud.getEmpleado());
			entity.persist(solicitud1);
			entity.getTransaction().commit();
			FacesMessage message = new FacesMessage("Se guardó la solicitud con éxito");
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, message);
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> mostrar() {
		List<Solicitud> solicitud = null;
		Query query = entity.createQuery("FROM Solicitud s");
		solicitud = query.getResultList();
		return solicitud;
	}


}