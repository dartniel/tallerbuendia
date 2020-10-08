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
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void agregarAutomovil(Automovil automovil,Cliente cliente) {
		Cliente obj = new Cliente();
		Query query = entity.createQuery("FROM Cliente c where c.idCliente = :idCliente");
		query.setParameter("idCliente", cliente.getIdCliente());
		obj = (Cliente) query.getSingleResult();
		System.out.println(cliente);
		try {
				entity.getTransaction().begin();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			    System.out.println(sdf.format(timestamp));
			    Automovil automoviles = new Automovil(automovil.getChasis(), automovil.getColor(), automovil.getObservacion(), automovil.getPlaca(), cliente, automovil.getDetalleCarro());
				entity.persist(automoviles);
				entity.getTransaction().commit();
			}catch(Exception e) {
				entity.close();
				e.printStackTrace();
			}
			
		}


	
}
