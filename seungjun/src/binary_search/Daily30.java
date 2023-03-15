package binary_search;

class Daily30 {
    public static void main(String[] args) {
        	String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
            String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

            int[] answer = new Daily30().solution(words, queries);
            for(int i : answer) {
                System.out.println(i);
            }
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int front = 0;
            int rear = queries[i].length();
            if (queries[i].charAt(0) == '?') {
                front = upperBound(queries[i]);
            } else {
                rear = lowerBound(queries[i]);
            }

            for (String word : words) {
                if (word.length() == queries[i].length() && queries[i].substring(front, rear).equals(word.substring(front, rear))) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    private int lowerBound(String query) {
        int front = 0;
        int rear = query.length() - 1;

        while(front < rear) {
            int middle = (front + rear) / 2;
            if (query.charAt(middle) != '?') {
                front = middle + 1;
            } else {
                rear = middle;
            }
        }

        return front;
    }

    private int upperBound(String query) {
        int front = 0;
        int rear = query.length() - 1;

        while(front < rear) {
            int middle = (front + rear) / 2;
            if (query.charAt(middle) == '?') {
                front = middle + 1;
            } else {
                rear = middle;
            }
        }

        return front;
    }
}
