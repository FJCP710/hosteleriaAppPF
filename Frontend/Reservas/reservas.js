document.addEventListener('DOMContentLoaded', function() {
    
    const regex = /correo=([^&]+)/;
    const match = document.cookie.match(regex);
    let correo;
    if (match) {
        correo = match[1];
        console.log(correo);
    }

    
    let urlIdCorreo = `http://localhost:9090/idPorCorreo?correo=${correo}`;
    
    fetch(urlIdCorreo, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(idUsuario => {
        console.log('Datos del primer fetch:', idUsuario);

        let urlListadoReservas = `http://localhost:8080/listarPorUsuario?idUsuario=${idUsuario}`;

        return fetch(urlListadoReservas, {method: 'POST',headers: {'Content-Type': 'application/json'}})
    })
    .then(response => response.json())
    .then(listadoReservas => {
        console.log('Datos del segundo fetch:', listadoReservas);
        let reservas = document.getElementById('tabla'); 

        listadoReservas.forEach(reserva => {
            let tr = document.createElement('tr');
            
            let tdNombre = document.createElement('td');
            tdNombre.textContent = reserva.nombreReserva ;
            tr.appendChild(tdNombre);

            let tdNum = document.createElement('td');
            tdNum.textContent = reserva.numPersonas;
            tdNum.style.textAlign = "center";
            tr.appendChild(tdNum);

            let tdRest = document.createElement('td');
            tdRest.textContent = "Restaurante";
            tr.appendChild(tdRest);

            let tdFecha = document.createElement('td');
            tdFecha.textContent = formatearFecha(reserva.fecha);
            tr.appendChild(tdFecha);

            let tdMod = document.createElement('td');
            let mod = document.createElement('input');
            mod.setAttribute("type", "button");
            mod.setAttribute("value", "Modificar");

            let del = document.createElement('input');
            del.setAttribute("type", "button");
            del.setAttribute("value", "Eliminar");
            
            tdMod.appendChild(mod);
            tdMod.appendChild(del);
            tr.appendChild(tdMod);

            reservas.appendChild(tr);

            mod.setAttribute("onclick", `modificarReserva(${reserva.idReserva}, ${reserva.idUsuario}, ${reserva.idRestaurante})`);
            del.setAttribute("onclick", `eliminarReserva(${reserva.idReserva}, ${reserva.idUsuario}, ${reserva.idRestaurante},
                '${reserva.nombreReserva}', ${reserva.numPersonas}, '${reserva.fecha}')`);

        });

    })
    .catch(error => {
        console.error('Error:', error);
    });
});

function modificarReserva(idReserva, idUsuario, idRestaurante) {
    document.getElementById('modificacion').style.display = 'block';

    var now = new Date(),
    minDateTime = now.toISOString().substring(0,16);
    document.getElementById('reservation_datetime').min = minDateTime;
    
    var form = document.getElementById('modificacion_form');
    if (form.eventListener) {
        form.removeEventListener('submit', form.eventListener);
    }

    form.eventListener = function(event) {
        event.preventDefault();
      
        var nombreReserva = document.getElementById('reservation_name').value;
        var numPersonas = document.getElementById('num_people').value;
        var fecha = document.getElementById('reservation_datetime').value;
    

        const regex = /correo=([^&]+)/;
        const match = document.cookie.match(regex);
        let correo;
        if (match) {
            correo = match[1];
            console.log(correo);
        }

        let urlModificacion = `http://localhost:8080/modificarReserva`;

        var reservaMod = {
            idReserva: idReserva,
            idUsuario: idUsuario,
            idRestaurante: idRestaurante,
            nombreReserva: nombreReserva,
            numPersonas: numPersonas,
            fecha: fecha
        };

        console.log(reservaMod);

        fetch(urlModificacion,{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservaMod)
        })
        .then(response => {
            response.json();
        })
        .then(modificado => {
            console.log(modificado);
            alert(`Reserva en ${reservaMod.restaurante} con fecha ${reservaMod.fecha} modificado`);
            location.reload()
        })
        .catch((error) => console.error('Error:', error));
    };

    form.addEventListener('submit', form.eventListener);
};


function eliminarReserva(idReserva, idUsuario, idRestaurante, nombreReserva, numPersonas, fecha) {
    let url = `http://localhost:8080/eliminarReserva`;

    var reservaDel = {
        idReserva: idReserva,
        idUsuario: idUsuario,
        idRestaurante: idRestaurante,
        nombreReserva: nombreReserva,
        numPersonas: numPersonas,
        fecha: fecha
    };

    fetch(url,{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reservaDel)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Error al eliminar reserva: ${response.status}`);
        }
        return response.text();
    })
    .then(text => {
        alert(`Reserva en ${reservaDel.restaurante} con fecha ${reservaDel.fecha} eliminada`)
        location.reload();
    })
    .catch((error) => console.error('Error:', error));
}

function formatearFecha(fechaISO) {
    let fecha = new Date(fechaISO);
    let opciones = { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit' };

    return fecha.toLocaleString('es-ES', opciones);
};

let cerrarSesion = document.getElementById("cierre").addEventListener("click", ()=>{
    document.cookie = 'sesion=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    window.location.href='../index/index.html';
});