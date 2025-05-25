<script setup>

import { ref, onMounted } from 'vue'

const defaultImage = 'https://images.cdn3.buscalibre.com/fit-in/360x360/61/8d/618d227e8967274cd9589a549adff52d.jpg'

const role = 'administrador'
const isUser = true;
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
    <label class="header font-bold flex justify-center">Información libro</label>
    <div class="flex flex-row ml-8 mt-10">
        <label for="bookImage" :class="{ 'relative': true, 'cursor-pointer': !isUser, 'group': true }">
            <img :src="previewUrl || defaultImage" alt="Foto de perfil" :class="{
                'w-60': true, 'h-70': true, 'rounded-2xl': true,
                'object-cover': true, 'border-2': true, ' border-gray-300': true, 'shadow': true,
                'transition': true, 'duration-300': true, ' group-hover:opacity-80': !isUser
            }" />
            <div v-if="!isUser"
                class="absolute bottom-0 right-0 bg-gray-800 text-white text-xs px-2 py-1 rounded-full group-hover:scale-105 transition">
                Cambiar
            </div>
        </label>
        <input v-if="!isUser" id="bookImage" type="file" accept="image/*" @change="onFileChange" class="hidden" />
        <div v-if="!isUser" class="flex flex-col ml-20 mt-15">
            <button class="cursor-pointer bg-[#C94C4C] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                <span>Eliminar libro</span>
            </button>
            <button class="cursor-pointer bg-[#D9D9D9] p-2 rounded-2xl text-2xl mt-8 w-2xs">
                <span>Actualizar</span>
            </button>
        </div>
    </div>
    <div class="flex flex-col mt-10">
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Titulo</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field" :disabled="isUser"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Año de publicación</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field " :disabled="isUser"
                type="date"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Editorial</label>
            <input id="observacion" v-model="observacion" rows="1" class="input-field" :disabled="isUser"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Autor</label>
            <input :disabled="isUser" id="observacion" v-model="observacion" rows="1" class="input-field"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Categoria</label>
            <input :disabled="isUser" id="observacion" v-model="observacion" rows="1" class="input-field"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Cantidad disponible</label>
            <input :disabled="isUser" id="observacion" v-model="observacion" rows="1" class="input-field"
                type="number"></input>
        </div>
        <div class="input-wrapper">
            <label for="observacion" class="input-label">Ubicación</label>
            <select v-if="!isUser" id="observacion" v-model="observacion" rows="1" class="input-field">
                <option value="">Tulua</option>
                <option value="Bibliotecario">Buga</option>
                <option value="Usuario">Cali</option>
            </select>
            <input v-if="isUser" disabled id="observacion" v-model="observacion" rows="1" class="input-field">
            </input>
        </div>
        <div v-if="!isUser" class="input-wrapper mt-8">
            <label for="observacion" class="input-label">Observación</label>
            <textarea id="observacion" v-model="observacion" rows="1" class="input-field-observacion"></textarea>
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
    font-size: 1.6rem;
}
</style>