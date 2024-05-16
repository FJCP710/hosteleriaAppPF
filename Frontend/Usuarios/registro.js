function submitForm() {
    const form = document.getElementById('registroForm');
    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch('http://localhost:8080/crearUsuario', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch((error) => {
        console.error('Error:', error);
    });
}