package graph;

import java.util.*;

//图的广度优先遍历
//邻接表存储
public class BFS {
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

    //队列实现
    private Queue<String> queue = new LinkedList<>();

    private void BFSSearch(String startPoint) {
        //起始点标记并进队列
        status.put(startPoint, true);
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            //从queue中取出队列头的点；更新状态为已经遍历。
            String currentQueueHeader = queue.poll(); //出队
            status.put(currentQueueHeader, true);
            System.out.println(currentQueueHeader);//输出位置
            //找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
            List<String> neighborPoints = graph.get(currentQueueHeader);
            for (String point : neighborPoints) {
                if (!status.getOrDefault(point, false)) { //未被遍历
                    if (queue.contains(point)) continue;
                    queue.add(point);
                    status.put(point, false);
                }
            }
        }
    }

    public static void main(String arg[]) {
        BFS bfs = new BFS();
        bfs.initGraphData();//初始化图
        bfs.BFSSearch("1");//设置起始点
    }

}
