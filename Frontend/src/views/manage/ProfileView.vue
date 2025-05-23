<script setup>

import { ref } from 'vue'

// Imagen predeterminada (ícono de usuario genérico)
const defaultImage = 'https://cdn-icons-png.flaticon.com/512/149/149071.png'

const previewUrl = ref(null)

const onFileChange = (event) => {
    const file = event.target.files[0]
    if (file && file.type.startsWith('image/')) {
        previewUrl.value = URL.createObjectURL(file)
    } else {
        alert('Por favor selecciona una imagen válida.')
    }
}

</script>

<template>
    <div class="flex flex-row">
        <div class="p-2 flex flex-col items-center">
            <label for="profileImage" class="relative cursor-pointer group">
                <img :src="previewUrl || defaultImage" alt="Foto de perfil"
                    class="w-38 h-38 rounded-full object-cover border-2 border-gray-300 shadow transition duration-300 group-hover:opacity-80" />
                <div
                    class="absolute bottom-0 right-0 bg-gray-800 text-white text-xs px-2 py-1 rounded-full group-hover:scale-105 transition">
                    Cambiar
                </div>
            </label>

            <input id="profileImage" type="file" accept="image/*" @change="onFileChange" class="hidden" />
            <div class="mt-2 ml-5 flex flex-col">
                <label class="p-1 fields">Nombre</label>
                <input id="name"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-2 ml-5 flex flex-col">
                <label class="p-1 fields">Correo electrónico</label>
                <input id="email" type="email" placeholder="tucorreo@ejemplo.com" required
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-2 ml-5 flex flex-col">
                <label class="p-1 fields">Contraseña</label>
                <input id="password" type="password"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-2 ml-5 flex flex-col">
                <label class="p-1 fields">Rol</label>
                <select id="Rol" v-model="numeroSeleccionado"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    <option disabled value="">Selecciona un rol</option>
                    <option value="Bibliotecario">Bibliotecario</option>
                    <option value="Usuario">Lector</option>
                </select>
            </div>
            <div class="flex justify-center">
                <button class="cursor-pointer bg-[#C9A66B] p-2 rounded text-2xl mt-8 w-2xs">
                    <span>Actualizar</span>
                </button>
            </div>
        </div>
        <div class="p-4 flex flex-col justify-center items-end">
            <div class="flex justify-center">
                <button class="cursor-pointer bg-[#D9D9D9] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                    <span>Reporte usuarios</span>
                </button>
            </div>
            <div class="flex justify-center">
                <button class="cursor-pointer bg-[#D9D9D9] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                    <span>Reporte libros</span>
                </button>
            </div>
            <div class="flex justify-center">
                <button class="cursor-pointer bg-[#D9D9D9] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                    <span>Reporte dashboard</span>
                </button>
            </div>
            <div class="flex justify-center">
                <button class="cursor-pointer bg-[#D9D9D9] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                    <span>Reporte prestamos</span>
                </button>
            </div>
        </div>
    </div>
</template>

<style scoped>
.header {
    font-size: 1.6rem;
}
</style>