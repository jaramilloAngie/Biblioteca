<script setup>

//import InitAdmin from './InitAdminView.vue'
//import InitUser from './InitUserView.vue'
//import InitLibrarian from './InitLibrarianView.vue';
//import CatalogBooks from '../books/CatalogBooks.vue';
import LoanRegistration from '../loans/LoanRegistrationView.vue';

/*export default {
  props: ['role']
}*/

// <InitAdmin v-if="role === 'administrador'" />
// <InitAdmin/>

</script>

<template>
    <div>
        <LoanRegistration/>
    </div>
</template>

<style scoped></style>