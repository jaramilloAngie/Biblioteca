import { createRouter, createWebHistory } from 'vue-router';
import LoginView from '../views/auth/LoginView.vue';
import RegistroView from '../views/auth/RegistroView.vue';
import InitView from '../views/init/InitView.vue';
//import LibrosView from '../views/LibrosView.vue';
import UsuariosView from '../views/users/UsersListView.vue';
import PerfilView from '../views/manage/ProfileView.vue';
import ManagePerfilView from '../views/manage/ManageUserProfile.vue';
import LibrosView from '../views/books/CatalogBooks.vue';
import InfoBook from '../views/books/InfoBook.vue';
import AddBook from '../views/books/AddBook.vue';
import PrestamosView from '../views/loans/LoanRegistrationView.vue';
import RecoverPassword from '../views/auth/RecoverPasswordView.vue';
import Layout from '../layout/Layout.vue';

const role = 'administrador'

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: LoginView
    },
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/registro',
        name: 'Registro',
        component: RegistroView
    },
    {
        path: '/recuperar_contraseña',
        name: 'Recuperar_contraseña',
        component: RecoverPassword
    },
    {
        path: '/inicio',
        name: 'Inicio',
        component: InitView,
        meta: { requiresAuth: true, layout: 'main' }
    },
    {
        path: '/perfil',
        name: 'Pefil',
        component: PerfilView,
        meta: { requiresAuth: true, layout: 'main', roles: ['admin'] }
    },
    {
        path: '/libros',
        name: 'Libros',
        component: LibrosView,
        meta: { requiresAuth: true, layout: 'main'},
        props: { roles: role }
    },
    {
        path: '/info_book',
        name: 'Info_book',
        component: InfoBook,
        meta: { requiresAuth: true, layout: 'main'},
        props: { roles: role }
    },
    {
        path: '/add_book',
        name: 'Add_book',
        component: AddBook,
        meta: { requiresAuth: true, layout: 'main'},
        props: { roles: role }
    },
    {
        path: '/usuarios',
        name: 'Usuarios',
        component: UsuariosView,
        meta: { requiresAuth: true, layout: 'main'},
        props: { roles: role }
    },
    {
        path: '/prestamos',
        name: 'Prestamos',
        component: PrestamosView,
        meta: { requiresAuth: true, layout: 'main'},
        props: { roles: role }
    },
    {
        path: '/manage_profile',
        name: 'Manage',
        component: ManagePerfilView,
        meta: { requiresAuth: true, layout: 'main', roles: ['admin'] }
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    next();
});

function getUserRole() {
    return localStorage.getItem('userRole');
}

export default router;