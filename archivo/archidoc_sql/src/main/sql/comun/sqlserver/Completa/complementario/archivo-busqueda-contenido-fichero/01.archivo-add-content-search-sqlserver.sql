-- A�adir un linked server al servicio de index server 'Web', que debe tener definido como
-- uno de sus directorios la direcci�n de red del repositorio electr�nico (Ej: \\10.228.20.176\repfs)
-- con la informaci�n de usuario y contrase�a rellenas.
	EXEC sp_addlinkedserver FileSystem,
           'Index Server',
           'MSIDXS',
           'Web'