<script setup>

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

const admin = 'administrador'
const bibliotecario = 'bibliotecario'
const user = 'usuario'
defineProps(['roles'])

</script>

<template>
    <div>
        <InitAdmin v-if="roles === admin"/>
        <InitLibrarian v-else-if="roles === bibliotecario"/>
        <InitUser v-else-if="roles === user"/>
    </div>
</template>

<style scoped></style>