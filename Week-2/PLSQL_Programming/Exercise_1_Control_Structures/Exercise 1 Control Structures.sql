DECLARE
  num NUMBER := &input_number;
BEGIN
  IF num > 0 THEN
    DBMS_OUTPUT.PUT_LINE('positive');
  ELSIF num < 0 THEN
    DBMS_OUTPUT.PUT_LINE(' Negative');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Zero');
  END IF;
END;
/