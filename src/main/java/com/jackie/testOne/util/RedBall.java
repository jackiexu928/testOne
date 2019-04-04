package com.jackie.testOne.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2019/2/16
 */
public class RedBall {
    /**
     * 最近所有的红球
     * @return
     */
    public static List<String> getDoubleColorBallRedBall(){
        List<String> redBall = new ArrayList<>();
        //----19030-----
        redBall.add("7,9,13,14,33");
        redBall.add("1,4,18,24,28");
        redBall.add("6,22,28,29,33");

        redBall.add("16,18,24,25,27");
        redBall.add("10,12,15,17,19");
        redBall.add("6,13,16,19,29");
        redBall.add("11,17,19,29,33");
        redBall.add("1,3,14,26,30");
        //----19022----
        redBall.add("1,4,14,15,21");
        redBall.add("7,13,17,24,33");
        redBall.add("1,8,16,27,34");
        redBall.add("4,11,19,25,32");
        redBall.add("3,18,19,26,34");
        //----19017----
        redBall.add("1,5,7,22,25");
        redBall.add("3,5,13,16,28");
        redBall.add("2,5,10,13,30");
        redBall.add("12,14,20,28,31");
        redBall.add("8,10,15,17,18");

        redBall.add("5,9,17,18,19");
        redBall.add("4,12,13,16,17");
        redBall.add("3,7,24,25,27");
        redBall.add("3,9,15,18,26");
        redBall.add("3,8,17,20,24");

        redBall.add("3,12,16,29,32");
        redBall.add("14,17,19,25,30");
        redBall.add("21,26,27,29,34");
        redBall.add("15,16,17,31,32");
        redBall.add("4,8,18,20,32");

        redBall.add("2,7,14,22,31");
        redBall.add("6,18,23,26,28");
        redBall.add("14,22,23,26,30");
        redBall.add("3,6,7,8,21");
        redBall.add("2,4,5,12,28");

        redBall.add("4,8,18,29,30");
        redBall.add("5,12,13,31,34");
        redBall.add("1,7,10,11,20");
        redBall.add("2,6,24,33,34");
        redBall.add("1,11,26,33,35");

        redBall.add("3,8,9,13,33");
        redBall.add("9,18,29,31,33");
        redBall.add("6,17,18,24,31");
        redBall.add("4,7,20,22,33");
        redBall.add("19,24,28,29,34");

        redBall.add("3,7,23,26,33");
        redBall.add("1,6,8,12,15");
        redBall.add("5,11,16,28,35");
        redBall.add("1,23,24,28,33");
        redBall.add("7,10,22,23,33");

        redBall.add("3,11,12,19,21");
        redBall.add("14,19,23,27,34");
        redBall.add("4,5,19,31,35");
        redBall.add("8,12,14,15,19");
        redBall.add("3,16,22,23,27");

        redBall.add("12,14,21,32,33");
        redBall.add("3,4,16,18,25");
        redBall.add("4,7,21,22,29");
        redBall.add("11,12,14,16,26");
        redBall.add("1,3,4,11,29");

        redBall.add("11,13,15,21,27");
        redBall.add("7,16,20,21,34");
        redBall.add("8,10,12,19,20");
        redBall.add("6,9,29,32,35");
        redBall.add("8,9,21,30,31");

        redBall.add("6,7,21,29,30");
        redBall.add("21,22,25,27,30");
        redBall.add("6,9,11,16,35");
        redBall.add("4,5,14,21,34");
        redBall.add("7,11,13,22,29");

        redBall.add("1,14,17,21,33");
        redBall.add("2,6,13,18,25");
        redBall.add("12,18,26,28,29");
        redBall.add("8,12,27,31,33");
        redBall.add("3,7,8,9,29");

        redBall.add("3,16,27,28,32");
        redBall.add("6,19,21,27,28");
        redBall.add("10,16,23,25,34");
        redBall.add("9,10,24,31,32");
        redBall.add("7,8,9,10,22");

        redBall.add("4,14,17,24,31");
        redBall.add("1,16,19,20,31");
        redBall.add("1,13,14,26,28");
        redBall.add("14,24,26,28,35");
        redBall.add("6,7,13,22,24");

        redBall.add("3,14,15,23,29");
        redBall.add("6,20,21,26,30");
        redBall.add("12,13,16,20,21");
        redBall.add("2,15,18,25,27");
        redBall.add("10,12,14,18,23");

        redBall.add("13,14,20,28,34");
        redBall.add("7,14,18,29,35");
        redBall.add("11,16,25,30,34");
        redBall.add("3,11,16,18,33");
        redBall.add("5,7,14,18,19");

        redBall.add("6,22,26,28,31");
        redBall.add("6,20,24,33,34");
        redBall.add("26,27,28,32,34");
        redBall.add("8,9,21,25,33");
        redBall.add("3,14,19,23,25");

        redBall.add("16,22,24,29,31");
        redBall.add("1,2,14,25,31");
        redBall.add("6,11,17,22,35");
        redBall.add("7,12,25,27,28");
        redBall.add("1,2,14,17,18");

        redBall.add("2,10,13,21,35");
        redBall.add("7,16,24,26,31");
        redBall.add("3,4,10,27,29");
        redBall.add("7,11,12,22,30");
        redBall.add("1,6,9,15,26");

        redBall.add("7,18,28,29,32");
        redBall.add("1,6,12,20,34");
        redBall.add("3,9,12,28,30");
        redBall.add("13,19,24,25,29");
        redBall.add("5,12,17,24,26");
        return redBall;
    }

