package textProcessing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ****. input.txt中有10万个随机整数，每行一个，范围从0-99999，
 * 需要分别统计[0-99]、[100-199]、[200-299]、[300-399] …… [99900, 99999]，出现的次数。
 * 输出为每个范围及其中数字出现的次数，范围和数字间空格分隔，每行一个
 */
public class count {
    public static void main(String[] args) {
        printResult("./input.txt");
    }

    private static void printResult(String filePath) {
        int n = 100000; //范围大小
        int m = 100; //统计区间
        int[] memo = new int[n / m];
        storageResult(memo, filePath, m);
        int temp;
        for (int i = 0; i < memo.length; i++) {
            temp = i * m;
            //输出
            System.out.println(temp + "—" + (temp + 99) + " " + memo[i]);
        }
    }

    private static void storageResult(int[] memo, String inputFilePath, int m) {
        try (FileInputStream inputStream = new FileInputStream(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                //利用数组存储统计值
                memo[Integer.parseInt(str) / m]++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
