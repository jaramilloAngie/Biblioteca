<script setup>

import { ref, onMounted } from 'vue'
import RecentLoans from '../loans/RecentLoans.vue';

const defaultImage = 'https://cdn-icons-png.flaticon.com/512/149/149071.png'

const role = 'administrador'

</script>

<template>
    <div class="flex flex-row">
        <div>
            <div class="flex ml-15">
                <label for="profileImage" class="relative group">
                    <img :src="previewUrl || defaultImage" alt="Foto de perfil"
                        class="w-38 h-38 rounded-full object-cover border-2 border-gray-300 shadow transition duration-300" />
                </label>
            </div>
            <div class="flex justify-center">
                <button class="cursor-pointer bg-[#C94C4C] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                    <span>Bloquear usuario</span>
                </button>
            </div>
            <div v-if="role === 'administrador'" class="flex justify-center">
                <button class="cursor-pointer bg-[#D9D9D9] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                    <span>Actualizar</span>
                </button>
            </div>
        </div>
        <div class="ml-15">
            <div class="mt-2 flex flex-col">
                <label class="p-1 fields">Nombre</label>
                <input id="name"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-2 flex flex-col">
                <label class="p-1 fields">Correo electrónico</label>
                <input id="email" type="email" placeholder="tucorreo@ejemplo.com" required
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-2 flex flex-col">
                <label class="p-1 fields">Número de teléfono</label>
                <input id="email" type="email" placeholder="+57" required
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div v-if="role === 'administrador'" class="mt-2 flex flex-col">
                <label class="p-1 fields">Rol</label>
                <select id="Rol" v-model="numeroSeleccionado"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    <option disabled value="">Selecciona un rol</option>
                    <option value="Bibliotecario">Bibliotecario</option>
                    <option value="Usuario">Lector</option>
                </select>
            </div>
        </div>
    </div>
    <div>
        <div class="mt-6 flex flex-col">
            <label class="p-1 fields font-bold text-2xl">Observación</label>
            <textarea id="observacion" v-model="observacion" rows="5" placeholder="Escribe aquí tu observación..."
                class="w-full p-3 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 resize-y"></textarea>
        </div>
    </div>
    <div class="mt-15">
        <label class="p-1 fields text-2xl">Historial de préstamos</label>
        <RecentLoans class="mt-5"/>
    </div>
</template>

<style scoped>
.header {
    font-size: 1.6rem;
}
</style>