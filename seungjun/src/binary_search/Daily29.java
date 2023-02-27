package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Daily29 {
    private static final List<Integer> installPosition = new ArrayList<>();
    private static int ipTimeCount;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseCount = Integer.parseInt(st.nextToken());
        ipTimeCount = Integer.parseInt(st.nextToken());

        List<Integer> houseList = new ArrayList<>();
        for (int i = 0; i < houseCount; i++) {
            houseList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(houseList);

        if (ipTimeCount % 2 == 0) {
            int mid = (houseCount - 1) / 2;
            binarySearch(houseList, 0, mid);
            binarySearch(houseList, mid + 1, houseCount - 1);
        }

        binarySearch(houseList, 0, houseCount - 1);

        int resultSub = 0;
        for (int i = 1; i < installPosition.size() - 1; i++) {
            int sub = installPosition.get(i) - installPosition.get(i - 1);

            if (resultSub < sub) {
                resultSub = sub;
            }
        }

        System.out.println(resultSub);
    }

    private static void binarySearch(List<Integer> houseList, int front, int rear) {
        int mid = (front + rear) / 2;

        if (ipTimeCount <= 0) {
            return;
        }

        installPosition.add(mid);
        ipTimeCount--;
        binarySearch(houseList, front, mid);
        binarySearch(houseList, mid + 1, rear);
    }
}
