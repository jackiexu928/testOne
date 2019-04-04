package com.jackie.testOne.util;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 双色球选号
 *
 * @author xujj
 * @date 2018/9/14
 */
public class DoubleColorBall {
    public static final List<Integer> redBallAllNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                                                    11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                                                                    21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                                                                    31, 32, 33);

    public static final List<Integer> blueSection1 = Arrays.asList(1, 2, 3, 4, 5);
    public static final List<Integer> blueSection2 = Arrays.asList(6, 7, 8, 9, 10);
    public static final List<Integer> blueSection3 = Arrays.asList(11, 12, 13, 14, 15, 16);

    //最近五次红球号码
    public static final List<Integer> lastRed1 = Arrays.asList(1, 10, 14, 15, 18, 31);
    public static final List<Integer> lastRed2 = Arrays.asList(3, 7, 11, 21, 30, 33);
    public static final List<Integer> lastRed3 = Arrays.asList(2, 5, 7, 8, 20, 27);
    public static final List<Integer> lastRed4 = Arrays.asList(2, 12, 13, 23, 27, 28);
    public static final List<Integer> lastRed5 = Arrays.asList(3, 11, 17, 18, 24, 25);

    //最近几次蓝球号码
    public static final Integer lastBlue1 = 13;
    public static final Integer lastBlue2 = 7;
    public static final Integer lastBlue3 = 4;
    public static final Integer lastBlue4 = 12;

    //集团号码
    public static final List<Integer> group = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 14, 16, 18, 24, 25, 28, 32);

    //万能12码
    public static final List<Integer> omnipotent = Arrays.asList(1, 10, 11, 12, 14, 15, 18, 19, 24, 25, 27, 29);

    /**
     * 八卦阵
     * 一西北01.10.19.28；五东南05.14.23.32；
     * 二西02.11.20.29；六北06.15.24.25；
     * 三南03.12.21.30；七东北07.16.17.26；
     * 四东04.13.22.31；八西南08.09.18.27.
     */
    public static final List<Integer> one = Arrays.asList(1, 10, 19, 28);
    public static final List<Integer> two = Arrays.asList(2, 11, 20, 29);
    public static final List<Integer> three = Arrays.asList(3, 12, 21, 30);
    public static final List<Integer> four = Arrays.asList(4, 13, 22, 31);
    public static final List<Integer> five = Arrays.asList(5, 14, 23, 32);
    public static final List<Integer> six = Arrays.asList(6, 15, 24, 25);
    public static final List<Integer> seven = Arrays.asList(7, 16, 17, 26);
    public static final List<Integer> eight = Arrays.asList(8, 9, 18, 27);

    //质数01 03 05 07 11 13 17 19 23 29 31
    public static final List<Integer> primeNumbers = Arrays.asList(1, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

    public static void main(String[] args) {
        printNumbers(5);//打印5注
    }

    /**
     * 打印号码
     * @param num   号码组数
     */
    public static void printNumbers(int num){
        for (int i = 0; i < num; i ++){
            List<Integer> redBalls = getRedBall();
            List<Integer> blueBalls = getBlueBall();
            System.out.println(redBalls + " + " + blueBalls);
        }
    }

    /**
     * 获取红球号码
     * @return
     */
    public static List<Integer> getRedBall(){
        List<Integer> frequentlyNum = getFrequentlyRedBall();
        List<Integer> redBalls = new ArrayList<>();
        boolean flag = true;
        while(flag){
            redBalls = getNumbers(33,6,frequentlyNum);
            if (notHaveFiveInGroup(redBalls) && isInOmnipotent(redBalls) && notHaveThreeInGossip(redBalls)
                    && goldenCut(redBalls) && sumIsNotRepeated(redBalls) && havePrimeNumbers(redBalls)
                    && mantissa(redBalls) && notRepeated(redBalls) && sumMaxAndMin(redBalls)){
                flag = false;
            }
        }
        return redBalls;
    }

    /**
     * 获取蓝球号码
     * @return
     */
    public static List<Integer> getBlueBall() {
        List<Integer> frequentlyNum = getFrequentlyBlueBall();
        List<Integer> blueBalls = new ArrayList<>();
        boolean flag = true;
        while (flag){
            blueBalls = getNumbers(16,1,frequentlyNum);
            if (continuousOddEven(blueBalls)){
                flag = false;
            }
        }
        return blueBalls;
    }

    /**
     * 去除高频号码，随机获取红球或者蓝球
     * @param range 范围，例如红球：33，蓝球：16
     * @param num   个数，红球：6，蓝球：1
     * @param frequentlyNum 高频号码
     * @return
     */
    public static List<Integer> getNumbers(int range, int num, List<Integer> frequentlyNum){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Boolean flag = true;
            int ball = 1 + (int)(Math.random() * range);
            if (list != null && list.size() > 0) {
                begin:
                for (Integer integer : list) {
                    if (frequentlyNum != null && frequentlyNum.size() > 0){
                        for (Integer frequently : frequentlyNum){
                            if (integer == ball || frequently == ball) {
                                flag = false;
                                i--;
                                break begin;
                            }
                        }
                    } else {
                        if (integer == ball) {
                            flag = false;
                            i--;
                            break;
                        }
                    }
                }
            } else {
                if (frequentlyNum != null && frequentlyNum.size() > 0){
                    for (Integer frequently : frequentlyNum){
                        if (frequently == ball) {
                            flag = false;
                            i--;
                            break;
                        }
                    }
                }
            }
            if (flag){
                list.add(ball);
            }
        }
        list.sort(Comparator.naturalOrder());
        return list;
    }

    /**
     * 获取蓝球高频号
     * 蓝球不会连续出现三次
     * 蓝球可分为三个区间：1-5，6-10，11-16，最近两期如果都在同一个区间，下期这个蓝球不会再出现在此区间内
     * xxx 最近100期内只出现四次，4/98，可行
     */
    public static List<Integer> getFrequentlyBlueBall(){
        Map<Integer, Object> section1 = listToMap(blueSection1);
        Map<Integer, Object> section2 = listToMap(blueSection2);
        Map<Integer, Object> section3 = listToMap(blueSection3);
        if (section1.get(lastBlue1) != null && section1.get(lastBlue2) != null){
            return blueSection1;
        }
        if (section2.get(lastBlue1) != null && section2.get(lastBlue2) != null){
            return blueSection2;
        }
        if (section3.get(lastBlue1) != null && section3.get(lastBlue2) != null){
            return blueSection3;
        }
        return null;
    }

    /**
     * 获取红球高频号，一个号码不会连续出现四次
     * 最近5期里，如果出现四次，则下一期一定不会出现
     * @return
     */
    public static List<Integer> getFrequentlyRedBall(){
        List<Integer> frequentlyRedBall = new ArrayList<>();
        Map<Integer, Object> last1 = listToMap(lastRed1);
        Map<Integer, Object> last2 = listToMap(lastRed2);
        Map<Integer, Object> last3 = listToMap(lastRed3);
        Map<Integer, Object> last4 = listToMap(lastRed4);
        Map<Integer, Object> last5 = listToMap(lastRed5);
        for (Integer integer : lastRed1){//一个号码不会连续出现四次
            if (last2.get(integer) != null && last3.get(integer) != null){
                frequentlyRedBall.add(integer);
            }
        }
        List<Integer> last = new ArrayList<>();
        last.addAll(lastRed1);
        last.addAll(lastRed2);
        last.addAll(lastRed3);
        last.addAll(lastRed4);
        last.addAll(lastRed5);
        Map<Integer, Object> redAllNum = listToMap(redBallAllNum);
        for (Integer key : redAllNum.keySet()){
            redAllNum.put(key, 0);//置0
        }
        for (Integer integer : last){
            Integer x = (Integer) redAllNum.get(integer);
            x ++;
            redAllNum.put(integer, x);
            if (x > 3){
                frequentlyRedBall.add(integer);
            }
        }
        return frequentlyRedBall;
    }

    /**
     * 1.集团出号法
     * 这些号码不能超过5个：01 02 03 04 05 06 09 14 16 18 24 25 28 32
     * 选中的号码如果有5个与该号码相同，则排除
     */
    public static boolean notHaveFiveInGroup(List<Integer> redBalls){
        Map<Integer, Object> map = listToMap(group);
        int x = 0;
        for (Integer integer : redBalls){
            if (map.get(integer) != null){
                x ++;
            }
        }
        if (x >= 5){
            return false;
        } else {
            return true;
        }
    }

    /**
     * 2.排除万能12码
     * 双色球每期开奖号码都包含了此12码：01 10 11 12 14 15 18 19 24 25 27 29
     * 如果选择的号码没有这12个码的其中之一，则排除
     */
    public static boolean isInOmnipotent(List<Integer> redBalls){
        Map<Integer, Object> map = listToMap(omnipotent);
        for (Integer integer : redBalls) {
            if (map.get(integer) != null){
                return true;//如果存在就返回true
            }
        }
        return false;
    }

    /**
     * 3、八卦阵排除法
     * 一西北01.10.19.28；五东南05.14.23.32；
     * 二西02.11.20.29；六北06.15.24.25；
     * 三南03.12.21.30；七东北07.16.17.26；
     * 四东04.13.22.31；八西南08.09.18.27.
     * 使用方法：
     * （1）将你自己所选的号码与上面的号对照，如果有三个号与某一组号码相同则是错误的；
     * （2）本号码共八组，可选用一至二个，绝不会在某一组号码中出现三至四个号。
     */
    public static boolean notHaveThreeInGossip(List<Integer> redBalls){
        Map<Integer, Map> map = new HashMap<>();
        map.put(1, listToMap(one));
        map.put(2, listToMap(two));
        map.put(3, listToMap(three));
        map.put(4, listToMap(four));
        map.put(5, listToMap(five));
        map.put(6, listToMap(six));
        map.put(7, listToMap(seven));
        map.put(8, listToMap(eight));
        for (int i = 1; i < 9 ; i ++) {
            int x = 0;
            for (Integer integer : redBalls) {
                if (map.get(i).get(integer) != null){
                    x ++;
                }
            }
            if (x > 2){
                return false;
            }
        }
        return true;
    }

    /**
     * xxx 概率不高
     * 4、排除神奇数字7
     * 与7有关的数字：07 14 16 17 18 21 25 27 28 29，有网友认为，双色球常出号码都跟7有关
     * 您所选中的号码如果没有这些号码或是大于或等于5个，则排除
     */

    /**
     * 5、黄金分割
     * 按照12期来出号次数从少到多进行排列，并将33个号分为3组，每组11个，每期出号每组中不会出现大于5个
     * 您选中的号码大于每组5个时，则排除
     */
    public static boolean goldenCut(List<Integer> redBalls){
        int top = 0;
        int middle = 0;
        int bottom = 0;
        for (Integer integer : redBalls){
            if (integer <= 11){
                bottom ++;
            } else if (integer <= 22){
                middle ++;
            } else {
                top ++;
            }
        }
        if (bottom >= 5 || middle >= 5 || top >= 5){
            return false;
        }
        return true;
    }

    /**
     * 6、排除重复和值
     * 相邻2期开奖号的和值相等的机率非常低
     * 当您所选择的号码有和值与上期和值一样的，则排除
     */
    public static boolean sumIsNotRepeated(List<Integer> redBalls){
        int lastSum = 0;
        int newSum = 0;
        for (int i = 0; i < redBalls.size(); i ++){
            lastSum += lastRed1.get(i);
            newSum += redBalls.get(i);
        }
        if (lastSum == newSum) {
            return false;
        }
        return true;
    }

    /**
     * 7、排除质数为0的号码
     * 双色球质数：01 03 05 07 11 13 17 19 23 29 31
     * 您选中的号码中没有质数时，则删除
     */
    public static boolean havePrimeNumbers(List<Integer> redBalls){
        Map<Integer, Object> map = listToMap(primeNumbers);
        for (Integer integer : redBalls) {
            if (map.get(integer) != null){
                return true;
            }
        }
        return false;
    }

    /**
     * 8、排除没有2、3、6、7、9尾
     * 经研究，双色球自开奖以来多数情况下都带有尾数为2、3、6、7、9的数字，如：02 13 16 27 29等类似号码
     */
    public static boolean mantissa(List<Integer> redBalls){
        for (Integer integer : redBalls){
            int mantissa = integer % 10;
            if (mantissa == 2 || mantissa == 3 || mantissa == 6 || mantissa == 7 || mantissa == 9){
                return true;
            }
        }
        return false;
    }

    /**
     * 蓝球不会出现连续5次以上的奇数或偶数（100期仅出现2次，2/96）
     * @param blueBalls
     * @return
     */
    public static boolean continuousOddEven(List<Integer> blueBalls){
        List<Integer> lastFourBlue = new ArrayList<>();
        lastFourBlue.add(lastBlue1);
        lastFourBlue.add(lastBlue2);
        lastFourBlue.add(lastBlue3);
        lastFourBlue.add(lastBlue4);
        int odd = 0;
        int even = 0;
        for (Integer integer : lastFourBlue){
            if (integer % 2 == 1){
                odd ++;
                even = 0;
            } else {
                even ++;
                odd = 0;
            }
        }
        if (odd == 4 && blueBalls.get(0) % 2 == 1){
            return false;
        }
        if (even == 4 && blueBalls.get(0) % 2 == 0){
            return false;
        }
        return true;
    }

    /**
     * v2.0 更新内容
     * 与往期的号码不能重复
     * @param redBalls
     * @return
     */
    public static boolean notRepeated(List<Integer> redBalls){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < redBalls.size(); i ++){
            stringBuffer.append(redBalls.get(i));
            if (i < redBalls.size() - 1){
                stringBuffer.append(",");
            }
        }
        List<String> oldRedBalls = DoubleColorRedBall.getDoubleColorBallRedBall();
        for (String string : oldRedBalls){
            if (string.equals(stringBuffer.toString())){
                return false;
            }
        }
        return true;
    }

    /**
     * v2.0更新内容
     * 和值区间判断
     * @param redBalls
     * @return
     */
    public static boolean sumMaxAndMin(List<Integer> redBalls){
        int sum = 0;
        for (Integer redBall : redBalls){
            sum += redBall;
        }
        Map<String, Integer> maxAndMin = SumMaxAndMinUtil.getSumMaxAndMin(DoubleColorRedBall.getDoubleColorBallRedBall());
        if (sum <= maxAndMin.get("min") || sum >= maxAndMin.get("max")){
            return false;
        }
        return true;
    }

    /**
     * list转map
     * @param list
     * @return
     */
    public static Map<Integer, Object> listToMap(List<Integer> list){
        Map<Integer, Object> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (Integer integer : list) {
                map.put(integer,integer);
            }
        }
        return map;
    }
}
