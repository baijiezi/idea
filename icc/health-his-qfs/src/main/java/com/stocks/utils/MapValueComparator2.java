package com.stocks.utils;

import java.util.Comparator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-2-19
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
public class MapValueComparator2 implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> me1, Map.Entry<String, Integer> me2) {

        return me1.getValue().compareTo(me2.getValue());
    }
}