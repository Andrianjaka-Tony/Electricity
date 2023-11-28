import { FC } from "react";
import "./Table.scss";

interface Props {
  labels: string[];
  values: string[][];
  width: string[];
}

const Table: FC<Props> = ({ labels, values, width }: Props) => {
  return (
    <table className="table">
      <thead>
        <tr>
          {labels.map((label: string, index: number) => (
            <td style={{ width: width[index] }} key={index}>
              {label}
            </td>
          ))}
        </tr>
      </thead>
      <tbody>
        {values.map((row: string[], index: number) => (
          <tr key={index}>
            {row.map((col: string, index: number) => (
              <td style={{ width: width[index] }} key={index}>
                {col}
              </td>
            ))}
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default Table;
