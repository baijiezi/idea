-- SELECT DISTINCT s.code from sic_stocks_zjlx_dfcf s where s.zhuLiJingBi > 50000

-- +12  -2   =1  T0
-- SELECT * from sic_stocks_zjlx_dfcf s where s.zhuLiJingBi >= 50000 ORDER BY s.`code`,s.date asc

-- 准确率高
 SELECT * from sic_stocks_zjlx_dfcf s LEFT JOIN sic_stocks_price p ON s.`code` = p.`code` AND s.date = p.date where s.chaoDaDanJingBi >= 50000 ORDER BY s.date asc

-- +7  -3   =8  T1
-- SELECT * from sic_stocks_zjlx_dfcf s LEFT JOIN sic_stocks_price p ON s.`code` = p.`code` AND s.date = p.date where s.chaoDaDanJingBi >= 45000 and s.chaoDaDanJingBi < 50000 ORDER BY s.`code`,s.date asc

-- +16  -6   =13  T1
-- SELECT * from sic_stocks_zjlx_dfcf s LEFT JOIN sic_stocks_price p ON s.`code` = p.`code` AND s.date = p.date where s.chaoDaDanJingBi >= 40000 and s.chaoDaDanJingBi < 45000 ORDER BY s.`code`,s.date asc

-- SELECT * from sic_stocks_zjlx_dfcf s LEFT JOIN sic_stocks_price p ON s.`code` = p.`code` AND s.date = p.date where s.chaoDaDanJingBi >= 35000 and s.chaoDaDanJingBi < 40000 ORDER BY s.`code`,s.date asc

-- SELECT * from sic_stocks_price s where s.code in(SELECT DISTINCT s.code from sic_stocks_zjlx_dfcf s where s.zhuLiJingBi > 50000) ORDER BY s.`code`,s.date


-- SELECT * from sic_stocks_zjlx_dfcf s where s.chaoDaDanJingBi >= 40000 OR s.zhuLiJingBi >= 40000


