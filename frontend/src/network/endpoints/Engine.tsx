import { axiosClient } from "../apiClient";

export function GetEngine(){
    return axiosClient()
      .get("/api/moteur/all")
      .then((res) => res.data);
  }
  