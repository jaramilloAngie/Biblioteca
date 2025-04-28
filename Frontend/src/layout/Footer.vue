<template>
    <footer class="main-footer">
      <div class="footer-content">
        <div class="footer-section">
          <h3><b>Sobre nosotros</b></h3>
          <ul>
            <li><a href="#">¿Quiénes somos?</a></li>
            <li><a href="#">Misión y visión</a></li>
          </ul>
        </div>
  
        <div class="footer-section">
          <h3><b>Enlaces rápidos</b></h3>
          <ul>
            <li><a href="#">Catálogo</a></li>
            <li><a href="#">Iniciar sesión</a></li>
            <li><a href="#">Registro</a></li>
          </ul>
        </div>
  
        <div class="footer-section">
          <h3><b>Síguenos</b></h3>
          <ul>
            <li><a href="#">Facebook</a></li>
            <li><a href="#">Instagram</a></li>
          </ul>
        </div>
      </div>
      <div class="footer-bottom">
        <p>LeeMás. Todos los derechos reservados</p>
      </div>
    </footer>
  </template>
  
  <script setup>
  // No se necesita lógica de script adicional para este footer estático
  </script>
  
  <style scoped>
  .main-footer {
    background-color: #C9A66B; /* Color similar al de la imagen */
    color: #000; /* Texto negro para contraste */
    padding: 20px;
    text-align: center; /* Centra el texto por defecto */
  }
  
  .footer-content {
    display: flex;
    justify-content: space-around; /* Espacio uniforme entre las secciones */
    margin-bottom: 20px;
    text-align: left; /* Alinea el texto de las secciones a la izquierda */
  }
  
  .footer-section {
    flex: 1;
    justify-items: center; /* Distribuye el espacio de manera igualitaria entre las secciones */
  }
  
  .footer-section h3 {
    margin-top: 0;
    margin-bottom: 10px;
  }
  
  .footer-section ul {
    list-style: disc;
    padding-left: 20px;
    margin: 0;
  }
  
  .footer-section li {
    margin-bottom: 5px;
  }
  
  .footer-section a {
    color: #000;
    text-decoration: none;
  }
  
  .footer-section a:hover {
    text-decoration: underline;
  }
  
  .footer-bottom {
    border-top: 1px solid rgba(0, 0, 0, 0.1); /* Línea sutil en la parte superior */
    padding-top: 10px;
    font-size: 0.9em;
  }
  
  /* Media query para hacerlo más responsivo en pantallas más pequeñas */
  @media (max-width: 768px) {
    .footer-content {
      flex-direction: column; /* Apila las secciones en pantallas pequeñas */
      text-align: center; /* Centra el texto en pantallas pequeñas */
    }
  
    .footer-section {
      margin-bottom: 20px;
    }
  }
  </style>