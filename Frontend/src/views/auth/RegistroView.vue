<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Topbar from '../../layout/Topbar.vue';
import UsuarioServicio from '../../servicio/UsuarioServicio';

const router = useRouter();

const nombre = ref('');
const apellido = ref('');
const correo = ref('');
const contraseña = ref('');
const confirmar_contraseña = ref('');
const sedeId = ref(null);
const sedes = ref([]);
const errorMessage = ref('');
const successMessage = ref('');

const fetchSedes = async () => {
    const response = await UsuarioServicio.obtenerSedes();
    if (response && response.length > 0) {
        sedes.value = response;
    } else {
        errorMessage.value = 'No se pudieron cargar las sedes. Inténtalo de nuevo más tarde.';
    }
};

onMounted(() => {
    fetchSedes();
});

const handleRegistro = async () => {
    errorMessage.value = '';
    successMessage.value = '';

    if (contraseña.value !== confirmar_contraseña.value) {
        errorMessage.value = 'Las contraseñas no coinciden.';
        return;
    }

    if (!sedeId.value) {
        errorMessage.value = 'Debe seleccionar una sede.';
        return;
    }

    const userData = {
        nombre: nombre.value,
        apellido: apellido.value,
        correo: correo.value,
        contraseña: contraseña.value,
        sedeId: sedeId.value
    };

    try {
        const response = await UsuarioServicio.registrarUsuario(userData);
        if (response.estado === false) {
            errorMessage.value = response.mensaje;
        } else {
            successMessage.value = response;
            setTimeout(() => {
                router.push('/login');
            }, 2000);
        }
    } catch (error) {
        console.error("Error al registrar usuario:", error);
        errorMessage.value = 'Ocurrió un error al intentar registrar el usuario. Por favor, inténtalo de nuevo.';
    }
};
</script>

<template>
    <Topbar />
    <div class="bg-gray-100 flex justify-center items-center py-5">
        <div class="p-8 w-2/6">
            <h2 class="text-center text-5xl font-bold text-gray-800 mb-4">¡Registrate!</h2>
            <div class="mb-4 mt-10">
                <input type="text" id="nombre" placeholder="Nombres" v-model="nombre"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mb-4">
                <input type="text" id="apellido" placeholder="Apellidos" v-model="apellido"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mb-4">
                <input type="email" id="correo" placeholder="Correo electronico" v-model="correo"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mb-4">
                <input type="password" id="contraseña" placeholder="Contraseña" v-model="contraseña"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mb-4">
                <input type="password" id="confirmar_contraseña" placeholder="Confirmar contraseña"
                    v-model="confirmar_contraseña"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mb-10">
                <select name="select" v-model="sedeId"
                    class="bg-[#EFE7D9] shadow appearance-none border-none rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    <option :value="null" disabled>-- Seleccionar sede --</option>
                    <option v-for="sede in sedes" :key="sede.idSede" :value="sede.idSede">{{ sede.nombreSede }}</option>
                </select>
            </div>
            <div class="flex items-center justify-center mt-7">
                <button @click="handleRegistro"
                    class="bg-[#C9A66B] hover:bg-amber-600 text-white text-2xl font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline active:shadow-inner active:scale-95 transition-all duration-100"
                    type="button">
                    Registrarse
                </button>
            </div>
            <p v-if="errorMessage" class="text-red-500 text-center mt-4">{{ errorMessage }}</p>
            <p v-if="successMessage" class="text-green-500 text-center mt-4">{{ successMessage }}</p>
            <div class="mt-4 text-center">
                <span class="text-gray-600 text-1xl">¿Ya tienes una cuenta?
                    <router-link to="/login" class="font-semibold underline text-blue-500 text-1xl hover:text-blue-800">
                        Inicia sesión
                    </router-link>
                </span>
            </div>
        </div>
    </div>
</template>