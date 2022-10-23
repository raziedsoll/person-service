set search_path to medical_schema;
-- 4.Написать запрос, выводящий список ФЛ с их родителями,
-- у которых отсуствует мед.статус.

-- Отсуствие мед.статуса в таблице medical_card обозначается "-"

SELECT *
FROM person_data AS pd1
         JOIN person_data AS pd2
              ON pd1.parent_id = pd2.id
         JOIN medical_card AS mc
              ON pd2.medical_card_id = mc.id
WHERE mc.med_status = '-'
