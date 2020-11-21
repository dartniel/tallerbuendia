package sv.com.taller.controllers;

 

import java.util.List;

 

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

 

import sv.com.taller.entities.Automovil;
import sv.com.taller.entities.Cliente;
import sv.com.taller.entities.DetalleCarro;
import sv.com.taller.repositories.AutomovilRepository;

 

@Named("Automovil")
@RequestScoped
public class AutomovilController {

 

    private List<Automovil> mostrarAutomovilCliente;
    private Automovil accionAutomovil;
    
    public Automovil getAccionAutomovil() {
        return accionAutomovil;
    }

 

    public void setAccionAutomovil(Automovil accionAutomovil) {
        this.accionAutomovil = accionAutomovil;
    }

 

    @PostConstruct
    public void init() {
        this.accionAutomovil=new Automovil();
        this.accionAutomovil.setCliente(new Cliente());
        this.accionAutomovil.setDetalleCarro(new DetalleCarro());
    }
    @EJB
    private AutomovilRepository automovilRepository;

 

    public List<Automovil> getMostrarAutomovilCliente() {
        return mostrarAutomovilCliente;
    }
    
    public void modificarAutomovil() {
        automovilRepository.modificarAutomovil(accionAutomovil);
    }

 

}
 