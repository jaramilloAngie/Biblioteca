<script setup>
</script>

<template>
  <div class="w-full h-20 bg-[#C9A66B] flex items-center">
    <div class="w-1/5 h-full flex items-center justify-center ">
      <img src="../../../assets/Logo.png" alt="Logo" class="h-full w-full object-cover">
    </div>
    <div class="w-4/5 h-full">
      </div>
  </div>
  <div class="bg-gray-100 flex justify-center items-center py-5">
    <div class="p-8  w-2/5">      
        <h2 class="text-center text-5xl font-bold text-gray-800 mb-4">Biblioteca</h2>
      <div class="mb-4 mt-10">
        <label for="email" class="block text-gray-700 text-2xl mb-2">
          Correo electrónico
        </label>
        <input
          type="email"
          id="email"
          class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        />
      </div>
      <div class="mb-6">
        <label for="password" class="block text-gray-700 text-2xl mb-2">
          Contraseña
        </label>
        <input
          type="password"
          id="password"
          class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        />
      </div>
      <div class="flex items-center justify-between mb-4">
        <router-link to="" class="inline-block align-baseline font-semibold text-1xl underline text-blue-500 hover:text-blue-800">
          ¿Olvidaste tu contraseña?
        </router-link>
      </div>
      <div class="flex items-center justify-center mt-7">
        <button
          class="bg-[#C9A66B] hover:bg-amber-600 text-white text-2xl font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline active:shadow-inner active:scale-95 transition-all duration-100"
          type="button"
        >
          Iniciar Sesión
        </button>
      </div>
      <div class="mt-4 text-center">
        <span class="text-gray-600 text-1xl">¿No tienes una cuenta?
          <router-link to="" class="font-semibold underline text-blue-500 text-1xl hover:text-blue-800">
            Crea una
          </router-link>
        </span>
      </div>
    </div>
  </div>
</template>
