<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const menuItems = ref([]);
const userRole = ref(null);

onMounted(() => {
    //const loggedInUserInfo = { role: 'admin', name: 'Admin User' };
    //userRole.value = loggedInUserInfo.role;
    userRole.value = 'administrador';
    generateMenu(userRole.value);
});

const generateMenu = (role) => {
    menuItems.value = [];
    if (role === 'administrador') {
        menuItems.value.push(
            { label: 'Inicio', icon: 'pi pi-fw pi-home', to: '/inicio' },
            { label: 'Libros', icon: 'pi pi-fw pi-book', to: '/libros' },
            { label: 'Usuarios', icon: 'pi pi-fw pi-users', to: '/usuarios' },
            { label: 'Prestamos', icon: 'pi pi-fw pi-inbox', to: '/prestamos' },
            { label: 'Configuración', icon: 'pi pi-fw pi-cog', to: '/configuracion' }
        );
    } else if (role === 'bibliotecario') {
        menuItems.value.push(
            { label: 'Inicio', icon: 'pi pi-fw pi-home', to: '/inicio' },
            { label: 'Libros', icon: 'pi pi-fw pi-list', to: '/libros' },
            { label: 'Usuarios', icon: 'pi pi-fw pi-users', to: '/usuarios' },
            { label: 'Prestamos', icon: 'pi pi-fw pi-inbox', to: '/prestamos' }
        );
    } else if (role === 'usuario') {
        menuItems.value.push(
            { label: 'Inicio', icon: 'pi pi-fw pi-home', to: '/inicio' },
            { label: 'Libros', icon: 'pi pi-fw pi-list', to: '/libros' },
            { label: 'Prestamos', icon: 'pi pi-fw pi-inbox', to: '/prestamos' },
            { label: 'Perfil', icon: '', to: '/perfil' }
        );
    }
};

const navigate = (item) => {
    if (item.to) {
        router.push(item.to);
    }
};
</script>

<template>
    <div class="w-64 bg-gray-200 h-full p-4">
        <ul class="list-none p-0 m-0">
            <li v-for="item in menuItems" :key="item.to" class="mb-2">
                <button
                    @click="navigate(item)"
                    class="flex items-center w-full p-3 rounded-md hover:bg-gray-300 transition-colors duration-200"
                >
                    <i :class="[item.icon, 'mr-2']"></i>
                    <span>{{ item.label }}</span>
                </button>
            </li>
        </ul>
    </div>
</template>

<style scoped>
.pi {
    font-size: 1.2rem;
}
</style>