package com.stocks.task;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-28
 * Time: 上午10:19
 * To change this template use File | Settings | File Templates.
 */
public class StockDailyTask2 {

    public static void main(String[] args){
        try{
            AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                    .setMaximumConnectionsPerHost(30)
                    .setMaximumConnectionsTotal(300)
                    .setConnectionTimeoutInMs(3000)
                    .setRequestTimeoutInMs(5 * 1000 * 60)
                    .build();
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

            String url = "http://nuff.eastmoney.com/EM_Finance2015TradeInterface/JS.ashx?id=0023402&token=beb0a0047196124721f56b0f0ff5a27c&cb=callback08984737466089427&callback=callback08984737466089427&_=1456623860821";
            Future r = asyncHttpClient.prepareGet(url).execute();
            Response response = (Response) r.get();
            String result = response.getResponseBody();
            //callback08984737466089427({"Comment":[],"Value":["2","002340","格林美","9.58","9.57","9.56","9.55","9.54","9.59","9.60","9.61","9.62","9.63","1812","704","531","281","107","1291","556","404","114","314","10.53","8.61","9.58","9.61","0.01","9.72","0.10","9.81","246638","9.37","2026","9.57","2.37亿","0.89","2.11","55.47","103029","143609","12.36","756","3.15","1","11177161570","13943065493","0|0|0|0|0","0|0|0|0|0","2016-02-28 15:20:27","4.60","-","-"]})
            System.out.println(result);


            url = "http://hqdigi2.eastmoney.com/EM_Quote2010NumericApplication/CompatiblePage.aspx?Type=fs&jsName=js&stk=5100101&Reference=xml&rt=0.41115833702497184";
            r = asyncHttpClient.prepareGet(url).execute();
            response = (Response) r.get();
            result = response.getResponseBody();
            //var js={skif:"1,510010,治理ETF,0.834,0.013,1.58%,,,0.802,0.821,0.838,0.802,0.00%,0.000,0.843,4.38%,0.818,1776,0,14,,,539,1237,-84.31%,-2633,0,2016-02-26 15:03:13,1",bsif:["0.847,116,0","0.842,190,0","0.838,10,0","0.835,231,0","0.834,2331,0","0.811,56,0","0.810,56,0","0.808,13,0","0.806,20,0","0.805,100,0"],dtif:["14:56:12,0.834,1,1","14:49:10,0.834,1,1","14:36:38,0.809,13,-1","14:23:05,0.835,1,1","14:08:02,0.819,100,1","13:29:37,0.807,24,-1","13:27:06,0.806,169,-1","13:26:51,0.809,57,-1","13:26:36,0.810,2,-1","13:14:18,0.810,2,-1","13:05:00,0.819,2,1","11:25:18,0.817,2,1","11:11:29,0.812,46,1","11:10:59,0.812,9,-1","10:51:39,0.812,144,-1","10:47:22,0.813,1,-1","10:46:22,0.813,1,-1","10:45:07,0.813,1,-1","10:44:22,0.813,3,-1","10:36:34,0.824,400,1","10:33:34,0.823,5,1","10:27:47,0.814,68,0","10:27:02,0.814,40,0","10:26:47,0.814,40,0","10:26:01,0.820,400,1"],dpif:["1,000001,上证指数,2767.21,25.96,0.95%,19006898,634,106,387,,,,,,-1","2,399001,深证成指,9573.70,22.63,0.24%,29632934,714,225,849,,,,,,-1"]};
            System.out.println(result);

        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
