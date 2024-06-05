document.addEventListener('DOMContentLoaded', function() {
    buscarRestaurantes('Sevilla');

    
});

let botonBuscar = document.getElementById('botonBuscar');
botonBuscar.addEventListener('click', function() {
    let ciudad = document.getElementById('localidad').value;
    let calle = document.getElementById('calle').value;
    
    buscarRestaurantes(ciudad, calle);
});

let cerrarSesion = document.getElementById("cierre").addEventListener("click", ()=>{
    document.cookie = 'sesion=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    window.location.href='../index/index.html';
})

function buscarRestaurantes(ciudad, calle = '') {
    let url = `http://localhost:9080/buscarRestaurantesCiudad?ciudad=${ciudad}`;

    if (calle.trim().length > 0) {
        url = `http://localhost:9080/restaurantesPorCalle?ciudad=${ciudad}&calle=${calle}`;
    }

    fetch(url)
        .then(response => response.json())
        .then(data => {
            document.querySelector('main h2').innerText = `Restaurantes en ${ciudad}`;
            let restaurantes = document.getElementById('restaurantes');

            restaurantes.innerHTML = '';
            data.forEach(restaurante => {
                let li = document.createElement('li');
                let res = document.createElement('input');
                res.setAttribute("type", "button");
                res.setAttribute("value", "Reservar");
                li.textContent = restaurante.nombreComercial +" ";
                restaurantes.appendChild(li);
                li.appendChild(res);
                res.setAttribute("onclick", `reservar('${restaurante.razonSocial}');`);
            });
        })
        .catch(error => console.error('Error:', error));
}

function reservar(razonSocial) {
    document.getElementById('reservation_section').style.display = 'block';

    var now = new Date(),
    minDateTime = now.toISOString().substring(0,16);
    document.getElementById('reservation_datetime').min = minDateTime;
    
    var reservationForm = document.getElementById('reservation_form');
    reservationForm.removeEventListener('submit', submitHandler); // Eliminar el controlador de eventos anterior
    reservationForm.addEventListener('submit', submitHandler); // Añadir el nuevo controlador de eventos

function submitHandler(event){
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

    let urlIdCorreo = `http://localhost:8080/idPorCorreo?correo=${correo}`;
    let urlIdRestaurante = `http://localhost:9080/cogerIdPorRazonSocial?razonSocial=${razonSocial}`;

    Promise.all([
        fetch(urlIdCorreo, {
            method: 'POST',
            mode: 'no-cors',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json()),
        fetch(urlIdRestaurante,{
            method: 'POST',
            mode:'no-cors',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
    ])
    .then(([idUsuario, idRestaurante]) => {

        console.log('Datos del primer fetch:', idUsuario);
        console.log('Datos del segundo fetch:', idRestaurante);
        var reserva = {
            idUsuario: idUsuario,
            idRestaurante: idRestaurante,
            nombreReserva: nombreReserva,
            numPersonas: numPersonas,
            fecha: fecha
            };
        console.log("Datos combinados", reserva)

        let urlReserva = `http://localhost:9090/crearReserva`;

        return fetch(urlReserva, {
            method: 'POST',
            mode: 'no-cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reserva)
        })
    })
    .then(data3 => {
        alert("Reserva creada con éxito");
    })
    .catch(error => {
        alert("La reserva no ha podido ser creada");
        console.error('Error:', error);
    });

    var reservationSection = document.getElementById('reservation_section');
    var reservationTitle = document.getElementById('reservation_title');

    reservationSection.style.backgroundColor = 'lightgrey';
    reservationTitle.style.color = 'blue';
    }
}

