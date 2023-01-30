package greedy.practice;

import java.util.*;

public class Exam01 {


    public void solution() {
//        int people = 5;
        int[] fearList = {2, 3, 1, 2, 2};
        Arrays.sort(fearList);

        int cnt = 0; //그룹의 인원수
        int groupCnt = 0; // 그룹

        for (int i : fearList) {
            cnt++;
            if (cnt>=i) {
                groupCnt++;
                cnt = 0;
            }
        }
        System.out.println(groupCnt);
    }


}
