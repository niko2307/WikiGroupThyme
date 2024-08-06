document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const messageDiv = document.querySelector('.message');

    if (form) {
        form.addEventListener('submit', function(event) {
            event.preventDefault();  // Prevenir el envío real del formulario para pruebas

            // Mostrar mensaje de confirmación
            if (messageDiv) {
                messageDiv.classList.add('visible');  // Mostrar el mensaje
                setTimeout(function() {
                    messageDiv.classList.remove('visible'); // Ocultar el mensaje después de 3 segundos
                    form.reset();  // Limpiar el formulario después de ocultar el mensaje
                }, 3000); // 3 segundos
            }
        });
    }
});
