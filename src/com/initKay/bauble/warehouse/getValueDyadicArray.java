package com.initKay.bauble.warehouse;

public class getValueDyadicArray {
    /**
     * @param sample 数组
     * @param traget 需要查找的值
     * @param rows   行数
     * @param cols   列数
     * @return 查找状态
     */
    public boolean getTraget(int[][] sample, int traget, int rows, int cols) {

        boolean found = false;
        if (sample != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                int temp = sample[row][col];
                if (traget > temp) {
                    ++row;
                } else if (traget < temp) {
                    --col;
                } else {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }
    private static int[][] sample = new int[][]{{1, 2, 8, 9},
            {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

    public static void printSample() {
        for (int i = 0; i < sample.length; i++) {
            for (int j = 0; j < sample[i].length; j++) {
                System.out.print(sample[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void getValue(String[] args) {
        printSample();
        boolean flag;
        getValueDyadicArray getValueDyadicArray = new getValueDyadicArray();
        flag = getValueDyadicArray.getTraget(sample, 4, 4, 7);
        System.out.println(flag);
    }
}