    /*public static Map<String, Integer> getSumMaxAndMin(){
        Map<String, Integer> map = new HashMap<>();
        List<String> redBall = getDoubleColorBallRedBall();
        int remainder = redBall.size() % 5;
        if (remainder != 0){
            for (int i = 0; i < remainder; i ++){
                redBall.remove(redBall.size() - i - 1);
            }
        }
        int max = 0;
        int min = 0;
        int sum = 0;
        int lastFourSum = 0;
        for (int j = 0; j < redBall.size(); j ++){
            String string = redBall.get(j);
            String[] s = string.split(",");
            for (int k = 0; k < s.length; k ++){
                int x = Integer.parseInt(s[k]);
                sum += x;
                if (j < 4){
                    lastFourSum += x;
                }
            }
            if ((j + 1) % 5 == 0){
                if (min == 0 || sum < min){
                    min = sum;
                }
                if (sum > max){
                    max = sum;
                }
                sum = 0;
            }
        }
        map.put("min", min - lastFourSum);
        map.put("max", max - lastFourSum);
        return map;
    }*/

    public static void main(String[] args){
        SumMaxAndMinUtil.getSumMaxAndMin(getDoubleColorBallRedBall());
        //每5组的数字之和
        List<String> list = getDoubleColorBallRedBall();
        int sum = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("max", 0);
        map.put("min", 0);
        /*for (int i = 0; i < list.size(); i ++){
            String string = list.get(i);
            String[] s = string.split(",");
            for (int j = 0; j < s.length; j ++){
                int x = Integer.parseInt(s[j]);
                sum += x;
            }
            if ((i + 1) % 5 == 0){
                //System.out.println(sum);
                if (map.get("min") == 0){
                    map.put("min", sum);
                } else if (sum < map.get("min")){
                    map.put("min", sum);
                }
                if (sum > map.get("max")){
                    map.put("max", sum);
                }
                sum = 0;
            }
        }*/
        System.out.println("max = " + map.get("max"));
        System.out.println("min = " + map.get("min"));

        //验证是否会有两组一模一样的号码   经验证不会有重复
        Map<String, String> redBallMap = new HashMap<>();
        for (int k = 0; k < list.size(); k ++){
            String balls = list.get(k);
            if (redBallMap.containsKey(balls)){
                System.out.println(balls);
            } else {
                redBallMap.put(balls, balls);
            }
        }
    }
}
