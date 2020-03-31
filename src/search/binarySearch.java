package search;
//折半查找
public class binarySearch {
    private static int BinarySearch(int array[],int low,int high,int x) {
        if ( low>high ) {
            return -1; // 查找失败
        }
       int mid = (low + high) / 2;
        if ( array[mid] == x ) {
            return mid; // 查找到
        } else if ( x < array[mid] ) {
            return BinarySearch(array, low, mid - 1, x);
        } else {
            return BinarySearch(array, mid + 1, high, x);
        }
    }
    public static void main(String arg[]){
        int array[] = { 3, 1, 6, 7, 2, 8, 9, 10, 4, 5 };
        int index = BinarySearch(array,0,array.length-1,8);
        System.out.println(index);

    }
}
