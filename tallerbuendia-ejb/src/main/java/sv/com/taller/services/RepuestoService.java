package sv.com.taller.services;

import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.taller.JPAUtils.JPAUtil;
import sv.com.taller.entities.Repuesto;
import sv.com.taller.repositories.RepuestoRepository;

@Stateless
public class RepuestoService implements RepuestoRepository{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void agregar(Repuesto repuesto) {
		
		try {
			entity.getTransaction().begin();
			String codigo = generarCodigo();
			Repuesto repuestos = new Repuesto(codigo,repuesto.getCantidad(),repuesto.getCosto(),
					repuesto.getFechaAdquisicion(), repuesto.getNombre(),repuesto.getPrecioVenta(),repuesto.getMarcaProveedor());
			entity.persist(repuestos);
			entity.getTransaction().commit();
			FacesMessage message = new FacesMessage("El Repuesto "+ repuesto.getNombre()+" con <strong>ID: "+ codigo +" </strong>se agregó al invetario");
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, message);
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificar(Repuesto repuesto) {
		try {
			entity.getTransaction().begin();
			entity.merge(repuesto);
			entity.getTransaction().commit();
			System.out.println("Repuesto Modificado");
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(Repuesto repuesto) {
		try {
			entity.getTransaction().begin();
			entity.remove(repuesto);
			entity.getTransaction().commit();
			System.out.println("Repuesto Elimado");
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Repuesto> mostrar() {
		List<Repuesto> repuestos = null;
		Query query = entity.createQuery("FROM Repuesto r");
		repuestos = query.getResultList();
		return repuestos;
	}

	
	public String generarCodigo() {
		 Random rand = new Random(); 
		int nuevoCodigo = rand.nextInt(10000); 
		return String.valueOf(nuevoCodigo);
	}
}
