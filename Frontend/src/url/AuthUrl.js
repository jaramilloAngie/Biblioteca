export default {
  getAuthUrl: async () => import.meta.env.VITE_AUTH_URL,
  getSedesUrl: async () => import.meta.env.VITE_API_BASE_URL + import.meta.env.VITE_SEDES_URL,
  getRegistroUrl: async () => import.meta.env.VITE_API_BASE_URL + import.meta.env.VITE_REGISTRO_URL,
};