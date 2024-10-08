document.addEventListener('DOMContentLoaded', function () {
  // Bloque 1: Manejo del formulario de contacto
  const form = document.getElementById('contactForm');
  const fields = {
    name: { maxChars: 50, counter: document.getElementById('nameCounter') },
    lastname: {
      maxChars: 50,
      counter: document.getElementById('lastnameCounter'),
    },
    email: { maxChars: 100, counter: document.getElementById('emailCounter') },
    descripcion: {
      maxChars: 200,
      counter: document.getElementById('descripcionCounter'),
    },
  };
  const errorMessageDiv = document.getElementById('errorMessage');
  const messageDiv = document.querySelector('.message');

  // Función para actualizar el contador de caracteres y validar la longitud
  function updateCounter(field, counter, maxChars) {
    const currentLength = field.value.length;

    counter.textContent = `${currentLength}/${maxChars}`;

    if (currentLength > maxChars) {
      field.classList.add('error');
      errorMessageDiv.textContent = `El campo "${field.getAttribute(
        'id'
      )}" ha excedido el número máximo de caracteres (${maxChars}).`;
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

    field.addEventListener('input', function () {
      updateCounter(field, counter, maxChars);
    });
  }

  // Al enviar el form
  form.addEventListener('submit', function (event) {
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
      event.preventDefault(); // Previene el envío del form si hay errores
      return;
    }

    // Mostrar mensaje de confirmación y limpiar el form
    if (messageDiv) {
      messageDiv.classList.add('visible');
      setTimeout(function () {
        messageDiv.classList.remove('visible');
        form.reset(); // Limpia el form después de 3 segundos
        for (const fieldName in fields) {
          fields[
            fieldName
          ].counter.textContent = `0/${fields[fieldName].maxChars}`;
        }
      }, 3000);
    }
  });

<<<<<<< HEAD
  // Bloque 2: Manejo del modal de pruebas
=======
// para pruebas 

document.addEventListener('DOMContentLoaded', function () {
>>>>>>> 54640bfc09c351ce95bde98bb4b7a38b6485ba92
  const pruebaItems = document.querySelectorAll('.prueba-item');
  const modalOverlay = document.getElementById('modal-overlay');
  const modalClose = document.getElementById('modal-close');
  const modalTitle = document.getElementById('modal-title');
  const modalImage = document.getElementById('modal-image');
  const modalDescription = document.getElementById('modal-description');

  pruebaItems.forEach((item) => {
    item.addEventListener('click', function () {
      // Obtener la información de la prueba
      const title = this.querySelector('.prueba-text h3').textContent;
      const imageSrc = this.querySelector('.prueba-imagen').src;
      const description = this.querySelector('.prueba-text p').textContent;

      // Actualizar el contenido del modal
      modalTitle.textContent = title;
      modalImage.src = imageSrc;
      modalDescription.textContent = description;

      // Mostrar el modal
      modalOverlay.style.display = 'flex';
    });
  });

  // Cerrar el modal al hacer clic en el botón de cierre o en el overlay
  modalClose.addEventListener('click', function () {
    modalOverlay.style.display = 'none';
  });

  modalOverlay.addEventListener('click', function (event) {
    if (event.target === modalOverlay) {
      modalOverlay.style.display = 'none';
    }
  });
});

