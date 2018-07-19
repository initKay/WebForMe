package com.initKay.interview;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * author: initKay
 * Date: 2018/7/19
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 * Description:
 * 一维数组的几种排序方式
 */
public class ArrayUtil {
    /**
     * Array自带的sort方法进行排序
     */
    public void ArraySort() {
        int[] a = {5, 4, 2, 4, 9, 1};
        Arrays.sort(a);  //进行排序
        for (int i : a) {
            System.out.print(i);
        }
    }

    /**
     * 冒泡法排序
     *
     * @param args 输入数组
     * @return 数组
     */
    public int[] bubbleSort(int[] args) {//冒泡排序算法
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i] > args[j]) {
                    int temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }
        return args;
    }

    /**
     * 选择排序法
     * @param a 数组
     */
    public static void selectSort(int[] a) {
        int minIndex = 0;
        int temp = 0;
        if ((a == null) || (a.length == 0))
            return;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;//无序区的最小数据数组下标
            for (int j = i + 1; j < a.length; j++) {
                //在无序区中找到最小数据并保存其数组下标
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                //如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
                temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    /**
     * 插入排序法
     * @param args 数组
     * @return 返回
     */
    public static int[] insertSort(int[] args)
    {
        if(args==null||args.length<2){
            return args;
        }
        for(int i=1;i<args.length;i++)
        {
            for(int j=i;j>0;j--)
            {
                if (args[j]<args[j-1])
                {
                    int temp=args[j-1];
                    args[j-1]=args[j];
                    args[j]=temp;
                }else break;
            }
        }
        return args;
    }

    /**
     * 二分法从数组中查找某个数N
     */
    public void dichotomyLocation(){
        int[] a={40,60,30,80,50,20,90,20,10,70};
        int target=80;
        Arrays.sort(a);
        boolean result=false;
        int min=0;
        int max=a.length-1;
        while(min<=max){
            int b=(min+max)/2;
            if(target>a[b]){
                min=b+1;
            }
            if(target<a[b]){
                max=b-1;
            }
            if(target==a[b]){
                min++;
                result=true;

            }

        }
        System.out.println(result);
    }
}
