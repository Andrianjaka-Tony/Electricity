import { useNavigate } from "react-router-dom";

const useMove = () => {
  const navigate = useNavigate();

  const move = (link: string) => {
    navigate(link);
  };

  return move;
};

export default useMove;
