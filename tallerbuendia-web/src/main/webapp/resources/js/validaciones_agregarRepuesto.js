const button = document.getElementById('registroRepuesto:button');
const formularioRepuesto = document.getElementById('registroRepuesto');

//Inputs
const idRepuesto = document.getElementById('registroRepuesto:idRepuesto');
const nombre= document.getElementById('registroRepuesto:nombre');
const proveedor = document.getElementById('registroRepuesto:proveedor');
const marcaRepuesto = document.getElementById('registroRepuesto:marcaRepuesto');
const costo = document.getElementById('registroRepuesto:costo');
const precioVenta = document.getElementById('registroRepuesto:precioVenta');
const cantidad = document.getElementById('registroRepuesto:cantidad');
const fechaAdquisicion = document.getElementById('registroRepuesto:fechaAdquisicion');
const mensajeExitoRepuesto = document.getElementById('registroRepuesto:mensajeExito');

//Instanciar la InterfazRepuesto
button.addEventListener('click', function(e){
    //Instanciar la InterfazRepuesto
    const ui = new InterfazRepuesto();
    //Comprobar que los campos no estem vacíos
    if( nombre.value === '' ||  costo.value === '' || precioVenta.value === '' || cantidad.value === '' || fechaAdquisicion === '' || proveedor.value === ''){
       ui.camposVacios('No pueden quedar campos vacíos', 'error');
       e.preventDefault();
    }

    if(nombre.value.length > 25 ){
        ui.inputMensaje('El nombre del repuesto debe tener menos de 25 caracteres', 'error', 'nombreDiv', 'nombreClass');
        e.preventDefault();
    }

    if(costo.value < 0 ){
        ui.inputMensaje('El costo no puede ser negativo', 'error', 'costoDiv', 'costoClass');
        e.preventDefault();
    } 
    if(costo.value.length > 5){
        ui.inputMensaje('El costo no puede superar los 4 dígitos', 'error', 'costoDiv', 'costoClass');
        e.preventDefault();
    }
    if(costo.value === '0.0'){
        ui.inputMensaje('El costo no puede ser 0', 'error', 'costoDiv', 'costoClass');
        e.preventDefault();
    }
    if(precioVenta.value < 0 ){
        ui.inputMensaje('El precio de venta no puede ser negativo', 'error', 'precioVentaDiv', 'precioVentaClass');
        e.preventDefault();
    }
    
    if(precioVenta.value.length > 5){
            ui.inputMensaje('El precio de venta no puede superar los 4 dígitos', 'error', 'precioVentaDiv', 'precioVentaClass');
            e.preventDefault();
        }
    if(precioVenta.value === '0.0'){
        ui.inputMensaje('El precio de venta no puede ser 0', 'error', 'precioVentaDiv', 'precioVentaClass');
        e.preventDefault();
    }

    if(cantidad.value < 0 ){
        ui.inputMensaje('La cantidad no puede ser negativo', 'error', 'cantidadDiv', 'cantidadClass');
        e.preventDefault();
    }
    if(cantidad.value === '0' ){
        ui.inputMensaje('La cantidad no puede ser 0', 'error', 'cantidadDiv', 'cantidadClass');
        e.preventDefault();
    }
    if(proveedor.value === ''){
        ui.inputMensaje('Este campo no puede quedar vacío', 'error', 'proveedorDiv', 'proveedorClass');
        e.preventDefault();
    }




})

document.addEventListener('DOMContentLoaded', function(e){
    const ui = new InterfazRepuesto();
    if(mensajeExitoRepuesto.firstChild){
        ui.camposVacios(mensajeExitoRepuesto.textContent, 'exito');
        mensajeExitoRepuesto.removeChild(mensajeExitoRepuesto.firstChild)
    }
})

nombre.addEventListener('blur', function(e){
    const ui = new InterfazRepuesto();
    if(nombre.value.length > 25){
        ui.inputMensaje('El nombre del repuesto debe tener menos de 25 caracteres', 'error', 'nombreDiv', 'nombreClass');
        e.preventDefault();
    }

    if(nombre.value.length > 0){
        document.querySelector('.nombreClass').remove();
    }

    if(nombre.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','nombreDiv', 'nombreClass');
    }
})
fechaAdquisicion.addEventListener('blur', function(e){
    const ui = new InterfazRepuesto();
    if(fechaAdquisicion.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','fechaAdquisicionDiv', 'fechaAdquisicionClass');
    }
    if(fechaAdquisicion.value.length > 0){
        document.querySelector('.fechaAdquisicionClass').remove();
    }
})

