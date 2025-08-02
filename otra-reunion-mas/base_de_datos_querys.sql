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
        
        