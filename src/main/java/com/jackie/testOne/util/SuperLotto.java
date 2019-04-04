package com.jackie.testOne.util;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 大乐透选号
 *
 * @author xujj
 * @date 2018/9/13
 */
public class SuperLotto {
    public static final List<Integer> section1 = Arrays.asList(1, 2, 3, 4, 5);
    public static final List<Integer> section2 = Arrays.asList(6, 7, 8, 9, 10);
    public static final List<Integer> section3 = Arrays.asList(11, 12, 13, 14, 15);
    public static final List<Integer> section4 = Arrays.asList(16, 17, 18, 19, 20);
    public static final List<Integer> section5 = Arrays.asList(21, 22, 23, 24, 25);
    public static final List<Integer> section6 = Arrays.asList(26, 27, 28, 29, 30);
    public static final List<Integer> section7 = Arrays.asList(31, 32, 33, 34, 35);

    public static final List<Integer> last1 = Arrays.asList(7, 9, 13, 14, 33);
    public static final List<Integer> last2 = Arrays.asList(1, 4, 18, 24, 28);
    public static final List<Integer> last3 = Arrays.asList(6, 22, 28, 29, 33);
    public static final List<Integer> last4 = Arrays.asList(16, 18, 24, 25, 27);
    public static final List<Integer> last5 = Arrays.asList(10, 12, 15, 17, 19);

    public static final List<Integer> lastBlue1 = Arrays.asList(2, 4);
    public static final List<Integer> lastBlue2 = Arrays.asList(2, 3);
    public static final List<Integer> lastBlue3 = Arrays.asList(2, 7);
    public static final List<Integer> lastBlue4 = Arrays.asList(2, 7);
    public static final List<Integer> lastBlue5 = Arrays.asList(2, 3);


    public static final int red = 1;
    public static final int blue = 2;

    //万能15码
    public static final List<Integer> omnipotent = Arrays.asList(1, 2, 3, 6, 10, 11, 12, 14, 15, 18, 19, 24, 25, 27, 29);

    public static void main(String[] args) {
        printNumbers(5);//打印5注
    }

    /**
     * 打印号码
     * @param num   号码组数
     */
    public static void printNumbers(int num){
        List<Integer> redFrequentlyNum = new ArrayList<>();
        redFrequentlyNum.addAll(getFrequentlyNum());
        redFrequentlyNum.addAll(getFrequentlyBall(red));
        List<Integer> blueFrequentlyNum = new ArrayList<>();
        blueFrequentlyNum.addAll(getFrequentlyBall(blue));
        for (int i = 0; i < num; i ++){
            List<Integer> redBall = getRedNumbers(redFrequentlyNum);
            List<Integer> blueBall = getblueNumbers(blueFrequentlyNum);
            for (Integer red : redBall){
                System.out.print(red + "\t");
            }
            System.out.println("+" + "\t" + blueBall.get(0) + "\t" + blueBall.get(1));
            //System.out.println(redBall + " + " + blueBall);
        }
    }

