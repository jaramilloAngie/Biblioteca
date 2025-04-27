<template>
    <div class="w-full h-20 bg-[#C9A66B] flex items-center">
        <div class="w-1/5 h-full flex items-center justify-center">
            <div class="w-full h-full flex items-center justify-center mr-4 object-cover">
                <img src="../assets/Logo.png" alt="Logo" class="h-full w-full object-cover">
            </div>
            <span v-if="loggedInUser" class="text-white font-semibold text-lg">{{ loggedInUser.nombre }}</span>
        </div>
        <div>
            </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const loggedInUser = ref(null);

const setLoggedInUser = (user) => {
    loggedInUser.value = user;
};

defineExpose({
    setLoggedInUser
});
</script>