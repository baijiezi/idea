package com.stocks.task;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-23
 * Time: 下午11:31
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("Default Charset in Use=" + getDefaultCharSet());
    }

    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        String enc = writer.getEncoding();
        return enc;
    }
}


//Default Charset=UTF-8
//file.encoding=UTF-8
//        Default Charset=UTF-8
//        Default Charset in Use=UTF8