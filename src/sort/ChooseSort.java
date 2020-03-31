package sort;

public class ChooseSort {
    public static void chooseSort(int[] arr){
        for(int i = 0; i < arr.length - 1 ; i++){
            int min = i; // 遍历的区间最小的值
            for (int j = i + 1; j < arr.length ;j++){
                if(arr[j] < arr[min]){
                    // 找到当前遍历区间最小的值的索引
                    min = j;
                }
            }
            if(min != i){
                // 发生了调换
                int temp =  arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        //输入
        int[] arr = new int[]{1, 5, 8, 3, 4, 9, 6, 1, 3, 3, 5};
        chooseSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

}
