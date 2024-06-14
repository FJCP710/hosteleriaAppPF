const loginButton = document.getElementById('iniciarSesion');

loginButton.addEventListener('click', submitForm);

function submitForm() {
    const form = document.getElementById('loginForm');
    const correo = document.getElementById('correo').value;
    const contra = document.getElementById('contra').value;

    const url = 'http://localhost:9080/inicioSesion';
    fetch(url, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ correo: correo, contra: contra })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log(data)
        if (data) {
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

let cerrarSesion = document.getElementById("cierre").addEventListener("click", ()=>{
    document.cookie = 'sesion=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    window.location.href='../index/index.html';
});