package com.test;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-14
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 */
public class AsynHttpClientTest {

    public static void main(String[] args){
        AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                .setMaximumConnectionsPerHost(30)
                .setMaximumConnectionsTotal(300)
                .setConnectionTimeoutInMs(20*60*1000)
                .setRequestTimeoutInMs(5 * 1000 * 60)
                .build();
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);

//        String url = "http://vol.stock.hexun.com/603000.shtm";
        String url = "http://vol.stock.hexun.com/Data/Stock/SMinData.ashx?code=002340&count=20&page=1&callback=hx_json14579481800134419886";
        try{
            Future r = asyncHttpClient.prepareGet(url).execute();
            Response response = (Response) r.get();
            String result = response.getResponseBody();
            System.out.println("result: " + result);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
