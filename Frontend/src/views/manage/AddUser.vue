<script setup>

</script>
<template>
    <div>
        <label class="header flex justify-center font-bold">Agregar Usuario</label>
        <div>
            <div class="mt-7 ml-5 flex flex-col">
                <label class="p-1 fields">Nombre</label>
                <input id="name"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-3 ml-5 flex flex-col">
                <label class="p-1 fields">Correo electrónico</label>
                <input id="email" type="email" placeholder="tucorreo@ejemplo.com" required
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-3 ml-5 flex flex-col">
                <label class="p-1 fields">Número de teléfono</label>
                <input id="phoneNumber" type="tel" pattern="[0-9]{10}" maxlength="10" placeholder="+57" required
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-3 ml-5 flex flex-col">
                <label class="p-1 fields">Contraseña</label>
                <input id="password" type="password"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="mt-3 ml-5 flex flex-col">
                <label class="p-1 fields">Rol</label>
                <select id="Rol" v-model="numeroSeleccionado"
                    class="fields bg-[#D9D9D9] shadow appearance-none border-none rounded w-xl py-1 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    <option disabled value="">Selecciona un rol</option>
                    <option value="Bibliotecario">Bibliotecario</option>
                    <option value="Usuario">Lector</option>
                </select>
            </div>
        </div>
        <div class="flex justify-center">
            <button class="cursor-pointer bg-[#C9A66B] p-2 rounded text-2xl mt-8 w-2xs">
                <span>Añadir</span>
            </button>
        </div>
    </div>
</template>
<style scoped>
.header {
    font-size: 1.7rem
}

.fields {
    font-size: 1.5rem;
}
</style>