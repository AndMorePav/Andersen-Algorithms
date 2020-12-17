package andersen;

import java.util.*;

public class Algorithms {

    public static void main(String[] args) {
        DirectedWeightedGraph uwg = new DirectedWeightedGraph();
        uwg.addEdge(new Edge(5, "book", "record"));
        uwg.addEdge(new Edge(0, "book", "poster"));
        uwg.addEdge(new Edge(15, "record", "guitar"));
        uwg.addEdge(new Edge(20, "guitar", "piano"));
        uwg.addEdge(new Edge(35, "poster", "drums"));
        uwg.addEdge(new Edge(10, "drums", "piano"));
        uwg.addEdge(new Edge(30, "poster", "guitar"));
        uwg.addEdge(new Edge(20, "record", "drums"));

        System.out.println(uwg);
        dijkstra(uwg);

        Map map = new HashMap();


    }

    static List<String> BFS(UndirectedGraph graph, String required, String started) {
        Map<String, List<String>> vertexMap = graph.getVertexMap();
        ArrayDeque<String> path = new ArrayDeque<>();
        path.offer(started);

        LinkedList<String> checked = new LinkedList<>();

        while (path.size() > 0) {
            if (required.equals(path.getFirst())) {
                checked.add(path.getFirst());
                return checked;
            } else {
                List<String> strings = vertexMap.get(path.getFirst());

                for (String str : strings) {
                    if (!checked.contains(str))
                        path.offer(str);
                }

                checked.add(path.pollFirst());
            }
        }


        return new LinkedList<String>();
    }

    static void quickSort(int[] arr, int start, int end) {
//        if(arr.length < 2)
//            return;

        if(start >= end)
            return;

        int middle = start +((end - start)/2);
        int pivot = arr[middle];

        int temp;
        temp = arr[end];
        arr[end] = arr[middle];
        arr[middle] = temp;

        int i = start-1;
        int j = end;

        do {
            do{i++;} while (arr[i] < pivot && i < end );
            do{j--;} while (arr[j] > pivot && j>start);

            if(i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        } while (i < j);

        temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;


        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);

    }

    static int binarySearch(int[] arr, int required) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = high - low / 2;
            int guess = arr[middle];

            if (guess == required)
                return middle;
            else if (guess > required)
                high = middle - 1;
            else low = middle + 1;
        }
        return -1;
    }

    static String  dijkstra(int[][] graph, int src, int target) {
        List<String> result = new LinkedList<String>();

        int[] dist = new int[5];
        boolean[] b = new boolean[5];

        for (int i = 0; i < 5; i++) {
            dist[i] = Integer.MAX_VALUE;
            b[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < 5; count++) {
            int u = minDistance(dist, b);
            b[u] = true;
            for (int x = 0; x < 5; x++) {
                if (!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][x] < dist[x]) {
                    dist[x] = dist[u] + graph[u][x];
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(i + " dist from source " + dist[i]);
        }
        return result.get(target);
    }

    private static int minDistance(int[] dist, boolean[] b) {
        int min = Integer.MAX_VALUE, index = -1;
        for (int x = 0; x < 5; x++) {
            if (!b[x] && dist[x] <= min) {
                min = dist[x];
                index = x;
            }
        }
        return index;
    }

    //todo
    static void dijkstra(DirectedWeightedGraph dwg) {
        Map<String, List<Edge>> map = dwg.getVertexMap();

        Collection<List<Edge>> set = map.values();
        Iterator<List<Edge>> iterator = set.iterator();

        for(List<Edge> list : set) {
            for(Edge edge : list){




            }
        }
    }
    }




