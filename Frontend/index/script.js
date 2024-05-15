document.addEventListener('DOMContentLoaded', function() {
    buscarRestaurantes('Sevilla');
});

let botonBuscar = document.getElementById('botonBuscar');
botonBuscar.addEventListener('click', function() {
    let ciudad = document.getElementById('localidad').value;
    let calle = document.getElementById('calle').value;
    
    buscarRestaurantes(ciudad, calle);
});

function buscarRestaurantes(ciudad, calle = '') {
    let url = `http://localhost:9080/buscarRestaurantesCiudad?ciudad=${ciudad}`;

    if (calle.trim().length > 0) {
        url = `http://localhost:9080/restaurantesPorCalle?ciudad=${ciudad}&calle=${calle}`;
    }

    fetch(url)
        .then(response => response.json())
        .then(data => {
            let restaurantes = document.getElementById('restaurantes');

            restaurantes.innerHTML = '';
            data.forEach(restaurante => {
                let li = document.createElement('li');
                li.textContent = restaurante.nombreComercial;
                restaurantes.appendChild(li);
            });
        })
        .catch(error => console.error('Error:', error));
}
