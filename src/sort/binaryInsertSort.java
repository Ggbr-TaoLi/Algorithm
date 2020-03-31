package sort;

import java.util.Random;

//折半插入排序
//时间复杂度O(n2) 不稳定
public class binaryInsertSort {
    private static void BinaryInsertSort(int array[], int n) {
        int i, j, low, mid, high, temp;
        for (i = 1; i < n; i++) {
            low = 0;
            high = i - 1;
            temp = array[i];
            //判断插入位置
            while (low <= high)
            {
                mid = (low+high)/2;
                if (array[mid] > temp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (j = i-1; j >= high+1;--j)    //插入元素，high+1后的元素后移
            {
                array[j+1] = array[j];
            }
            array[j+1] = temp;    //将元素插入到指定位置
        }
    }

    public static void main(String arg[]) {
        int[] array = new int[100];
        //数组中添加100个100以内的随机数
        Random random = new Random();
        for (int i = 0;i < 100;++i){
            array[i] = Math.abs(random.nextInt(100));
        }
        BinaryInsertSort(array,array.length);
        for(int arr :array){
            System.out.println(arr);
        }

    }
}
