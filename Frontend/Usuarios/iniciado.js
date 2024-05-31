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
            });
        })
        .catch(error => console.error('Error:', error));
}
