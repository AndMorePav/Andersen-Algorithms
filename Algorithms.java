package andersen;

import java.util.*;

public class Algorithms {

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
    // todo
    static void quickSort(int[] arr) {
        if (arr.length < 2)
            return;

        int middle = arr[arr.length / 2];

        int count = 0;
        for (int element : arr)
            if (element < middle)
                count++;

        int[] less = new int[count];

        count = 0;
        for (int element : arr)
            if (element < middle)
                less[count++] = element;

        count = 0;
        for (int element : arr)
            if (element > middle)
                count++;

        int[] greater = new int[count];

        count = 0;
        for (int element : arr)
            if (element > middle)
                greater[count++] = element;

        quickSort(less);
        quickSort(greater);

        count = 0;
        for (int element : less) {
            arr[count++] = element;
        }

        arr[count++] = middle;


        for (int element : greater) {
            arr[count++] = element;
        }
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
}

