<script setup>
import Topbar from './Topbar.vue';
import Menu from './Menu.vue';
import { ref, computed } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();

// isAuthenticated ahora es una computed property que depende de la ruta actual
const isAuthenticated = computed(() => route.meta.requiresAuth !== undefined ? route.meta.requiresAuth : false);
</script>

<template>
    <div class="layout-container">
        <div v-if="isAuthenticated">
            <Topbar />
            <div class="layout-main-sidebar">
                <Menu />
                <div class="layout-main-content">
                    <router-view />
                </div>
            </div>
        </div>
        <router-view v-else />
    </div>
</template>

<style scoped>
.layout-container {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
}

.layout-main-sidebar {
    display: flex;
    flex-grow: 1;
}

.layout-main-content {
    flex-grow: 1;
    padding: 20px;
}
</style>