costo.addEventListener('blur', function(e){
    const ui = new InterfazRepuesto();
    const costoFloat = parseFloat(costo.value);
    if(costo.value.length > 0){
        document.querySelector('.costoClass').remove();
    }

    if(costo.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','costoDiv','costoClass');
    } 
    if(costoFloat <= 0 ){
        ui.inputMensaje('El costo no puede ser negativo', 'error', 'costoDiv', 'costoClass');
        e.preventDefault();
    } 
    if(costo.value.length > 5){
        ui.inputMensaje('El costo no puede superar los 4 dígitos', 'error', 'costoDiv', 'costoClass');
        e.preventDefault();
    }
    if(costo.value === '0.0'){
        ui.inputMensaje('El costo no puede ser 0', 'error', 'costoDiv', 'costoClass');
        e.preventDefault();
    }
    if(costo.value === '0'){
        ui.inputMensaje('El costo no puede ser 0', 'error', 'costoDiv', 'costoClass');
        e.preventDefault();
    }
  
    
})
precioVenta.addEventListener('blur', function(e){
    const ui = new InterfazRepuesto();
    if(precioVenta.value < 0){
        ui.inputMensaje('El precio de venta no puede ser negativo', 'error', 'precioVentaDiv', 'precioVentaClass');
        e.preventDefault();
    }
    if(precioVenta.value.length > 5){
            ui.inputMensaje('El precio de venta no puede superar los 4 dígitos', 'error', 'precioVentaDiv', 'precioVentaClass');
            e.preventDefault();
    }
    if(precioVenta.value.length > 0){
        document.querySelector('.precioVentaClass').remove();
    }

    if(precioVenta.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','precioVentaDiv', 'precioVentaClass');
    }
    
    if(precioVenta.value === '0.0'){
        ui.inputMensaje('El precio de venta no puede ser 0', 'error', 'precioVentaDiv', 'precioVentaClass');
        e.preventDefault();
    }
    if(precioVenta.value === '0'){
        ui.inputMensaje('El precio de venta no puede ser 0', 'error', 'precioVentaDiv', 'precioVentaClass');
        e.preventDefault();
    }
    
})
cantidad.addEventListener('focus', function(e){
    const ui = new InterfazRepuesto();
    if(cantidad.value.includes('-')){
        ui.inputMensaje('La cantidad no puede ser negativo', 'error', 'cantidadDiv', 'cantidadClass');
        e.preventDefault();
    }
    if(cantidad.value === '0' ){
        ui.inputMensaje('La cantidad no puede ser 0', 'error', 'cantidadDiv', 'cantidadClass');
        e.preventDefault();
    }
    if(cantidad.value === '0.0' ){
        ui.inputMensaje('La cantidad no puede ser 0', 'error', 'cantidadDiv', 'cantidadClass');
        e.preventDefault();
    }
    if(cantidad.value.length > 0){
        document.querySelector('.cantidadClass').remove();
    }

    if(cantidad.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','cantidadDiv', 'cantidadClass');
    }
    
})
cantidad.addEventListener('blur', function(e){
    const ui = new InterfazRepuesto();
    if(cantidad.value < 0 ){
        ui.inputMensaje('La cantidad no puede ser negativo', 'error', 'cantidadDiv', 'cantidadClass');
        e.preventDefault();
    }
    if(cantidad.value === 0 ){
        ui.inputMensaje('La cantidad no puede ser 0', 'error', 'cantidadDiv', 'cantidadClass');
        e.preventDefault();
    }
    if(cantidad.value.length > 0){
        document.querySelector('.cantidadClass').remove();
    }

    if(cantidad.value.length <= 0){
        ui.inputMensaje('Este campo no puede quedar vacío.', 'error','cantidadDiv', 'cantidadClass');
    }
    
})


class InterfazRepuesto{

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