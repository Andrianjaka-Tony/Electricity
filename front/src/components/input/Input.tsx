import { ChangeEventHandler, FocusEvent, useState, FC } from "react";
import "./Input.scss";

interface Props {
  label: string;
  id: string;
  type: string;
  name: string;
  value: string;
  autoComplete: string;
  required: boolean;
  onChange: ChangeEventHandler<HTMLInputElement>;
}

const Input: FC<Props> = ({
  label = "",
  id = "",
  type = "text",
  name = "",
  value = "",
  autoComplete = "off",
  required = false,
  onChange = () => {},
}: Props) => {
  const [isFocus, setFocus] = useState<boolean>(value.trim() !== "");

  const labelProps = {
    className: isFocus ? "focus" : "",
    htmlFor: id,
  };

  const handleFocus = (event: FocusEvent<HTMLInputElement>) => {
    setFocus(true);
  };

  const handleBlur = (event: FocusEvent<HTMLInputElement>) => {
    const inputValue = event.currentTarget.value;
    if (!inputValue.trim()) {
      setFocus(false);
    }
  };

  const inputProps = {
    id,
    type: isFocus ? type : "text",
    name,
    value,
    autoComplete,
    required,
    onChange,
    onBlur: handleBlur,
    onFocus: handleFocus,
  };

  return (
    <div className="input">
      <label {...labelProps}>{label}</label>
      <input {...inputProps} />
    </div>
  );
};

export default Input;
