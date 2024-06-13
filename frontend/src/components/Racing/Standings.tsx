// components/Standings.js
const standings = [
  {
    rank: 1,
    driver: "M. Verstappen",
    team: "Red Bull",
    points: 169,
    wins: 5,
    podiums: 6,
  },
  {
    rank: 2,
    driver: "C. Leclerc",
    team: "Ferrari",
    points: 138,
    wins: 1,
    podiums: 5,
  },
  // ... (add the rest of the data)
];

const Standings = () => {
  return (
    <div className="max-w-screen-xl mx-auto p-4 justify-between">
      <h1 className="text-3xl font-bold mb-4">Race Standing</h1>
      <div>
        <table className="w-full border-collapse">
          <thead>
            <tr className="bg-gray-200">
              <th className="py-2 px-4 border">Rank</th>
              <th className="py-2 px-4 border">Driver</th>
              <th className="py-2 px-4 border">Points</th>
              <th className="py-2 px-4 border">Wins</th>
              <th className="py-2 px-4 border">Podiums</th>
            </tr>
          </thead>
          <tbody>
            {standings.map((driver) => (
              <tr key={driver.rank} className="odd:bg-gray-100">
                <td className="py-2 px-4 border">{driver.rank}</td>
                <td className="py-2 px-4 border">
                  {driver.driver}{" "}
                  <span className="text-gray-500">({driver.team})</span>
                </td>
                <td className="py-2 px-4 border text-right">{driver.points}</td>
                <td className="py-2 px-4 border text-right">{driver.wins}</td>
                <td className="py-2 px-4 border text-right">
                  {driver.podiums}
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
