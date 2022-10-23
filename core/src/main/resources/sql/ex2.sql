set search_path to medical_schema;
-- 2. Удалить строки-дубликаты (не учитывая id)

-- Посмотреть на дубликаты
-- SELECT DISTINCT (il1.*)
-- FROM illness AS il1,
--      illness AS il2
-- WHERE il1.id <> il2.id
--   AND il1.type_id = il2.type_id
--   AND il1.heaviness = il2.heaviness
--   AND il1.appearance_dttm = il2.appearance_dttm
--   AND il1.recovery_dt = il2.recovery_dt


-- Удалить дубликаты
DELETE
FROM illness AS il1 using illness as il2
WHERE il1.id > il2.id
  AND il1.type_id = il2.type_id
  AND il1.heaviness = il2.heaviness
  AND il1.appearance_dttm = il2.appearance_dttm
  AND il1.recovery_dt = il2.recovery_dt
