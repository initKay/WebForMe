package bauble.warehouse;

public class getValueDyadicArray {
    /**
     *
     * @param sample 数组
     * @param traget 需要查找的值
     * @param rows 行数
     * @param cols 列数
     * @return 查找状态
     */
    public boolean getTraget(int[][] sample,int traget,int rows,int cols){

        boolean found=false;
        if (sample!=null&&rows>0&&cols>0){
            int row=0;
            int col=cols-1;
            while (row<rows&&col>=0){
                int temp=sample[row][col];
                if (traget>temp){
                    ++row;
                }else if (traget<temp){
                    --col;
                }else {
                    found=true;
                    break;
                }
            }
        }

        return found;
    }
}
