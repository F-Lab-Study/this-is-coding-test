package binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Daily30Answer {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        List<Integer> answer = new Daily30Answer().solution(words, queries);
        for(int i : answer) {
            System.out.println(i);
        }
    }

    public List<Integer> solution(String[] words, String[] queries) {
        Map<Integer, List<String>> frontMap = new HashMap<>();
        Map<Integer, List<String>> backMap = new HashMap<>();

        for (String word : words) {
            int len = word.length();

            frontMap.computeIfAbsent(len, i -> new ArrayList<>()).add(word);
            backMap.computeIfAbsent(len, i -> new ArrayList<>()).add(reverse(word));
        }

        for (int key : frontMap.keySet()) {
            frontMap.get(key).sort(null);
            backMap.get(key).sort(null);
        }

        List<Integer> ans = new ArrayList<>();
        for (String query : queries) {
            List<String> list;
            if (query.charAt(0) == '?') {
                list = backMap.get(query.length());
                query = reverse(query);
            } else {
                list = frontMap.get(query.length());
            }

            if (list == null) {
                ans.add(0);
            } else {
                ans.add(
                        upperBound(list, query.replace('?', 'z'))
                                - lowerBound(list, query.replace("?", "a"))
                );
            }
        }

        return ans;
    }

    private int upperBound(List<String> list, String str) {
        int front = 0;
        int rear = list.size();

        while (front < rear) {
            int middle = (front + rear) / 2;

            // list.get(middle)의 값이 str보다 큰 경우
            if (str.compareTo(list.get(middle)) < 0) {
                rear = middle;
            } else {
                front = middle + 1;
            }
        }

        return front;
    }

    private int lowerBound(List<String> list, String str) {
        int front = 0;
        int rear = list.size();

        while (front < rear) {
            int middle = (front + rear) / 2;

            // list.get(middle)의 값이 str보다 크거나 같은 경우
            if (str.compareTo(list.get(middle)) <= 0) {
                rear = middle;
            } else {
                front = middle + 1;
            }
        }

        return front;
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
