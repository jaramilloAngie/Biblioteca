<script setup>

import { ref, onMounted } from 'vue';

const books = ref([]);

const admin = 'administrador'
const bibliotecario = 'bibliotecario'
defineProps(['roles'])


const isUser = (rol) => {
    if (rol === admin || rol === bibliotecario) {
        return false;
    } else {
        return true;
    }
}

const usuarios = ref([
    { username: 'user123', name: 'The admin', email: 'admin@gmail.com', role: 'Administrador' },
    { username: 'user456', name: 'The Editor', email: 'editor@gmail.com', role: 'Editor' },
    { username: 'user789', name: 'The author', email: 'author@gmail.com', role: 'Author' },
    { username: 'user123', name: 'The admin', email: 'admin@gmail.com', role: 'Administrador' },
    { username: 'user456', name: 'The Editor', email: 'editor@gmail.com', role: 'Editor' },
    { username: 'user789', name: 'The author', email: 'author@gmail.com', role: 'Author' },
    { username: 'user123', name: 'The admin', email: 'admin@gmail.com', role: 'Administrador' },
    { username: 'user456', name: 'The Editor', email: 'editor@gmail.com', role: 'Editor' },
    { username: 'user789', name: 'The author', email: 'author@gmail.com', role: 'Author' },

])

</script>

<template>
    <div>
        <div class="flex flex-row gap-20 items-center">
            <div class="header flex items-center">
                <i class="pi pi-fw pi-users" style="font-size:40px"></i>
                <label class="p-3" for="header"><b>Usuarios</b></label>
            </div>
            <input placeholder="Filtrar" type="search" id="filter_user"
                class="header bg-[#EFE7D9] shadow appearance-none border-none rounded w-4xs py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />

        </div>
        <div class="p-4">
            <table class="table-auto w-full border-collapse border border-gray-300">
                <thead>
                    <tr class="bg-gray-200">
                        <th class="border border-gray-300 px-4 py-2">Nombre de usuario</th>
                        <th class="border border-gray-300 px-4 py-2">Nombre</th>
                        <th class="border border-gray-300 px-4 py-2">Correo</th>
                        <th class="border border-gray-300 px-4 py-2">Rol</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="usuario in usuarios" :key="usuario.id">
                        <td class="border border-gray-300 px-4 py-2">{{ usuario.username }}</td>
                        <td class="border border-gray-300 px-4 py-2">{{ usuario.name }}</td>
                        <td class="border border-gray-300 px-4 py-2">{{ usuario.email }}</td>
                        <td class="border border-gray-300 px-4 py-2">{{ usuario.role }}</td>
                        <td class="border border-gray-300 py-1 flex flex-row justify-center">
                            <router-link to="/manage_profile"
                                class="inline-block align-baseline font-semibold text-1xl underline text-blue-500 hover:text-blue-800">
                                Ver perfil
                            </router-link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<style scoped>
.header {
    font-size: 1.6rem;
}
</style>