<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const menuItems = ref([]);
const userRole = ref(null);

onMounted(() => {
    //const loggedInUserInfo = { role: 'admin', name: 'Admin User' };
    //userRole.value = loggedInUserInfo.role;
    userRole.value = 'usuario';
    generateMenu(userRole.value);
});

const generateMenu = (role) => {
    menuItems.value = [];
    if (role === 'administrador') {
        menuItems.value.push(
            { label: 'Inicio', icon: 'pi pi-fw pi-objects-column', to: '/inicio' },
            { label: 'Libros', icon: 'pi pi-fw pi-book', to: '/libros' },
            { label: 'Usuarios', icon: 'pi pi-fw pi-users', to: '/usuarios' },
            { label: 'Prestamos', icon: 'pi pi-fw pi-arrow-right-arrow-left', to: '/prestamos' },
            { label: 'Perfil', icon: 'pi pi-fw pi-user', to: '/perfil' }
        );
    } else if (role === 'bibliotecario') {
        menuItems.value.push(
            { label: 'Inicio', icon: 'pi pi-fw pi-objects-column', to: '/inicio' },
            { label: 'Libros', icon: 'pi pi-fw pi-book', to: '/libros' },
            { label: 'Usuarios', icon: 'pi pi-fw pi-users', to: '/usuarios' },
            { label: 'Prestamos', icon: 'pi pi-fw pi-arrow-right-arrow-left', to: '/prestamos' },
            { label: 'Perfil', icon: 'pi pi-fw pi-user', to: '/perfil' }
        );
    } else if (role === 'usuario') {
        menuItems.value.push(
            { label: 'Inicio', icon: 'pi pi-fw pi-objects-column', to: '/inicio' },
            { label: 'Libros', icon: 'pi pi-fw pi-book', to: '/libros' },
            { label: 'Prestamos', icon: 'pi pi-fw pi-arrow-right-arrow-left', to: '/prestamos' },
            { label: 'Perfil', icon: 'pi pi-fw pi-user', to: '/perfil' }
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
    <div class="w-1/5 bg-[#C9A66B] h-full p-4">
        <ul class="list-none p-0 m-0">
            <li v-for="item in menuItems" :key="item.to" class="mb-2">
                <button
                    @click="navigate(item)"
                    class="flex items-center w-full p-3 rounded-md text-2xl font-bold hover:bg-[#f0e9d9] transition-colors duration-200"
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