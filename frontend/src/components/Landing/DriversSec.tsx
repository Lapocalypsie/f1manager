import decals from "../../assets/Card Decal.png";

import userOneProfileImage from "../../assets/temp/PlayerImageOne.png";
import userTwoProfileImage from "../../assets/temp/PlayerImageTwo.png";
import userThreeProfileImage from "../../assets/temp/PlayerImageThree.png";

import coefficientIcon from "../../assets/icons/coefficient.png";
import enduranceIcon from "../../assets/icons/Endurance.png";
import forceIcon from "../../assets/icons/force.png";

const DriversSec = () => {
  return (
    <div className="bg-[#030710] text-white py-8">
      <div className="max-w-screen-xl mx-auto ">
        <h2 className="font-bold text-4xl">
          Ranking of
          <br /> Individual Standings
        </h2>
        <div className="w-2/5 my-4 border border-gray-400 rounded-full flex flex-row items-center justify-between">
          <div className="bg-white text-gray-900 font-bold font-poppins px-12 py-4 rounded-full cursor-pointer">
            Drivers
          </div>
          <div className="hover:bg-white hover:text-gray-900  duration-200 text-white font-bold font-poppins px-12 py-4 rounded-full cursor-pointer">
            Cars
          </div>
          <div className=" hover:bg-white hover:text-gray-900 duration-200 text-white font-bold font-poppins px-12 py-4 rounded-full cursor-pointer">
            Engine
          </div>
        </div>
        <div className="my-12 flex flex-row items-center justify-between">
          {/* USER ONE */}
          <div className="bg-[#070B16] rounded-md overflow-hidden border-2 border-gray-700 py-4 drop-shadow-lg">
            <div className="text-center flex flex-col items-center justify-start ">
              <img src={userOneProfileImage} />
              <h3 className="k2d-bold text-2xl pt-2">1. Max Verstappen</h3>
              <p className="text-lg text-gray-400 font-bold font-poppins">33</p>

              <div className=" px-8  flex flex-col items-center justify-center gap-2 py-4">
                <div className="flex flex-row items-center justify-start">
                  <img src={enduranceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver’s Endurance is 90
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={forceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Total force 95
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={coefficientIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver has coefficient of 0.5
                  </p>
                </div>
              </div>
              <img src={decals} className="w-full pl-2 py-2" />
            </div>
          </div>

          {/* USER TWO */}

          <div className="bg-[#070B16] rounded-md overflow-hidden border-2 border-gray-700 py-4 drop-shadow-lg">
            <div className="text-center flex flex-col items-center justify-start ">
              <img src={userTwoProfileImage} />
              <h3 className="k2d-bold text-2xl pt-2">2. Pérez Sergio</h3>
              <p className="text-lg text-gray-400 font-bold font-poppins">33</p>

              <div className=" px-8  flex flex-col items-center justify-center gap-2 py-4">
                <div className="flex flex-row items-center justify-start">
                  <img src={enduranceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver’s Endurance is 85
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={forceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Total force 95
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={coefficientIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver has coefficient of 0.5
                  </p>
                </div>
              </div>
              <img src={decals} className="w-full pl-2 py-2" />
            </div>
          </div>

          {/* USER THREE */}

          <div className="bg-[#070B16] rounded-md overflow-hidden border-2 border-gray-700 py-4 drop-shadow-lg">
            <div className="text-center flex flex-col items-center justify-start ">
              <img src={userThreeProfileImage} />
              <h3 className="k2d-bold text-2xl pt-2">3. Leclerc Charles </h3>
              <p className="text-lg text-gray-400 font-bold font-poppins">12</p>

              <div className=" px-8  flex flex-col items-center justify-center gap-2 py-4">
                <div className="flex flex-row items-center justify-start">
                  <img src={enduranceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver’s Endurance is 73
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={forceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Total force 90
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={coefficientIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver has coefficient of 0.1
                  </p>
                </div>
              </div>
              <img src={decals} className="w-full pl-2 py-2" />
            </div>
          </div>

          {/* USER ONE */}
          <div className="bg-[#070B16] rounded-md overflow-hidden border-2 border-gray-700 py-4 drop-shadow-lg">
            <div className="text-center flex flex-col items-center justify-start ">
              <img src={userOneProfileImage} />
              <h3 className="k2d-bold text-2xl pt-2">1. Max Verstappen</h3>
              <p className="text-lg text-gray-400 font-bold font-poppins">33</p>

              <div className=" px-8  flex flex-col items-center justify-center gap-2 py-4">
                <div className="flex flex-row items-center justify-start">
                  <img src={enduranceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver’s Endurance is 90
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={forceIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Total force 95
                  </p>
                </div>

                <div className="flex flex-row items-center justify-start">
                  <img src={coefficientIcon} />
                  <p className="ml-2 font-poppins text-gray-300">
                    Driver has coefficient of 0.5
                  </p>
                </div>
              </div>
              <img src={decals} className="w-full pl-2 py-2" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DriversSec;
