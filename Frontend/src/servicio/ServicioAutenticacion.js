import getAxiosInstance from "../axios/AxiosManager";

export default {
    async authLogin(correo, contraseña) {
        const axiosInstance = await getAxiosInstance();
        return axiosInstance.post('/login', {
            correo: correo,
            contraseña: contraseña
        });
    },

    async authLogout(){
        const axiosInstance = await getAxiosInstance();
        return axiosInstance.post('/logout');
    },
};