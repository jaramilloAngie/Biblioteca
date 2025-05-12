import axios from "axios";
import AuthUrl from "../url/AuthUrl";

const getAxiosInstance = async () => {
  const url = await AuthUrl.getAuthUrl();
  return axios.create({
    withCredentials: true,
    baseURL: url,
  });
};

export default getAxiosInstance;