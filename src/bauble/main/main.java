package bauble.main;

import bauble.warehouse.getValueDyadicArray;

public class main {
    private static int[][] sample = new int[][] { { 1, 2, 8, 9 },
            { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };

    public static void printSample() {
        for (int i = 0; i < sample.length; i++) {
            for (int j = 0; j < sample[i].length; j++) {
                System.out.print(sample[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        printSample();
        boolean flag;
        getValueDyadicArray getValueDyadicArray= new getValueDyadicArray();
        flag=getValueDyadicArray.getTraget(sample, 4, 4, 7);
        System.out.println(flag);
    }
}
