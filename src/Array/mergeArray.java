package Array;

import java.util.Arrays;

/**
 * 合并两个有序数组为一个有序数组
 */
public class mergeArray {
    private static void MergeArray(int[] num1, int[] num2, int[] num3) {
        //变量用于存储两个集合应该被比较的索引（存入新集合就加一）
        int a = 0;
        int b = 0;
        for (int i = 0; i < num3.length; i++) {
            if (a < num1.length && b < num2.length) {   //两数组都未遍历完，相互比较后加入
                if (num1[a] >= num2[b]) { //当两数相等时也取b的
                    num3[i] = num2[b];
                    b++;
                } else {
                    num3[i] = num1[a];
                    a++;
                }
            } else if (a < num1.length) {   //num2已经遍历完，无需比较，直接将剩余num1加入
                num3[i] = num1[a];
                a++;
            } else if (b < num2.length) {    //num1已经遍历完，无需比较，直接将剩余num2加入
                num3[i] = num2[b];
                b++;
            }
        }
    }

    public static void main(String arg[]) {
        int[] num1 = new int[]{1, 2, 4, 6, 7, 123, 411, 5334, 1414141, 1314141414};
        int[] num2 = new int[]{0, 2, 5, 7, 89, 113, 5623, 6353, 134134};
        int[] num3 = new int[num1.length + num2.length]; //合并数组
        MergeArray(num1, num2, num3);
        System.out.println("合并排序后:" + Arrays.toString(num3));
    }

}