    /**
     * 去除高频号码，随机获取红球或者蓝球
     * @param range 范围，例如红球：35，蓝球：12
     * @param num   个数，红球：5，蓝球：2
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
                    if (frequentlyNum != null && frequentlyNum.size() > 0) {
                        for (Integer frequently : frequentlyNum) {
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
                            break begin;
                        }
                    }
                }
            } else {
                if (frequentlyNum != null && frequentlyNum.size() > 0) {
                    for (Integer frequently : frequentlyNum) {
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
     * 获取红球号码
     * 90%以上的奖期存在邻位间距值大于7的号码结构。
     * 所以，在选号时应注意至少要留下2个号码之间的间距大于7的组合，
     * 号码之间的最大间距值一般在8-15之间为最佳
     */
    public static List<Integer> getRedNumbers(List<Integer> frequentlyNum){
        List<Integer> redBall = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            redBall = getNumbers(35, 5, frequentlyNum);
            if (differentValue(redBall) && sumIsNotRepeated(redBall) && isInOmnipotent(redBall) && mantissa(redBall)
                    && notRepeated(redBall) && sumMaxAndMin(redBall)){
                flag = false;
            }
        }
        return redBall;
    }

    /**
     * 获取蓝球号码
     */
    public static List<Integer> getblueNumbers(List<Integer> frequentlyNum){
        List<Integer> blueBall = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            blueBall = getNumbers(12, 2, frequentlyNum);
            if (continuousOddEven(blueBall) && blueNotRepeated(blueBall)){
                flag = false;
            }
        }
        return blueBall;
    }

    /**
     * 获取红球高频号码
     * 前区号码分为七个区间，一区（01-05）、二区（06-10）、三区（11-15）、四区（16-20）、五区（21-25）、六区（26-30）、七区（31-35）
     * 在五期内，同一区间号码总数达到7个的时候，我们可适当的排除此区间号码。
     * 相反，若是某一区间连续五期未曾出现1枚奖号，则需要重点留意。
     */
    public static List<Integer> getFrequentlyNum(){
        List<Integer> last = new ArrayList<>();
        last.addAll(last1);
        last.addAll(last2);
        last.addAll(last3);
        last.addAll(last4);
        last.addAll(last5);
        int secOne = 0;
        int secTwo = 0;
        int secThree = 0;
        int secFour = 0;
        int secFive = 0;
        int secSix = 0;
        int secSeven = 0;
        for (Integer integer : last){
            if (integer >= 1 && integer <= 5){
                secOne ++;
            } else if (integer >= 6 && integer <= 10) {
                secTwo ++;
            } else if (integer >= 11 && integer <= 15) {
                secThree ++;
            } else if (integer >= 16 && integer <= 20) {
                secFour ++;
            } else if (integer >= 21 && integer <= 25) {
                secFive ++;
            } else if (integer >= 26 && integer <= 30) {
                secSix ++;
            } else {
                secSeven ++;
            }
        }
        List<Integer> frequentlyNum = new ArrayList<>();
        if (secOne >= 7){
            frequentlyNum.addAll(section1);
        }
        if (secTwo >= 7){
            frequentlyNum.addAll(section2);
        }
        if (secThree >= 7){
            frequentlyNum.addAll(section3);
        }
        if (secFour >= 7){
            frequentlyNum.addAll(section4);
        }
        if (secFive >= 7){
            frequentlyNum.addAll(section5);
        }
        if (secSix >= 7){
            frequentlyNum.addAll(section6);
        }
        if (secSeven >= 7){
            frequentlyNum.addAll(section7);
        }
        return frequentlyNum;
    }

    /**
     * 获取高频号码
     * 一个号码不会连续出现三次，不管是红球还是蓝球（100期蓝球仅3次，3/98），（100期红球仅3次，3/98）
     * @param color 1：红球    2：蓝球
     * @return
     */
    public static List<Integer> getFrequentlyBall(int color){
        List<Integer> frequentlyBall = new ArrayList<>();
        if (color == red){
            for (Integer integer1 : last1){
                for (Integer integer2 : last2){
                    if (integer1 == integer2){
                        frequentlyBall.add(integer1);
                    }
                }
            }
        } else if(color == blue){
            for (Integer integer1 : lastBlue1){
                for (Integer integer2 : lastBlue2){
                    if (integer1 == integer2){
                        frequentlyBall.add(integer1);
                    }
                }
            }
        }
        return frequentlyBall;
    }

    /**
     * 90%以上的奖期存在邻位间距值大于7的号码结构。
     * 所以，在选号时应注意至少要留下2个号码之间的间距大于7的组合，
     * 号码之间的最大间距值一般在8-15之间为最佳
     */
    public static boolean differentValue(List<Integer> redBalls){
        int x = 0;//间距大于7且小于16的号码个数
        for (int i = 0; i < redBalls.size() - 1; i ++){
            if (redBalls.get(i + 1) - redBalls.get(i) > 7 && redBalls.get(i + 1) - redBalls.get(i) < 16){
                x ++;
            }
        }
        if (x >= 2){
            return true;
        }
        return false;
    }

    /**
     * 相邻两期红球和值不相等
     */
    public static boolean sumIsNotRepeated(List<Integer> redBalls){
        int lastSum = 0;
        int newSum = 0;
        for (int i = 0; i < last1.size(); i ++){
            lastSum += last1.get(i);
            newSum += redBalls.get(i);
        }
        if (lastSum == newSum){
            return false;
        }
        return true;
    }

    /**
     * 蓝球全单/双不会连续出现3次（100期仅1次，1/96），单+双不会连续出现5次（100期仅1次，1/96）
     */
    public static boolean continuousOddEven(List<Integer> blueBall){
        int odd = 0;    //连续奇数次数
        int even = 0;   //连续偶数次数
        int oddEven = 0;//连续奇数+偶数次数
        List<List<Integer>> lastFiveBlue = new ArrayList<>();
        lastFiveBlue.add(lastBlue1);
        lastFiveBlue.add(lastBlue2);
        lastFiveBlue.add(lastBlue3);
        lastFiveBlue.add(lastBlue4);
        for (int i = 0; i < 2; i ++){
            if (lastFiveBlue.get(i).get(0) % 2 == 1 && lastFiveBlue.get(i).get(1) % 2 == 1) {
                odd ++;
                even = 0;
            } else if (lastFiveBlue.get(i).get(0) % 2 == 0 && lastFiveBlue.get(i).get(1) % 2 == 0) {
                even ++;
                odd =0;
            }
        }
        if (odd == 2){
            if (blueBall.get(0) % 2 == 1 && blueBall.get(1) % 2 == 1){
                return false;
            }
        }
        if (even == 2){
            if (blueBall.get(0) % 2 == 0 && blueBall.get(1) % 2 == 0){
                return false;
            }
        }
        for (int j = 0; j < lastFiveBlue.size(); j ++){
            if ((lastFiveBlue.get(j).get(0) + lastFiveBlue.get(j).get(1)) % 2 == 1) {//奇数+偶数=奇数
                oddEven ++;
            } else {
                oddEven = 0;
                break;
            }
        }
        if (oddEven == 4) {
            if ((blueBall.get(0) + blueBall.get(1)) % 2 == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * 排除万能15码
     * 大乐透每期开奖号码都包含了此12码：01 02 03 06 10 11 12 14 15 18 19 24 25 27 29
     * 如果选择的号码没有这12个码的其中之一，则排除
     * xxx 其中 02 03 06还需求证
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
     * 排除没有2、3、6、7、9尾
     * 经研究，自开奖以来多数情况下都带有尾数为2、3、6、7、9的数字，如：02 13 16 27 29等类似号码
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
        List<String> oldRedBalls = RedBall.getDoubleColorBallRedBall();
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
        Map<String, Integer> maxAndMin = SumMaxAndMinUtil.getSumMaxAndMin(RedBall.getDoubleColorBallRedBall());
        if (sum <= maxAndMin.get("min") || sum >= maxAndMin.get("max")){
            return false;
        }
        return true;
    }

    /**
     * v2.0更新内容
     * 蓝球连续5次不会出现重复，经概率计算，连续5次不重复的概率为0.85634709
     * @param blueBall
     * @return
     */
    public static boolean blueNotRepeated(List<Integer> blueBall){
        if (blueBall.get(0).equals(lastBlue1.get(0)) && blueBall.get(1).equals(lastBlue1.get(1))){
            return false;
        } else if (blueBall.get(0).equals(lastBlue2.get(0)) && blueBall.get(1).equals(lastBlue2.get(1))){
            return false;
        } else if (blueBall.get(0).equals(lastBlue3.get(0)) && blueBall.get(1).equals(lastBlue3.get(1))){
            return false;
        } else if (blueBall.get(0).equals(lastBlue4.get(0)) && blueBall.get(1).equals(lastBlue4.get(1))){
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
