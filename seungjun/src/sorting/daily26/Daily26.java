package sorting.daily26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Daily26 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardGroupCount = Integer.parseInt(br.readLine());

        List<Integer> cardGroupList = new ArrayList<>();
        for (int i = 0; i < cardGroupCount; i++) {
            cardGroupList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(cardGroupList);

        int preSum = cardGroupList.get(0) + cardGroupList.get(1);
        for (int i = 2; i < cardGroupList.size(); i++) {
            preSum = preSum + preSum + cardGroupList.get(i);
        }

        System.out.println(preSum);
    }
}
