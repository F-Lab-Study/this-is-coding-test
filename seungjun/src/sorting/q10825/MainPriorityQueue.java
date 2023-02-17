package sorting.q10825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MainPriorityQueue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>();

        int studentCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            studentPriorityQueue.add(
                    new Student(
                            st.nextToken(),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Student s : studentPriorityQueue) {
            stringBuilder.append(s.name).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student s) {
            if (s.kor == kor) {
                if (s.eng == eng) {
                    if (s.math == math) {
                        return name.compareTo(s.name);
                    }

                    return s.math - math;
                }

                return eng - s.eng;
            }

            return s.kor - kor;
        }
    }
}
