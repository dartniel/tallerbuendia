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
import sv.com.taller.entities.Cliente;
import sv.com.taller.repositories.ClienteRepository;

@Stateless
public class ClienteService implements ClienteRepository{

	String codigo = generarCodigo();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void agregarCliente(Cliente cliente) {
		
		try {
			entity.getTransaction().begin();
			
			String cod = cliente.getNombre().substring(0,1)+ cliente.getApellido().substring(0,1) + codigo;
			cliente.setIdCliente(cod);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		    System.out.println(sdf.format(timestamp));
			Cliente clientes = new Cliente(cod, cliente.getApellido(),cliente.getAseguradora(),cliente.getTipoSeguro(),
					cliente.getDui(), cliente.getFechaNacimiento(), cliente.getLugarTrabajo(), cliente.getTelefonoTrabajo(),cliente.getNit(), cliente.getNombre(), cliente.getTelefono(), sdf.format(timestamp));
			entity.persist(clientes);
			entity.getTransaction().commit();
			FacesMessage message = new FacesMessage("El Cliente "+ cliente.getNombre()+" con <strong>ID: "+ codigo +" </strong>se agregó al invetario");
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, message);
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificar(Cliente cliente) {
		try {
			entity.getTransaction().begin();
			entity.merge(cliente);
			entity.getTransaction().commit();
			System.out.println("Cliente Modificado");
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(Cliente cliente) {
		try {
			entity.getTransaction().begin();
			entity.remove(cliente);
			entity.getTransaction().commit();
			System.out.println("Cliente Elimado");
		}catch(Exception e) {
			entity.close();
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> mostrar() {
		List<Cliente> Clientes = null;
		Query query = entity.createQuery("FROM Cliente c");
		Clientes = query.getResultList();
		return Clientes;
	}

	
	public String generarCodigo() {
		 Random rand = new Random(); 
		int nuevoCodigo = rand.nextInt(1000); 
		return String.valueOf(nuevoCodigo);
	}
	
}
