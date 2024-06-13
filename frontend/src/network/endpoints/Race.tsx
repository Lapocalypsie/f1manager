import { axiosClient } from "../apiClient";

export function GetRace() {
  return axiosClient()
    .get("api/course/makeCourse/1/2/1/2/1/2/10")
    .then((res) => res.data);
}

