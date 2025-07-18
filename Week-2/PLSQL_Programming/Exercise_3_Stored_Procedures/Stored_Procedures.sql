CREATE OR REPLACE PROCEDURE calculate_rectangle_area (
    p_length IN NUMBER,
    p_width IN NUMBER,
    p_area OUT NUMBER
) IS
BEGIN
    p_area := p_length * p_width;
    DBMS_OUTPUT.PUT_LINE('Area of rectangle: ' || p_area);
END calculate_rectangle_area;
/
DECLARE
    v_area NUMBER;
BEGIN
    calculate_rectangle_area(10, 5, v_area);
END;
/