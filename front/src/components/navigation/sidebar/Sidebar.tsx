import { Dispatch, FC, SetStateAction } from "react";
import { motion } from "framer-motion";
import { TfiClose } from "react-icons/tfi";
import { NavData } from "../data/navigation-data";
import useMove from "../../../hooks/useMove";
import { AnimatePresence } from "framer-motion";

interface Props {
  data: NavData[];
  isSidebarOpen: boolean | undefined;
  setSidebarOpen: Dispatch<SetStateAction<boolean | undefined>>;
}

const Sidebar: FC<Props> = ({ data, isSidebarOpen, setSidebarOpen }: Props) => {
  const move = useMove();

  const sidebarProps = {
    className: "sidebar",
    variants: {
      initial: {
        scaleY: 0,
      },
      animate: {
        scaleY: 1,
        transition: {
          when: "beforeChildren",
          ease: "easeOut",
          duration: 0.4,
          staggerChildren: 0.05,
          delayChildren: 0.2,
        },
      },
      exit: {
        translateY: "100%",
        transition: {
          when: "afterChildren",
          ease: "easeOut",
          duration: 0.4,
          staggerChildren: 0.05,
          delay: 0.2,
        },
      },
    },
    initial: "initial",
    animate: "animate",
    exit: "exit",
  };

  const closeProps = {
    className: "sidebar-close",
    onClick: () => {
      setSidebarOpen(false);
    },
  };

  const sidebarItemProps = ({ name, link }: NavData) => ({
    key: link,
    onClick: () => {
      setSidebarOpen(false);
      move(link);
    },
    className: "sidebar-item",
    variants: {
      initial: {
        opacity: 0,
      },
      animate: {
        opacity: 1,
      },
      exit: {
        opacity: 0,
      },
    },
  });

  return (
    <>
      <AnimatePresence>
        {isSidebarOpen && (
          <motion.aside key={"aside"} {...sidebarProps}>
            <TfiClose {...closeProps} />
            <div className="sidebar-items">
              {data.map(({ name, link }: NavData) => (
                <motion.div {...sidebarItemProps({ name, link })}>
                  {name}
                </motion.div>
              ))}
            </div>
          </motion.aside>
        )}
      </AnimatePresence>
    </>
  );
};

export default Sidebar;
