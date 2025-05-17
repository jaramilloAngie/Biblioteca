<script setup>

import RecentLoans from './RecentLoans.vue';

const today = new Date().toISOString().split('T')[0]

const admin = 'administrador'
const bibliotecario = 'bibliotecario'
defineProps(['roles'])


const isUser = (rol) => {
    if (rol === admin || rol === bibliotecario) {
        return false;
    }else {
        return true;
    }
}

</script>

<template>
    <div>
        <div class="header flex items-center">
            <i class="pi pi-fw pi-arrow-right-arrow-left" style="font-size:40px"></i>
            <label class="p-3" for="header"><b>Préstamos</b></label>
        </div>
        <div v-if="!isUser(roles)" class=" bg-[#EFE7D9] flex flex-col">
            <div class="flex justify-center">
                <label class="p-3 py-6 header2 font-bold">Registrar préstamo</label>
            </div>
            <div class="mt-5 ml-5 flex flex-col">
                <label class="p-3 header"><b>Nombre</b></label>
                <input id="filter_book"
                    class="header bg-[#D9D9D9] shadow appearance-none border-none rounded w-3xs py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-3 ml-5 flex flex-col">
                <label class="p-3 header"><b>Libro</b></label>
                <input id="filter_book"
                    class="header bg-[#D9D9D9] shadow appearance-none border-none rounded w-3xs py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />

            </div>
            <div class="mt-3 ml-5 flex flex-col">
                <label class="p-3 header"><b>Fecha pendiente</b></label>
                <div class="flex flex-row items-center">
                    <input id="filter_book" type="date" :min="today"
                        class="header bg-[#D9D9D9] shadow appearance-none border-none rounded w-3xs py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
                </div>
            </div>
            <div class="flex justify-center">
                <button class="cursor-pointer bg-[#C9A66B] p-2 rounded text-2xl mt-8">
                    <span>Guardar</span>
                </button>
            </div>
            <div class="mt-8"></div>
        </div>
        <label v-if="!isUser(roles)" class="block text-2xl mb-2 mt-10">
            <b>
                Préstamos recientes
            </b>
        </label>
        <label v-if="isUser(roles)" class="block text-2xl mb-2 mt-10">
            <b>
                Mis préstamos recientes
            </b>
        </label>
        <RecentLoans />
    </div>
</template>
<style scoped>
.header {
    font-size: 1.6rem;
}

.header2 {
    font-size: 1.7rem;
}
</style>