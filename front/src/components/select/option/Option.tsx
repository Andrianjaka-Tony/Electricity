import { FC } from "react";

interface Props {
  label: string;
  value: string;
}

const Option: FC<Props> = ({ label, value }: Props) => {
  return <option value={value}>{label}</option>;
};

export default Option;
