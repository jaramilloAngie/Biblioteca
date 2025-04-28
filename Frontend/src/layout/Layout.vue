<script setup>
import Topbar from './Topbar.vue';
import Menu from './Menu.vue';
import Footer from './Footer.vue';
import { ref, computed } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const isAuthenticated = computed(() => route.meta.requiresAuth !== undefined ? route.meta.requiresAuth : false);
</script>

<template>
    <div class="layout-container">
        <div v-if="isAuthenticated" class="h-screen flex flex-col">
            <Topbar />
            <div class="flex flex-row flex-grow">
                <Menu class="h-full" />
                <div class="layout-main-content flex flex-col flex-grow overflow-y-auto">
                    <router-view />
                    <Footer class="mt-6" /> </div>
            </div>
        </div>
        <router-view v-else class="h-screen" />
    </div>
</template>

<style scoped>
.layout-container {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
}

.layout-main-content {
    display: flex;
    flex-direction: column; /* Para apilar router-view y Footer verticalmente */
    flex-grow: 1;
    padding: 20px;
    overflow-y: auto;
}
</style>