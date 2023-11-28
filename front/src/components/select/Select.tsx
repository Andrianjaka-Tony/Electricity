import { ChangeEventHandler, FC, FocusEvent } from "react";
import "./Select.scss";
import Option from "./option/Option";

interface OptionProp {
  label: string;
  value: string;
}

interface Props {
  label: string;
  id: string;
  name: string;
  value: string;
  options: OptionProp[];
  onChange: ChangeEventHandler<HTMLSelectElement>;
}

const Select: FC<Props> = ({ label, id, name, value, onChange, options }) => {
  const toggleFocus = (event: FocusEvent<HTMLSelectElement>) => {
    const select = event.currentTarget.parentElement?.parentElement;
    select?.classList.toggle("focus");
  };

  const selectProps = {
    name,
    id,
    value,
    onChange,
    onFocus: toggleFocus,
    onBlur: toggleFocus,
  };

  return (
    <div className="select">
      <label htmlFor={id}>{label}</label>
      <div>
        <select {...selectProps}>
          {options.map((option: OptionProp) => (
            <Option key={option.value} {...option} />
          ))}
        </select>
      </div>
    </div>
  );
};

export default Select;
