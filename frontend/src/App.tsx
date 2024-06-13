import React, { useState } from "react";
import Hero from "./components/Landing/Hero.tsx";
import Navbar from "./components/Layout/Navbar.tsx";
import Selection from "./components/Landing/Selection.tsx";
import Standings from "./components/Racing/Standings.tsx";

function App() {
  const [showStandings, setShowStandings] = useState(false);

  const handleRaceStart = () => {
    setShowStandings(true);
  };

  return (
    <div>
      <Navbar />
      <Hero />
      <Selection onRaceStart={handleRaceStart} />
      {showStandings ? <Standings /> : ""}
    </div>
  );
}

export default App;
