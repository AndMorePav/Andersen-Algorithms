package andersen;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class AlgorithmsTest {



    @Test
    public void quickSort() {
        int[] test = {31, 5, 8, 3, 5};
        int[] expect = {3, 5, 5, 8, 31};
        Algorithms.quickSort(test);

        assertArrayEquals("Mismatch: ", expect, test);

    }

    @Test
    public void binarySearch() {
        int[] test = {3, 5, 6, 8, 31};
        int expected = 2;
        int expected2 = -1;

        assertEquals("Mismatch", expected, Algorithms.binarySearch(test, 6));
        assertEquals("Mismatch", expected2, Algorithms.binarySearch(test, 4));
    }

    @Test
    public void BFS() {
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        undirectedGraph.addEdge("me", "alice");
        undirectedGraph.addEdge("me", "bob");
        undirectedGraph.addEdge("me", "clare");
        undirectedGraph.addEdge("bob", "anuj");
        undirectedGraph.addEdge("bob", "peggy");
        undirectedGraph.addEdge("clare", "jonny");

        LinkedList<String> expected = new LinkedList<>();
        expected.add("me");
        expected.add("alice");
        expected.add("bob");
        expected.add("clare");
        expected.add("anuj");
        expected.add("peggy");

        LinkedList<String> expected2 = new LinkedList<>();

        assertEquals(expected, Algorithms.BFS(undirectedGraph, "peggy", "me"));
        assertNotSame(expected, Algorithms.BFS(undirectedGraph, "peggy", "me"));

        assertEquals(expected2, Algorithms.BFS(undirectedGraph, "iggi", "me"));
        assertNotSame(expected2, Algorithms.BFS(undirectedGraph, "iggi", "me"));
        ;
    }

    @Test
    public void dijkstra() {
        int[][] graph = new int[][]
                {{0, 4, 0, 0, 7},
                        {4, 0, 1, 2, 0},
                        {0, 1, 0, 6, 0},
                        {0, 2, 6, 0, 0},
                        {7, 0, 0, 0, 0}
                };

        assertEquals("Mismatch", "4 dist from source 7", Algorithms.dijkstra(graph, 0, 4));
        assertEquals("Mismatch", "1 dist from source 0", Algorithms.dijkstra(graph, 1, 1));
    }
}