<script setup>
  // No se necesita lógica de script adicional para este footer estático
</script>

<template>
  <footer class="main-footer w-full"> <div class="footer-content">
          <div class="footer-section">
              <h3><b>Sobre nosotros</b></h3>
              <ul>
                  <li><a href="#">¿Quiénes somos?</a></li>
                  <li><a href="#">Misión y visión</a></li>
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
  
<style scoped>
.main-footer {
    background-color: #C9A66B;
    color: #000;
    padding: 20px;
    text-align: center;
}

.footer-content {
    display: flex;
    justify-content: space-around;
    margin-bottom: 20px;
    text-align: left;
}

.footer-section {
    flex: 1;
    justify-items: center;
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
    border-top: 1px solid rgba(0, 0, 0, 0.1);
    padding-top: 10px;
    font-size: 0.9em;
}

@media (max-width: 768px) {
    .footer-content {
        flex-direction: column;
        text-align: center;
    }

    .footer-section {
        margin-bottom: 20px;
    }
}
</style>