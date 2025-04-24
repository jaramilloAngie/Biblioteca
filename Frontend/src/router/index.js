import { createRouter, createWebHistory } from 'vue-router';
import Login from '../views/pages/auth/Login.vue';

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: Login
    },    
    //{
        //path: '/recuperar-contrasena',
       //name: 'RecuperarContrasena',
        //component: () => import('../views/RecuperarContrasena.vue')
    //},
    //{
        //path: '/registro',
        //name: 'Registro',
        //component: () => import('../views/Registro.vue')
    //},
    {
        path: '/',
        redirect: '/login'
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;