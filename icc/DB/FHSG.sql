-- SELECT * FROM sic_stocks_fhsg s WHERE s.dengJiRi >= '2016-01-01' AND s.fenHong = 0 AND (s.zhuanZeng > 0 OR s.songGu > 0)

 SELECT * FROM sic_stocks_fhsg s LEFT JOIN sic_stocks_price p ON s.`code` = p.`code` AND s.chuQuanRi = p.date WHERE s.chuQuanRi >= '2016-01-01' AND s.fenHong > 4000  ORDER BY s.chuQuanRi

-- SELECT * FROM sic_stocks_fhsg s WHERE s.shouYiLv > 1000 AND s.createAt >= '2016-06-03'  ORDER BY s.shouYiLv DESC