package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Daily29Answer {
    private static final List<Integer> houseList = new ArrayList<>();
    private static int ipTimeCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseCount = Integer.parseInt(st.nextToken());
        ipTimeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < houseCount; i++) {
            houseList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(houseList);

        int minDistance = 1; // 모든 위치에 공유기가 설치되는 거리
        int maxDistance = houseList.get(houseList.size() - 1) - houseList.get(0) + 1; // 공유기가 1개만 설치되는 거리

        System.out.println(binarySearch(minDistance, maxDistance));
    }

    public static int binarySearch(int minDistance, int maxDistance) {
        while(minDistance < maxDistance) {
            int mid = (minDistance + maxDistance) / 2;

            if(canInstall(mid) < ipTimeCount) {
                maxDistance = mid;
            }
            else {
                minDistance = mid + 1;
            }
        }

        return maxDistance - 1;
    }

    private static int canInstall(int distance) {
        int count = 1;
        int lastLocate = houseList.get(0);

        for(int i = 1; i < houseList.size(); i++) {
            int locate = houseList.get(i);

            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }
}
