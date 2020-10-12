const buttonCliente = document.getElementById('registroCliente:buttonCliente');
const formularioCliente = document.getElementById('registroCliente');

//Inputs
const nombreCliente = document.getElementById('registroCliente:nombreCliente');
const apellidoCliente = document.getElementById('registroCliente:apellidoCliente');
const fechaNacimientoCliente = document.getElementById('registroCliente:fechaNacimientoCliente');
const dui = document.getElementById('registroCliente:dui');
const nit = document.getElementById('registroCliente:nit');
const telefonoCliente= document.getElementById('registroCliente:telefonoCliente');
const lugarTrabajo = document.getElementById('registroCliente:lugarTrabajo');
const telefonoTrabajo = document.getElementById('registroCliente:telefonoTrabajo');
const tipoSeguro = document.getElementById('registroCliente:tipoSeguro');
const aseguradoraCliente = document.getElementById('registroCliente:aseguradoraCliente');
const placa = document.getElementById('registroCliente:placa');
const color = document.getElementById('registroCliente:color');
const chasis = document.getElementById('registroCliente:chasis');
const marcaCarro = document.getElementById('registroCliente:marcaCarro');
const mensajeExitoCliente = document.getElementById('registroCliente:mensajeExito');
//Instanciar la interfaz
buttonCliente.addEventListener('click', function(e){
    //Instanciar la interfaz
    const ui = new InterfazCliente();
    //Comprobar que los campos no estem vacíos
    if( nombreCliente.value === '' ||  apellidoCliente.value === '' || fechaNacimientoCliente.value === '' || dui.value === '' || nit.value === '' || telefonoCliente.value === '' || lugarTrabajo.value === ''
    || telefonoTrabajo.value === '' || tipoSeguro.value === '' || aseguradoraCliente.value === '' || placa.value === '' || color.value === '' || chasis.value === '' || marcaCarro.value === ''){
       ui.camposVacios('No pueden quedar campos vacíos', 'error');
       e.preventDefault();
    }

    if(dui.value.length < 8){
        ui.inputMensaje('Este campo debe tener 9 dígitos.', 'error','duiClienteDiv','duiClienteClass');
        e.preventDefault();
    }
   
})

document.addEventListener('DOMContentLoaded', function(e){
    const ui = new InterfazCliente();
    if(mensajeExitoCliente.firstChild){
        ui.camposVacios(mensajeExitoCliente.textContent, 'exito');
        mensajeExitoCliente.removeChild(mensajeExitoCliente.firstChild)
    }

})

nombreCliente.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(nombreCliente.value.length > 0){
        document.querySelector('.nombreClienteClass').remove();
    }

    if(nombreCliente.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','nombreClienteDiv', 'nombreClienteClass');
    }
})

apellidoCliente.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(apellidoCliente.value.length > 0){
        document.querySelector('.apellidoClienteClass').remove();
    }

    if(apellidoCliente.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','apellidoClienteDiv', 'apellidoClienteClass');
    }
})

fechaNacimientoCliente.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(fechaAdquisicion.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','fechaNacimientoDiv', 'fechaNacimientoClass');
    }
    if(fechaAdquisicion.value.length > 0){
        document.querySelector('.fechaNacimientoClass').remove();
    }
})

dui.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(dui.value.length > 0){
        document.querySelector('.duiClienteClass').remove();
    }
    if(dui.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','duiClienteDiv','duiClienteClass');
    } 
    if(dui.value.length < 9){
        ui.inputMensaje('Este campo debe tener 9 dígitos.', 'error','duiClienteDiv','duiClienteClass');
    }
})
nit.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(nit.value.length > 0){
        document.querySelector('.nitClienteClass').remove();
    }

    if(nit.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','nitClienteDiv', 'nitClienteClass');
    }
})
telefonoCliente.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(telefonoCliente.value.length > 0){
        document.querySelector('.telefonoClienteClass').remove();
    }

    if(telefonoCliente.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','telefonoClienteDiv', 'telefonoClienteClass');
    }
})

lugarTrabajo.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(lugarTrabajo.value.length > 0){
        document.querySelector('.lugarTrabajoClass').remove();
    }

    if(lugarTrabajo.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','lugarTrabajoDiv', 'lugarTrabajoClass');
    }
})

telefonoTrabajo.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(telefonoTrabajo.value.length > 0){
        document.querySelector('.telefonoTrabajoClass').remove();
    }

    if(telefonoTrabajo.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','telefonoTrabajoDiv', 'telefonoTrabajoClass');
    }
})

tipoSeguro.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(tipoSeguro.value.length > 0){
        document.querySelector('.tipoSeguroClass').remove();
    }

    if(tipoSeguro.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','tipoSeguroDiv', 'tipoSeguroClass');
    }
})

aseguradoraCliente.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(aseguradoraCliente.value.length > 0){
        document.querySelector('.aseguradoraClass').remove();
    }

    if(aseguradoraCliente.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','aseguradoraDiv', 'aseguradoraClass');
    }
})


placa.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(placa.value.length > 0){
        document.querySelector('.placaClass').remove();
    }

    if(placa.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','placaDiv', 'placaClass');
    }
})

color.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(color.value.length > 0){
        document.querySelector('.colorClass').remove();
    }

    if(color.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','colorDiv', 'colorClass');
    }
})

chasis.addEventListener('blur', function(e){
    const ui = new InterfazCliente();
    if(chasis.value.length > 0){
        document.querySelector('.chasisClass').remove();
    }

    if(chasis.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','chasisDiv', 'chasisClass');
    }
})

marcaCarro.addEventListener('change', function(e){
    const ui = new InterfazCliente();
    if(marcaCarro.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','marcaDiv', 'marcaCarroClass');
    }else{
        document.querySelector('.marcaCarroClass').remove();
    }
})

class InterfazCliente{

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
        document.querySelector('.mensaje').insertBefore(divMensaje, formularioCliente);
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

