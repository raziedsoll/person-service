set search_path to medical_schema;
-- 3. Написать запрос, выводящий первые 50% записей из таблицы (наименьшие id)

SELECT pd.*
FROM person_data AS pd
ORDER BY pd.id
LIMIT (SELECT count(*) FROM person_data) * 0.5