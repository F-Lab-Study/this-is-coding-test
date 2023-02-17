package sorting.q10825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MainComparator {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentList = new ArrayList<>();

        int studentCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            studentList.add(
                    new Student(
                            st.nextToken(),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        studentList.sort(Comparator.comparing(Student::getKor, Comparator.reverseOrder())
                .thenComparingInt(Student::getEng)
                .thenComparing(Student::getMath, Comparator.reverseOrder())
                .thenComparing(Student::getName));

        StringBuilder stringBuilder = new StringBuilder();
        for (Student s : studentList) {
            stringBuilder.append(s.name).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static class Student {
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

        public String getName() {
            return name;
        }

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMath() {
            return math;
        }
    }
}
