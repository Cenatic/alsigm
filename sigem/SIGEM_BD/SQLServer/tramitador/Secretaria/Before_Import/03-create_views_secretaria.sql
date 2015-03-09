
create  view SEC_TBL_VIEW_ORGANO_CARGO  (ID, VALOR, SUSTITUTO, VIGENTE , ORDEN) as

SELECT   CAST ((ORG.ID*100+CARGO.ID) AS int),
	    CAST ( (ORG.VALOR + '-' + CARGO.VALOR) AS CHARACTER VARYING (5) ) ,
	    CAST( (ORG.SUSTITUTO + '-' + CARGO.SUSTITUTO) AS CHARACTER VARYING (129)),
	     CAST (1 AS NUMERIC(1,0))  , CAST(ORG.ORDEN*100+CARGO.ORDEN AS NUMERIC(10,0))
FROM  SEC_VLDTBL_ORGANO_GOBIERNO  ORG , SEC_VLDTBL_CARGO_ORGANO CARGO
;



CREATE VIEW SEC_TBL_VIEW_AREA_CARGO  (ID, VALOR, SUSTITUTO, VIGENTE , ORDEN) as
SELECT  CAST (( AREA.ID*100+CARGO.ID ) AS int),
	CAST ((AREA.VALOR + '-' + CARGO.VALOR) AS  CHARACTER VARYING (5)),
	CAST ((AREA.SUSTITUTO + '-' + CARGO.SUSTITUTO) AS CHARACTER VARYING (129)),
	CAST (1 AS NUMERIC(1,0))  , CAST(AREA.ORDEN*100+CARGO.ORDEN AS NUMERIC(10,0))
FROM  SEC_VLDTBL_AREA_GOBIERNO  AREA , SEC_VLDTBL_CARGO_AREA CARGO
;




CREATE PROCEDURE createViewJerarquiaByName
	@name VARCHAR(255)  ,
	@id INT OUTPUT AS
	DECLARE @stmt		VARCHAR(512)
	SET @stmt='SELECT id from spac_ct_jerarquias where nombre=''' + @name + ''''
	execute sp_executesql @stmt,@id  output
	SET @stmt='CREATE OR REPLACE VIEW SPAC_CT_JERARQUIA_'+ @id +' AS SELECT SPAC_EXPEDIENTES.ID as id, SPAC_EXPEDIENTES.ID   as id_padre , SPAC_EXPEDIENTES.ID as id_hija FROM SPAC_EXPEDIENTES WHERE ID=1;'
	EXEC ( @stmt)
	RETURN @id
	;







