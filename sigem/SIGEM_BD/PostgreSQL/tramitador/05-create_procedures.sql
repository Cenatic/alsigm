-- Funci�n para abstraerse de la implementaci�n de las secuencias
CREATE OR REPLACE FUNCTION spac_nextval(IN sequence_name character varying, OUT sequence_id numeric) AS
$BODY$DECLARE stmt varchar(512);
BEGIN
stmt:='SELECT nextval(''' || sequence_name || ''')' ; 
EXECUTE  stmt INTO sequence_id;
END$BODY$
  LANGUAGE 'plpgsql' VOLATILE;
 /