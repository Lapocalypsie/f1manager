import decals from "../../assets/Card Decal.png";

//import userOneProfileImage from "../../assets/temp/PlayerImageOne.png";
//import userTwoProfileImage from "../../assets/temp/PlayerImageTwo.png";
//import userThreeProfileImage from "../../assets/temp/PlayerImageThree.png";

import coefficientIcon from "../../assets/icons/coefficient.png";
import enduranceIcon from "../../assets/icons/Endurance.png";
import forceIcon from "../../assets/icons/force.png";

// CAROUSEL
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";
import { useEffect, useState } from "react";

// API

import { GetCars } from "../../network/endpoints/Car";
import { Car } from "../../types/types";

const CarsSec = () => {
  const [cars, setCars] = useState<Car[]>();

  const getAllCarsFromApi = async () => {
    const cars = await GetCars();
    setCars(cars);
    console.log(cars);
  };

  const responsive = {
    superLargeDesktop: {
      breakpoint: { max: 4000, min: 3000 },
      items: 5,
    },
    desktop: {
      breakpoint: { max: 3000, min: 1024 },
      items: 3,
    },
    tablet: {
      breakpoint: { max: 1024, min: 464 },
      items: 2,
    },
    mobile: {
      breakpoint: { max: 464, min: 0 },
      items: 1,
    },
  };

  useEffect(() => {
    getAllCarsFromApi();
  }, []);

  return (
    <div className="my-12">
      {cars ? (
        <Carousel
          additionalTransfrom={0}
          arrows
          autoPlaySpeed={3000}
          draggable
          keyBoardControl
          minimumTouchDrag={80}
          pauseOnHover
          responsive={responsive}
          shouldResetAutoplay
          slidesToSlide={1}
          swipeable
        >
          {cars.map((car) => (
            <div
              key={car.id}
              className="bg-[#070B16] my-4 rounded-md overflow-hidden border-2 border-gray-700 py-4 drop-shadow-lg mx-4"
            >
              <div className="text-center flex flex-col items-center justify-start select-none">
                <img
                  className="w-32 h-32 rounded-full object-cover"
                  src={car.imageF1}
                />
                <h3 className="k2d-bold text-2xl pt-2">
                  Voiture de course N°{car.id}
                </h3>
                <p className="text-lg text-gray-400 font-bold font-poppins">
                  {car.poidsF1}
                </p>
                <div className="px-8 flex flex-col items-center justify-center gap-2 py-4">
                  <div className="flex flex-row items-center justify-start">
                    <img src={enduranceIcon} alt="Endurance Icon" />
                    <p className="ml-2 font-poppins text-gray-300">
                      Weight: {car.poidsF1}
                    </p>
                  </div>
                  <div className="flex flex-row items-center justify-start">
                    <img src={forceIcon} alt="Force Icon" />
                    <p className="ml-2 font-poppins text-gray-300">
                      Max Speed: {car.vitesseMax}
                    </p>
                  </div>
                  <div className="flex flex-row items-center justify-start">
                    <img src={coefficientIcon} alt="Coefficient Icon" />
                    <p className="ml-2 font-poppins text-gray-300">
                      Coefficient: {car.coef}
                    </p>
                  </div>
                  <div className="flex flex-row items-center justify-start">
                    <img src={forceIcon} alt="Force Icon" />
                    <p className="ml-2 font-poppins text-gray-300">
                      0-100 km/h: {car.zeroTo100}
                    </p>
                  </div>
                  <div className="flex flex-row items-center justify-start">
                    <img src={enduranceIcon} alt="Endurance Icon" />
                    <p className="ml-2 font-poppins text-gray-300">
                      Maniability: {car.maniabilty}
                    </p>
                  </div>
                </div>
                <img src={decals} className="w-full pl-2 py-2" alt="Decals" />
              </div>
              <div className="px-8 flex flex-col items-center justify-center gap-2 py-4">
                <button
                  className="bg-orange-500 hover:bg-orange-700 text-white font-bold py-2 px-4 rounded-lg"
                  type="button"
                >
                  Sélectionner
                </button>
              </div>
            </div>
          ))}
        </Carousel>
      ) : (
        ""
      )}
    </div>
  );
};

export default CarsSec;
