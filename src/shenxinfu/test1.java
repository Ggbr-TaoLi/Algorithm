package shenxinfu;

import java.util.Scanner;
//叠杯子倒水 溢出

/**
 * 待完善
 */
public class test1 {
    private static int math(int N, int X, int[] start, int[] add) {
        int count =0;
        //依次从下往上倒
        for (int i = N; i >= 1; --i) {
            int num = add[i]+start[i];
            int snum = num-X;
            if(num>X){
                for(int j =i;j>=1;--j){
                    if(start[j]!=X){
                        start[j]+=snum;
                        if(start[j]>=X){
                            snum=start[j]-X;
                        }
                    }
                }
                //每次倒入的剩余计入count
                count+=snum;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] start = new int[X + 1];
        int[] add = new int[10000];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 2; j++) {
                    start[i] = sc.nextInt();
                    add[i] = sc.nextInt();
                }
            }
        //输出
        int count = math(N,X,start,add);
        System.out.println(count);
        }
}
