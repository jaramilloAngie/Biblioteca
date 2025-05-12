<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import AuthAPI from '../../servicio/ServicioAutenticacion';
import Topbar from '../../layout/Topbar.vue';

const email = ref('');
const password = ref('');
const router = useRouter();
const topbarRef = ref(null);
const errorMessage = ref('');
const isErrorVisible = ref(false);

const login = async () => {
    errorMessage.value = '';
    isErrorVisible.value = false;

    if (!email.value && !password.value) {
        showErrorMessage('Por favor, diligencia el correo electrónico y la contraseña.');
        return;
    }

    if (!email.value) {
        showErrorMessage('Por favor, ingresa tu correo electrónico.');
        return;
    }

    if (!password.value) {
        showErrorMessage('Por favor, ingresa tu contraseña.');
        return;
    }

    if (!validateEmail(email.value)) {
        showErrorMessage('Por favor, ingresa un correo electrónico válido.');
        return;
    }

    try {
        const { data } = await AuthAPI.authLogin(email.value, password.value);
        if (data.estado) {
            localStorage.setItem('token', data.jwt);
            localStorage.setItem('roles', JSON.stringify(data.roles));
            localStorage.setItem('permissions', JSON.stringify(data.permissions));
            router.push('/inicio');
        } else {
            if (data.mensaje === 'Usuario no encontrado') {
                showErrorMessage('El correo electrónico ingresado no existe.');
            } else if (data.mensaje === 'Credenciales incorrectas') {
                showErrorMessage('La contraseña es incorrecta.');
            } else {
                showErrorMessage('Correo electrónico o contraseña incorrectos.');
            }
        }
    } catch (error) {
        console.error("Login Error:", error);
        showErrorMessage('Ocurrió un error al intentar iniciar sesión. Por favor, intenta de nuevo.');
    }
};

const validateEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
};

const showErrorMessage = (message) => {
    errorMessage.value = message;
    isErrorVisible.value = true;
    setTimeout(() => {
        isErrorVisible.value = false;
        errorMessage.value = '';
    }, 3500);
};
</script>

<template>
    <Topbar ref="topbarRef" />
    <div class="relative bg-gray-100 flex justify-center items-center py-5">
        <div v-if="isErrorVisible"
            class="absolute top-[60px] right-5 bg-red-500 text-white py-3 px-4 rounded-md shadow-lg z-50 transition-opacity duration-500">
            {{ errorMessage }}
        </div>
        <div class="p-8 w-2/5">
            <h2 class="text-center text-5xl font-bold text-gray-800 mb-4">Biblioteca</h2>
            <div class="mb-4 mt-10">
                <label for="email" class="block text-gray-700 text-2xl mb-2">
                    Correo electrónico
                </label>
                <input type="email" id="email" v-model="email"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mb-6">
                <label for="password" class="block text-gray-700 text-2xl mb-2">
                    Contraseña
                </label>
                <input type="password" id="password" v-model="password"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-4 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="flex items-center justify-between mb-4">
                <router-link to=""
                    class="inline-block align-baseline font-semibold text-1xl underline text-blue-500 hover:text-blue-800">
                    ¿Olvidaste tu contraseña?
                </router-link>
            </div>
            <div v-if="error" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4"
                role="alert">
                <strong class="font-bold">Error:</strong>
                <span class="block sm:inline">{{ error }}</span>
            </div>
            <div class="flex items-center justify-center mt-7">
                <button @click="login"
                    class="bg-[#C9A66B] hover:bg-amber-600 text-white text-2xl font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline active:shadow-inner active:scale-95 transition-all duration-100"
                    type="button">
                    Iniciar Sesión
                </button>
            </div>
            <div class="mt-4 text-center">
                <span class="text-gray-600 text-1xl">¿No tienes una cuenta?
                    <router-link to="/registro"
                        class="font-semibold underline text-blue-500 text-1xl hover:text-blue-800">
                        Crea una
                    </router-link>
                </span>
            </div>
        </div>
    </div>
</template>

<style scoped>
.fixed-error {
    animation: fadeOut 0.5s ease-in-out 3s forwards;
}

@keyframes fadeOut {
    to {
        opacity: 0;
    }
}
</style>