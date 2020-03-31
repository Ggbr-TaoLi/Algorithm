package textProcessing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件input.txt是一个文本文件，每一行有多列（用空格分隔）。
 * keyword.conf是一个关键词配置文件，每一行是一个词。
 * 请找出文件input.txt中第一列包含keyword.conf中任意一个关键词的文本行并输出。
 * 示例
 * 输入：
 * 文件input.txt内容：
 * abc xxx
 * bcd xxx
 * def xxx
 * xyz xxx
 * 文件keyword.conf内容：
 * bc
 * eft
 * 输出（打印到标准输出）：
 * abc xxx
 * bcd xxx
 */
public class keywordMatching {
    private static void keywordMatching(String inputPath, String keywordPath) {
        Set<String> conf = getkeyword(keywordPath);
        try (FileInputStream inputStream = new FileInputStream(inputPath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                for (String keyword : conf) {
                    //str.split(" ")[0]返回一个数组
                    if (str.split(" ")[0].contains(keyword)) {
                        //结果输出
                        System.out.println(str);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Set<String> getkeyword(String keywordPath) {
        Set<String> set = new HashSet<>();
        try (FileInputStream inputStream = new FileInputStream(keywordPath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null)
                set.add(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static void main(String[] arg) {
        keywordMatching("./input.txt" , "./keyword.conf");
    }
}
