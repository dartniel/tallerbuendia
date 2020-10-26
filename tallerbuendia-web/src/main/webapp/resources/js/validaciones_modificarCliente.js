const buttonModificarCliente = document.getElementById('formModificarCliente:buttonCliente');
const formularioModificarCliente = document.getElementById('formModificarCliente');

// Inputs
const nombreModificarCliente = document.getElementById('formModificarCliente:nombreCliente');
const apellidoModificarCliente = document.getElementById('formModificarCliente:apellidoCliente');
const fechaModificarCliente = document.getElementById('formModificarCliente:fechaNacimientoCliente');
const duiModificar = document.getElementById('formModificarCliente:dui');
const nitModificar = document.getElementById('formModificarCliente:nit');
const telefonoModificarCliente= document.getElementById('formModificarCliente:telefonoCliente');
const lugarTrabajoModificar = document.getElementById('formModificarCliente:lugarTrabajo');
const telefonoTrabajoModificar = document.getElementById('formModificarCliente:telefonoTrabajo');
const tipoSeguroModificar = document.getElementById('formModificarCliente:tipoSeguro');
const aseguradoraModificarCliente = document.getElementById('formModificarCliente:aseguradoraCliente');
const mensajeExitoModificarCliente = document.getElementById('formModificarCliente:mensajeExito');

if(buttonModificarCliente){
	// Instanciar la interfaz
	buttonModificarCliente.addEventListener('click', function(e){
	    // Instanciar la interfaz
	    const ui = new InterfazModificarCliente();
	    // Comprobar que los campos no estem vacíos
	    if( nombreModificarCliente.value === '' ||  apellidoModificarCliente.value === '' || fechaModificarCliente.value === '' || duiModificar.value === '' || nitModificar.value === '' || telefonoModificarCliente.value === '' ){
	       ui.camposVacios('No pueden quedar campos vacíos', 'error');
	       e.preventDefault();
	    }

	    if(duiModificar.value.length < 8){
	        ui.inputMensaje('Este campo debe tener 9 dígitos.', 'error','duiClienteDivModificar','duiClienteClass');
	        e.preventDefault();
	    }
	   
	})

	document.addEventListener('DOMContentLoaded', function(e){
	    const ui = new InterfazModificarCliente();
	    if(mensajeExitoModificarCliente.firstChild){
	        ui.camposVacios(mensajeExitoModificarCliente.textContent, 'exito');
	       mensajeExitoModificarCliente.removeChild(mensajeExitoModificarCliente.firstChild)
	    }

	})

	nombreModificarCliente.addEventListener('blur', function(e){
	    const ui = new InterfazModificarCliente();
	    if(nombreModificarCliente.value.length > 0){
	        document.querySelector('.nombreClienteClass').remove();
	    }

	    if(nombreModificarCliente.value.length <= 0){
	        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','nombreClienteDivModificar', 'nombreClienteClass');
	    }
	})

	apellidoModificarCliente.addEventListener('blur', function(e){
	    const ui = new InterfazModificarCliente();
	    if(apellidoModificarCliente.value.length > 0){
	        document.querySelector('.apellidoClienteClass').remove();
	    }

	    if(apellidoModificarCliente.value.length <= 0){
	        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','apellidoClienteDivModificar', 'apellidoClienteClass');
	    }
	})

	fechaModificarCliente.addEventListener('blur', function(e){
	    const ui = new InterfazModificarCliente();
	    if(fechaModificarCliente.value.length <= 0){
	        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','fechaNacimientoDivModificar', 'fechaNacimientoClass');
	    }
	    if(fechaModificarCliente.value.length > 0){
	        document.querySelector('.fechaNacimientoClass').remove();
	    }
	})

	duiModificar.addEventListener('blur', function(e){
	    const ui = new InterfazModificarCliente();
	    if(duiModificar.value.length > 0){
	        document.querySelector('.duiClienteClass').remove();
	    }
	    if(duiModificar.value.length <= 0){
	        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','duiClienteDivModificar','duiClienteClass');
	    } 
	    if(duiModificar.value.length < 9){
	        ui.inputMensaje('Este campo debe tener 9 dígitos.', 'error','duiClienteDivModificar','duiClienteClass');
	    }
	})
	nitModificar.addEventListener('blur', function(e){
	    const ui = new InterfazModificarCliente();
	    if(nitModificar.value.length > 0){
	        document.querySelector('.nitClienteClass').remove();
	    }

	    if(nitModificar.value.length <= 0){
	        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','nitClienteDivModificar', 'nitClienteClass');
	    }
	})
	telefonoModificarCliente.addEventListener('blur', function(e){
	    const ui = new InterfazModificarCliente();
	    if(telefonoModificarCliente.value.length > 0){
	        document.querySelector('.telefonoClienteClass').remove();
	    }

	    if(telefonoModificarCliente.value.length <= 0){
	        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','telefonoClienteDivModificar', 'telefonoClienteClass');
	    }
	})


	class InterfazModificarCliente{

	    camposVacios(mensaje,tipo){
	        const divMensaje = document.createElement('div');
	        divMensaje.classList.add('text-center', 'alert');
	        if(tipo === 'error'){
	            divMensaje.classList.add('alert-danger','alert-dismissible','fade','show');
	        }else{
	            divMensaje.classList.add('alert-success','alert-dismissible','fade','show', 'exito');
	        }

	        const texto = `
	        ${mensaje}
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        `;
	        divMensaje.innerHTML = texto;
	        document.querySelector('#mensaje').insertBefore(divMensaje, formularioModificarCliente);
	    }
	 
	    inputMensaje(mensaje,tipo, id, classes){
	        const divMensaje = document.createElement('div');
	        divMensaje.classList.add('text-center', 'alert');
	        if(tipo === 'error'){
	            divMensaje.classList.add('alert-danger','alert-dismissible','fade','show', classes);
	        }else{
	            divMensaje.classList.add('alert-success');
	        }

	        const texto = `
	        ${mensaje}
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        `;
	        divMensaje.innerHTML = texto;
	        // Insertar en el DOM
	        document.querySelector(`#${id}`).appendChild(divMensaje);
	        // Quitar el alert después de 3 segundos
	            
	            
	       
	    }
	}

	function validarSoloNumerosCliente(regexString) {
	    var theEvent = window.event || event;
	    var key = theEvent.keyCode || theEvent.which;
	    if (key >= 46 || key <= 57) {
	        key = String.fromCharCode(key);
	        var regex = new RegExp("^" + regexString + "$");
	        if (!regex.test(key)) {
	            theEvent.returnValue = false;
	            if (theEvent.preventDefault) {
	                theEvent.preventDefault();
	            }
	        }
	    }
	}


}