import { FC } from "react";
import { TfiClose } from "react-icons/tfi";
import { motion } from "framer-motion";
import "./Notification.scss";

interface Props {
  className: string;
  head: string;
  content: string;
}

const Notification: FC<Props> = ({ className, head, content }: Props) => {
  const notificationProps = {
    className: "notification " + className,
    variants: {
      initial: {
        y: "-300px",
      },
      animate: {
        y: 0,
      },
      exit: {
        y: "-300px",
      },
    },
    initial: "initial",
    animate: "animate",
    exit: "exit",
    transition: {
      duration: 0.4,
      type: "spring",
    },
  };

  return (
    <motion.div {...notificationProps}>
      <div className="notification-head">{head}</div>
      <div className="notification-content">{content}</div>
      <TfiClose className="notification-close" />
    </motion.div>
  );
};

export default Notification;
