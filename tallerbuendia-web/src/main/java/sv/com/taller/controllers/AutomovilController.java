package sv.com.taller.controllers;

 

import java.util.List;

 

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

 

import sv.com.taller.entities.Automovil;
import sv.com.taller.entities.Chequeo;
import sv.com.taller.entities.Cliente;
import sv.com.taller.entities.DetalleCarro;
import sv.com.taller.entities.DetalleChequeo;
import sv.com.taller.repositories.AutomovilRepository;
import sv.com.taller.repositories.ChequeoRepository;
import sv.com.taller.repositories.DetalleChequeoRepository;

 

@Named("Automovil")
@RequestScoped
public class AutomovilController {
	
    private List<Automovil> mostrarAutomovilCliente;
    private List<Automovil> mostrar;
    private Automovil accionAutomovil;
    private Automovil automovil;
    private Chequeo chequeo;
    private List<DetalleChequeo> detalleChequeo;
    
    public Automovil getAccionAutomovil() {
        return accionAutomovil;
    }

    public void setAccionAutomovil(Automovil accionAutomovil) {
        this.accionAutomovil = accionAutomovil;
    }

    public Chequeo getChequeo() {
		return chequeo;
	}

	public void setChequeo(Chequeo chequeo) {
		this.chequeo = chequeo;
	}

	public List<DetalleChequeo> getDetalleChequeo() {
		return detalleChequeo;
	}

	@PostConstruct
    public void init() {
        this.accionAutomovil=new Automovil();
        this.accionAutomovil.setCliente(new Cliente());
        this.accionAutomovil.setDetalleCarro(new DetalleCarro());
    }
    @EJB
    private AutomovilRepository automovilRepository;
    
    @EJB
    private ChequeoRepository chequeoRepsitory;
    
    @EJB
    private DetalleChequeoRepository detalleChequeoRepository;
 
    public List<Automovil> getMostrarAutomovilCliente() {
        return mostrarAutomovilCliente;
    }
    public void agregarAutomovilUnico() {
    	automovilRepository.agregarAutomovilUnico(automovil);
    }
    
    public void modificarAutomovil() {
        automovilRepository.modificarAutomovil(accionAutomovil);
    }

	public List<Automovil> getMostrar() {
		mostrar = automovilRepository.mostrar();
		return mostrar;
	}
	
	public String redirectBitacora() {
		chequeo = chequeoRepsitory.buscarChequeo(accionAutomovil.getCliente().getIdCliente());
		detalleChequeo = detalleChequeoRepository.buscar(chequeo);
		return "bitacoraReparacion";
	}
}
 