-- SELECT * FROM sic_stocks_zjlx_hx s LEFT JOIN sic_stocks_price p ON s.`code` = p.`code` and s.date = p.date where s.chaoDaDanLiuRuZhanBi > 60000 ORDER BY s.chaoDaDanLiuRuZhanBi

SELECT * FROM sic_stocks_zjlx_hx s LEFT JOIN sic_stocks_price p ON s.`code` = p.`code` and s.date = p.date where s.jingLiuRuLv > 80000 ORDER BY s.jingLiuRuLv