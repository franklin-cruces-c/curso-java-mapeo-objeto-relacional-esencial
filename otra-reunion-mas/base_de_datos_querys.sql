SELECT * FROM reunion;

SELECT *, now() FROM reunion WHERE fecha > now();


SELECT * FROM sala WHERE capacidad >= 4;


-- Query generada por JPA - Hibernate
select
        pr.participantes_id,
        pr.reuniones_id,
        r.id,
        r.asunto,
        r.fecha ,
        r.sala_id,
        acta2_.id,
        acta2_.contenido,
        acta2_.reunion_id 
    from
        persona_reunion pr 
    inner join
        reunion r 
            on pr.reuniones_id=r.id 
    left outer join
        acta acta2_ 
            on r.id=acta2_.reunion_id 
    where
        pr.participantes_id=1
        
        
SELECT a.*, r.fecha 
FROM acta a
INNER JOIN reunion r ON a.reunion_id = r.id
WHERE r.fecha < now() -1;

--Las reuniones de un empleado
SELECT r.*,p.nombre 
FROM reunion r
INNER JOIN persona_reunion pr ON pr.reuniones_id = r.id 
INNER JOIN persona p ON  p.id = pr.participantes_id  
WHERE p.numeroEmpleado ='E002';

        
        
        