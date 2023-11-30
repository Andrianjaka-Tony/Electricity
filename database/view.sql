CREATE VIEW _attendance_day AS
  SELECT
    *,
    (SELECT TO_CHAR(_attendance._date, 'Day')) AS _day
  FROM 
    _attendance;


CREATE VIEW _attendance_avg AS
  SELECT
    _subsector,
    _period,
    AVG(_number) AS _number,
    _day
  FROM
    _attendance_day
  GROUP BY _subsector, _period, _day;
