--Inserta una nueva direcci�n telem�tica de personas
INSERT INTO scr_typeaddress (id, description, code) VALUES (4, 'Direcci�n electr�nica �nica', 'DU');

-- TABLA scr_typeaddress
-- Modificamos los valores del registro de telefono para poner telefono (fijo)
update scr_typeaddress set description='Tel�fono (fijo)', code='TF' where id = 1;

--Insertamos el nuevo valor para telefono movil
insert into scr_typeaddress (id, description, code) values (5,'Tel�fono (m�vil)','TM');
