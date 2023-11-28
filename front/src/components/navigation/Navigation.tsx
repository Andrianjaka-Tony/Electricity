import { FC, useState } from "react";
import Navbar from "./navbar/Navbar";
import Sidebar from "./sidebar/Sidebar";
import { navbarData, sidebarData } from "./data/navigation-data";
import "./Navigation.scss";

interface Props {}

const Navigation: FC<Props> = () => {
  const [isSidebarOpen, setSidebarOpen] = useState<boolean>();

  return (
    <>
      <Navbar data={navbarData} setSidebarOpen={setSidebarOpen} />
      <Sidebar
        data={sidebarData}
        isSidebarOpen={isSidebarOpen}
        setSidebarOpen={setSidebarOpen}
      />
    </>
  );
};

export default Navigation;
