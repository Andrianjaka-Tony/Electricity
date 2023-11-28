import { Dispatch, FC, SetStateAction } from "react";
import { HiMiniBars2 } from "react-icons/hi2";
import { NavData } from "../data/navigation-data";
import useMove from "../../../hooks/useMove";

interface Props {
  data: NavData[];
  setSidebarOpen: Dispatch<SetStateAction<boolean | undefined>>;
}

const Navbar: FC<Props> = ({ data, setSidebarOpen }: Props) => {
  const move = useMove();

  const navbarItemProps = ({ name, link }: NavData) => ({
    key: link,
    onClick: () => {
      move(link);
    },
    className: "navbar-item",
  });

  const hamburgerProps = {
    className: "navbar-hamburger",
    onClick: () => {
      setSidebarOpen(true);
    },
  };

  return (
    <nav className="navbar">
      <img
        src="./image/nav-logo.png"
        alt="Navigation logo"
        className="navbar-logo"
      />
      <div className="navbar-items">
        {data.map(({ name, link }: NavData) => (
          <div {...navbarItemProps({ name, link })}>{name}</div>
        ))}
      </div>
      <HiMiniBars2 {...hamburgerProps} />
    </nav>
  );
};

export default Navbar;
