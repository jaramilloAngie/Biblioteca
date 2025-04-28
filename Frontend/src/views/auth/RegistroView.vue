<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import Topbar from '../../layout/Topbar.vue';
</script>

<template>
    <Topbar />
    <div class="bg-gray-100 flex justify-center items-center py-5">
        <div class="p-8 w-2/6">
            <h2 class="text-center text-5xl font-bold text-gray-800 mb-4">¡Registrate!</h2>
            <div class="mb-4 mt-10">                
                <input
                    type="text"
                    id="nombre"
                    placeholder="Nombres"
                    v-model="nombre"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="mb-4">                
                <input
                    type="text"
                    id="apellido"
                    placeholder="Apellidos"
                    v-model="apellido"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="mb-4">                
                <input
                    type="email"
                    id="correo"
                    placeholder="Correo electronico"
                    v-model="correo"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="mb-4">                
                <input
                    type="password"
                    id="contraseña"
                    placeholder="Contraseña"
                    v-model="contraseña"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="mb-10">                
                <input
                    type="password"
                    id="confirmar_contraseña"
                    placeholder="Confirmar contraseña"
                    v-model="confirmar_contraseña"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="flex items-center justify-center mt-7">
                <button
                    @click="login"
                    class="bg-[#C9A66B] hover:bg-amber-600 text-white text-2xl font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline active:shadow-inner active:scale-95 transition-all duration-100"
                    type="button"
                >
                    Registrarse
                </button>
            </div>
            <div class="mt-4 text-center">
                <span class="text-gray-600 text-1xl">¿Ya tienes una cuenta?
                    <router-link to="/login" class="font-semibold underline text-blue-500 text-1xl hover:text-blue-800">
                        Inicia sesión
                    </router-link>
                </span>
            </div>
        </div>
    </div>
</template>