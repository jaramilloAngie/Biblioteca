<script setup>
import { useRoute } from 'vue-router';
import InitAdmin from './InitAdminView.vue'
import InitUser from './InitUserView.vue'
import InitLibrarian from './InitLibrarianView.vue';
//import CatalogBooks from '../books/CatalogBooks.vue';
//import LoanRegistration from '../loans/LoanRegistrationView.vue';
//import AddUser from '../manage/AddUser.vue';

/*export default {
  props: ['role']
}*/

// <InitAdmin v-if="role === 'administrador'" />
// <InitAdmin/>

const route = useRoute();

const role = route.query.role

const admin = 'ROLE_Administrador'
const bibliotecario = 'ROLE_Bibliotecario'
const user = 'ROLE_Lector'

</script>

<template>
    <div>
        <InitAdmin v-if="role === admin"/>
        <InitLibrarian v-else-if="role === bibliotecario"/>
        <InitUser v-else-if="role === user"/>
    </div>
</template>

<style scoped></style>