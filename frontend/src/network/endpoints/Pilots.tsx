import { axiosClient } from "../apiClient";

export function GetPilots() {
  return axiosClient()
    .get("/pilotes")
    .then((res) => res.data);
}
