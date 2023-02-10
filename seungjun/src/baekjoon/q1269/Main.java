package baekjoon.q1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //3 5 A/B
        //1 2 4
        //2 3 4 5 6
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            bList.add(Integer.parseInt(st.nextToken()));
        }

        String inputString = scanner.nextLine();
        int[] inputLength = Arrays.stream(inputString.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[] setA = scanner.nextLine().split("\\s+");
        if (inputLength[0] != setA.length) {
            throw new IllegalArgumentException("조건에 부합하지 않습니다.");
        }

        String[] setB = scanner.nextLine().split("\\s+");
        if (inputLength[1] != setB.length) {
            throw new IllegalArgumentException("조건에 부합하지 않습니다.");
        }
        Set<String> stringSet = new HashSet<>(Arrays.asList(setB));


        int count = 0;


        Stack<Integer> stack = new Stack<>();

        for (String iA : setA) {
            if (stringSet.contains(iA)) {
                count++;
            }
        }

        System.out.println((setA.length - count) + (setB.length - count));
    }
}
