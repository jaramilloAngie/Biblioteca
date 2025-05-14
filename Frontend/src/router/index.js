import { createRouter, createWebHistory } from 'vue-router';
import LoginView from '../views/auth/LoginView.vue';
import RegistroView from '../views/auth/RegistroView.vue';
import InitView from '../views/init/InitView.vue';
//import LibrosView from '../views/LibrosView.vue';
//import UsuariosView from '../views/UsuariosView.vue';
//import ConfiguracionView from '../views/ConfiguracionView.vue';
import LibrosView from '../views/books/CatalogBooks.vue';
import PrestamosView from '../views/loans/LoanRegistrationView.vue';
import Layout from '../layout/Layout.vue';

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
        path: '/inicio',
        name: 'Inicio',
        component: InitView,
        meta: { requiresAuth: true, layout: 'main' },
        props: { roles: 'usuario' }
    },
    //{
        //path: '/configuracion',
        //name: 'Configuracion',
        //component: ConfiguracionView,
        //meta: { requiresAuth: true, layout: 'main', roles: ['admin'] }
    //},
    {
        path: '/libros',
        name: 'Libros',
        component: LibrosView,
        meta: { requiresAuth: true, layout: 'main'},
        props: { roles: 'bibliotecario' }
    },
    {
        path: '/prestamos',
        name: 'Prestamos',
        component: PrestamosView,
        meta: { requiresAuth: true, layout: 'main'},
        props: { roles: 'usuario' }
    }
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