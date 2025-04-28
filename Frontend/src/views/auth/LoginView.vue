<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import Topbar from '../../layout/Topbar.vue';

const email = ref('');
const password = ref('');
const router = useRouter();
const topbarRef = ref(null);

const login = async () => {
    const user = {
        email: email.value,
        role: 'admin',
        nombre: 'Julian'
    };

    console.log('Iniciando sesión con:', email.value, password.value);

    localStorage.setItem('authToken', 'fakeToken');
    localStorage.setItem('userRole', user.role);
    if (topbarRef.value && user.nombre) {
        topbarRef.value.setLoggedInUser(user);
    }
    router.push('/inicio');
};
</script>

<template>
    <Topbar ref="topbarRef" />
    <div class="bg-gray-100 flex justify-center items-center py-5">
        <div class="p-8 w-2/5">
            <h2 class="text-center text-5xl font-bold text-gray-800 mb-4">Biblioteca</h2>
            <div class="mb-4 mt-10">
                <label for="email" class="block text-gray-700 text-2xl mb-2">
                    Correo electrónico
                </label>
                <input
                    type="email"
                    id="email"
                    v-model="email"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="mb-6">
                <label for="password" class="block text-gray-700 text-2xl mb-2">
                    Contraseña
                </label>
                <input
                    type="password"
                    id="password"
                    v-model="password"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                />
            </div>
            <div class="flex items-center justify-between mb-4">
                <router-link to="" class="inline-block align-baseline font-semibold text-1xl underline text-blue-500 hover:text-blue-800">
                    ¿Olvidaste tu contraseña?
                </router-link>
            </div>
            <div class="flex items-center justify-center mt-7">
                <button
                    @click="login"
                    class="bg-[#C9A66B] hover:bg-amber-600 text-white text-2xl font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline active:shadow-inner active:scale-95 transition-all duration-100"
                    type="button"
                >
                    Iniciar Sesión
                </button>
            </div>
            <div class="mt-4 text-center">
                <span class="text-gray-600 text-1xl">¿No tienes una cuenta?
                    <router-link to="/registro" class="font-semibold underline text-blue-500 text-1xl hover:text-blue-800">
                        Crea una
                    </router-link>
                </span>
            </div>
        </div>
    </div>
</template>