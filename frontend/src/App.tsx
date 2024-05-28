import DriversSec from "./components/Landing/DriversSec.tsx";
import Hero from "./components/Landing/Hero.tsx";
import Navbar from "./components/Layout/Navbar.tsx";
import SplashScreen from "./components/Shared/SplashScreen.tsx";

function App() {
  return (
    <div>
      <SplashScreen />
      <Navbar />
      <Hero />
      <DriversSec />
    </div>
  );
}

export default App;
