SELECT weeknum, COUNT(*) 
FROM complaint.complaint
WHERE idsubject='P'
GROUP BY weeknum
ORDER BY weeknum;