package bfs_dfs.q24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] visited;
    private static int visitedNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

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

        visited = new int[nodeSize + 1];

        dfs(startNode);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int curNode) {
        visited[curNode] = ++visitedNumber;
        Collections.sort(graph.get(curNode));

        for (Integer nextNode : graph.get(curNode)) {
            if (visited[nextNode] == 0) {
                dfs(nextNode);
            }
        }
    }
}
