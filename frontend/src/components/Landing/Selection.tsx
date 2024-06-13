/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useState } from "react";
import DriversSec from "./DriversSec";
import CarsSec from "./CarsSec";
import EngineSec from "./EngineSec";

const Selection = ({ onRaceStart } : any) => {
  const [currentTab, setCurrentTab] = useState("Drivers");

  const handleTabChange = (tab: string) => {
    setCurrentTab(tab);
  };

  return (
    <div className="bg-[#030710] text-white py-8">
      <div className="max-w-screen-xl mx-auto ">
        <h2 className="font-bold text-4xl">
          Ranking of
          <br/> Individual Standings
        </h2>
        <div className="w-2/5 my-4 border border-gray-400 rounded-full flex flex-row items-center justify-between">
          <div
              className={`${
                  currentTab === "Drivers" ? "bg-white text-black" : "bg-transparent text-white"
              } hover:bg-white hover:text-black duration-200 font-bold font-poppins px-12 py-4 rounded-full cursor-pointer`}
              onClick={() => handleTabChange("Drivers")}
          >
            Drivers
          </div>
          <div
              className={`${
                  currentTab === "Cars" ? "bg-white text-black" : "bg-transparent text-white"
              } hover:bg-white hover:text-black duration-200 font-bold font-poppins px-12 py-4 rounded-full cursor-pointer`}
              onClick={() => handleTabChange("Cars")}
          >
            Cars
          </div>
          <div
              className={`${
                  currentTab === "Engine" ? "bg-white text-black" : "bg-transparent text-white"
              } hover:bg-white hover:text-black duration-200 font-bold font-poppins px-12 py-4 rounded-full cursor-pointer`}
              onClick={() => handleTabChange("Engine")}
          >
            Engine
          </div>
        </div>
        <div className="my-12">
          {currentTab === "Drivers" && <DriversSec/>}
          {currentTab === "Cars" && <CarsSec/>}
          {currentTab === "Engine" && <EngineSec/>}
        </div>
      </div>
      <div className="text-center">
        <button
            className="bg-red-500 py-10 px-20 rounded-full font-bold text-xl"
            onClick={onRaceStart}
        >
          Let's Race Now !
        </button>
      </div>
    </div>
  );
};

export default Selection;
