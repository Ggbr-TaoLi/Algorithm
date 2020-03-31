package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//图的深度优先遍历
//邻接表存储
public class DFS {
    //实现标记map
    private Map<String, Boolean> status = new HashMap<>();
    //图
    private Map<String, List<String>> graph = new HashMap<>();
    /**
     * 初始化图数据：使用邻接表来表示图数据。邻接矩阵用数组。
     */
    //初始化
    public void initGraphData() {
//        图结构如下
//          1
//        /   \
//       2     3
//      / \   / \
//     4  5  6  7
//      \ | / \ /
//        8    9
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("1", "4", "5"));
        graph.put("3", Arrays.asList("1", "6", "7"));
        graph.put("4", Arrays.asList("2", "8"));
        graph.put("5", Arrays.asList("2", "8"));
        graph.put("6", Arrays.asList("3", "8", "9"));
        graph.put("7", Arrays.asList("3", "9"));
        graph.put("8", Arrays.asList("4", "5", "6"));
        graph.put("9", Arrays.asList("6", "7"));
    }
    //递归实现
    private void DFSSearch(String startPoint) {
        if(status.getOrDefault(startPoint,false)){
            return;
        }
        status.put(startPoint, true); //标记
        System.out.println(startPoint); //输出节点处
        //找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入list中。
        //用遍历集合取代c/c++中的while(p){p=p->nextarc}。
        List<String> neighborPoints = graph.get(startPoint);
        for (String point : neighborPoints) {
            DFSSearch(point); //递归

        }
    }
    public static void main(String arg[]) {
        DFS dfs = new DFS();
        dfs.initGraphData();//初始化图
        dfs.DFSSearch("1");//设置起始点
    }

}
