package bfs_dfs.q7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final Queue<int[]> nextNodeInfo = new LinkedList<>();
    private static final List<List<Integer>> box = new ArrayList<>();
    private static final List<int[]> startNodeList = new ArrayList<>();
    private static int[] boxSize;
    private static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        initial();

        findStartNode();

        bfs();

        System.out.println(isZeroTomatoExist() ? -1 : maxValue);
    }

    private static void initial() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boxSize = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        for (int i = 0; i <= boxSize[1]; i++) {
            box.add(new ArrayList<>());
            box.get(i).add(0);
        }

        for (int i = 1; i <= boxSize[1]; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                box.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void findStartNode() {
        for (int i = 1; i <= boxSize[1]; i++) {
            for (int j = 1; j <= boxSize[0]; j++) {
                if (box.get(i).get(j) == 1) {
                    startNodeList.add(new int[] {i, j});
                }
            }
        }
    }

    private static void bfs() {
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] startNode : startNodeList) {
            nextNodeInfo.add(startNode);
            box.get(startNode[0]).set(startNode[1], 0);
        }

        while(!nextNodeInfo.isEmpty()) {
            int[] currentNode = nextNodeInfo.poll();

            for (int[] m : move) {
                int[] nextNode = {currentNode[0] + m[0], currentNode[1] + m[1]};

                if (isNotAvailableNode(nextNode)) {
                    continue;
                }

                box.get(nextNode[0]).set(nextNode[1], box.get(currentNode[0]).get(currentNode[1]) + 1);

                if (isLargerThenMaxValue(nextNode)) {
                    maxValue = box.get(nextNode[0]).get(nextNode[1]);
                }

                nextNodeInfo.add(nextNode);
            }

        }

        for (int[] startNode : startNodeList) {
            box.get(startNode[0]).set(startNode[1], 1);
        }
    }

    private static boolean isZeroTomatoExist() {
        for (int i = 1; i <= boxSize[1]; i++) {
            for (int j = 1; j <= boxSize[0]; j++) {
                if (box.get(i).get(j) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isNotAvailableNode(int[] nextNode) {
        if (isXAxisRangeOut(nextNode)) {
            return true;
        }

        if (isYAxisRangeOut(nextNode)) {
            return true;
        }

        if (isNotZeroTomato(nextNode)) {
            return true;
        }
        return false;
    }

    private static boolean isXAxisRangeOut(int[] nextNode) {
        return nextNode[0] <= 0 || nextNode[0] > boxSize[1];
    }

    private static boolean isYAxisRangeOut(int[] nextNode) {
        return nextNode[1] <= 0 || nextNode[1] > boxSize[0];
    }

    private static boolean isNotZeroTomato(int[] nextNode) {
        return box.get(nextNode[0]).get(nextNode[1]) != 0;
    }

    private static boolean isLargerThenMaxValue(int[] nextNode) {
        return maxValue < box.get(nextNode[0]).get(nextNode[1]);
    }
}
