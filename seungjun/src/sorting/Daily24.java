package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Daily24 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houseCount = Integer.parseInt(br.readLine());
        List<Integer> houseList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            houseList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(houseList);

        int minPosition = houseList.get(0);
        int maxPosition = houseList.get(houseCount - 1);
        int avgPosition = (minPosition + maxPosition) / 2;

        int resultPosition = 0;
        int min = maxPosition;
        for (int i : houseList) {
            int sub = Math.abs(avgPosition - i);
            if (sub < min) {
                min = sub;
                resultPosition = i;
            }
        }

        System.out.println(resultPosition);
    }
}
