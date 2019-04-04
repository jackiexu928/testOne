package com.jackie.testOne.util;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/9/18
 */
public class Test {
    /*public static void main(String[] args) {
        String st = "2018-3";
        String ed = "2021-2";
        Integer start = Integer.parseInt(st.replace("-",""));
        Integer end = Integer.parseInt(ed.replace("-",""));
        int num = end % 10 - start % 10 + (end / 10 - start / 10) * 4 + 1;
        List<Map<String, Integer>> quarters = new ArrayList<>();
        for (int i = 0; i < num; i ++){
            int quarter = start % 10 + i;
            int year = start / 10;
            if (quarter > 4){
                year = start / 10 + (quarter - 1) / 4;
                quarter = (quarter % 4) == 0 ? 4 : (quarter % 4);
            }
            Map<String, Integer> map = new HashMap<>();
            map.put("year", year);
            map.put("quarter", quarter);
            quarters .add(map);
            //System.out.println(year + "-" + quarter);
        }
        //System.out.println(num);
        List<String> list = new ArrayList<>();
        list.add("+");
        list.add("");
        list.add("-");
        String[] strings = {"+", "-", "*"};
        System.out.println(list);
        System.out.println(strings[0]);
    }*/
    /*public static void main(String[] args) {
        List<Double> l = new ArrayList<Double>();
        l.add(3.0);
        l.add(1.0);
        l.add(2.0);
        l.add(9.0);
        l.add(7.0);
        //Collections.sort(l);//默认排序(从小到大)
        *//*for(double i : l){
            if (i == 3.0){
                l.remove(i);
            }
            //System.out.println(i);
        }*//*
        for (int i = l.size() - 1; i >= 0; i --){
            if (l.get(i) == 3.0){
                l.remove(i);
            }
        }
        for (int j = 0; j < l.size(); j ++){
            System.out.println(l.get(j));
        }

        //Collections.reverse(l);
        //倒叙(从大到小)
        *//*for(int i : l){
            System.out.println(i);
        }*//*
    }*/
    public static void main(String[] args) {
        System.out.println(powerEquationOfOneUnknown(7,3,-1));
    }

    /**
     * 一元多次方程
     * result = k1 * x^n1 + k2 * x^n2 + ... + b
     * @param d x,k1,n1,k2,n2,...,b
     * @return
     */
    public static double powerEquationOfOneUnknown(double... d){
        double result = 0;
        double x = d[0];
        for (int i = 1; i < d.length; i++) {
            if (i < d.length - 1) {
                result += d[i] * Math.pow(x, d[i + 1]);
            } else {
                result += d[i];
            }
            i ++;
        }
        return result;
    }
}
