<script setup>

import { ref, onMounted } from 'vue'

const defaultImage = 'https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg'

const role = 'administrador'

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
    <label class="header font-bold flex justify-center">Agregar libro</label>
    <div class="flex flex-row ml-8 mt-10">
        <label for="bookImage" class="relative cursor-pointer group">
            <img :src="previewUrl || defaultImage" alt="Foto de perfil"
                class="w-60 h-70 rounded-2xl object-cover border-2 border-gray-300 shadow transition duration-300 group-hover:opacity-80" />
            <div
                class="absolute bottom-0 right-0 bg-gray-800 text-white text-xs px-2 py-1 rounded-full group-hover:scale-105 transition">
                Cambiar
            </div>
        </label>
        <input id="bookImage" type="file" accept="image/*" @change="onFileChange" class="hidden" />
    </div>
    <div class="flex flex-col mt-10">
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Titulo</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Año de publicación</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field " type="date"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Editorial</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Autor</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Categoria</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Cantidad disponible</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field" type="number"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Ubicación</label>
            <select id="observacion" v-model="observacion" rows="1" class="input-field">
                <option value="">Tulua</option>
                <option value="Bibliotecario">Buga</option>
                <option value="Usuario">Cali</option>
            </select>
        </div>
        <div class="flex justify-center">
            <button class="cursor-pointer bg-[#C9A66B] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                <span>Agregar</span>
            </button>
        </div>
    </div>
</template>

<style scoped>
.input-wrapper {
    position: relative;
    width: 100%;
    max-width: 550px;
    margin: 1rem;
}

.input-label {
    position: absolute;
    top: -0.6rem;
    left: 1rem;
    background: white;
    padding: 0 0.4rem;
    font-size: 0.9rem;
    font-weight: bold;
    color: #333;
    z-index: 1;
}

.input-field {
    width: 100%;
    border: 1px solid black;
    border-radius: 1rem;
    padding: 0.5rem 1.3rem 0.5rem;
    font-size: 1rem;
    resize: vertical;
    box-sizing: border-box;
}

.input-field-observacion {
    width: 100%;
    border: 1px solid black;
    border-radius: 1rem;
    padding: 0.5rem 1.3rem 5rem;
    font-size: 1rem;
    resize: vertical;
    box-sizing: border-box;
}

.header {
    font-size: 2rem;
}
</style>