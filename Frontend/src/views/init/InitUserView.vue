<script setup>

import { ref, onMounted } from 'vue';

const menuItems = ref([]);
const recetLoans = ref([]);

onMounted(() => {
    //const loggedInUserInfo = { role: 'admin', name: 'Admin User' };
    //userRole.value = loggedInUserInfo.role;
    generateMenu();
    getRecentLoans();
});

const getRecentLoans = () => {
    recetLoans.value = []
    recetLoans.value.push(
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' },
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' },
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' },
        { label: 'El gran Gatsby', label2: 'B.Scott Fitzgeraid Fecha de mayo, 2024' }
    );
};

const generateMenu = () => {
    menuItems.value = [];
    menuItems.value.push(
        { label: 'Libros Disponibles' },
        { label: 'Libros Prestados' },
        { label: 'Préstamos Activos' },
        { label: 'Próxima Devolución' }
    );

};


const Buscar = () => {
    console.log('Botón "Buscar" presionado...')
};

</script>

<template>
    <div>
        <div class="header flex items-center">
            <i class="pi pi-fw pi-objects-column" style="font-size:40px"></i>
            <label class="p-3" for="header"><b>Inicio</b></label>
        </div>
        <ul class="flex flex-row gap-2 p-1 m-0 w-full">
            <li v-for="item in menuItems" :key="item.to" class="mb-2 w-full">
                <button
                    class="flex items-center justify-center bg-[#EFE7D9] p-3 rounded-md text-2xl hover:bg-[#8a8a8a] transition-colors duration-200 w-full h-full cursor-pointer">
                    <span>{{ item.label }}</span>
                </button>
            </li>
        </ul>
        <div class="mb-4 mt-10">
            <label for="search_book" class="block text-2xl mb-2">
                Buscar Libros
            </label>
            <div class="flex flex-row gap-5">
                <input type="search_book" id="search_book"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-3xs py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
                <button @click="Buscar()"
                    class="cursor-pointer bg-[#C9A66B] hover:bg-amber-600 text-black text-2xl py-2 px-4 rounded-md focus:outline-none focus:shadow-outline active:shadow-inner active:scale-95 transition-all duration-100"
                    type="button">
                    Buscar
                </button>
            </div>
        </div>
        <div>
            <label class="block text-2xl mb-2 mt-10">
                Mis préstamos recientes
            </label>
            <ul class="gap-2 p-1 m-0 w-full bg-amber-50 ">
                <li v-for="item in recetLoans" :key="item.to" class="mb-2 w-full flex flex-col">
                    <label class="font-bold text-2xl">{{ item.label }}</label>
                    <label class="text-gray-700">{{ item.label2 }}</label>
                </li>
            </ul>
        </div>
    </div>
</template>

<style scoped>
.header {
    font-size: 1.6rem;
}
</style>