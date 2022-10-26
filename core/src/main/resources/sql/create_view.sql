set search_path to medical_schema;

CREATE VIEW med_card_view AS
SELECT mc.id,
       mc.client_status,
       mc.med_status,
       mc.registry_dt,
       mc.comment,
       i.type_id,
       i.heaviness,
       i.appearance_dttm,
       i.recovery_dt
FROM medical_card AS mc
         JOIN illness AS i
              ON mc.id = i.medical_card_id
ORDER BY mc.id
