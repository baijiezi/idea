package com.stocks.utils;

import java.util.Comparator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-11-13
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public class MapValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> me1, Map.Entry<Integer, Integer> me2) {

        return me1.getValue().compareTo(me2.getValue());
    }
}