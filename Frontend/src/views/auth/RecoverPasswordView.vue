<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import Topbar from '../../layout/Topbar.vue';
</script>

<template>
    <Topbar />
    <div class="bg-gray-100 flex flex-col justify-center items-center py-5">
        <div class="p-10 w-3/6">
            <h2 class="text-center text-4xl font-bold text-gray-800 mb-4 w-full">Recupera tu contraseña</h2>
        </div>
        <div class="p-8 w-2/6">
            <div class="mb-4">                
                <input
                    type="email"
                    id="correo"
                    placeholder="Correo electrónico"
                    v-model="correo"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="flex items-center justify-center mt-15 w-full">
                <button
                    @click=""
                    class="cursor-pointer bg-[#C9A66B] hover:bg-amber-600 text-white text-2xl font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline active:shadow-inner active:scale-95 transition-all duration-100"
                    type="button"
                >
                    Recuperar
                </button>
            </div>
        </div>
    </div>
</template>