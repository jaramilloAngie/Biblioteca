import getAxiosInstance from "@/axios/AxiosManager";
import AuthUrl from "@/url/AuthUrl";

export default {
    async registrarUsuario(userData) {
        const axiosInstance = await getAxiosInstance();
        const registroUrl = await AuthUrl.getRegistroUrl();
        try {
            const response = await axiosInstance.post(registroUrl, userData);
            return response.data;
        } catch (error) {
            if (error.response) {
                return { estado: false, mensaje: error.response.data.mensaje || 'Error al registrar usuario' };
            } else if (error.request) {
                return { estado: false, mensaje: 'No se recibió respuesta del servidor' };
            } else {
                return { estado: false, mensaje: error.message };
            }
        }
    },

    async obtenerSedes() {
        const axiosInstance = await getAxiosInstance();
        const sedesUrl = await AuthUrl.getSedesUrl();
        try {
            const response = await axiosInstance.get(sedesUrl);
            return response.data;
        } catch (error) {
            console.error("Error al obtener sedes:", error);
            return { estado: false, mensaje: 'No se pudieron cargar las sedes.' };
        }
    },
};