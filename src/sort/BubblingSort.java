package sort;

//冒泡
public class BubblingSort {
    public static void bubblingSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                // 初始化一个布尔值
                boolean flag = true;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // 调换
                        int temp;
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        // 改变flag
                        flag = false;
                    }
                }
                if (flag) { //有序时，提前跳出循环
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        //输入
        int[] arr = new int[]{1, 5, 8, 3, 4, 9, 6, 1, 3, 73, 5};
        bubblingSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
