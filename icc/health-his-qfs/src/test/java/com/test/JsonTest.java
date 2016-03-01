package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-29
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
public class JsonTest {
    public static void main(String[] args){

        String str = "{\"Comment\":[],\"Value\":[\"2\",\"002340\",\"李丽珍\",\"9.58\",\"9.57\",\"9.56\",\"9.55\",\"9.54\",\"9.59\",\"9.60\",\"9.61\",\"9.62\",\"9.63\",\"1812\",\"704\",\"531\",\"281\",\"107\",\"1291\",\"556\",\"404\",\"114\",\"314\",\"10.53\",\"8.61\",\"9.58\",\"9.61\",\"0.01\",\"9.72\",\"0.10\",\"9.81\",\"246638\",\"9.37\",\"2026\",\"9.57\",\"2.37亿\",\"0.89\",\"2.11\",\"55.47\",\"103029\",\"143609\",\"12.36\",\"756\",\"3.15\",\"1\",\"11177161570\",\"13943065493\",\"0|0|0|0|0\",\"0|0|0|0|0\",\"2016-02-28 15:20:27\",\"4.60\",\"-\",\"-\"]}";
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.get("Value"));

    }
}
