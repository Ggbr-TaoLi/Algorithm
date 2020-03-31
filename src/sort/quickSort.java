package sort;

import java.util.ArrayList;
import java.util.Random;

//快速排序
//平均时间复杂度O(nlogn) 不稳定
public class quickSort {
     private static void QuikSort(ArrayList<Integer> array, int left , int right){
         if(left > right){ //递归终止条件
             return;
         }
         int pivot = array.get(left); //获取基准值（一般令第一个值为基准值）
         int l = left;
         int r = right;
         while(l!=r){ //终止条件，确定pivot的最终位置
             //从右往左找出小于pivot的数
             while (array.get(r)>=pivot && l<r) r--;
             //从左往右找出大于pivot的数
             while (array.get(l)<=pivot && l<r) l++;
             //交换彼此位置
             if(l<r){
                 int temp = array.get(r);
                 array.set(r,array.get(l));
                 array.set(l,temp);
             }
         }
         //交换基准值与最终位置的数
         array.set(left,array.get(l));
         array.set(l,pivot);
         //递归执行
         QuikSort(array,left,l-1);
         QuikSort(array,l+1,right);
    }

    public static void main(String arg[]){
        ArrayList<Integer> array = new ArrayList<>();
        //添加100个100以内的随机数
        Random random = new Random();
        for(int i=0;i<100;++i){
            array.add( Math.abs(random.nextInt(100)));
        }
        QuikSort(array,0,array.size()-1);
        for(int arr : array){
            System.out.println(arr);
        }
    }
}
