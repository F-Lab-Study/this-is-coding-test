package baekjoon.q2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static final Queue<int[]> nextNodeInfo = new LinkedList<>();
    private static int[] graphSize;

    public static void main(String[] args) throws IOException {
        initialGraph();

        bfs();

        System.out.println(graph.get(graphSize[0]).get(graphSize[1]));
    }

    private static void initialGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        graphSize = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        for (int i = 0; i <= graphSize[0]; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= graphSize[0]; i++) {
            String string = br.readLine();
            graph.get(i).add(0);
            for (char c : string.toCharArray()) {
                graph.get(i).add(Character.digit(c, 10));
            }
        }
    }

    private static void bfs() {
        nextNodeInfo.add(new int[] {1, 1});
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!nextNodeInfo.isEmpty()) {
            int[] currentNode = nextNodeInfo.poll();

            if (Arrays.equals(graphSize, currentNode)) {
                break;
            }

            for (int[] m : move) {
                int[] nextNode = {currentNode[0] + m[0], currentNode[1] + m[1]};

                if (isXAxisRangeOut(nextNode)) {
                    continue;
                }

                if (isYAxisRangeOut(nextNode)) {
                    continue;
                }

                if (isMovable(nextNode)) {
                    continue;
                }

                graph.get(nextNode[0]).set(nextNode[1], graph.get(currentNode[0]).get(currentNode[1]) + 1);

                nextNodeInfo.add(nextNode);
            }
        }
    }

    private static boolean isXAxisRangeOut(int[] nextNode) {
        return nextNode[0] <= 0 || nextNode[0] > graphSize[0];
    }

    private static boolean isYAxisRangeOut(int[] nextNode) {
        return nextNode[1] <= 0 || nextNode[1] > graphSize[1];
    }

    private static boolean isMovable(int[] nextNode) {
        return graph.get(nextNode[0]).get(nextNode[1]) != 1;
    }
}
