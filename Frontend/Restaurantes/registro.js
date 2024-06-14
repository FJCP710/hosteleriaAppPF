function submitForm() {
    const nombreComercial = document.getElementById('nombreComercial').value;
    const razonSocial = document.getElementById('razonSocial').value;
    const calle = document.getElementById('calle').value;
    const numero = document.getElementById('numero').value;
    const ciudad = document.getElementById('ciudad').value;
    const aforo = document.getElementById('aforo').value;
    const mesasDisponibles = document.getElementById('mesasDisponibles').value;
    const reservarLocal = document.getElementById('reservarLocal').checked;
    const correo = document.getElementById('correo').value;
    const contra = document.getElementById('contra').value;

    const url = 'http://localhost:9080/crearRestaurante';

    console.log(reservarLocal);

    var restaurante = {
        nombreComercial: nombreComercial,
        razonSocial: razonSocial,
        calle: calle,
        numero: numero,
        ciudad: ciudad,
        aforo: aforo,
        mesasDisponibles: mesasDisponibles,
        reservarLocal: reservarLocal,
        correo: correo,
        contra: contra
    }

    console.log(restaurante);

    fetch(url, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(restaurante)
    })
    .then(response => response.text())
    .then(text => {
        console.log(text);
        if (text === "Usuario creado con éxito") {
            console.log('Inicio de sesión exitoso');
    
            var cookieExpiration = new Date(Date.now() + 3600000);
            var password = contra;
            var censoredPassword = password.replace(/./g, "*");
            var mail = correo;
    
            var cookieValue = `correo=${mail}&password=${censoredPassword}`;
            document.cookie = `sesion=${cookieValue}; expires=${cookieExpiration.toUTCString()}; path=/`;
    
            window.location.href = 'iniciado.html';
    
        } else {
            console.error('Error en el inicio de sesión');
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}