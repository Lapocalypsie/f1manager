import { axiosClient } from "../apiClient";

export function GetCars() {
  return axiosClient()
    .get("/api/f1/all")
    .then((res) => res.data);
}

