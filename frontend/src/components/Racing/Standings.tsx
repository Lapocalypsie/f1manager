/* eslint-disable @typescript-eslint/no-explicit-any */
import { useEffect, useState } from "react";
import { GetRace } from "../../network/endpoints/Race";

const Standings = () => {
  const [imageF1, setImageF1] = useState([]);
  const [imagePilote, setImagePilote] = useState([]);
  const [nomPilote, setNomPilote] = useState([]);
  const [prenomPilote, setPrenomPilote] = useState([]);

  useEffect(() => {
    const fetchStandings = async () => {
      const race = await GetRace();
      setImageF1(race.imageF1);
      setImagePilote(race.imagePilote);
      setNomPilote(race.nomPilote);
      setPrenomPilote(race.prenomPilote);
    };
    fetchStandings();
  }, []);

  return (
    <div className="max-w-screen-xl mx-auto p-4">
      <h1 className="text-5xl font-extrabold mb-8 text-center text-gray-800">Race Standings</h1>
      <div className="overflow-x-auto">
        <table className="w-full border-collapse shadow-lg rounded-lg">
          <thead>
            <tr className="bg-gray-800 text-white">
              <th className="py-4 px-6 border-b-2 border-gray-200 text-left text-sm font-semibold uppercase tracking-wider">Rank</th>
              <th className="py-4 px-6 border-b-2 border-gray-200 text-left text-sm font-semibold uppercase tracking-wider">Driver</th>
              <th className="py-4 px-6 border-b-2 border-gray-200 text-left text-sm font-semibold uppercase tracking-wider">Picture</th>
              <th className="py-4 px-6 border-b-2 border-gray-200 text-left text-sm font-semibold uppercase tracking-wider">Car</th>
            </tr>
          </thead>
          <tbody className="bg-white">
            {imageF1.map((image, index) => (
              <tr key={index} className="hover:bg-gray-100 transition duration-300 ease-in-out">
                <td className="py-4 px-6 border-b border-gray-200">{index + 1}</td>
                <td className="py-4 px-6 border-b border-gray-200">{prenomPilote[index]} {nomPilote[index]}</td>
                <td className="py-4 px-6 border-b border-gray-200">
                  <div className="flex justify-center items-center">
                    <img
                      src={imagePilote[index]}
                      alt={`${prenomPilote[index]} ${nomPilote[index]}`}
                      className="w-24 h-24 rounded-full shadow-md"
                    />
                  </div>
                </td>
                <td className="py-4 px-6 border-b border-gray-200">
                  <div className="flex justify-center items-center">
                    <img
                      src={image}
                      alt={`Car of ${prenomPilote[index]} ${nomPilote[index]}`}
                      className="w-36 h-24 rounded-md shadow-md"
                    />
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Standings;
