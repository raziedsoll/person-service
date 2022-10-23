set search_path to medical_schema;
-- 1. Написать запрос, выводящий общие записи из 2 таблиц.

SELECT *
FROM contact AS c
         INNER JOIN address AS a
                    ON c.id = a.contact_id