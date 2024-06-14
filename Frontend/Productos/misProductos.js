document.addEventListener('DOMContentLoaded', (event) =>{

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
        
        const urlPromociones = `http://localhost:9070/listarPromocionesPorRestaurante?idRestaurante=${idRestaurante}`;

        fetch(urlPromociones,{
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
        .then(promociones =>{
            console.log(promociones);
            let arrayIdProm = [];
            promociones.forEach(p => {
                arrayIdProm.push(p.idProducto);
            });

            console.log("PROMOCIONES: ", arrayIdProm);

            const urlProductos = `http://localhost:9060/listarPorId?idsProductos=${arrayIdProm}`;

            fetch(urlProductos,{
                method: 'POST',
                mode: 'cors',
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => response.json())
            .then(productos =>{

                console.log("PRODUCTOS",productos);

                productos.forEach(producto =>{
                    let tr = document.createElement('tr');
            
                    let tdNombre = document.createElement('td');
                    tdNombre.textContent = producto.nombre;
                    tr.appendChild(tdNombre);
            
                    let tdPrecio = document.createElement('td');
                    tdPrecio.textContent = producto.precio;
                    tr.appendChild(tdPrecio);
            
                    let tdDimension = document.createElement('td');
                    tdDimension.textContent = producto.dimension;
                    tr.appendChild(tdDimension);
            
                    let promocion = promociones.find(p => p.idProducto === producto.idProducto);
                    if (promocion) {
                        let tdPorcentaje = document.createElement('td');
                        tdPorcentaje.textContent = promocion.porcentaje;
                        tr.appendChild(tdPorcentaje);
            
                        let tdPrecioMin = document.createElement('td');
                        tdPrecioMin.textContent = promocion.precioMin;
                        tr.appendChild(tdPrecioMin);
                    }

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

                    // mod.setAttribute("onclick", `modificar(${producto.nombre}, ${producto.precio}, ${producto.dimension},
                    //     '${promocion.idRestaurante}', ${promocion.idProducto}, ${promocion.porcentaje}, ${promocion.precioMin})`);
                    del.setAttribute("onclick", `eliminar('${producto.nombre}', ${producto.precio}, '${producto.dimension}',
                        ${promocion.idRestaurante}, ${promocion.idProducto}, ${promocion.porcentaje}, ${promocion.precioMin})`);
            
                    document.getElementById('tabla').appendChild(tr);
                })

            });

        }).catch((error) => {
            console.error('Error:', error);
        });

    }).catch((error) => {
        console.error('Error:', error);
    });

    let cerrarSesion = document.getElementById("cierre").addEventListener("click", ()=>{
        document.cookie = 'sesion=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
        window.location.href='../index/index.html';
    });
});

async function eliminar(nombre, precio, dimension, idRestaurante, idProducto, porcentaje, precioMin) {
    const promocion = {
        idRestaurante: idRestaurante,
        idProducto: idProducto,
        porcentaje: porcentaje,
        precioMin: precioMin
    }

    const urlDelProm = `http://localhost:9070/eliminarPromocion`;

    try {
        const response = await fetch(urlDelProm,{
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(promocion),
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (response.ok) {
            const responseBody = await response.text();
            if (responseBody === "Promoción eliminada con éxito") {
                eliminarProd(nombre, precio, dimension);
            } else {
                console.log(`Error: ${responseBody}`);
            }
        } else {
            console.log(`Error: ${response.status} - ${response.statusText}`);
        }
    } catch (error) {
        console.error('Error:', error);
    }
}




function eliminarProd(nombre, precio, dimension) {
    const producto ={
        nombre: nombre,
        precio: precio,
        dimension: dimension
    }

    const urlDelProd =`http://localhost:9060/eliminarProducto`;

    fetch(urlDelProd,{
        method: 'POST',
        mode: 'cors',
        body: JSON.stringify(producto),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
    .then(prod =>{
        alert(`Promoción eliminada`);
        location.reload()
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}




