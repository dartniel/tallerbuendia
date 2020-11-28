package sv.com.taller.controllers;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.io.Serializable;

@Named("User")
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName = "";
	private String lastName = "";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String user() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getName());
		return authentication.getName();
	}

	public String redirectUser() {
		if (user().equals("JC220313")) {
			return "agregarNuevoCliente?faces-redirect=true";
		} else {
			return null;
		}

	}

	// No permite regresar al login
	public void onPageLoad() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			try {
				// Hacer una pagina 404
				FacesContext.getCurrentInstance().getExternalContext().redirect("agregarNuevoCliente.xhtml");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}