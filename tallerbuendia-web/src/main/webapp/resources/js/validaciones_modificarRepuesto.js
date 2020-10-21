const button1 = document.getElementById('formModificar:button1');
const formularioModificarRepuesto = document.getElementById('formModificar');

//Inputs
const idRepuestoModificar = document.getElementById('formModificar:idRepuesto');
const nombreModificar= document.getElementById('formModificar:nombre');
const proveedorModificar= document.getElementById('formModificar:proveedor');
const marcaRepuestoModificar = document.getElementById('formModificar:marcaRepuesto');
const costoModificar = document.getElementById('formModificar:costo');
const precioVentaModificar= document.getElementById('formModificar:precioVenta');
const cantidadModificar = document.getElementById('formModificar:cantidad');
const fechaAdquisicionModificar = document.getElementById('formModificar:fechaAdquisicion');
const mensajeExitoRepuestoModificar = document.getElementById('formModificar:mensajeExito');

//Instanciar la InterfazRepuesto
button1.addEventListener('click', function(e){
    //Instanciar la InterfazRepuesto
    const ui = new InterfazRepuestoModificar();
    //Comprobar que los campos no estem vacíos
    if( nombreModificar.value === '' ||  costoModificar.value === '' || precioVentaModificar.value === '' || cantidadModificar.value === '' || fechaAdquisicionModificar === '' || proveedorModificar.value === ''){
       ui.camposVacios('No pueden quedar campos vacíos', 'error');
       e.preventDefault();
    }
    if(costoModificar.value === '0.0'|| costoModificar.value === '0'){
        ui.inputMensaje('El costo no puede ser 0', 'error', 'costoDivModificar', 'costoClass');
        e.preventDefault();
    }
    if(precioVenta.value === '0.0' || precioVenta.value === '0'){
        ui.inputMensaje('El precio de venta no puede ser 0', 'error', 'precioVentaDivModificar', 'precioVentaClass');
        e.preventDefault();
    }
    if(cantidad.value === '0' ){
        ui.inputMensaje('La cantidad no puede ser 0', 'error', 'cantidadDivModificar', 'cantidadClass');
        e.preventDefault();
    }
    if(proveedor.value === ''){
        ui.inputMensaje('Este campo no puede quedar vacío', 'error', 'proveedorDivModificar', 'proveedorClass');
        e.preventDefault();
    }
})

document.addEventListener('DOMContentLoaded', function(e){
    const ui = new InterfazRepuestoModificar();
    if(mensajeExitoRepuestoModificar.firstChild){
        ui.camposVacios(mensajeExitoRepuestoModificar.textContent, 'exito');
        mensajeExitoRepuestoModificar.removeChild(mensajeExitoRepuestoModificar.firstChild)
    }
})

nombreModificar.addEventListener('blur', function(e){
    const ui = new InterfazRepuestoModificar();

    if(nombreModificar.value.length > 0){
        document.querySelector('.nombreClass').remove();
    }

    if(nombreModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','nombreDiv', 'nombreClass');
    }
})
fechaAdquisicionModificar.addEventListener('blur', function(e){
    const ui = new InterfazRepuestoModificar();
    if(fechaAdquisicionModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','fechaAdquisicionDivModificar', 'fechaAdquisicionClass');
    }
    if(fechaAdquisicionModificar.value.length > 0){
        document.querySelector('.fechaAdquisicionClass').remove();
    }
})

costoModificar.addEventListener('blur', function(e){
    const ui = new InterfazRepuestoModificar();
   
    if(costoModificar.value.length > 0){
        document.querySelector('.costoClass').remove();
    }

    if(costoModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','costoDivModificar','costoClass');
    } 
 
    if(costoModificar.value === '0.0'){
        ui.inputMensaje('El costo no puede ser 0', 'error', 'costoDivModificar', 'costoClass');
        e.preventDefault();
    }
    if(costoModificar.value === '0'){
        ui.inputMensaje('El costo no puede ser 0', 'error', 'costoDivModificar', 'costoClass');
        e.preventDefault();
    }
  
    
})
precioVentaModificar.addEventListener('blur', function(e){
    const ui = new InterfazRepuestoModificar();
    if(precioVentaModificar.value < 0){
        ui.inputMensaje('El precio de venta no puede ser negativo', 'error', 'precioVentaDivModificar', 'precioVentaClass');
        e.preventDefault();
    }
    if(precioVentaModificar.value.length > 0){
        document.querySelector('.precioVentaClass').remove();
    }

    if(precioVentaModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','precioVentaDivModificar', 'precioVentaClass');
    }
    
    if(precioVentaModificar.value === '0.0'){
        ui.inputMensaje('El precio de venta no puede ser 0', 'error', 'precioVentaDivModificar', 'precioVentaClass');
        e.preventDefault();
    }
    if(precioVentaModificar.value === '0'){
        ui.inputMensaje('El precio de venta no puede ser 0', 'error', 'precioVentaDivModificar', 'precioVentaClass');
        e.preventDefault();
    }
    
})

cantidadModificar.addEventListener('blur', function(e){
    const ui = new InterfazRepuestoModificar();
    if(cantidadModificar.value === '0' ){
        ui.inputMensaje('La cantidad no puede ser 0', 'error', 'cantidadDivModificar', 'cantidadClass');
        e.preventDefault();
    }
    if(cantidadModificar.value.length > 0){
        document.querySelector('.cantidadClass').remove();
    }

    if(cantidadModificar.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','cantidadDivModificar', 'cantidadClass');
    }
    
})


class InterfazRepuestoModificar{

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
        document.querySelector('.mensaje').insertBefore(divMensaje, formularioRepuesto);
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

function validarSoloNumerosRepuesto(regexString) {
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

function validarCosto(regexString) {
    var theEvent = window.event || event;
    var key = theEvent.keyCode || theEvent.which;
    const longitudCosto = costo.value.length;
    const longitudPrecioVenta = precioVenta.value.length;
    if(costo.value.includes('.')){
        const posicion = costo.value.indexOf('.');
        if(longitudCosto === (posicion+3)){
        	theEvent.returnValue = false;
        }
    }
    if (key> 31 && (key< 48 || key> 57) && key!= 46){
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
function validarPrecioVenta(regexString) {
    var theEvent = window.event || event;
    var key = theEvent.keyCode || theEvent.which;
    const longitudPrecioVenta = precioVenta.value.length;
    if(precioVenta.value.includes('.')){
        const posicion = precioVenta.value.indexOf('.');
        if(longitudPrecioVenta=== (posicion+3)){
                theEvent.returnValue = false;
        }

    }
    if (key> 31 && (key< 48 || key> 57) && key!= 46){
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
