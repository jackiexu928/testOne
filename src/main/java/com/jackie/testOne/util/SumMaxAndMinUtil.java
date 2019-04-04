package com.jackie.testOne.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2019/2/28
 */
public class SumMaxAndMinUtil {
    public static Map<String, Integer> getSumMaxAndMin(List<String> redBall){
        Map<String, Integer> map = new HashMap<>();
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
    }
}
