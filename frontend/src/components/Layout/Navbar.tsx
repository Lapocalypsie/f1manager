import Logo from "../../assets/logo.png";

const Navbar = () => {
  return (
    <div className="max-w-screen-xl mx-auto p-4 flex flex-row justify-between">
      <div className="flex flex-row items-center">
        <img src={Logo} className="h-10" alt="Logo" />
        <div className="flex flex-row gap-x-8 px-4 items-center justify-center font-roboto">
          <a href="#">Rules</a>
          <a href="#">Calender</a>
          <a href="#">Standings</a>
          <a href="#">Driver Profiles</a>
        </div>
      </div>
      <div className="bg-gray-950 text-white flex items-center justify-center rounded-full px-8 cursor-pointer">
        Sign Up
      </div>
    </div>
  );
};

export default Navbar;
