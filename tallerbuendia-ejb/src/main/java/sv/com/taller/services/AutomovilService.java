package sv.com.taller.services;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.Automovil;
import sv.com.taller.entities.Cliente;
import sv.com.taller.repositories.AutomovilRepository;

@Stateless
public class AutomovilService implements AutomovilRepository{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void agregarAutomovil(Automovil automovil, Cliente cliente) {
		Cliente obj = new Cliente();
		Query query = entity.createQuery("FROM Cliente c WHERE c.idCliente = :idCliente");
		query.setParameter("idCliente", cliente.getIdCliente());
		obj = (Cliente) query.getSingleResult();
		try {
				entity.getTransaction().begin();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			    Automovil automoviles = new Automovil(automovil.getChasis(), automovil.getColor(), automovil.getObservacion(), automovil.getPlaca(), obj, automovil.getDetalleCarro(), timestamp);
				entity.persist(automoviles);
				entity.getTransaction().commit();
			}catch(Exception e) {
				entity.close();
				e.printStackTrace();
			}
			
		}
	@SuppressWarnings("unchecked")
	@Override
	public List<Automovil> mostrarAutomovilCliente() {
		List<Automovil> automovilCliente=null;
		Query query=entity.createQuery("FROM Automovil as a");
		automovilCliente=query.getResultList();
		return automovilCliente;
	}
	@Override
	public void modificarAutomovil(Automovil automovil) {
	
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public Automovil llenarAutomovil(int id) {
		
		Automovil automovilCliente=null;
		Query query=entity.createQuery("FROM Automovil as a where a.idAutomovil=:idAutomovil");
		query.setParameter("idAutomovil",id);
		automovilCliente=(Automovil) query.getSingleResult();
		System.out.println(automovilCliente);
		return automovilCliente;
		
	}


	
}
