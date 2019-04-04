package com.jackie.testOne.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/9/14
 */
public class Probebility {
    public static void main(String[] args){
        //C(33,6)*C(16,1)
        //System.out.println(combination(33,6).multiply(combination(16,1)));
        //System.out.println(combination(35,5));
        System.out.println(caculate(8));
    }

    /**
     * 排列
     * @param n
     * @param m
     * @return
     */
    public static BigInteger permutation(int n, int m){
        if (m > n || n < 0){
            return null;
        }
        BigInteger permutation = factorial(n).divide(factorial(n - m));
        return permutation;
    }

    /**
     * 组合
     * @param n
     * @param m
     * @return
     */
    public static BigInteger combination(int n, int m) {
        if (m > n || n < 0){
            return null;
        }
        BigInteger combination = permutation(n, m).divide(factorial(m));
        return combination;
    }

    /**
     * 阶乘
     * @param n
     * @return
     */
    public static BigInteger factorial(int n){
        //0! = 1
        if (n == 0){
            return new BigInteger("1");
        }
        BigInteger factorial = new BigInteger("1");
        for (int i = 0; i < n; i ++) {
            String f = n - i + "";
            factorial = factorial.multiply(new BigInteger(f));
        }
        return factorial;
    }

    public static BigDecimal caculate(int n){
        BigDecimal fenzi = new BigDecimal("1.0");
        BigDecimal fenmu = new BigDecimal("1.0");
        for (int i = 0; i < n; i ++){
            String f = 66 - i + "";
            fenzi = fenzi.multiply(new BigDecimal(f));
            /*if (i == n - 1){
                String f = n - 1 + "";
                fenzi = fenzi.multiply(new BigDecimal(f));
            } else if (i == 0){
                fenzi = fenzi.multiply(new BigDecimal("66"));
            } else {
                String f = 66 - i + "";
                fenzi = fenzi.multiply(new BigDecimal(f));
            }*/
            fenmu = fenmu.multiply(new BigDecimal("66"));
        }
        BigDecimal bigDecimal = fenzi.divide(fenmu, 8, RoundingMode.HALF_UP);

        return bigDecimal;
    }
}
