<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Graphic from './Graphics.vue'

const router = useRouter();
const menuItems = ref([]);
const userRole = ref(null);

onMounted(() => {
    //const loggedInUserInfo = { role: 'admin', name: 'Admin User' };
    //userRole.value = loggedInUserInfo.role;
    userRole.value = 'ROLE_Administrador';
    generateMenu(userRole.value);
});

const generateMenu = (role) => {
    menuItems.value = [];
    menuItems.value.push(
        { label: 'Libros', icon: 'pi pi-fw pi-book', to: '/libros' },
        { label: 'Usuarios', icon: 'pi pi-fw pi-users', to: '/usuarios' },
        { label: 'Prestamos activos', icon: 'pi pi-fw pi-arrow-right-arrow-left', to: '/prestamos' }
    );

};

const navigate = (item) => {
    if (item.to) {
        router.push(item.to);
    }
};
</script>

<template>
    <div>
        <div class="header flex items-center">
            <i class="pi pi-fw pi-objects-column" style="font-size:40px"></i>
            <label class="p-3" for="header"><b>Inicio</b></label>
        </div>
        <ul class="flex flex-row gap-2 p-5 m-0 w-full">
            <li v-for="item in menuItems" :key="item.to" class="mb-2 w-full">
                <button @click="navigate(item)"
                    class="bg-[#EFE7D9] flex items-center p-3 rounded-md text-2xl hover:bg-[#8a8a8a] transition-colors duration-200 w-full h-full cursor-pointer">
                    <i :class="[item.icon, 'mr-2']" style="font-size:30px"></i>
                    <span>{{ item.label }}</span>
                </button>
            </li>
        </ul>
        <div class="max-h-full">
            <div>
                <Graphic></Graphic>
            </div>
        </div>
    </div>
</template>

<style scoped>
.pi {
    font-size: 1.2rem;
}

.header {
    font-size: 1.6rem;
}
</style>