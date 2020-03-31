package textProcessing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * ****. 在对域名进行分析中，常常会碰到“主域归属”问题。首先，我们有一个主域列表，如下所示：
 * *.sports.sina.com.cn
 * *.sina.com.cn
 * *.baidu.com
 * *.tencent.com
 * *.com
 * *.cn
 * 等等，这个列表可能会包含百万级别的配置。
 * 在有这个配置的前提下，给定一个域名，比如roll.sports.sina.com.cn，希望能够找到它所匹配的最长的“主域”，比如，对于上面这个域名，应该匹配到*.sports.这个主域。
 * 请实现一个程序，从配置文件domain.txt读取主域列表，每行一个；从标准输入读取需要匹配的域名，每行一个；向标准输出打印：需要匹配的域名\t它匹配到的最长主域。
 * 注意，请尽可能高效，使用正则匹配会非常慢。
 */
public class domainMatching {
    /**
     *思路
     * 按行读取每一条数据，将该数据以Map的方式形如下图
     *
         cn             com
                    /       /           \
      com     baidu tencent
       /
      sina
       /
      sports
      将数据进行压缩
      将"roll.sports.sina.com.cn"
      解析为 数组 先找到 cn 的 HashMap 查看是否存在 tempMap，
      在tempMap中查找key为com的HashMap，
      如此查找下去，知道查找的key 不存在，输出找到的结果。

     由于 数据量比较大，可以将通过Hash的方式将数据存储在多个机器上，例如com 和cn，结尾的数据比较多，可以将其分配2台甚至多台机器处理，或者内存更大的机器
     基本的思路还是不变的
     * 时间复杂度O(n)
     * */
    public static void main(String[] args) {
        String data = "roll.sports.sina.com.cn";
        HashMap<String, HashMap> stringHashMapHashMap = storageDate("./input.txt");
        String[] arr = data.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length - 1; i > 0; i--) {
            if (stringHashMapHashMap.containsKey(arr[i])) {
                stringBuilder.insert(0, "." + arr[i]);
                stringHashMapHashMap = stringHashMapHashMap.get(arr[i]);
            } else {
                break;
            }
        }
        //输出
        System.out.println(stringBuilder.insert(0, "*"));
    }

    /*
     * 将所有数据压缩插入到map中
     * */
    private static HashMap<String, HashMap> storageDate(String inputFilePath) {
        HashMap<String, HashMap> map = new HashMap<>();
        try (FileInputStream inputStream = new FileInputStream(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split("\\.");
                addToMap(arr, map, arr.length - 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /*
     * 将数据插入到Map中
     * */
    private static HashMap<String, HashMap> addToMap(String[] arr, HashMap<String, HashMap> map, int n) {
        if (n >= 1) {
            map.put(arr[n], addToMap(arr, map.containsKey(arr[n]) ? map.get(arr[n]) : new HashMap<>(), n - 1));
        }
        return map;
    }
}
