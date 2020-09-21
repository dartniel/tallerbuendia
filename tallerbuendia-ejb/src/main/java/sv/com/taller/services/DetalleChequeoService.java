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
import sv.com.taller.repositories.DetalleChequeoRepository;

@Stateless
public class DetalleChequeoService implements DetalleChequeoRepository {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleChequeo> mostrar(Chequeo chequeo) {
		List<DetalleChequeo> detalleChequeo = null;
		Query query = entity.createQuery("FROM DetalleChequeo d WHERE d.chequeo = :chequeo");
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
			
			if(nuevaExistencia < 0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El stock no tiene los suministros necesarios", null));
			}else {
				valorExistencia.setCantidad(nuevaExistencia);
				entity.getTransaction().begin();
				entity.merge(valorExistencia);
				entity.getTransaction().commit();
			}
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}

}
