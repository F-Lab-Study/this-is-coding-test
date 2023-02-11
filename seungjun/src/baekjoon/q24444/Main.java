package baekjoon.q24444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final Queue<Integer> queue = new LinkedList<>();
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] visited;
    private static int visitSeq = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        visited = new int[nodeSize + 1];

        for (int i = 0; i <= nodeSize; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int edgeL = Integer.parseInt(st.nextToken());
            int edgeR = Integer.parseInt(st.nextToken());

            graph.get(edgeL).add(edgeR);
            graph.get(edgeR).add(edgeL);
        }

        bfs(startNode);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int startNode) {
        queue.add(startNode);
        visited[startNode] = ++visitSeq;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            Collections.sort(graph.get(node));

            for (int nextNode : graph.get(node)) {
                if (visited[nextNode] == 0) {
                    visited[nextNode] = ++visitSeq;
                    queue.add(nextNode);
                }
            }
        }
    }
}
