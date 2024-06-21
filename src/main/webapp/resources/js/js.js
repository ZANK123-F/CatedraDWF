window.addEventListener('scroll', function() {
    var navbar = document.querySelector('.navbar');
    var header = document.querySelector('header');
    var headerHeight = header.offsetHeight;

    if (window.scrollY > headerHeight) {
        navbar.style.backgroundColor = '#fff'; // Cambiar el color de la barra de navegación cuando no está sobre el encabezado
    } else {
        navbar.style.backgroundColor = 'rgba(255, 255, 255, 0.5)'; // Restaurar el color de fondo original
    }
});