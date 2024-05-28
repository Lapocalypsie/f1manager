import { useEffect, useState } from "react";

const SplashScreen = () => {
  const [isHidden, setIsHidden] = useState(false);

  useEffect(() => {
    setTimeout(() => {
      setIsHidden(true);
    }, 6000);
  }, []);

  return (
    <div
      className={`overflow-y-hidden  bg-gray-950 duration-300 absolute z-50 top-0 left-0 h-screen w-full flex flex-col gap-y-8 items-center justify-center  ${
        isHidden ? "hidden" : "opacity-100"
      }`}
    >
      <img
        className="h-24"
        src="https://www.f1manager.com/_nuxt/img/f1m2024-logo-primary-animated.aafa515.svg"
      />
      <div className="flex items-center justify-center bg-dark">
        <span className="loading loading-infinity loading-lg text-primary"></span>
      </div>
    </div>
  );
};

export default SplashScreen;
