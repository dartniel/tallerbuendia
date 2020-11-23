const placaModificar = document.getElementById('formModificarVehiculo:placa');
const colorModificar = document.getElementById('formModificarVehiculo:color');
const chasisModificar = document.getElementById('formModificarVehiculo:chasis');
const marcaCarroModificar = document.getElementById('formModificarVehiculo:marcaCarro1');
const formularioModificarVehiculo = document.getElementById('formModificarVehiculo');
const botonModificarVehiculo = document.getElementById('formModificarVehiculo:modificarVehiculo');
botonModificarVehiculo.addEventListener('click', function(e){
    //Instanciar la interfaz
    const ui = new InterfazModificarVehiculo();
    //Comprobar que los campos no estem vacíos
    if(placaModificar.value === '' || colorModificar.value === '' || chasisModificar.value === '' || marcaCarroModificar.value === ''){
       ui.camposVacios('No pueden quedar campos vacíos', 'error');
       e.preventDefault();
    }
   
})

placaModificar.addEventListener('blur', function(e){
    const ui = new InterfazModificarVehiculo();
    if(placaModificar.value.length > 0){
        document.querySelector('.placaClass').remove();
    }

    if(placaModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','placaDiv', 'placaClass');
    }
})

colorModificar.addEventListener('blur', function(e){
    const ui = new InterfazModificarVehiculo();
    if(colorModificar.value.length > 0){
        document.querySelector('.colorClass').remove();
    }

    if(colorModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','colorDiv', 'colorClass');
    }
})

chasisModificar.addEventListener('blur', function(e){
    const ui = new InterfazModificarVehiculo();
    if(chasisModificar.value.length > 0){
        document.querySelector('.chasisClass').remove();
    }

    if(chasisModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','chasisDiv', 'chasisClass');
    }
})

marcaCarroModificar.addEventListener('change', function(e){
    const ui = new InterfazModificarVehiculo();
    if(marcaCarroModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','marcaDiv', 'marcaCarroClass');
    }else{
        document.querySelector('.marcaCarroClass').remove();
    }
})



class InterfazModificarVehiculo{

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
        document.querySelector('#, mensaje').insertBefore(divMensaje, formularioModificarVehiculo);
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

function validarSoloNumerosVehiculo(regexString) {
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

