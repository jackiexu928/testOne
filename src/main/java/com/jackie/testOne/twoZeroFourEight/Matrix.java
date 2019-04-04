package com.jackie.testOne.twoZeroFourEight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2019/3/29
 */
public class Matrix {
    public static int[][] initMatrix = {{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0}};
    public static boolean isMerge = false;

    /**
     * 开局
     */
    public static void begin(){
        Random random = new Random();
        boolean flag = true;
        int x1 = random.nextInt(initMatrix[0].length);
        int y1 = random.nextInt(initMatrix.length);
        initMatrix[x1][y1] = 2;
        while (flag){
            int x2 = random.nextInt(initMatrix[0].length);
            int y2 = random.nextInt(initMatrix.length);
            if (x1 != x2 || y1!= y2){
                flag = false;
                initMatrix[x2][y2] = 2;
            }
        }
        show();
    }

    /**
     * 展示
     */
    public static void show(){
        System.out.println("****************************");
        for (int i = 0; i < initMatrix.length; i ++){
            for (int j = 0; j < initMatrix[0].length; j ++){
                if (initMatrix[i][j] == 0){
                    System.out.print("    " + "\t");
                } else {
                    System.out.print(complement(initMatrix[i][j]) + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("****************************");
    }

    /**
     * 为了使数字对齐，将所有数字补全4位
     * @param a
     * @return
     */
    public static String complement(int a){
        String str = a + "";
        while (str.length() < 4){
            str = str + " ";
        }
        return str;
    }

    /**
     * 判断是否结束
     * @return
     */
    public static boolean isOver(){
        //任意相邻两个相等
        for (int i = 0; i < initMatrix.length; i ++){
            for (int j = 0; j < initMatrix[0].length; j ++){
                if (initMatrix[i][j] == 0){
                    return false;
                }
                if (j + 1 < initMatrix[0].length){
                    if (initMatrix[i][j] == initMatrix[i][j + 1]){
                        return false;
                    }
                }
                if (i + 1 < initMatrix.length){
                    if (initMatrix[i][j] == initMatrix[i + 1][j]){
                        return false;
                    }
                }
            }
        }
        System.out.println("Game Over!");
        return true;
    }

    /**
     * 判断是否成功弄出2048
     */
    public static void isWin(){
        for (int i = 0; i < initMatrix.length; i ++){
            for (int j = 0; j < initMatrix[0].length; j ++){
                if (initMatrix[i][j] == 2048){
                    System.out.println("You Win!");
                }
            }
        }
    }

    /**
     * 判断是否不能向左移动
     * @param
     * @return
     */
    public static boolean cannotLeft(){
        for (int i = 0; i < initMatrix.length; i ++){
            int x = -1;
            for (int j = 0; j < initMatrix[0].length; j ++){
                if (initMatrix[i][0] == 0) {
                    if (j != 0 && initMatrix[i][j] != 0) {
                        return false;
                    }
                } else {
                    if (j != 0) {
                        if (initMatrix[i][j] != 0) {
                            if (x == -1) {
                                if (initMatrix[i][j] == initMatrix[i][0]) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            } else if (x == 0){
                                return false;
                            } else {
                                if (initMatrix[i][j] == x) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            }
                        } else {
                            x = 0;
                        }
                    }
                }
            }
        }
        System.out.println("Can't move!");
        return true;
    }
    /**
     * 判断是否不能向右移动
     * @param
     * @return
     */
    public static boolean cannotRight(){
        for (int i = 0; i < initMatrix.length; i ++){
            int x = -1;
            for (int j = initMatrix[0].length - 1; j >= 0; j --){
                if (initMatrix[i][initMatrix[0].length - 1] == 0) {
                    if (j != initMatrix[0].length - 1 && initMatrix[i][j] != 0) {
                        return false;
                    }
                } else {
                    if (j != initMatrix[0].length - 1) {
                        if (initMatrix[i][j] != 0) {
                            if (x == -1) {
                                if (initMatrix[i][j] == initMatrix[i][initMatrix[0].length - 1]) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            } else if (x == 0){
                                return false;
                            } else {
                                if (initMatrix[i][j] == x) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            }
                        } else {
                            x = 0;
                        }
                    }
                }
            }
        }
        System.out.println("Can't move!");
        return true;
    }

    /**
     * 判断是否不能向上移动
     * @param
     * @return
     */
    public static boolean cannotUp(){
        for (int j = 0; j < initMatrix[0].length; j ++){
            int x = -1;
            for (int i = 0; i < initMatrix.length; i ++){
                if (initMatrix[0][j] == 0) {
                    if (i != 0 && initMatrix[i][j] != 0) {
                        return false;
                    }
                } else {
                    if (i != 0) {
                        if (initMatrix[i][j] != 0) {
                            if (x == -1) {
                                if (initMatrix[i][j] == initMatrix[0][j]) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            } else if (x == 0){
                                return false;
                            } else {
                                if (initMatrix[i][j] == x) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            }
                        } else {
                            x = 0;
                        }
                    }
                }
            }
        }
        System.out.println("Can't move!");
        return true;
    }

    /**
     * 判断是否不能向下移动
     * @param
     * @return
     */
    public static boolean cannotDown(){
        for (int j = 0; j < initMatrix[0].length; j ++){
            int x = -1;
            for (int i = initMatrix.length - 1; i >= 0; i --){
                if (initMatrix[initMatrix.length - 1][j] == 0) {
                    if (i != initMatrix.length - 1 && initMatrix[i][j] != 0) {
                        return false;
                    }
                } else {
                    if (i != initMatrix.length - 1) {
                        if (initMatrix[i][j] != 0) {
                            if (x == -1) {
                                if (initMatrix[i][j] == initMatrix[initMatrix.length - 1][j]) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            } else if (x == 0){
                                return false;
                            } else {
                                if (initMatrix[i][j] == x) {
                                    return false;
                                } else {
                                    x = initMatrix[i][j];
                                }
                            }
                        } else {
                            x = 0;
                        }
                    }
                }
            }
        }
        System.out.println("Can't move!");
        return true;
    }

    /**
     * 左移
     */
    public static void left(){
        if (!isOver() && !cannotLeft()){
            for (int i = 0; i < initMatrix.length; i ++){
                List<Integer> list = new ArrayList<>();
                isMerge = false;//是否是合并的数
                for (int j = 0; j < initMatrix[0].length; j ++){
                    if (initMatrix[i][j] != 0){
                        merge(list, initMatrix[i][j]);
                    }
                }
                if (list.size() > 0){
                    for (int k = 0; k < initMatrix[0].length; k ++){
                        if (k < list.size()){
                            initMatrix[i][k] = list.get(k);
                        } else {
                            initMatrix[i][k] = 0;
                        }
                    }
                }
            }
            addNum();
            show();
            isWin();
        }
    }

    /**
     * 右移
     */
    public static void right(){
        if (!isOver() && !cannotRight()){
            for (int i = 0; i < initMatrix.length; i ++){
                List<Integer> list = new ArrayList<>();
                isMerge = false;//是否是合并的数
                for (int j = initMatrix[0].length - 1; j >= 0; j --){
                    if (initMatrix[i][j] != 0){
                        merge(list, initMatrix[i][j]);
                    }
                }
                if (list.size() > 0){
                    for (int k = initMatrix[0].length - 1; k >= 0; k --){
                        if (initMatrix[0].length - 1 - k < list.size()){
                            initMatrix[i][k] = list.get(initMatrix[0].length - 1 - k);
                        } else {
                            initMatrix[i][k] = 0;
                        }
                    }
                }
            }
            addNum();
            show();
            isWin();
        }
    }

    /**
     * 上移
     */
    public static void up(){
        if (!isOver() && !cannotUp()){
            for (int j = 0; j < initMatrix[0].length; j ++){
                List<Integer> list = new ArrayList<>();
                isMerge = false;//是否是合并的数
                for (int i = 0; i < initMatrix.length; i ++){
                    if (initMatrix[i][j] != 0){
                        merge(list, initMatrix[i][j]);
                    }
                }
                if (list.size() > 0){
                    for (int k = 0; k < initMatrix.length; k ++){
                        if (k < list.size()){
                            initMatrix[k][j] = list.get(k);
                        } else {
                            initMatrix[k][j] = 0;
                        }
                    }
                }
            }
            addNum();
            show();
            isWin();
        }
    }

    /**
     * 下移
     */
    public static void down(){
        if (!isOver() && !cannotDown()){
            for (int j = 0; j < initMatrix[0].length; j ++){
                List<Integer> list = new ArrayList<>();
                isMerge = false;//是否是合并的数
                for (int i = initMatrix.length - 1; i >= 0; i --){
                    if (initMatrix[i][j] != 0){
                        merge(list, initMatrix[i][j]);
                    }
                }
                if (list.size() > 0){
                    for (int k = initMatrix.length - 1; k >= 0; k --){
                        if (initMatrix.length - 1 - k < list.size()){
                            initMatrix[k][j] = list.get(initMatrix[0].length - 1 - k);
                        } else {
                            initMatrix[k][j] = 0;
                        }
                    }
                }
            }
            addNum();
            show();
            isWin();
        }
    }

    public static void merge(List<Integer> list, int num){
        if (list.size() > 0){
            if (!isMerge && num == list.get(list.size() - 1)){
                int x = list.get(list.size() - 1);
                x *= 2;
                list.set(list.size() - 1, x);
                isMerge = true;
            } else {
                list.add(num);
                isMerge = false;
            }
        } else {
            list.add(num);
        }
    }

    public static void addNum(){
        Random random = new Random();
        while (true){
            int x = random.nextInt(initMatrix[0].length);
            int y = random.nextInt(initMatrix.length);
            if (initMatrix[x][y] == 0){
                initMatrix[x][y] = 2;
                break;
            }
        }
    }

    public static void main(String[] args) {
        begin();
        System.out.println("←4,→6,↑8,↓2");
        Scanner sc = new Scanner(System.in);
        while (!isOver()){
            int direction = sc.nextInt();
            switch (direction){
                case 4:
                    left();
                    break;
                case 6:
                    right();
                    break;
                case 8:
                    up();
                    break;
                case 2:
                    down();
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
