package com.initKay.interview;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * author: initKay
 * Date: 2018/7/19
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class PascalTriangle {

    public static void main(String[] args) {
        int[] a={5,4,2,4,9,1};
        PascalTriangle pascalTriangle = new PascalTriangle();
        ArrayUtil arrayUtil=new ArrayUtil();
//        pascalTriangle.OneArray();
//        arrayUtil.ArraySort();
//        pascalTriangle.dichotomyLocation();
        //arrayUtil.bubbleSort(a);
    }

    //用一个二维数组打印杨辉三角
    public void doubleArray() {
        //设置杨辉三角的行数
        int num = 10;
        //申请二维数组存放杨辉三角数值
        int[][] yangHui = new int[num][];
        for (int i = 0; i < yangHui.length; i++)
            yangHui[i] = new int[i + 1];
        //利用杨辉三角的计算公式，初始化数组
        for (int i = 0; i < yangHui.length; i++)
            for (int j = 0; j < yangHui[i].length; j++) {
                //每一行第一个数和最后一个数都为1
                yangHui[i][0] = yangHui[i][i] = 1;

                if (i > 1 && j > 0 && j < i)
                    //杨辉三角的值等于其上一层两个值之和
                    yangHui[i][j] = yangHui[i - 1][j] + yangHui[i - 1][j - 1];
            }

        //遍历数组，以输出
        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < (num - i - 1) / 2; j++)
                System.out.print("\t");
            for (int j = 0; j < yangHui[i].length; j++)
                System.out.print(yangHui[i][j] + "\t");

            System.out.println();
        }
    }

    /**
     * 两个二维数组打印杨辉三角
     **/
    public void TwoArray() {
        int num = 20;

        //申请UP数组用以存储上一层的数据
        int[] up = new int[num];
        for (int i = 0; i <= num; i++) {
            //申请a数组用以存放本层的运算结果
            int[] a = new int[i];
            for (int j = 0; j < i; j++) {
                //将本层第一个和最后一个数值赋值为1
                if (j == 0 || j == i)
                    a[j] = up[j] = 1;
                //当从第三行起，非首尾数字的值等于上方两数只和
                if (i > 2 && j != 0 && j != i)
                    a[j] = up[j - 1] + up[j];
            }
            //将本层的运算结果存到up数组中，以供一下次运算使用
            for (int k = 0; k < i; k++)
                up[k] = a[k];

            //打印本层数字
            for (int k = 0; k < (num - i - 1) / 2; k++)
                System.out.print("\t");
            for (int k = 0; k < i; k++)
                System.out.print(a[k] + "\t");

            System.out.println();
        }
    }

    public void OneArray() {
        int num = 10;
        //申请数组存放杨辉三角的数值
        int yangHui[] = new int[(1 + num) * num / 2];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < (num - i - 1) / 2; j++)
                System.out.print("\t");

            //temp表示已经存储的数字个数
            int temp = (1 + i) * i / 2;
            for (int j = 0; j <= i; j++) {
                //每一层的首尾数值为1
                if (j == 0 || j == i)
                    yangHui[temp + j] = 1;
                else
                    //非首尾数值为上面两数之和
                    yangHui[temp + j] = yangHui[temp + j - i] + yangHui[temp + j - i - 1];
                System.out.print(yangHui[temp + j] + "\t");
            }
        }
        System.out.println();
    }

}
