import forceIcon from "../../assets/icons/force.png";

// CAROUSEL
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";
import { useEffect, useState } from "react";

// API

import { GetEngine } from "../../network/endpoints/Engine";
import { Engine } from "../../types/types";

const EngineSec = () => {
  const [engine, setEngine] = useState<Engine[]>();

  const getAllEnginesFromApi = async () => {
    const engines = await GetEngine();
    setEngine(engines);
    console.log(engines);
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
    getAllEnginesFromApi();
  }, []);

  return (
    <div className="my-12">
      {engine ? (
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
          {engine.map((engine) => (
            <div
              key={engine.id}
              className="bg-[#070B16] my-4 rounded-md overflow-hidden border-2 border-gray-700 py-4 drop-shadow-lg mx-4"
            >
              <div className="text-center flex flex-col items-center justify-start select-none">
                <img
                  className="w-32 h-32 rounded-full object-cover"
                  src={engine.imageMoteur}
                  alt={engine.nomMoteur}
                />
                <h3 className="k2d-bold text-2xl pt-2">{engine.nomMoteur}</h3>
                <p className="text-lg text-gray-400 font-bold font-poppins">
                  Consommation d'essence: {engine.consommationEssence} liters
                </p>
                <div className="px-8 flex flex-col items-center justify-center gap-2 py-4">
                  <div className="flex flex-row items-center justify-start">
                    <img src={forceIcon} alt="Force Icon" />
                    <p className="ml-2 font-poppins text-gray-300">
                      Puissance: {engine.puissance}
                    </p>
                  </div>
                  <div className="flex flex-row items-center justify-start">
                    <p className="ml-2 font-poppins text-gray-300">
                      Prix: {engine.prixMoteur} €
                    </p>
                  </div>
                </div>
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

export default EngineSec;
