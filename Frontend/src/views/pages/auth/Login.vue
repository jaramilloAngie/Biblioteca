<script setup>
</script>

<template>
  <div class="bg-gray-100 h-screen flex justify-center items-center">
    <div class="bg-white p-8 rounded shadow-md w-96">
      <div class="flex justify-start mb-6">
        <span class="text-xl font-semibold text-gray-700">LeeMás</span>
      </div>
      <h2 class="text-2xl font-semibold text-gray-800 mb-4">Inicia Sesión</h2>
      <div class="mb-4">
        <label for="email" class="block text-gray-700 text-sm font-bold mb-2">
          Correo electrónico
        </label>
        <input
          type="text"
          id="email"
          class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        />
      </div>
      <div class="mb-6">
        <label for="password" class="block text-gray-700 text-sm font-bold mb-2">
          Contraseña
        </label>
        <input
          type="password"
          id="password"
          class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        />
      </div>
      <div class="flex items-center justify-between mb-4">
        <router-link to="" class="inline-block align-baseline font-semibold text-sm text-blue-500 hover:text-blue-800">
          ¿Olvidaste tu contraseña?
        </router-link>
      </div>
      <div class="flex items-center justify-center">
        <button
          class="bg-indigo-500 hover:bg-indigo-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          type="button"
        >
          Iniciar Sesión
        </button>
      </div>
      <div class="mt-4 text-center">
        <span class="text-gray-600 text-sm">¿No tienes una cuenta?
          <router-link to="" class="font-semibold text-blue-500 hover:text-blue-800">
            Crea una
          </router-link>
        </span>
      </div>
    </div>
  </div>
</template>
