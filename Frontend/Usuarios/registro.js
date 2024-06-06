function submitForm() {
    const form = document.getElementById('registroForm');
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const fechaNacimiento = document.getElementById('fecha_nacimiento').value;
    const usuario = document.getElementById('usuario').value;
    const contra = document.getElementById('contraseña').value;
    const correo = document.getElementById('correo').value;

    const url = 'http://localhost:9090/crearUsuario';
    var user ={
        nombre: nombre, 
        apellido: apellido, 
        fechaNacimiento: fechaNacimiento, 
        usuario: usuario,
        correo: correo, 
        contra: contra 
    }

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
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