const buttonAgregarSolicitud = document.getElementById('registroSolicitud:button');
const formularioSolicitud = document.getElementById('registroSolicitud');

//Inputs
const fechaSolicitud = document.getElementById('registroSolicitud:fechaSolicitud');
const descripcionSolicitud= document.getElementById('registroSolicitud:descripcionSolicitud');
const cantidadSolicitud = document.getElementById('registroSolicitud:cantidadSolicitud');
const proveedorSolicitud = document.getElementById('registroSolicitud:proveedorSolicitud');
const empleadoSolicitud = document.getElementById('registroSolicitud:empleadoSolicitud');
const mensajeExitoSolicitud = document.getElementById('registroSolicitud:mensajeExito');

buttonAgregarSolicitud.addEventListener('click', function(e){
    //Instanciar la InterfazAgregarSolicitud
    const ui = new InterfazAgregarSolicitud();
    //Comprobar que los campos no estem vacíos
    if( fechaSolicitud.value === '' ||  descripcionSolicitud.value === '' || cantidadSolicitud.value === '' || proveedorSolicitud.value === '' || empleadoSolicitud.value === ''){
       ui.camposVacios('No pueden quedar campos vacíos', 'error');
       e.preventDefault();
    }
    if(descripcionSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','descripcionSolicitudDiv', 'descripcionClass');
    }
    if(cantidadSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','cantidadSolicitudDiv', 'cantidadSolicituClass');
    }
    if(proveedorSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','proveedorSolicitudDiv', 'proveedorSolicitudClass');
    }
    
    if(empleadoSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','empleadoSolicitudDiv', 'empleadoSolicitudClass');
    }
    if(fechaSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','fechaSolicitudDiv', 'fechaSolicitudClass');
    }
})
document.addEventListener('DOMContentLoaded', function(e){
    const ui = new InterfazAgregarSolicitud();
    if(mensajeExitoSolicitud.firstChild){   
        ui.camposVacios(mensajeExitoSolicitud.textContent, 'exito');
        mensajeExitoSolicitud.removeChild(mensajeExitoSolicitud.firstChild)
    }

   cantidadSolicitud.value = '';
})

descripcionSolicitud.addEventListener('blur', function(e){
    const ui = new InterfazAgregarSolicitud();

    if(descripcionSolicitud.value.length > 0){
        document.querySelector('.descripcionClass').remove();
    }

    if(descripcionSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','descripcionSolicitudDiv', 'descripcionClass');
    }
})

cantidadSolicitud.addEventListener('blur', function(e){
    const ui = new InterfazAgregarSolicitud();
    if(cantidadSolicitud.value === '0' ){
        ui.inputMensaje('La cantidad no puede ser 0', 'error', 'cantidadSolicitudDiv', 'cantidadSolicitudClass');
        e.preventDefault();
    }
    if(cantidadSolicitud.value.length > 0){
        document.querySelector('.cantidadSolicitudClass').remove();
    }

    if(cantidadSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','cantidadSolicitudDiv', 'cantidadSolicituClass');
    }
    
})

proveedorSolicitud.addEventListener('change', function(e){
    const ui = new InterfazAgregarSolicitud();

    if(proveedorSolicitud.value.length > 0){
        document.querySelector('.proveedorSolicitudClass').remove();
    }

    if(proveedorSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','proveedorSolicitudDiv', 'proveedorSolicitudClass');
    }
})
empleadoSolicitud.addEventListener('change', function(e){
    const ui = new InterfazAgregarSolicitud();

    if(empleadoSolicitud.value.length > 0){
        document.querySelector('.empleadoSolicitudClass').remove();
    }

    if(empleadoSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','empleadoSolicitudDiv', 'empleadoSolicitudClass');
    }
})

fechaSolicitud.addEventListener('blur', function(e){
    const ui = new InterfazAgregarSolicitud();
    if(fechaSolicitud.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','fechaSolicitudDiv', 'fechaSolicitudClass');
    }
    if(fechaSolicitud.value.length > 0){
        document.querySelector('.fechaSolicitudClass').remove();
    }
})

class InterfazAgregarSolicitud{

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
        document.querySelector('.mensaje').insertBefore(divMensaje, formularioSolicitud);
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
        //Insertar en el DOM
        document.querySelector(`#${id}`).appendChild(divMensaje);
        //Quitar el alert después de 3 segundos
            
            
       
    }
}

function validarSoloNumerosSolicitud(regexString) {
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

