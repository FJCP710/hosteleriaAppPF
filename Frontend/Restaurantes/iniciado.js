document.addEventListener('DOMContentLoaded', function() {

    const regex = /correo=([^&]+)/;
    const match = document.cookie.match(regex);
    let correo;
    if (match) {
        correo = match[1];
        console.log(correo);
    }
    
    let urlId = `http://localhost:9080/idPorCorreo?correo=${correo}`;

    fetch(urlId, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        let urlReservas = `http://localhost:8080/listarPorIdRestaurante?idRestaurante=${data}`;
        return fetch(urlReservas, {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            }
        });
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        let tabla = document.getElementById('tabla');

        data.forEach(reserva => {
            console.log(reserva);

            let tr = document.createElement('tr');

            let tdNombre = document.createElement('td');
            tdNombre.textContent = reserva.nombreReserva;
            tr.appendChild(tdNombre);

            let tdNum = document.createElement('td');
            tdNum.textContent = reserva.numPersonas;
            tdNum.style.textAlign = "center";
            tr.appendChild(tdNum);

            let tdFecha = document.createElement('td');
            tdFecha.textContent = formatearFecha(reserva.fecha);
            tr.appendChild(tdFecha);

            let tdDel = document.createElement('td');
            let del = document.createElement('input');
            del.setAttribute("type", "button");
            del.setAttribute("value", "Eliminar");
            
            tdDel.appendChild(del);
            tr.appendChild(tdDel);

            tabla.appendChild(tr);

            del.setAttribute("onclick", `eliminarReserva(${reserva.idReserva}, ${reserva.idUsuario}, ${reserva.idRestaurante},
                '${reserva.nombreReserva}', ${reserva.numPersonas}, '${reserva.fecha}')`);

        });

    })
    .catch((error) => {
        console.error('Error:', error);
    });
    

});

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
