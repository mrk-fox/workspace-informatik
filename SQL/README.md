# SQL

No. 1) Welche anderen Fächer (außer Informatik selbst) unterrichten diejenigen Lehrer, die auch Informatik unterrichten?

No. 2)

```sql
SELECT COUNT(*) AS Zaehlung
FROM Ziehung
WHERE (Zahl1 = 10 OR Zahl2 = 10) AND Ziehung.Datum>='2010-01-01'
```
