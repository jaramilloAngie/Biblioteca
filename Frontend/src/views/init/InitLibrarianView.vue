<script setup>

import { ref, onMounted } from 'vue';

const menuItems = ref([]);

onMounted(() => {
    //const loggedInUserInfo = { role: 'admin', name: 'Admin User' };
    //userRole.value = loggedInUserInfo.role;
    generateMenu();
});

const generateMenu = () => {
    menuItems.value = [];
    menuItems.value.push(
        { label: 'Préstamos activos', cantidad: '000' },
        { label: 'Libros disponibles', cantidad: '000' },
        { label: 'Prestamos atrasasdos', cantidad: '000' }
    );

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
                    class=" flex flex-col items-center justify-center bg-[#EFE7D9] p-3 rounded-md text-2xl w-full h-full ">
                    <span>{{ item.label }}</span>
                    <label class="font-bold text-2xl">{{ item.cantidad }}</label>
                </button>
            </li>
        </ul>
    </div>
</template>

<style scoped>
.header {
    font-size: 1.6rem;
}
</style>