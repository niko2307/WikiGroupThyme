document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('contactForm');
    const fields = {
        name: { maxChars: 50, counter: document.getElementById('nameCounter') },
        lastname: { maxChars: 50, counter: document.getElementById('lastnameCounter') },
        email: { maxChars: 100, counter: document.getElementById('emailCounter') },
        descripcion: { maxChars: 200, counter: document.getElementById('descripcionCounter') }
    };
    const errorMessageDiv = document.getElementById('errorMessage');
    const messageDiv = document.querySelector('.message');

    // Función para actualizar el contador de caracteres y validar la longitud
    function updateCounter(field, counter, maxChars) {
        const currentLength = field.value.length;

        counter.textContent = `${currentLength}/${maxChars}`;

        if (currentLength > maxChars) {
            field.classList.add('error');
            errorMessageDiv.textContent = `El campo "${field.getAttribute('id')}" ha excedido el número máximo de caracteres (${maxChars}).`;
        } else {
            field.classList.remove('error');
            errorMessageDiv.textContent = '';
        }
    }

    // Añadir eventos de input a cada campo
    for (const fieldName in fields) {
        const field = form.querySelector(`#${fieldName}`);
        const maxChars = fields[fieldName].maxChars;
        const counter = fields[fieldName].counter;

        field.addEventListener('input', function() {
            updateCounter(field, counter, maxChars);
        });
    }

    // Al enviar el formulario
    form.addEventListener('submit', function(event) {
        let isValid = true;

        // Verificar todas las validaciones antes de enviar
        for (const fieldName in fields) {
            const field = form.querySelector(`#${fieldName}`);
            const maxChars = fields[fieldName].maxChars;
            updateCounter(field, fields[fieldName].counter, maxChars);

            if (field.value.length > maxChars) {
                isValid = false;
            }
        }

        if (!isValid) {
            event.preventDefault(); // Previene el envío del formulario si hay errores
            return;
        }

        // Mostrar mensaje de confirmación y limpiar el formulario
        if (messageDiv) {
            messageDiv.classList.add('visible');
            setTimeout(function() {
                messageDiv.classList.remove('visible');
                form.reset(); // Limpia el formulario después de 3 segundos
                for (const fieldName in fields) {
                    fields[fieldName].counter.textContent = `0/${fields[fieldName].maxChars}`;
                }
            }, 3000);
        }
    });
});
