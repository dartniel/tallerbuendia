const button = document.getElementById('registroRepuesto:button');
const formulario = document.getElementById('registroRepuesto');
button.addEventListener('click', function(e){
    // Leer del formulario de gastos
    const idRepuesto = document.getElementById('registroRepuesto:idRepuesto').value;
    const nombre= document.getElementById('registroRepuesto:nombre').value;
    const proveedor = document.getElementById('registroRepuesto:proveedor').value;
    const marcaRepuesto = document.getElementById('registroRepuesto:marcaRepuesto').value;
    const costo = document.getElementById('registroRepuesto:costo').value;
    const precioVenta = document.getElementById('registroRepuesto:precioVenta').value;
    const cantidad = document.getElementById('registroRepuesto:cantidad').value;
    const fechaAdquisicion = document.getElementById('registroRepuesto:fechaAdquisicion').value;

    // Instanciar la interfaz
    const ui = new Interfaz();
    // Comprobar que los campos no estem vacíos
    if(idRepuesto === '' || nombre === '' || proveedor === '' || marcaRepuesto === '' || costo === '' || precioVenta === '' || cantidad === '' || fechaAdquisicion === ''){
        // 2 parámetros mensaje y tipo
       ui.camposVacios('No pueden quedar campos vacíos', 'error');
       e.preventDefault();
    }
    if(idRepuesto.length >= 6){
        ui.inputMensaje('ID Repuesto debe llevar solo 5 caracteres', 'error', 'idRepuestoDiv');
        e.preventDefault();
        }
    
        if(nombre.length >= 40){
            ui.inputMensaje('El nombre del repuesto debe tener menos de 25 caracteres', 'error', 'nombreDiv');
            e.preventDefault();
        }
        
        if(marcaRepuesto.length >= 25){
            ui.inputMensaje('La marca del repuesto debe tener menos de 25 caracteres', 'error', 'marcaRepuestoDiv');
            e.preventDefault();
        }
        
        const dia = new Date().getDate();
        const mes = new Date().getMonth();
        const año = new Date().getFullYear();
        const fechaSeleccionada = fechaAdquisicion.split('-');
        if(fechaSeleccionada[2] > dia || fechaSeleccionada[1] > (mes+1) || fechaSeleccionada[0] > año){
            ui.inputMensaje(`La fecha seleccionada no puede ser mayor que hoy ${dia}/${mes}/${año}`, 'error', 'fechaAdquisicionDiv');
            e.preventDefault();
        }
        if(costo < 0 ){
            ui.inputMensaje('El costo no puede ser negativo', 'error', 'costoDiv');
            e.preventDefault();
        } 
        if(costo.length > 3){
            ui.inputMensaje('El costo no puede superar los 4 dígitos', 'error', 'costoDiv');
            e.preventDefault();
        }

        if(precioVenta < 0 ){
            ui.inputMensaje('El precio de venta no puede ser negativo', 'error', 'precioVentaDiv');
            e.preventDefault();
        }
        
        if(precioVenta.length > 3){
                ui.inputMensaje('El precio de venta no puede superar los 4 dígitos', 'error', 'precioVentaDiv');
                e.preventDefault();
            }

        if(cantidad < 0 ){
            ui.inputMensaje('La cantidad no puede ser negativo', 'error', 'cantidadDiv');
            e.preventDefault();
        }

   
    
    // ui.camposVacios('Se agregó el repuesto correctamente', 'correcto');

})

class Interfaz{

    camposVacios(mensaje,tipo){
        const divMensaje = document.createElement('div');
        divMensaje.classList.add('text-center', 'alert');
        if(tipo === 'error'){
            divMensaje.classList.add('alert-danger');
        }else{
            divMensaje.classList.add('alert-success');
        }

        divMensaje.appendChild(document.createTextNode(mensaje));
        // Insertar en el DOM
        document.querySelector('.mensaje').insertBefore(divMensaje, formulario);
        // Quitar el alert después de 3 segundos
        setTimeout(function(){
            document.querySelector('.mensaje .alert').remove();
        },5000)
    }
    inputMensaje(mensaje,tipo, id){
        const divMensaje = document.createElement('div');
        divMensaje.classList.add('text-center', 'alert');
        if(tipo === 'error'){
            divMensaje.classList.add('alert-danger');
        }else{
            divMensaje.classList.add('alert-success');
        }

        divMensaje.appendChild(document.createTextNode(mensaje));
        // Insertar en el DOM
        document.querySelector(`#${id}`).appendChild(divMensaje);
        // Quitar el alert después de 3 segundos
        setTimeout(function(){
            document.querySelector('.alert-danger').remove();
            
        },5000)
    }
}