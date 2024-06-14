document.addEventListener('DOMContentLoaded', (event) =>{

    let boton = document.getElementById('incluir').addEventListener('click', incluir);
    let cerrarSesion = document.getElementById("cierre").addEventListener("click", ()=>{
        document.cookie = 'sesion=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
        window.location.href='../index/index.html';
    });
})


function incluir() {
    let nombreProducto = document.getElementById('nombreProducto').value;
    let precio = parseFloat(document.getElementById('precio').value);
    let dimension = document.getElementById('dimension').value;
    const producto = {
        nombre: nombreProducto,
        precio: precio,
        dimension: dimension
    }

    let porcentaje = parseFloat(document.getElementById('porcentaje').value);
    let precioMin = parseFloat(document.getElementById('precioMin').value);

    const urlProductos = `http://localhost:9060/crearProducto`;

    fetch(urlProductos, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(producto)
    })
    .then(response => response.text())
    .then(text => {
        console.log(text);

        if (text === "Producto creado con éxito") {
            console.log('Producto creado');
            
            const urlIdNombre = `http://localhost:9060/idPorNombre?nombre=${producto.nombre}`;

            fetch(urlIdNombre, {
                method: 'POST',
                mode: 'cors',
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => response.text())
            .then(idProducto =>{

                const regex = /correo=([^&]+)/;
                const match = document.cookie.match(regex);
                let correo;
                if (match) {
                    correo = match[1];
                    console.log(correo);
                }

                const urlIdRestaurante = `http://localhost:9080/idPorCorreo?correo=${correo}`;

                fetch(urlIdRestaurante,{
                    method: 'POST',
                    mode: 'cors',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(response => response.text())
                .then(idRestaurante =>{
                    const promocion = {
                        idRestaurante: idRestaurante,
                        idProducto: idProducto,
                        porcentaje: porcentaje,
                        precioMin: precioMin
                    }

                    const urlCrearPromocion = `http://localhost:9070/crearPromocion`;

                    fetch(urlCrearPromocion,{
                        method: 'POST',
                        mode: 'cors',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(promocion)
                    }).then(response => response.text())
                    .then(text =>{

                        if(text === 'Promoción creado con éxito'){
                            alert("Promoción creada con éxito");
                            location.reload();
                        }

                    }).catch((error) => {
                        console.error('Error:', error);
                    });
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    
        } else {
            console.error('Error', error);
        }

    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

