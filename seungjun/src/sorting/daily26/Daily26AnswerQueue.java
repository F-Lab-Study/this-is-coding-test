package sorting.daily26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Daily26AnswerQueue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardGroupCount = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> cardGroupQueue = new PriorityQueue<>();
        for (int i = 0; i < cardGroupCount; i++) {
            cardGroupQueue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(cardGroupQueue.size() != 1) {
            int sum = cardGroupQueue.poll() + cardGroupQueue.poll();
            result += sum;
            cardGroupQueue.add(sum);
        }

        System.out.println(result);
    }
}
