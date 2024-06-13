//import { Select } from "@headlessui/react";
import Hero from "./components/Landing/Hero.tsx";
import Navbar from "./components/Layout/Navbar.tsx";
//import SplashScreen from "./components/Shared/SplashScreen.tsx";
import Selection from "./components/Landing/Selection.tsx";
import Standings from "./components/Racing/Standings.tsx";

function App() {
  return (
    <div>
      {/* <SplashScreen /> */}
      <Navbar />
      <Hero />
      <Selection />
      <Standings />
    </div>
  );
}

export default App;
