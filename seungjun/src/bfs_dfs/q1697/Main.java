package bfs_dfs.q1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subinPosition = Integer.parseInt(st.nextToken());
        int sisterPosition = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, subinPosition});

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            visited.add(node[1]);

            if (node[1] < 0 || node[1] > 100000) {
                continue;
            }

            if (node[1] == sisterPosition) {
                System.out.println(node[0]);
                break;
            }

            if (!visited.contains(node[1] - 1)) {
                queue.add(new int[]{node[0] + 1, node[1] - 1});
            }

            if (!visited.contains(node[1] * 2)) {
                queue.add(new int[]{node[0] + 1, node[1] * 2});
            }

            if (!visited.contains(node[1] + 1)) {
                queue.add(new int[]{node[0] + 1, node[1] + 1});
            }
        }
    }
}
