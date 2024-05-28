import heroPilots from "../../assets/hero-pilots.png";
import decals from "../../assets/Decals.png";

const Hero = () => {
  return (
    <div className="max-w-screen-xl mx-auto  grid grid-cols-2 bg-[#E10700]  my-12 rounded-xl">
      <div className="text-white pl-8 relative py-20">
        <h2 className="k2d-bold text-5xl">
          Formula One
          <br /> Makkers Online Racing
        </h2>
        <p className="text-md text-gray-100 font-medium pt-4">
          Become the ultimate F1 manager. Strategize,
          <br /> optimize, and lead your team to victory.
        </p>
        <div className="bg-white w-5/6 inline-block absolute bottom-0 py-4 rounded-t-md drop-shadow-md">
          <div className="flex flex-row gap-x-8  items-center justify-center font-roboto text-gray-950">
            <a href="#">Rules</a>
            <span className="h-[25px] inline-block bg-gray-300 w-[2px]" />
            <a href="#">Calender</a>
            <span className="h-[25px] inline-block bg-gray-300 w-[2px]" />
            <a href="#">Standings</a>
            <span className="h-[25px] inline-block bg-gray-300 w-[2px]" />
            <a href="#">Driver Profiles</a>
          </div>
        </div>
      </div>
      <div className="flex items-center justify-end relative overflow-hidden">
        <img className="z-10" src={heroPilots} />
        <img className="absolute top-10 z-0 scale-125" src={decals} />
      </div>
    </div>
  );
};

export default Hero;
